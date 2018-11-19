package AdministradorTest;

import org.junit.Test;

import modelo.GTSPException;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;


public class AdminTest2 {
	
	AdminrFixture2 fixture2 = new AdminrFixture2();
	
	public AdminTest2() {
		
	}
	
	/**
	 * Inicio Fixture
	 */
	
	@Before
	public void setUp() {
		fixture2.setUp();
	}
	
	
	@Test
	public void testInformeTareasDeColaborador1() {
		String informe = fixture2.colab1.informeTareasDeColaborador(new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
		assertEquals("Devolucion Incorrecta",informe,"El colaborador no posee tareas. \nTOTAL HORAS: 0");
	}
}
