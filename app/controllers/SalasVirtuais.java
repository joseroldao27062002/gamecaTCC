package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

import java.util.UUID;

import models.Aluno;
import models.CentroAprendizagem;
import models.Comentario;
import models.Feed;
import models.Frequencia;
import models.Mensagem;
import models.Professor;
import models.SalaVirtual;
import models.Tabuleiro;
import controllers.Alunos;
import controllers.Professores;
//import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import play.data.validation.Valid;
import play.db.jpa.GenericModel.JPAQuery;
import play.modules.paginate.ValuePaginator;
import play.mvc.Before;
import play.mvc.Controller;
import sun.util.calendar.LocalGregorianCalendar.Date;

public class SalasVirtuais extends Controller {
	
	@Before(only = {"novaSalaVirtualAlunos"})
	static void rentringirSalaAoAluno() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Aluno")) {
			Restricoes.restricoesProfessores();
		}
	}
   @Before(only = {"formSalasVirtuais", "indexProfessores", "listarSalasVirtuais", "novaSalaVirtual"})
	static void rentringirSalaAoProfessor() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Professor")) {
			Restricoes.restricoesAlunos();
		}
	}
	
	public static void formSalasVirtuais() {
		render();

	}

	public static void mostrarSalaProfessores(long id, SalaVirtual s) {
		SalaVirtual sala = SalaVirtual.findById(id);
		List<Aluno> salas = sala.alunos;
		ValuePaginator listaPaginadaAlunos = new ValuePaginator(salas);
		listaPaginadaAlunos.setPageSize(10);
		System.out.println("Lista paginada  " + listaPaginadaAlunos);
		if (salas.isEmpty()) {
			listaPaginadaAlunos = null;
		} else {
			listaPaginadaAlunos = listaPaginadaAlunos;
		}
		List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;

		List<Aluno> alunos = sala.alunos;

		List<Aluno> listaAlunosRanking = new ArrayList<>();
		for (int a = 0; a < alunos.size(); a++) {
			System.out.println(alunos.get(a).nome + "---" + alunos.get(a).getPontosPorSala(sala.id));
			listaAlunosRanking.add(alunos.get(a));
		}

		listaAlunosRanking.sort(new Comparator<Aluno>() {

			@Override
			public int compare(Aluno aluno1, Aluno aluno2) {
				if (aluno1.getPontosPorSala(sala.id) < aluno2.getPontosPorSala(sala.id)) {
					return 1;

				}
				if (aluno2.getPontosPorSala(sala.id) < aluno1.getPontosPorSala(sala.id)) {
					return -1;
				}
				return 0;
			}
		});

		List<Aluno> listaPodio = new ArrayList<>();
		if (listaAlunosRanking.size() == 0) {
			listaPodio = null;
		}
		if (listaAlunosRanking.size() == 1) {
			for (Integer a = 0; a < 1; a++) {
				listaPodio.add(listaAlunosRanking.get(a));
			}
		}
		if (listaAlunosRanking.size() == 2) {
			for (Integer a = 0; a < 2; a++) {
				listaPodio.add(listaAlunosRanking.get(a));
			}
		}
		if (listaAlunosRanking.size() > 2) {

			for (Integer a = 0; a < 3; a++) {
				listaPodio.add(listaAlunosRanking.get(a));
			}
		}
		long salaVirtual = sala.id;
		System.out.println("LIST " + listaPaginadaAlunos);
		renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s, listaPaginadaAlunos, listaCas, listaAlunosRanking,
				listaPodio, salaVirtual);
	}

	public static void mostrarSalaAlunos(long id, SalaVirtual s) {
		SalaVirtual sala = SalaVirtual.findById(id);
		List<Aluno> alunos = sala.alunos;
		ValuePaginator listaPaginadaAlunos = new ValuePaginator(alunos);
		listaPaginadaAlunos.setPageSize(10);
		List<Aluno> listaAlunosRanking = new ArrayList<>();
		for (int a = 0; a < alunos.size(); a++) {
			System.out.println(alunos.get(a).nome + "---" + alunos.get(a).getPontosPorSala(sala.id));
			listaAlunosRanking.add(alunos.get(a));
		}

		listaAlunosRanking.sort(new Comparator<Aluno>() {

			@Override
			public int compare(Aluno aluno1, Aluno aluno2) {
				if (aluno1.getPontosPorSala(sala.id) < aluno2.getPontosPorSala(sala.id)) {
					return 1;

				}
				if (aluno2.getPontosPorSala(sala.id) < aluno1.getPontosPorSala(sala.id)) {
					return -1;
				}
				return 0;

			}
		});
		List<Aluno> listaPodio = new ArrayList<>();

		if (listaAlunosRanking.size() == 0) {
			listaPodio = null;
		}
		if (listaAlunosRanking.size() == 1) {
			for (Integer a = 0; a < 1; a++) {
				listaPodio.add(listaAlunosRanking.get(a));
			}
		}
		if (listaAlunosRanking.size() == 2) {
			for (Integer a = 0; a < 2; a++) {
				listaPodio.add(listaAlunosRanking.get(a));
			}
		}
		if (listaAlunosRanking.size() > 2) {

			for (Integer a = 0; a < 3; a++) {
				listaPodio.add(listaAlunosRanking.get(a));
			}
		}
		long salaVirtual = id;
		List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html", salaVirtual, sala, s, listaPaginadaAlunos, listaCas,
				listaPodio);
	}

	public static void autenticarCodigo(String codigo, SalaVirtual s) {
		SalaVirtual salaV = SalaVirtual.find("codigo = ?", codigo).first();

		String idA = session.get("idAluno");
		Long idTeste = Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idTeste);

		if (salaV == null) {
			SalasVirtuais.entrarNovaSalaVirtual();
		}

		Long idSala = salaV.id;
		SalaVirtual sala = SalaVirtual.findById(idSala);
		s = sala;

		if (s.alunos.contains(aluno) == false) {
			s.alunos.add(aluno);
			s.save();
		}

		List<Aluno> alunos = sala.alunos;
		ValuePaginator listaPaginadaAlunos = new ValuePaginator(alunos);
		listaPaginadaAlunos.setPageSize(10);
		List<Aluno> listaAlunosRanking = new ArrayList<>();
		for (int a = 0; a < alunos.size(); a++) {
			System.out.println(alunos.get(a).nome + "---" + alunos.get(a).getPontosPorSala(sala.id));
			listaAlunosRanking.add(alunos.get(a));
		}

		listaAlunosRanking.sort(new Comparator<Aluno>() {

			@Override
			public int compare(Aluno aluno1, Aluno aluno2) {
				if (aluno1.getPontosPorSala(sala.id) < aluno2.getPontosPorSala(sala.id)) {
					return 1;

				}
				if (aluno2.getPontosPorSala(sala.id) < aluno1.getPontosPorSala(sala.id)) {
					return -1;
				}
				return 0;

			}
		});
		List<Aluno> listaPodio = new ArrayList<>();

		if (listaAlunosRanking.size() == 0) {
			listaPodio = null;
		}
		if (listaAlunosRanking.size() == 1) {
			for (Integer a = 0; a < 1; a++) {
				listaPodio.add(listaAlunosRanking.get(a));
			}
		}
		if (listaAlunosRanking.size() == 2) {
			for (Integer a = 0; a < 2; a++) {
				listaPodio.add(listaAlunosRanking.get(a));
			}
		}
		if (listaAlunosRanking.size() > 2) {

			for (Integer a = 0; a < 3; a++) {
				listaPodio.add(listaAlunosRanking.get(a));
			}
		}
		long salaVirtual = s.id;

		renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html", salaVirtual, salaV, listaPaginadaAlunos, listaPodio);
	}

	public static void mostrarSala(long i) {
		SalaVirtual salaVirtual = SalaVirtual.findById(i);
		renderTemplate("SalasVirtuais/novaSalaVirtualAlunos.html", salaVirtual);
	}

	public static void salvar(@Valid SalaVirtual s) {
		if (validation.hasErrors()) {
			validation.keep();
			params.flash();
			formSalasVirtuais();
		}
		if (s.id == null) {
			s.save();
			detalhes(s.id, s);
		} else {
			s.save();
			SalaVirtual sala = s;
			List<Aluno> salas = sala.alunos;
			List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
			List<Aluno> alunos = sala.alunos;

			ValuePaginator listaPaginadaAlunos = new ValuePaginator(salas);
			listaPaginadaAlunos.setPageSize(10);

			if (salas.isEmpty()) {
				listaPaginadaAlunos = null;
			} else {
				listaPaginadaAlunos = listaPaginadaAlunos;
			}

			List<Aluno> listaAlunosRanking = new ArrayList<>();
			for (int a = 0; a < alunos.size(); a++) {
				System.out.println(alunos.get(a).nome + "---" + alunos.get(a).getPontosPorSala(sala.id));
				listaAlunosRanking.add(alunos.get(a));
			}
			listaAlunosRanking.sort(new Comparator<Aluno>() {

				@Override
				public int compare(Aluno aluno1, Aluno aluno2) {
					if (aluno1.getPontosPorSala(sala.id) < aluno2.getPontosPorSala(sala.id)) {
						return 1;

					}
					if (aluno2.getPontosPorSala(sala.id) < aluno1.getPontosPorSala(sala.id)) {
						return -1;
					}
					return 0;
				}
			});
			List<Aluno> listaPodio = new ArrayList<>();
			if (listaAlunosRanking.size() == 0) {
				listaPodio = null;
			}
			if (listaAlunosRanking.size() == 1) {
				for (Integer a = 0; a < 1; a++) {
					listaPodio.add(listaAlunosRanking.get(a));
				}
			}
			if (listaAlunosRanking.size() == 2) {
				for (Integer a = 0; a < 2; a++) {
					listaPodio.add(listaAlunosRanking.get(a));
				}
			}
			if (listaAlunosRanking.size() > 2) {

				for (Integer a = 0; a < 3; a++) {
					listaPodio.add(listaAlunosRanking.get(a));
				}
			}
			long salaVirtual = sala.id;
			renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s, salas, listaCas, listaAlunosRanking,
					listaPodio, salaVirtual, listaPaginadaAlunos);
		}

	}

	public static void listarSalasVirtuais() {
		List<SalaVirtual> lista = SalaVirtual.findAll();
		render(lista);
	}

	public static void editar(long id) {
		SalaVirtual s = SalaVirtual.findById(id);
		renderTemplate("SalasVirtuais/formSalasVirtuais.html", s);
	}

	public static void deletar(long id) {
		SalaVirtual s = SalaVirtual.findById(id);
		Feed feed= Feed.find("idSalaVirtual= ?", id).first();
		//excluir feed
		if(feed != null) {
		feed.delete();
		}
		
		//excluir mensagens e comentarios
		if(feed != null) {
			List<Mensagem> listarMensagens= Mensagem.find("idFeed= ?", feed.id).fetch();
			if (listarMensagens != null) {
				for (int i = 0; i < listarMensagens.size(); i++) {
					listarMensagens.get(i).delete();
					}
	
			}
		}
		
		//escluir tabuleiro
		Tabuleiro tabuleiro= Tabuleiro.find("idSalaVirtual= ?", id).first();
		if(tabuleiro != null) {
			tabuleiro.delete();
		}
		
		//excluir Cas
		/*
		List<CentroAprendizagem> listarCas= CentroAprendizagem.find("idSalaVirtual= ?", id).fetch();
		if (listarCas != null) {
			for (int i = 0; i < listarCas.size(); i++) {
				listarCas.get(i).delete();
				}

		}
		*/
		//ecluir freq
		List<Frequencia> frequenciasSala= Frequencia.find("idSala= ?", id).fetch();
		if (frequenciasSala!= null) {
			for (int i = 0; i < frequenciasSala.size(); i++) {
				frequenciasSala.get(i).delete();
			}
		}
		
		
		//excluir ca
		List<CentroAprendizagem> listarCentros= CentroAprendizagem.find("idSalaVirtual = ?", id).fetch();
		if (listarCentros != null) {
			for (int i = 0; i < listarCentros.size(); i++) {
				listarCentros.get(i).delete();
			}
		}
		
		
		
		//comentario
		/*List<Comentario> listarComentarios = Comentario.find("idMensagem = ?", id).fetch();
		if (listarComentarios != null) {
			for (int i = 0; i < listarComentarios.size(); i++) {
				listarComentarios.get(i).delete();

			}
		}
		*/
		s.delete();
		indexProfessores();
	}
	

	public static void detalhes(long id, SalaVirtual s) {

		SalaVirtual sala = SalaVirtual.findById(id);
		String idP = session.get("idProfessor");
		Long idProfessor = Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);

		if (sala.professores.contains(professor) == false) {
			sala.professores.add(professor);
			sala.save();
		}

		List<Aluno> salas = sala.alunos;
		ValuePaginator listaPaginadaAlunos = new ValuePaginator(salas);
		listaPaginadaAlunos.setPageSize(10);

		if (salas.isEmpty()) {
			listaPaginadaAlunos = null;
		} else {
			listaPaginadaAlunos = listaPaginadaAlunos;
		}
		renderTemplate("SalasVirtuais/novaSalaVirtual.html", sala, s, salas, listaPaginadaAlunos);
	}

	public static void novaSalaVirtual(Long id) {
		System.out.println("mostrar id" + id);
		String idP = session.get("idProfessor");
		Long idProfessor = Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
		List<SalaVirtual> salas = professor.salasVirtuais;
		SalaVirtual sala = SalaVirtual.findById(id);
		List<CentroAprendizagem> listaCas = sala.centrosAprendizagem;
		render(salas, listaCas);
	}

	public static void novaSalaVirtualAlunos() {
		render();
	}

	public static void entrarNovaSalaVirtual() {
		render();
	}

	public static void indexProfessores() {

		String idP = session.get("idProfessor");
		Long idProfessor = Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
		List<SalaVirtual> salas = professor.salasVirtuais;

		List<SalaVirtual> salasProfessores = professor.salasVirtuais;
		System.out.println("ver salas   " + salasProfessores);
		List<SalaVirtual> salasSegunda = new ArrayList();
		List<SalaVirtual> salasTerça = new ArrayList();
		List<SalaVirtual> salasQuarta = new ArrayList();
		List<SalaVirtual> salasQuinta = new ArrayList();
		List<SalaVirtual> salasSexta = new ArrayList();

		for (int a = 0; a < salasProfessores.size(); a++) {
			if (salasProfessores.get(a).dia.equals("Segunda")) {
				salasSegunda.add(salasProfessores.get(a));
			}
			if (salasProfessores.get(a).dia.equals("Terça")) {
				salasTerça.add(salasProfessores.get(a));
			}
			if (salasProfessores.get(a).dia.equals("Quarta")) {
				salasQuarta.add(salasProfessores.get(a));
			}
			if (salasProfessores.get(a).dia.equals("Quinta")) {
				salasQuinta.add(salasProfessores.get(a));
			}
			if (salasProfessores.get(a).dia.equals("Sexta")) {
				salasSexta.add(salasProfessores.get(a));
			}

		}

		if (salasSegunda.size() == 0) {
			salasSegunda = null;
		}

		if (salasTerça.size() == 0) {
			salasTerça = null;
		}

		if (salasQuarta.size() == 0) {
			salasQuarta = null;
		}

		if (salasQuinta.size() == 0) {
			salasQuinta = null;
		}

		if (salasSexta.size() == 0) {
			salasSexta = null;
		}

		render(salas, salasSegunda, salasTerça, salasQuarta, salasQuinta, salasSexta);

	}

}
