package TareaTest;

import modelo.*;

public class TareaFixture1 {
	
	Colaborador colab = new Colaborador(null, null, null, null, null);
	Cliente client = new Cliente(null, null, null, null, null, null);
	Servicio serv = new Servicio("Servicio 1", "por hora", 0);
	Tarea tarea1 = null;
	
	public TareaFixture1() {
	
	}
	
	public void setUp() {
		tarea1 = new Tarea(colab,client,serv);
	}
	
	public void tearDown() {
		
	}
}
