package Abierto;

import junit.framework.JUnit4TestAdapter;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;


public class AbiertoTest {
	
	private AbiertoFixture1 escenario = new AbiertoFixture1();
	
	public AbiertoTest() {}
	
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
			this.escenario.abierto.actualizaAbierto();
			fail("Deberia haber lanzado excepsion");			
		} catch(Exception e) {
			assertTrue("Deberia haber lanzado otra excepcion.", e.getMessage().equalsIgnoreCase("Cambio de estado invalido: de abierto a abierto."));
		}
	}
	
	@Test
	public void testPruebaCerrar() {
		try {
			this.escenario.abierto.actualizaCerrado();
			assertTrue("No se cambio el estado de la tarea.", this.escenario.abierto.getTarea().getEstado().getTipoEstado().equalsIgnoreCase("cerrado"));
		} catch(Exception e) {
			fail("No deberia lanzar ninguna excepcion");
		}
	}
	
	@Test
	public void testPruebaPausar() {
		try {
			this.escenario.abierto.actualizaPausa();
			assertTrue("No se cambio el estado de la tarea.", this.escenario.abierto.getTarea().getEstado().getTipoEstado().equalsIgnoreCase("pausa"));
		} catch(Exception e) {
			fail("No deberia haber lanzado ninguna excepcion.");
		}
	}
}
