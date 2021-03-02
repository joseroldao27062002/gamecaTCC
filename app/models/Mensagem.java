package models;

import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;
import sun.util.calendar.LocalGregorianCalendar.Date;

@Entity
public class Mensagem extends Model{
	public String conteudoMensagem;
	public String autorMensagem;
	public long matriculaAutorMensagem;
	public String nomeFoto;
	public String dataPublicacao;
	public String horaPublicacao;
	
	@ManyToOne
	@JoinColumn(name="idFeed")
	public Feed feed;
	
	@OneToMany
	@JoinColumn(name="idComentario")
	public List<Comentario> comentarios;

}
