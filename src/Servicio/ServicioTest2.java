package Servicio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServicioTest2 {

	private ServicioFixture2 escenario = new ServicioFixture2();
	
	public ServicioTest2() {
	
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
			assertTrue("El valor calculado no es el esperado", escenario.myServicio.calcularCostoFinal(10) == 650);
		} catch(Exception e) {
			fail("No deberia haber lanzado ninguna excepcion.");
		}
	}
	
	/*
	 * Se prueban horas negativas
	 */
	@Test
	public void testCalculoCosto2() {
		try {
			double costo = escenario.myServicio.calcularCostoFinal(-5);
			fail("Deberia haber lanzado alguna excepcion.");
		} catch(Exception e) {
			assertFalse("No se arroja la excepcion correspondiente",e.getMessage().equalsIgnoreCase("No existe un servicio con ese tipo de costo"));
		}
	}
}
