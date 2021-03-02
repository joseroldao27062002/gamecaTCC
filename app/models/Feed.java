package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class Feed extends Model{
	
	@OneToOne
	@JoinColumn(name="idSalaVirtual")
	public SalaVirtual salaVirtual;

	@OneToMany
	@JoinColumn(name="IdFeed")
	public List<Mensagem> mensagens;
}
