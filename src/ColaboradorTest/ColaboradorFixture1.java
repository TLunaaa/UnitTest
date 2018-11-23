package ColaboradorTest;

import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import modelo.*;

public class ColaboradorFixture1 {
	
	Colaborador colab1;
	Colaborador colab2;
	Cliente client;
	Cliente client2;
	private Servicio serv; 
	private Modelo modelo;
	

	
	public ColaboradorFixture1() {
	
	}
	
	public void setUp() {
		colab1 = new Colaborador("Pedrito Perez","pedrito@gmail.com","12345678","pedrito","123");
		colab2 = new Colaborador("Stuart Vang","magna@non.org","657-947-5496","vangi","456");
		client = new Cliente("Paco Martinez", "paco_negocios@fimdp.com.ar", "2262457896", "23124578", "emprendedor", "emprendedoresmdp");
		client2 = new Cliente("Jose Hernandez", "gaucho22@fimdp.com.ar", "2262345667", "35843794", "emprendedor", "emprendedoresmiramar");
		serv = new Servicio("Servicio1","fijo",300);
		Tarea tarea = new Tarea(colab1,client,serv);
		Tarea tarea2 = new Tarea(colab2,client,serv);
		try {
			tarea.actualizoTarea("cerrado");
			tarea.setHorasDedicadas(200);
		} catch (GTSPException e) {
			fail("salto aserto");
		}
		colab1.getTareas().add(tarea);
		colab2.getTareas().add(tarea2);
	}
	
	public void tearDown() {
		colab1.getTareas().clear();
		colab2.getTareas().clear();
	}
	
	
}
