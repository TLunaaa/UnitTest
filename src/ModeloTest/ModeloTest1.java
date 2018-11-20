package ModeloTest;

import org.junit.Test;

import modelo.GTSPException;
import modelo.Usuario;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

import static org.junit.Assert.*;

public class ModeloTest1 {
	
	ModeloFixture1 fixture = new ModeloFixture1();
	
	@Before
	public void setUp() {
		fixture.setUp();
	}
	
	@After
	public void tearDown() {
		fixture.tearDown();
	}
	
	@Test
	public void testActualizoEstado1() {
		try {
			fixture.modelo.actualizoEstado(Integer.toString(fixture.tarea.getID()),"cerrado"); //Tuve que Harcodear el ID para que funcione (devuelve un entero y pide un String)
			assertTrue("Error al actualizar el estado de la tarea",fixture.tarea.getEstado().getTipoEstado().equalsIgnoreCase("cerrado"));
		}catch(GTSPException e) {
			fail("no deberia tirar ninguna excepcion");
		}
	}
	
	/*es conveniente que el método pueda
	informar cuál de ellos se presentó, en lugar de sólo decir que
	hubo un problema. */
	
	@Test
	public void testActualizoEstado2() {
		try {
			fixture.modelo.actualizoEstado("111", "cerrada");
			fail("Este metodo deberia lanzar una excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"No existe tarea.");
		}
	}
	
	
	@Test
	public void testActualizoEstado3() {
		try {
			fixture.modelo.actualizoEstado(Integer.toString(fixture.tarea.getID()), "abierto");
			fail("Este metodo deberia lanzar una excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"Cambio de estado invalido: de abierto a abierto.");
		}
	}
	
	@Test 
	public void testAddCliente1() {
		fixture.modelo.addCliente(fixture.client2);
		//assertTrue("no se agrego el cliente correspondiente.");
		//No hay manera de veirificar que se haya agregado correctamente el cliente.
	}
	
	@Test 
	void testAddClietne2() {
		fixture.modelo.addCliente(fixture.client1);
		fail("Deberia haber lanzado un error, el cliente agregado ya existe.");
	}
	
	@Test
	void testAddCliente3() {
		fixture.modelo.addCliente(null);
		fail("Se agrego un cliente nulo, deberia habel lanzado una excepcion.");
	}
	
	@Test
	void testCambioContrasenia1() {
		try {
			fixture.modelo.cambioContrasenia(fixture.colab1, fixture.colab1.getContrasenia(), "123", "123");
			assertEquals("No se cambio la contrasenia",fixture.colab1.getContrasenia(),"123");
		} catch (GTSPException e) {
			fail("No deberia tirar excepcion");
		}
	}
	
	@Test
	void testCambioContrasenia2() {
		try {
			fixture.modelo.cambioContrasenia(fixture.colab2, fixture.colab2.getContrasenia(), "123", "123");
			fail("Deberia haber lanzado excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"Usuario no existente");
		}
	}
	
	//Deberia estar documentado el mensaje de la exception.
	@Test
	void testCambioContrasenia3() {
		try {
			fixture.modelo.cambioContrasenia(fixture.colab1, fixture.colab1.getContrasenia(), "456", "123");
			fail("Deberia haber lanzado excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"La nueva contraseña no coincide.");
		}
	}
	
	//Deberia estar documentado el mensaje de la exception.
	@Test
	void testCambioContrasenia4() {
		try {
			fixture.modelo.cambioContrasenia(fixture.colab1, "asd", "123", "123");
			fail("Deberia haber lanzado excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"Contraseña actual no incorrecta.");//??????????
		}
	}
}
