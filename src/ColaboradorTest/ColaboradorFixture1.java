package ColaboradorTest;

import java.util.ArrayList;

import modelo.*;

public class ColaboradorFixture1 {
	
	Colaborador colab1;
	Cliente client;
	private Servicio serv; 
	private Tarea tarea; 
	private Modelo modelo;
	

	
	public ColaboradorFixture1() {
	
	}
	
	public void setUp() {
		colab1 = new Colaborador("Pedrito Perez","pedrito@gmail.com","123","pedrito","123");
		client = new Cliente("pepito", "pepito@gmail.com", "123", "444", "", "");
		serv = new Servicio("comer", null, 0);
		tarea = new Tarea(colab1,client,serv);
		
	}
	
	public void tearDown() {
		
	}
	
	
}