package Servicio;

import static org.junit.Assert.assertFalse;
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
	
	/*
	 * Se prueba que se haya almacenado correctamente la descripcion del servicio
	 */
	@Test
	public void testGetDescripcion() {
		assertTrue("Descripcion incorrecta.", escenario.myServicio.getDescripcion().equalsIgnoreCase("Probando"));
	}
	
	/*
	 * Se prueba el valor que devuelve el metodo.
	 */
	@Test	
	public void testCalculoCosto1() {
		try {
			assertTrue("El valor calculado no es el esperado", escenario.myServicio.calcularCostoFinal(10) == 220);
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
