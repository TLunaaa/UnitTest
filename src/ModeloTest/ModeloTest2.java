package ModeloTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.GTSPException;

public class ModeloTest2 {
	
	ModeloFixture2 fixture = new ModeloFixture2();
	
	@Before
	public void setUp() {
		fixture.setUp();
	}
	
	@After
	public void tearDown() {
		fixture.tearDown();
	}
	
	@Test
	public void testActualizaEstado() {
		try {
			fixture.modelo.actualizoEstado(Integer.toString(fixture.tarea.getID()), "cerrado");
			fail("Deberia habel lanzado una excepcion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion no es la esperada.", e.getMessage().equalsIgnoreCase("El usuario no puede acceder a esa funci�n."));
		}
	}
	
	@Test
	public void testCrearTarea() {
		try {
			fixture.modelo.crearTarea(fixture.colab1.getNombreApellido(), fixture.client1.getCuit(), fixture.serv.getDescripcion());
			fail("Deberia habel lanzado una excepsion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion no es la esperada.", e.getMessage().equalsIgnoreCase("El usuario no puede acceder a esa funcion."));
		}
	}
}
