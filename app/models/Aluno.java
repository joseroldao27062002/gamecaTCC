package models;
//import enums.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import com.google.gson.annotations.Expose;

//import enums.TipoUsuario;
import javax.persistence.Entity;

import play.data.validation.Email;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.mvc.Scope.Session;

@Entity
public class Aluno extends Model implements Comparable<Aluno>{
	@Expose
	/*@Required(message = "Inserção de nome obrigatório")
	@MinSize(value = 2, message = "O nome do aluno deve ter no mínimo 2 caracteres")*/
	public String nome;
	
	@Required(message = "Inserção de matrícula obrigatória")
	/*@Unique(message = "Um aluno cadastrado no sistema já tem essa matrícula")*/
	@Expose
	public long matricula;
	
	@Required(message = "Inserção de email obrigatório")
	/*@Unique(message = "Um aluno cadastrado no sistema já tem esse email")*/
	@Email(message = "O dado digitado não é compatível ao tipo email")
	@Expose
	public String email;
	
	@Required
	@MinSize(value = 3, message = "A senha deve ter no mínimo 3 caracteres")
	public String senha;
	
	public int pontos;
	
	@Expose
	@Transient
	public Integer pontuacaoPorCA;

	public int getPontos() {
		return pontos;
	}
		
	@ManyToMany(mappedBy="alunos")
	public List<SalaVirtual> salasVirtuais;
	
	public int getPontosPorSala(Long salaId) {
		List<Frequencia> frequencias = Frequencia.find("aluno=? and IdSala=?", this, salaId).fetch();
		
		int soma = 0;
		for(int i = 0; i<frequencias.size();i++) {
			soma += frequencias.get(i).grauFrequencia + frequencias.get(i).grauParticipacao;
		}
		return soma;
		//metodo para comparar pela soma
	}
	
	public Integer[] getFrequencia(Long salaId) {
		List<Frequencia> frequencias = Frequencia.find("aluno=? and id_Sala=?", this, salaId).fetch();
		
		Integer frequencia = 0;
		int  participacao = 0;
		Integer[] retorno = new Integer[2];
		for(int i = 0; i<frequencias.size();i++) {
			frequencia = frequencias.get(i).grauFrequencia; 
			participacao = frequencias.get(i).grauParticipacao;
			retorno[0] = frequencia;
			retorno[1] = participacao;
			
		}
		return retorno;
	}

	@Override
		public int compareTo(Aluno a) {
			return (a.pontos - this.pontos);
			
	}	
	
	
	
	
}
