package jobs;

//import enums.TipoUsuario;
import models.Aluno;
import models.Professor;
import models.SalaVirtual;
import play.jobs.Job;
import play.jobs.OnApplicationStart;


@OnApplicationStart
public class inicializador extends Job{

	@Override
	public void doJob() throws Exception {
		
		if(Aluno.count() == 0) {
			
			Aluno  aluno1 = new Aluno();
			aluno1.nome = "Aluno1";
			aluno1.matricula = 	Long.parseLong("376465346");
			aluno1.email = "aluno1@gmail.com";
			aluno1.senha = "123";
			//aluno1.tipoUsuario = TipoUsuario.ALUNO;
			aluno1.save();
			
			Aluno  aluno2 = new Aluno();
			aluno2.nome = "Aluno2";
			aluno2.matricula = 	Long.parseLong("398364146");
			aluno2.email = "aluno2@gmail.com";
			aluno2.senha = "123";
			//aluno1.tipoUsuario = TipoUsuario.ALUNO;
			aluno2.save();
			
			Aluno  aluno3 = new Aluno();
			aluno3.nome = "Aluno3";
			aluno3.matricula = 	Long.parseLong("123463749");
			aluno3.email = "aluno3@gmail.com";
			aluno3.senha = "123";
			//aluno2.tipoUsuario = TipoUsuario.ALUNO;
			aluno3.save();
			
			Aluno  aluno4 = new Aluno();
			aluno4.nome = "Aluno4";
			aluno4.matricula = 	Long.parseLong("306462346");
			aluno4.email = "aluno4@gmail.com";
			aluno4.senha = "123";
			//aluno1.tipoUsuario = TipoUsuario.ALUNO;
			aluno4.save();
			
		}
		if(Professor.count() == 0) {
			
			Professor  professor1 = new Professor();
			professor1.nome = "Professor1";
			professor1.matricula = 	Long.parseLong("7046546");
			professor1.email = "professor1@gmail.com";
			professor1.senha = "123";
			//professor1.tipoUsuario = TipoUsuario.PROFESSOR;
			professor1.save();
			
			Professor  professor2 = new Professor();
			professor2.nome = "Professor2";
			professor2.matricula = 	Long.parseLong("06466546");
			professor2.email = "professor2@gmail.com";
			professor2.senha = "123";
			//professor2.tipoUsuario = TipoUsuario.PROFESSOR;
			professor2.save();
				
		}
		if(SalaVirtual.count() == 0) {
			
			SalaVirtual sala1 = new SalaVirtual();
			sala1.nomeTurma = "4INF2M";
			sala1.sala = "5";
			sala1.bloco = "2";
			sala1.disciplina = "História";
			sala1.horario = "15:20h";
			sala1.dia = "Terça";
			sala1.codigo = "f2af30d1";
			sala1.save();
			
			
				
		}
	}

}
