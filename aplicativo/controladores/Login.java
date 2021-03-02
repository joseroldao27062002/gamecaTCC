package controllers;
	
	import java.util.HashMap;
	import java.util.Map;
	import com.google.gson.Gson;

import enums.TipoUsuario;
import models.Aluno;
	import models.DadosSUAP;
	import models.Professor;
	import models.SalaVirtual;
	import models.Usuario;
	import play.libs.WS;
	import play.mvc.Controller;
	
	public class Login extends Controller {
		
		public static void logout() {
			session.clear();
			PainelLoginUsuario.index();
		}
		
		public static void autenticarSuap(String matricula, String senha) {
			WS.HttpResponse resposta;
			String urlToken = "https://suap.ifrn.edu.br/api/v2/autenticacao/token/";
			String urlDados = "https://suap.ifrn.edu.br/api/v2/minhas-informacoes/meus-dados/";	
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("username", matricula);
			parametros.put("password", senha);
			resposta = WS.url(urlToken).params(parametros).post();
	
			if (resposta.success()) {
				String token = resposta.getJson().getAsJsonObject().get("token").getAsString();
				Map<String, String> header = new HashMap<String, String>();
				header.put("X-CSRFToken", token);
				header.put("Authorization", "JWT " + token);
				resposta = WS.url(urlDados).headers(header).get();
				DadosSUAP dadosSUAP = new Gson().fromJson(resposta.getString(), DadosSUAP.class);
					
				Professor professor = Professor.find("matricula = ? and senha = ?", matricula, senha).first();;
				if (TipoUsuario.PROFESSOR != null) {
					professor = new Professor();
					professor.nome = dadosSUAP.nome_usual;
					professor.matricula = dadosSUAP.matricula;
					//professor.tipoVinculo = dadosSUAP.tipo_vinculo;
					//professor.url_foto_75x100 = "http://suap.ifrn.edu.br" + dadosSUAP.url_foto_75x100;
					professor.email = dadosSUAP.email;
					professor.save();
					
					session.put("nomeProfessor", professor.nome);
					session.put("matriculaProfessor", professor.matricula);
					session.put("emailProfessor", professor.email);
					session.put("idProfessor", professor.id);
					SalasVirtuais.indexProfessores();
				} else {
					Aluno aluno = Aluno.find("matricula = ? and senha = ?", matricula , senha).first();
					aluno = new Aluno();
					aluno.nome = dadosSUAP.nome_usual;
					aluno.matricula = dadosSUAP.matricula;
					//professor.tipoVinculo = dadosSUAP.tipo_vinculo;
					//professor.url_foto_75x100 = "http://suap.ifrn.edu.br" + dadosSUAP.url_foto_75x100;
					aluno.email = dadosSUAP.email;
					aluno.save();
						
					session.put("nomeAluno", aluno.nome);
					session.put("matriculaAluno", aluno.matricula);
					session.put("emailAluno", aluno.email);
					session.put("idAluno", aluno.id);
					Alunos.indexAlunos();
				}
					//session.put("usuarioFoto", usuario.url_foto_75x100);
			} else {
				flash.error("Email ou senha inválidos");
				PainelLoginUsuario.index();
			}
		}
	}
		
		
			
	


