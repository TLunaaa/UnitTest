package Servicio;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServicioTest1 {

	private ServicioFixture1 escenario = new ServicioFixture1();
	
	public ServicioTest1() {
	
	}
	
	@Before 
	public void setUp() {
		escenario.setUp();
	}
	
	@After 
	public void tearDown() {
		escenario.tearDown();
	}
	
	@Test
	public void testGetDescripcion() {
		assertTrue("Descripcion incorrecta.", escenario.myServicio.getDescripcion().equalsIgnoreCase("Probando"));
	}
	
	@Test	
	public void testCalculoCosto1() {
		try {
			assertTrue("El valor calculado no es el esperado", escenario.myServicio.calcularCostoFinal(10) == 220);
		} catch(Exception e) {
			fail("No deberia haber lanzado ninguna excepcion.");
		}
	}
	
	@Test
	public void testCalculoCosto2() {
		try {
			assertTrue("El valor calculado no es el esperado.",  escenario.myServicio.calcularCostoFinal(-5) == -110);
		} catch(Exception e) {
			fail("No deberia haber lanzado ninguna excepcion.");
		}
	}
}
