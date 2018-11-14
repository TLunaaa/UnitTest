package Servicio;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServicioTest3 {

	private ServicioFixture3 escenario = new ServicioFixture3();
	
	public ServicioTest3() {
	
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
		assertTrue("Descripcion incorrecta.", escenario.myServicio.getDescripcion().equalsIgnoreCase(" "));
	}
	
	@Test	
	public void testCalculoCosto1() {
		try {
			double valor = escenario.myServicio.calcularCostoFinal(60);
			fail("Deberia haber lanzado alguna excepcion.");
		} catch(Exception e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("No existe un servicio con ese tipo de costo"));
		}
	}
	
	@Test
	public void testCalculoCosto2() {
		try {
			double valor = escenario.myServicio.calcularCostoFinal(-10);
			fail("Deberia haber lanzado alguna excepcion.");
		} catch(Exception e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("No existe un servicio con ese tipo de costo"));
		}
	}
}
