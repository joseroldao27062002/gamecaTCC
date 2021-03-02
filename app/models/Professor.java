package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
//import enums.TipoUsuario;
import play.db.jpa.Model;

@Entity
public class Professor extends Model{
	/*@Required(message = "Inserção do nome do professor é obrigatória")
	@MinSize(value = 2, message = "O nome do professor deve ter pelo menos 2 caracteres")*/
	public String nome;

	@Required(message = "Inserção da matrícula obrigatória")
	/*@Unique(message = "Um professor cadastrado no sistema já tem essa matrícula")*/
	public Long matricula;

	@Required(message = "Inserção do email é obrigatório")
	@Email(message = "O dado digitado não é compatível ao tipo email")
	/*@Unique(message = "Um professor cadastrado no sistema já tem esse email")*/
	public String email;

	@Required(message = "Inserção da senha é obrigatória")
	@MinSize(value = 3, message = "A senha deve ter no mínimo 3 caracteres")
	public String senha;
	
	//public TipoUsuario tipoUsuario;
	
	public Professor() {
	//tipoUsuario = TipoUsuario.PROFESSOR;
	}
	
	@ManyToMany(mappedBy="professores")
	public List<SalaVirtual> salasVirtuais;
	
	@OneToMany
	@JoinColumn(name="idSalaVirtual")
	public List <CentroAprendizagem> centrosAprendizagem;
	
	
	//@ManyToMany(mappedBy="professores")
	//public List<SalaVirtual> salasVirtuais;
	
	
}
