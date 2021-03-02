package models;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import controllers.SalasVirtuais;
import play.data.validation.MaxSize;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class SalaVirtual extends Model{
	@Required(message = "A inserção de um dia da semana é obrigatório")
	public String dia;

	@Required(message = "Inserção do nome da turma é obrigatória")
	@MinSize(value = 4, message = "O nome da turma deve ter pelo menos 5 caracteres")
	public String nomeTurma;

	@Required(message = "Informe o horário")
	public String horario;

	@Required(message = "A inserção da sala é obrigatória")
	@Min(value = 1, message = "A sala não pode ter um número menor ou igual a 0")
	@MinSize(value = 1, message = "A sala deve ter pelo menos 1 caracter")
	@MaxSize(value = 3, message =  "A sala deve ter no m[aximo 3 caracteres")
	public String sala;

	@Required(message = "A inserção do bloco obrigatório")
	@Min(value = 1, message = "O número do bloco não pode ser um valor menor ou igual a 0")
	@MaxSize(value = 2, message = "O bloco deve ter no máximo 2 caracteres")
	public String bloco;

	@Required(message = "O nome da disciplina é obrigatório")
	@MinSize(value = 2, message = "O nome da disciplina deve ter pelo menos 2 caracteres")
	public String disciplina;
	
	
	@ManyToMany
	@JoinTable(name="salaVirtual_aluno")
	public List<Aluno> alunos;
	
	@ManyToMany
	@JoinTable(name="salaVirtual_professor")
	public List<Professor> professores;

	@OneToMany
	@JoinColumn(name="IdSalaVirtual")
	public List<CentroAprendizagem> centrosAprendizagem;
	
	@OneToOne
	@JoinColumn(name="idTabuleiro")
    public Tabuleiro tabuleiros;
	
	@OneToOne
	@JoinColumn(name="idFeed")
    public Feed feed;
	
	
	/*
	@OneToMany
	@JoinColumn(name="IdSalaVirtual")
	public List<Frequencia> frequencias;
	*/
	
	//quando o relacionamento é manyToMany o BD vai criar uma terceira tabela
	
	
	public static String geradorDeCodigos() {
	UUID codigo= UUID.randomUUID();
		
	if (codigo.toString().length() > 10) {
		return codigo.toString().substring(0, 8);	
	}
		return null;	
	} 
	public String codigo = geradorDeCodigos();
	
	

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
}