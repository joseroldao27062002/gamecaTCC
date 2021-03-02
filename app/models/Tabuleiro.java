package models;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import antlr.collections.List;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Tabuleiro extends Model {
	@Required(message="O nome do tabuleiro é obrigatório")
	@MinSize(value = 2, message="O nome deve ter pelo menos 2 caracteres")
	public String nome;
	@OneToOne
	@JoinColumn(name="idSalaVirtual")
	public SalaVirtual salaVirtual;
}
