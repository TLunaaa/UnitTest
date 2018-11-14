package ColaboradorTest;

import modelo.*;

public class ColaboradorFixture2 {
	
	Colaborador colab1;
	private Cliente client;
	private Servicio serv; 
	private Tarea tarea; 
	
	public ColaboradorFixture2() {
	
	}
	
	public void setUp() {
		colab1 = new Colaborador("Pedrito Perez","pedrito@gmail.com","123","pedrito","123");
	}
	
	public void tearDown() {
		
	}
}
