package ModeloTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.GTSPException;

public class ModeloTest3 {

	ModeloFixture3 fixture = new ModeloFixture3();
	
	@Before
	public void setUp() {
		fixture.setUp();
	}
	
	@After
	public void tearDown() {
		fixture.tearDown();
	}
	//Se prueba crear una tarea cuyo colaborador tiene todas sus tareas cerradas.
	@Test
	public void testCrearTarea1() {
		try {
			fixture.modelo.crearTarea(fixture.colab1.getNombreUsuario(), fixture.client1.getCuit(), fixture.serv1.getDescripcion());
		} catch (GTSPException e) {
			System.out.println(e.getMessage());
			fail("No deberia haber lanzado ninguna excepcion.");
		}
	}
	//Se prueba crear una tarea con un colaborador inexistente.
	@Test
	public void testCrearTarea2() {
		try {
			fixture.modelo.crearTarea("otro", fixture.client1.getCuit(), fixture.serv1.getDescripcion());
			fail("Deberia haber lanzado una excepcion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("No es un colaborador valido."));
		}
	}
	//Se prueba crear una tarea con un cuit invalido.
	@Test
	public void testCrearTarea3() {
		try {
			fixture.modelo.crearTarea(fixture.colab1.getNombreUsuario(), "error", fixture.serv1.getDescripcion());
			fail("Deberia haber lanzado una excepcion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("No es un cliente valido."));
		}
	}
	//Se prueba crear una tarea con un servicio invalido.
	@Test
	public void testCrearTarea4() {
		try {
			fixture.modelo.crearTarea(fixture.colab1.getNombreUsuario(), fixture.client1.getCuit(), "error");
			fail("Deberia haber lanzado una excepcion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("No es un servicio valido."));
		}
	}
}
