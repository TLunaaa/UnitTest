package Cerrado;


import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;


public class CerradoTest {
	
	private CerradoFixture1 escenario = new CerradoFixture1();
	
	public CerradoTest() {}
	
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
			this.escenario.cerrado.actualizaAbierto();
			fail("Deberia lanzar alguna excepcion");
		} catch(Exception e) {
			assertTrue("Lanzo una excepcion incorrecta.", e.getMessage().equalsIgnoreCase("Cambio de estado invalido: de cerrado a abierto."));
		}
	}
	
	@Test
	public void testPruebaCerrar() {
		try {
			this.escenario.cerrado.actualizaCerrado();
			fail("Deberia lanzar alguna excepcion");
		} catch(Exception e) {
			assertTrue("Lanzo una excepcion incorrecta.", e.getMessage().equalsIgnoreCase("Cambio de estado invalido: de cerrado a cerrado."));
		}
	}
	
	@Test
	public void testPruebaPausar() {
		try {
			this.escenario.cerrado.actualizaPausa();
			fail("Deberia haber lanzado alguna excepcion.");
		} catch(Exception e) {
			assertTrue("Lanzo una excepcion incorrecta.", e.getMessage().equalsIgnoreCase("Cambio de estado invalido: de cerrado a pausa."));
		}
	}
}
