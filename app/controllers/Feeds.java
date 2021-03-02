package controllers;

import java.util.List;

import models.Aluno;
import models.Comentario;
import models.Feed;
import models.Mensagem;
import models.Professor;
import models.SalaVirtual;
import models.Tabuleiro;
import play.mvc.Before;
import play.mvc.Controller;

public class Feeds extends Controller {
	
	@Before(only = {"criarFeed"})
	static void rentringirSalaAoProfessor() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Professor")) {
			Restricoes.restricoesAlunos();
		}
	}

	public static void criarFeed(Long idSalaVirtual) {
		Feed feed1 = Feed.find("idSalaVirtual = ?", idSalaVirtual).first();
		String idP = session.get("idProfessor");
		Long idProfessor = Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);

		Long matricula = professor.matricula;

		if (feed1 != null) {
			long idFeed = feed1.id;
			List<Comentario> listarComentarios = Comentario.find("idFeed = ?", idFeed).fetch();
			List<Mensagem> listarMensagens = Mensagem.find("idFeed = ?", idFeed).fetch();
			renderTemplate("Mensagens/feed.html", idSalaVirtual, idFeed, listarMensagens, matricula, listarComentarios);

		} else {
			render(idSalaVirtual);
		}

	}

	public static void salvar(Long idSalaVirtual, Feed feed) {
		String idP = session.get("idProfessor");
		Long idProfessor = Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
		SalaVirtual sala = SalaVirtual.findById(idSalaVirtual);
		feed.salaVirtual = sala;
		feed.save();
		long idFeed = feed.id;
		System.out.println("idFeed salvar " + idFeed);
		detalhes(idSalaVirtual, idFeed);
	}

	public static void detalhes(long idSalaVirtual, long idFeed) {
		renderTemplate("Mensagens/Feed.html", idSalaVirtual, idFeed);
	}

}
