package teste;
import javafx.application.Application;
import java.util.UUID;

import models.SalaVirtual;

public class testando {
	
	public static void a() {
		UUID codigo= UUID.randomUUID();
		
			if (codigo.toString().length() > 10) {
			System.out.println(codigo.toString().substring(0, 8));
			
			}
	}

}




