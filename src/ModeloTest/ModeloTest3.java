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
	
	@Test
	public void testCrearTarea1() {
		try {
			fixture.modelo.crearTarea(fixture.colab1.getNombreApellido(), fixture.client1.getCuit(), fixture.serv1.getDescripcion());
		} catch (GTSPException e) {
			fail("No deberia haber lanzado ninguna excepcion.");
		}
	}
	
	@Test
	public void testCrearTarea2() {
		try {
			fixture.modelo.crearTarea("otro", fixture.client1.getCuit(), fixture.serv1.getDescripcion());
			fail("Deberia haber lanzado una excepcion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("No es un colaborador valido."));
		}
	}
	
	@Test
	public void testCrearTarea3() {
		try {
			fixture.modelo.crearTarea(fixture.colab1.getNombreApellido(), "error", fixture.serv1.getDescripcion());
			fail("Deberia haber lanzado una excepcion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("No es un cliente valido."));
		}
	}
	
	@Test
	public void testCrearTarea4() {
		try {
			fixture.modelo.crearTarea(fixture.colab1.getNombreApellido(), fixture.client1.getCuit(), "error");
			fail("Deberia haber lanzado una excepcion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("No es un servicio valido."));
		}
	}
}
