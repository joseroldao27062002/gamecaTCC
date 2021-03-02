package models;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Frequencia extends Model {
	
	public Integer grauParticipacao;
	public Integer grauFrequencia;

	
	
	@ManyToOne
	@JoinColumn(name="idAluno")
	public Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="idCa")
	public CentroAprendizagem centroAprendizagem;
	
	@ManyToOne
	@JoinColumn(name="idSala")
	public SalaVirtual salas;

	
		
}
