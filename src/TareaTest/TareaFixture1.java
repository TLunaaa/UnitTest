package TareaTest;

/*
 * Tarea recien creada,con el estado abierto.
 * Es el mismo escenario para el caso en el que la tarea estuviera en pausa.
 */

import modelo.*;

public class TareaFixture1 {
	
	public Tarea tarea = null;
	
	public TareaFixture1() {
		
	}
	
	public void setUp() {
		Colaborador colab = new Colaborador("Juan Gonzales", "eljuancho22@hotmail.com","223451252","juanjuan", "123");
		Cliente client = new Cliente("Paco Martinez", "paco_negocios@fimdp.com.ar", "2262457896", "23124578", "emprendedor", "emprendedoresmdp");
		Servicio serv = new Servicio("Servicio1","fijo",300);
		tarea = new Tarea(colab,client,serv);

	}
	
	public void tearDown() {
		
	}
}
