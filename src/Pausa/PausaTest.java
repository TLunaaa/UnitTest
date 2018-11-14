package Pausa;

import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;


public class PausaTest {
	
	private PausaFixture1 escenario = new PausaFixture1();
	
	public PausaTest() {}
	
	@Before
	public void setUp() {
		escenario.setUp();
	}
	
	@After 
	public void tearDown() {
		escenario.tearDown();
	}
	
	@Test
	public void testPruebaAbrir() {
		try {
			this.escenario.pausa.actualizaAbierto();
			assertTrue("No se cambio el estado de la tarea.", this.escenario.pausa.getTarea().getEstado().getTipoEstado().equalsIgnoreCase("abierto"));
		} catch(Exception e) {
			fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testPruebaCerrar() {
		try {
			this.escenario.pausa.actualizaCerrado();
			assertTrue("No se cambio el estado de la tarea.", this.escenario.pausa.getTarea().getEstado().getTipoEstado().equalsIgnoreCase("cerrado"));
		} catch(Exception e) {
			fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testPruebaPausar() {
		try {
			this.escenario.pausa.actualizaPausa();
			fail("Deberia haber lanzado alguna excepcion.");
		} catch(Exception e) {
			assertTrue("Lanzo una excepcion incorrecta.", e.getMessage().equalsIgnoreCase("Cambio de estado invalido: de pausa a pausa."));
		}
	}
}
