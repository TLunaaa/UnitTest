package AdministradorTest;

import modelo.*;

public class AdminrFixture2 {
	
	Colaborador colab1;
	private Cliente client;
	private Servicio serv; 
	private Tarea tarea; 
	
	public AdminrFixture2() {
	
	}
	
	public void setUp() {
		colab1 = new Colaborador("Pedrito Perez","pedrito@gmail.com","123","pedrito","123");
	}
	
	public void tearDown() {
		
	}
}
