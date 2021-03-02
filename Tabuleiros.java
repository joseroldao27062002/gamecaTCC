
package controllers;
import models.SalaVirtual;
import models.Tabuleiro;
import play.mvc.Controller;

public class Tabuleiros extends Controller {
	public static void indexTabuleiro() {
		render();
	}
	
	public static void formTabuleiro(Long salaVirtual) {
		render();
	}
	
	public static void salvarTabuleiro(Tabuleiro t, Long idSala) {
		SalaVirtual sala = SalaVirtual.findById(idSala);
		t.salaVirtual = sala;
		t.save();
	}
=======
package controllers;
import models.SalaVirtual;
import models.Tabuleiro;
import play.mvc.Controller;

public class Tabuleiros extends Controller {
	public static void indexTabuleiro() {
		render();
	}
	
	public static void formTabuleiro(Long salaVirtual) {
		render();
	}
	
	public static void salvarTabuleiro(Tabuleiro t, Long idSala) {
		SalaVirtual sala = SalaVirtual.findById(idSala);
		t.salaVirtual = sala;
		t.save();
	}
}