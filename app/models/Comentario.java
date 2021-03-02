package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Model;

@Entity
public class Comentario extends Model {

	public String autorComentario;
	public String comentario;
	public long matriculaAutorComentario;
	public long idFeed;
	public String dataPublicacao;
	public String horaPublicacao;
	
	
	
	@ManyToOne
	@JoinColumn(name="idMensagem")
	public Mensagem mensagem;
}
