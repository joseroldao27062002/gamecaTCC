package controllers;

import models.Aluno;
import models.Professor;
import models.SalaVirtual;
import play.mvc.Controller;

public class Login extends Controller {

	public static void logout() {
		session.clear();
		PainelLoginUsuario.index();
	}

	public static void autenticar(String email, String senha) {

		Professor professor = Professor.find("email = ? and senha = ?", email, senha).first();
		Aluno aluno = Aluno.find("email = ? and senha = ?", email, senha).first();
		
		validation.required(email);
		validation.email(email);
		validation.required(senha);
		validation.minSize(senha, 3);
		
		if (validation.hasErrors()) {
			params.flash();
			validation.keep();
			System.out.println("E-mail ou senha inválidos");
		}
		
		if (professor == null & aluno == null) {
			PainelLoginUsuario.index();
		} else {
			if (professor != null) {
				
				session.put("tipoUsuario", "Professor");
				session.put("nomeProfessor", professor.nome);
				session.put("matriculaProfessor", professor.matricula);
				session.put("emailProfessor", professor.email);
				session.put("idProfessor", professor.id);
				if(validation.hasErrors()) {	
					validation.keep();
					params.flash();	
				}
				SalasVirtuais.indexProfessores();
				
			} else {
				session.put("tipoUsuario", "Aluno");
				session.put("nomeAluno", aluno.nome);
				session.put("matriculaAluno", aluno.matricula);
				session.put("emailAluno", aluno.email);
				session.put("idAluno", aluno.id);
				if(validation.hasErrors()) {	
					validation.keep();
					params.flash();	
				}
				Alunos.indexAlunos();
			}
		}
	}

}
