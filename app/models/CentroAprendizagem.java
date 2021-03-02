package models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class CentroAprendizagem extends Model{
	
		/*@InFuture(message = "Informe uma data futura")*/
		@Required(message = "Inserção de data é obrigatória")
		public String data;
		
		@Required(message = "Inserção de horário é obrigatório")
		public String horario;
		
		@Required(message = "Inserção de assunto é obrigatório")
		@MinSize(value = 5, message = "O assunto deve ter pelo menos 5 caracteres")
		public String assunto;
		
		@Required(message = "Inserção de local é obrigatório")
		@MinSize(value = 2, message = "A Local deve ter pelo menos 2 caracteres")
		public String local;
		
		
		@ManyToOne
		@JoinColumn(name="idSalaVirtual")
		public SalaVirtual salaVirtual;
	}

	
	


