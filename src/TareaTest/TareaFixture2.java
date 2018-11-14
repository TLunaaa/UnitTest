package TareaTest;

import modelo.Cliente;
import modelo.Colaborador;
import modelo.GTSPException;
import modelo.Servicio;
import modelo.Tarea;

/*
 * Tarea con el estado cerrado.
 */

public class TareaFixture2 {
    public Tarea tarea = null;
	
	public TareaFixture2() {
		
	}
	
	public void setUp() {
		Colaborador colab = new Colaborador("Juan Gonzales", "eljuancho22@hotmail.com","223451252","juanjuan", "123");
		Cliente client = new Cliente("Paco Martinez", "paco_negocios@fimdp.com.ar", "2262457896", "23124578", "emprendedor", "emprendedoresmdp");
		Servicio serv = new Servicio("Servicio1","fijo",300);
		tarea = new Tarea(colab,client,serv);
		try {
			tarea.actualizoTarea("cerrado");
		}catch(GTSPException e) {
			
		}
		
	}
	
	public void tearDown() {
	}

}
