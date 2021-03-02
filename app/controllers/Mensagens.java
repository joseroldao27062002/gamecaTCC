package controllers;

import java.util.Calendar;
import java.util.List;
import java.io.File;
import java.text.SimpleDateFormat;

import models.Aluno;
import models.Comentario;
import models.Feed;
import models.Mensagem;
import models.Professor;
import models.SalaVirtual;
import play.mvc.Before;
import play.mvc.Controller;
import sun.util.calendar.LocalGregorianCalendar.Date;

public class Mensagens extends Controller {
	
	@Before(only = {"comentarioAluno", "feedAluno"})
	static void rentringirSalaAoAluno() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Aluno")) {
			Restricoes.restricoesProfessores();
		}
	}

	@Before(only = {"feed", "comentario"})
	static void rentringirSalaAoProfessor() {
		if (session.get("tipoUsuario") != null && !session.get("tipoUsuario").equalsIgnoreCase("Professor")) {
			Restricoes.restricoesAlunos();
		}
	}

	public static void comentario(long idMensagem) {
		render(idMensagem);
	}

	public static void comentarioAluno(long idMensagem) {
		render(idMensagem);
	}

	public static void salvarComentarioAluno(Long idMensagem, Comentario comentario) {
		String idA = session.get("idAluno");
		Long idAluno = Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idAluno);

		Mensagem mensagem = Mensagem.findById(idMensagem);
		Calendar calendar = Calendar.getInstance();
		java.util.Date data = calendar.getTime();
		SimpleDateFormat sddia = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdhora = new SimpleDateFormat("HH:mm:ss");
		String dia = sddia.format(data);
		String hora = sdhora.format(data);
		comentario.dataPublicacao = dia;
		comentario.horaPublicacao = hora;
		comentario.mensagem = mensagem;
		comentario.autorComentario = aluno.nome;
		comentario.matriculaAutorComentario = aluno.matricula;
		Feed feed = mensagem.feed;
		long idFeed = feed.id;
		comentario.idFeed = idFeed;
		SalaVirtual sala = feed.salaVirtual;
		long idSalaVirtual = sala.id;
		comentario.save();
		detalhesAlunos(idFeed, idSalaVirtual, null);
	}

	public static void editarComentarioAluno(long id, long idMensagem) {
		Comentario comentario = Comentario.findById(id);
		renderTemplate("Mensagens/comentarioAluno.html", comentario, idMensagem);
	}

	public static void salvarComentario(Long idMensagem, Comentario comentario) {
		String idP = session.get("idProfessor");
		Long idProfessor = Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);
		Mensagem mensagem = Mensagem.findById(idMensagem);
		Calendar calendar = Calendar.getInstance();
		java.util.Date data = calendar.getTime();
		SimpleDateFormat sddia = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdhora = new SimpleDateFormat("HH:mm:ss");
		String dia = sddia.format(data);
		String hora = sdhora.format(data);
		comentario.dataPublicacao = dia;
		comentario.horaPublicacao = hora;
		comentario.mensagem = mensagem;
		comentario.autorComentario = professor.nome;
		comentario.matriculaAutorComentario = professor.matricula;
		Feed feed = mensagem.feed;
		long idFeed = feed.id;
		comentario.idFeed = idFeed;
		SalaVirtual sala = feed.salaVirtual;
		long idSalaVirtual = sala.id;
		comentario.save();
		detalhes(idFeed, idSalaVirtual, null);
	}

	public static void editarComentario(long id, long idMensagem) {
		Comentario comentario = Comentario.findById(id);
		renderTemplate("Mensagens/comentario.html", comentario, idMensagem);
	}

	public static void deletarComentarioAluno(long id, long idMensagem) {
		Comentario comentario = Comentario.findById(id);
		comentario.delete();
		Mensagem mensagem = Mensagem.findById(idMensagem);
		Feed feed = mensagem.feed;
		long idFeed = feed.id;
		comentario.idFeed = idFeed;
		SalaVirtual sala = feed.salaVirtual;
		long idSalaVirtual = sala.id;
		detalhesAlunos(idFeed, idSalaVirtual, null);
	}

	public static void deletarComentario(long id, long idMensagem) {
		Comentario comentario = Comentario.findById(id);
		comentario.delete();
		Mensagem mensagem = Mensagem.findById(idMensagem);
		Feed feed = mensagem.feed;
		long idFeed = feed.id;
		comentario.idFeed = idFeed;
		SalaVirtual sala = feed.salaVirtual;
		long idSalaVirtual = sala.id;
		detalhes(idFeed, idSalaVirtual, null);
	}

	public static void salvar(long idFeed, long idSalaVirtual, Mensagem mensagem, File foto) {
		Feed feed = Feed.findById(idFeed);
		mensagem.feed = feed;
		String idP = session.get("idProfessor");
		Long idProfessor = Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);

		mensagem.matriculaAutorMensagem = professor.matricula;
		mensagem.autorMensagem = professor.nome;
		if (foto != null) {
			mensagem.nomeFoto = foto.getName();
		}

		Calendar calendar = Calendar.getInstance();
		java.util.Date data = calendar.getTime();
		SimpleDateFormat sddia = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdhora = new SimpleDateFormat("HH:mm:ss");
		String dia = sddia.format(data);
		String hora = sdhora.format(data);
		mensagem.dataPublicacao = dia;
		mensagem.horaPublicacao = hora;
		mensagem.save();

		if (foto != null) {
			new File("./uploads/" + mensagem.id).mkdirs();
			File dest = new File("./uploads/" + mensagem.id + "/" + foto.getName());
			if (dest.exists()) {
				dest.delete();
			}
			foto.renameTo(dest);
		}

		detalhes(idFeed, idSalaVirtual, foto);
	}

	public static void editar(long id, long idSalaVirtual, File foto) {

		Mensagem mensagem = Mensagem.findById(id);
		Feed feed = mensagem.feed;
		long idFeed = feed.id;
		File foto1;
		if (foto == null) {
			foto1 = null;

		}

		else {
			foto1 = foto;
		}

		List<Mensagem> listarMensagens = Mensagem.find("idFeed = ?", feed.id).fetch();
		renderTemplate("Mensagens/feed.html", idFeed, idSalaVirtual, mensagem, foto1);
	}

	public static void deletar(long id, long idSalaVirtual) {
		System.out.println("idMensagem " + id);
		System.out.println("idSalaVirtual " + idSalaVirtual);
		Mensagem mensagem = Mensagem.findById(id);
		Feed feed = mensagem.feed;
		long idFeed = feed.id;

		List<Comentario> listarComentarios = Comentario.find("idMensagem = ?", id).fetch();
		if (listarComentarios != null) {
			for (int i = 0; i < listarComentarios.size(); i++) {
				listarComentarios.get(i).delete();

			}
		}
		mensagem.delete();

		detalhes(idFeed, idSalaVirtual, null);
	}

	public static void feed(long idSalaVirtual, long idFeed) {
		render(idSalaVirtual, idFeed);
	}

	public static void detalhes(long idFeed, long idSalaVirtual, File foto) {
		String idP = session.get("idProfessor");
		Long idProfessor = Long.valueOf(idP);
		Professor professor = Professor.findById(idProfessor);

		Long matricula = professor.matricula;
		List<Comentario> listarComentarios = Comentario.find("idFeed = ?", idFeed).fetch();
		List<Mensagem> listarMensagens = Mensagem.find("idFeed = ?", idFeed).fetch();
		System.out.println("LISTAR COMENTARIOS " + listarComentarios);
		renderTemplate("Mensagens/feed.html", idSalaVirtual, idFeed, listarMensagens, foto, matricula,
				listarComentarios);
	}

	// Feed aluno
	public static void encontrarFeed(long idSalaVirtual) {
		System.out.println("idSalaVirtual " + idSalaVirtual);
		SalaVirtual sala = SalaVirtual.findById(idSalaVirtual);
		System.out.println("sala " + sala);
		Feed feed = Feed.find("idSalaVirtual = ?", idSalaVirtual).first();
		if (feed == null) {
			Mensagens.mensagemFeed();
		} else {
			long idFeed = feed.id;
			System.out.println("idFeed " + idFeed);

			feedAluno(idSalaVirtual, idFeed);
		}
	}

	public static void mensagemFeed() {
		render();
	}

	public static void feedAluno(long idSalaVirtual, long idFeed) {

		String idA = session.get("idAluno");
		Long idAluno = Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idAluno);
		Long matricula = aluno.matricula;
		List<Mensagem> listarMensagens = Mensagem.find("idFeed = ?", idFeed).fetch();
		List<Comentario> listarComentarios = Comentario.find("idFeed = ?", idFeed).fetch();
		render(idSalaVirtual, idFeed, listarMensagens, matricula, listarComentarios);
	}

	public static void salvarMensagemAluno(long idFeed, long idSalaVirtual, Mensagem mensagem, File foto) {
		Feed feed = Feed.findById(idFeed);
		mensagem.feed = feed;
		String idA = session.get("idAluno");
		Long idAluno = Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idAluno);
		mensagem.matriculaAutorMensagem = aluno.matricula;
		mensagem.autorMensagem = aluno.nome;
		if (foto != null) {
			mensagem.nomeFoto = foto.getName();
		}
		Calendar calendar = Calendar.getInstance();
		java.util.Date data = calendar.getTime();
		SimpleDateFormat sddia = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sdhora = new SimpleDateFormat("HH:mm:ss");
		String dia = sddia.format(data);
		String hora = sdhora.format(data);
		mensagem.dataPublicacao = dia;
		mensagem.horaPublicacao = hora;
		mensagem.save();

		if (foto != null) {
			new File("./uploads/" + mensagem.id).mkdirs();
			File dest = new File("./uploads/" + mensagem.id + "/" + foto.getName());
			if (dest.exists()) {
				dest.delete();
			}
			foto.renameTo(dest);
		}

		detalhesAlunos(idFeed, idSalaVirtual, foto);
	}

	public static void editarMensagemAluno(long id, long idSalaVirtual, File foto) {

		Mensagem mensagem = Mensagem.findById(id);
		Feed feed = mensagem.feed;
		long idFeed = feed.id;
		File foto1;
		if (foto == null) {
			foto1 = null;

		}

		else {
			foto1 = foto;
		}

		List<Mensagem> listarMensagens = Mensagem.find("idFeed = ?", feed.id).fetch();
		renderTemplate("Mensagens/feedAluno.html", idFeed, idSalaVirtual, mensagem, foto1);
	}

	public static void deletarMensagemAluno(long id, long idSalaVirtual) {
		Mensagem mensagem = Mensagem.findById(id);
		Feed feed = mensagem.feed;
		long idFeed = feed.id;

		List<Comentario> listarComentarios = Comentario.find("idMensagem = ?", id).fetch();
		if (listarComentarios != null) {
			for (int i = 0; i < listarComentarios.size(); i++) {
				listarComentarios.get(i).delete();

			}
		}
		mensagem.delete();
		detalhesAlunos(idFeed, idSalaVirtual, null);
	}

	public static void detalhesAlunos(long idFeed, long idSalaVirtual, File foto) {
		String idA = session.get("idAluno");
		Long idAluno = Long.valueOf(idA);
		Aluno aluno = Aluno.findById(idAluno);
		Long matricula = aluno.matricula;
		List<Comentario> listarComentarios = Comentario.find("idFeed = ?", idFeed).fetch();
		List<Mensagem> listarMensagens = Mensagem.find("idFeed = ?", idFeed).fetch();
		renderTemplate("Mensagens/feedAluno.html", idSalaVirtual, idFeed, listarMensagens, foto, matricula,
				listarComentarios);
	}
}
