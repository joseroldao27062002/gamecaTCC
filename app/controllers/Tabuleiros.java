package controllers;

import models.SalaVirtual;
import models.Tabuleiro;
import play.data.validation.Valid;
import play.mvc.Before;
import play.mvc.Controller;

public class Tabuleiros extends Controller {
	@Before(only = {"indexTabuleiroAlunos", "avisoTabuleiro"})
	static void rentringirSalaAoAluno() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Aluno")) {
			Restricoes.restricoesProfessores();
		}
	}

	@Before(only = {"formTabuleiro", "indexTabuleiro"})
	static void rentringirSalaAoProfessor() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Professor")) {
			Restricoes.restricoesAlunos();
		}
	}
	
	
	public static void indexTabuleiroAlunos(Long idSala) {
		Tabuleiro tabuleiro1 = Tabuleiro.find("idsalaVirtual = ?", idSala).first();
		SalaVirtual sala = SalaVirtual.findById(idSala);
		
		if (tabuleiro1 != null) {
			render(sala);
		} else {
			System.out.println("Esse tabuleiro não existe");
			renderTemplate("Tabuleiros/AvisoTabuleiro.html");
		}
	}

	public static void indexTabuleiro(Long idSala) {
		System.out.println("idSala do indexTabuleiro "+idSala);
		SalaVirtual sala = SalaVirtual.findById(idSala);
		System.out.println("sala que esta sendo renderizada no indexTabuleiro "+sala);
		render(sala);
	}

	public static void formTabuleiro(Long salaVirtual, Tabuleiro tabuleiro) {
		Tabuleiro tabuleiro1 = Tabuleiro.find("idSalaVirtual = ?", salaVirtual).first();
		if (tabuleiro1 == null) {
			System.out.println("");
			System.out.println("ESSE TABULEIRO NAO EXISTEEEE. entao vamos criar ");
			System.out.println("");
		} else {
			System.out.println("Esse tabuleiro existe. n crie outro!");
			indexTabuleiro(salaVirtual);
		}
		render(salaVirtual);
	}

	public static void salvarTabuleiro(Long idSalaVirtual, @Valid Tabuleiro t) {
		System.out.println("passou por salvarTabuleiro");
		System.out.println("aq esta a idSalaVirtual de salvarTabuleiro "+ idSalaVirtual);
		if (validation.hasErrors()) {	
			validation.keep();
			params.flash();	
			formTabuleiro(idSalaVirtual, t);
		}
		SalaVirtual sala = SalaVirtual.findById(idSalaVirtual);
		System.out.println("sala encontrada em salvaTabuleiro "+ sala);
		t.salaVirtual = sala;
				   
		t.save();
	        System.out.println("tabuleiro foi salvo!");
		long idSala = sala.id;
	       System.out.println("idSala de salvarTabuleiro "+idSala);
		renderTemplate("Tabuleiros/indexTabuleiro.html", sala);
	}
}
