package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import play.data.validation.Valid;
import play.mvc.Before;


import models.Aluno;
import models.Frequencia;
import models.Professor;
import models.SalaVirtual;
import play.mvc.Controller;

public class Alunos extends Controller {

	private static final Object Terça = null;

	public static void formAlunos() {
		render();
	}
	
	@Before(only = {"indexAlunos", "listarAlunos"})
	static void rentringirSalaAoAluno() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Aluno")) {
			Restricoes.restricoesProfessores();
		}
	}

	public static void salvar(@Valid Aluno a) {
		
		a.save();
		Login.autenticar(a.email, a.senha);
	}

	public static void listarAlunos() {
		List<Aluno> lista = Aluno.findAll();
		render(lista);
	}

	public static void editar(long id) {
		Aluno a = Aluno.findById(id);
		renderTemplate("Alunos/formAlunos.html", a);
	}

	public static void deletar(long id) {
		Aluno a = Aluno.findById(id);
		a.delete();
		listarAlunos();
	}

	public static void indexAlunos() {

		String idA = session.get("idAluno");
		Long idAluno = Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idAluno);
		List<SalaVirtual> salas = aluno.salasVirtuais;

		// tabela resumo
		List<SalaVirtual> salasAlunos = aluno.salasVirtuais;
		System.out.println("ver salas   " + salasAlunos);
		List<SalaVirtual> salasAlunosSegunda = new ArrayList();
		List<SalaVirtual> salasAlunosTerça = new ArrayList();
		List<SalaVirtual> salasAlunosQuarta = new ArrayList();
		List<SalaVirtual> salasAlunosQuinta = new ArrayList();
		List<SalaVirtual> salasAlunosSexta = new ArrayList();

		for (int a = 0; a < salasAlunos.size(); a++) {

			if (salasAlunos.get(a).dia.equals("Segunda")) {
				System.out.println("Mensagem" + salasAlunos.get(a).dia);
				salasAlunosSegunda.add(salasAlunos.get(a));
			}
			if (salasAlunos.get(a).dia.equals("Terça")) {
				salasAlunosTerça.add(salasAlunos.get(a));

			}
			if (salasAlunos.get(a).dia.equals("Quarta")) {
				salasAlunosQuarta.add(salasAlunos.get(a));
			}
			if (salasAlunos.get(a).dia.equals("Quinta")) {
				salasAlunosQuinta.add(salasAlunos.get(a));
			}
			if (salasAlunos.get(a).dia.equals("Sexta")) {
				salasAlunosSexta.add(salasAlunos.get(a));
			}

		}

		if (salasAlunosSegunda.size() == 0) {
			System.out.println("seg é nulo. sala: " + salasAlunosSegunda);
			salasAlunosSegunda = null;

		}

		if (salasAlunosTerça.size() == 0) {
			salasAlunosTerça = null;

		}
		if (salasAlunosQuarta.size() == 0) {
			salasAlunosQuarta = null;

		}

		if (salasAlunosQuinta.size() == 0) {
			salasAlunosQuinta = null;

		}

		if (salasAlunosSexta.size() == 0) {
			salasAlunosSexta = null;

		}

		render(salas, salasAlunosSegunda, salasAlunosTerça, salasAlunosQuarta, salasAlunosQuinta, salasAlunosSexta);

	}

	static Integer soma = 0;

	public static void calcularPontuacao(long idAluno, long id_CA, Aluno a, Frequencia freq) {
		ArrayList<Integer> var = new ArrayList();
		var.add(freq.grauFrequencia + freq.grauParticipacao);

		for (int i = 0; i < var.size(); i++) {
			soma += var.get(i);

		}

	}

}