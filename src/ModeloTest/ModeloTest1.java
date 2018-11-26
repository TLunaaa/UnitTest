package ModeloTest;

import org.junit.Test;

import modelo.Colaborador;
import modelo.GTSPException;
import modelo.Tarea;
import modelo.Usuario;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;


import static org.junit.Assert.*;

import java.util.GregorianCalendar;

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
			fail("No deberia lanzar ninguna excepcion.");
		}
	}
	
	/*es conveniente que el método pueda
	informar cuál de ellos se presentó, en lugar de sólo decir que
	hubo un problema. */
	
	@Test
	public void testActualizoEstado2() {
		try {
			fixture.modelo.actualizoEstado("111", "cerrada");
			fail("Este metodo deberia lanzar una excepcion.");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar.",e.getMessage(),"No existe tarea.");
		}
	}
	
	
	@Test
	public void testActualizoEstado3() {
		try {
			fixture.modelo.actualizoEstado(Integer.toString(fixture.tarea.getID()), "abierto");
			fail("Este metodo deberia lanzar una excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar.",e.getMessage(),"Cambio de estado invalido: de abierto a abierto.");
		}
	}
	
	@Test 
	public void testAddCliente1() {
		fixture.modelo.addCliente(fixture.client2);
		//assertTrue("No se agrego el cliente correspondiente.");
		//No hay manera de verificar que se haya agregado correctamente el cliente.
	}
	//Se intenta agregar un cliente ya agregado.
	@Test 
	public void testAddCliente2() {
		fixture.modelo.addCliente(fixture.client1);
		fail("Deberia haber lanzado un error, el cliente agregado ya existe.");
	}
	
	@Test
	public void testCambioContrasenia1() {
		try {
			fixture.modelo.cambioContrasenia(fixture.colab1, fixture.colab1.getContrasenia(), "123", "123");
			assertEquals("No se cambio la contrasenia",fixture.colab1.getContrasenia(),"123");
		} catch (GTSPException e) {
			fail("No deberia lanzar excepcion");
		}
	}
	//Se prueba cambiar la pass de un usuario no ingresado.
	@Test
	public void testCambioContrasenia2() {
		try {
			fixture.modelo.cambioContrasenia(fixture.colab2, fixture.colab2.getContrasenia(), "123", "123");
			fail("Deberia haber lanzado excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"Usuario no existente");
		}
	}
	
	//Deberia estar documentado el mensaje de la exception.
	@Test
	public void testCambioContrasenia3() {
		try {
			fixture.modelo.cambioContrasenia(fixture.colab1, fixture.colab1.getContrasenia(), "456", "123");
			fail("Deberia haber lanzado excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"La nueva contraseña no coincide.");
		}
	}
	
	//Deberia estar documentado el mensaje de la exception.
	@Test
	public void testCambioContrasenia4() {
		try {
			fixture.modelo.cambioContrasenia(fixture.colab1, "asd", "123", "123");
			fail("Deberia haber lanzado excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"Contraseña actual no incorrecta.");//??????????
		}
	}
	//Se intenta crear una tarea pero el Colaborador ya tiene una tarea Abierta
	@Test 
	public void testCrearTarea() {
		try {
			fixture.modelo.crearTarea(fixture.colab1.getNombreUsuario(), fixture.client1.getCuit(), fixture.serv.getDescripcion());
			fail("El metodo deberia haber lanzado alguna excepcion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("El colaborador solicitado tiene una tarea abierta."));
		}		
	}
	
	@Test
	public void testCrearUsuario1() {
		try {
			fixture.modelo.creaUsuario("carlos perez","123", "c@gmail.com", "administrador", "carlitos", "123");
			//no hay forma de verificar que se creo el usuario.
		} catch (GTSPException e) {
			fail("no deberia haber lanzado ninguna excepcion.");
		}
	}
	
	@Test
	public void testCrearUsuario2() {
		try {
			fixture.modelo.creaUsuario("carlos perez","123", "c@gmail.com", "colaborador", "carlitos", "123");
			//no hay forma de verificar que se creo el usuario.
		} catch (GTSPException e) {
			fail("no deberia haber lanzado ninguna excepcion.");
		}
	}
	
	@Test
	public void testCrearUsuario3() {
		try {
			fixture.modelo.creaUsuario("carlos perez","123", "c@gmail.com", "ingeniero", "carlitos", "123");
			fail("El programa deberia habel lanzado una excepcion.");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzado no es la correcta.", e.getMessage().equalsIgnoreCase("Perfil inexistente."));
		}
	}	
	//Se prueba el metodo con datos correctos.
	@Test
	public void testDatosIngresadosCorrectos1() {
		try {
			assertTrue("El usuario devuelto no el esperado.", fixture.colab1.equals(fixture.modelo.datosIngresadosCorrecto(fixture.colab1.getNombreUsuario(), fixture.colab1.getContrasenia())));
		} catch (GTSPException e) {
			fail("No deberia haber lanzado ninguna excepcion.");
		}
	}
	
	//Se prueba el metodo con la pass incorrecta.
	@Test
	public void testDatosIngresadosCorrectos2() {
		try {
			Usuario otro = fixture.modelo.datosIngresadosCorrecto(fixture.colab1.getNombreUsuario(), "Hola");
			fail("Deberia haber lanzado una excepcion");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("Contrasenia incorrecta."));
		}
	}
	
	//Se prueba el metodo con el nombre de usuario incorrecto.
	@Test
	public void testDatosIngresadosCorrectos3() {
		try {
			Usuario otro = fixture.modelo.datosIngresadosCorrecto("Pepe el pollo", "Hola");
			fail("Deberia haber lanzado una excepcion");
		} catch (GTSPException e) {
			assertTrue("La excepcion lanzada no es la correcta.", e.getMessage().equalsIgnoreCase("Nombre de usuario incorrecto."));
		}
	}
	//Se elimina una tarea existente.
	@Test
	public void testEliminaTarea1() {
		try {
			fixture.modelo.eliminaTarea(Integer.toString(fixture.tarea.getID()));
			assertEquals("No se borro la tarea",fixture.modelo.encuentraTarea(Integer.toString(fixture.tarea.getID())),null);			
		} catch (GTSPException e) {
			fail("No deberia haber lanzado excepcion");
		}
	}
	//Se elimina una tarea con idInvalido
	@Test
	public void testEliminaTarea2() {
		try {
			fixture.modelo.eliminaTarea("11111");
			fail("Deberia haber lanzado una excepcion");
		} catch (GTSPException e) {
			fail("Excepcion inchequeable");
		} catch (NullPointerException e) {
			fail("No se lanza una excepcion");
		}
	}
	
	//Se busca una tarea existente.
	@Test
	public void testEncuentraTarea1() {
		Tarea t = fixture.modelo.encuentraTarea(Integer.toString(fixture.tarea.getID()));
		assertTrue("No encontro la tarea",t!=null);
	}
	//Se busca una tarea inexistente.
	@Test
	public void testEncuentraTarea2() {
		Tarea t = fixture.modelo.encuentraTarea("11111");
		assertTrue("No encontro la tarea",t==null);
		fail("Deberia lanzar excepcion");
	}
	//Se pide informe siendo Admin
	@Test
	public void testInformeEstadoTareas1() {
		try {
			String inf = fixture.modelo.informeEstadoTareas();
		} catch (GTSPException e) {
			fail("No deberia haber lanzado excepcion");
		}
	}
	//Se pide informe con un nombre de usuario valido, siendo Admin
	@Test
	public void testInformeTareaColaborador1() {
		try {
			fixture.modelo.informeTareaColaborador(fixture.colab1.getNombreUsuario(), new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
		} catch (GTSPException e) {
			fail("No deberia haber lanzado excepcion");
		}
	}
	
	//Se pide informe con un nombre de usuario invalido, siendo Admin
	@Test
	public void testInformeTareaColaborador2() {
		try {
			fixture.modelo.informeTareaColaborador("Pedrito", new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
			fail("Deberia haber lanzado excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"Colaborador seleccionado no valido.");
		}
	}
	//Se pide informe con un cuit valido, siendo Admin
	@Test
	public void testInformeTareasPorCliente1() {
		try {
			fixture.modelo.informeTareasPorCliente(fixture.client1.getCuit(), new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));		
		} catch (GTSPException e) {
			fail("No deberia haber lanzado excepcion");
		}
	}
	//Se pide informe con un cuit invalido, siendo Admin
	@Test
	public void testInformeTareasPorCliente2() {
		try {
			fixture.modelo.informeTareasPorCliente("11111", new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
			fail("Deberia haber lanzado excepcion");
		} catch (GTSPException e) {
			assertEquals("No es el error que deberia lanzar",e.getMessage(),"El cliente no es uno valido");
		}
	}
	
	//Se intenta registrar un usuario valido.
	@Test
	public void testUsuarioValidoParaRegistrar1() {
		boolean resultado = fixture.modelo.usuarioValidoParaRegistrar(fixture.colab2);
		assertTrue("Salida erronea deberia ser Valido para registrar",resultado);
	}
	
	//Se intenta registrar un usuario con nombre de usuario ya registrado.
	@Test
	public void testUsuarioValidoParaRegistrar2() {
		Colaborador cAux = new Colaborador ("nada","nada@gmail.com","1123",fixture.colab1.getNombreUsuario(),"123");
		boolean resultado = fixture.modelo.usuarioValidoParaRegistrar(cAux);
		assertTrue("Salida erronea deberia ser invalido para registrar",!resultado);
	}
	
	//Se intenta registrar un usuario con un email ya registrado.
	@Test
	public void testUsuarioValidoParaRegistrar3() {
		Colaborador cAux = new Colaborador ("nada",fixture.colab1.getEMail(),"1123","pepito","123");
		boolean resultado = fixture.modelo.usuarioValidoParaRegistrar(cAux);
		assertTrue("Salida erronea deberia ser invalido para registrar",!resultado);
	}
}
