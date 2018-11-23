package ColaboradorTest;

import org.junit.Test;

import modelo.EstructuraAuxiliar;
import modelo.GTSPException;

import org.junit.Before;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;


public class ColaboradorTest1 {
	
	ColaboradorFixture1 fixture1 = new ColaboradorFixture1();
	
	public ColaboradorTest1() {
		
	}
	
	/**
	 * Inicio Fixture
	 */
	
	@Before
	public void setUp() {
		fixture1.setUp();
	}
	//Se prueba el cambio de pass con datos correctos.
	@Test
	public void testCambiar_contrasenia1() {
		try {
			fixture1.colab1.cambioContrasenia("123","456","456");
			assertEquals("No se cambio la contraseña", fixture1.colab1.getContrasenia(),"456");
		} catch (GTSPException e) {
			fail(e.getMessage());
		}
		
	}
	//Se prueba el cambio de pass con la pass actual incorrecta.
	@Test
	public void testCambiar_contrasenia2() {
		try {
			fixture1.colab1.cambioContrasenia("444","456","456");
			fail("No lanza excepcion");
		} catch (GTSPException e) {
			assertEquals("No genera la excepcion de contraseña incorrecta",e.getMessage(),"Contraseña actual no incorrecta.");
		}
	}
	//Se prueba el cambio de pass con las nuevas pass distintas entre si.
	@Test
	public void testCambiar_contrasenia3() {
		try {
			fixture1.colab1.cambioContrasenia("123","456","777");
			fail("No lanza excepcion");
		} catch (GTSPException e) {
			assertEquals("No genera la excepcion de contraseñas distintas",e.getMessage(),"La nueva contraseña no coincide.");
		}
	}
	//Se prueba un informe en un periodo con tareas y colab con tareas.
	@Test
	public void testInformeTareasDeColaborador1() {
		
		String informe = fixture1.colab1.informeTareasDeColaborador(new GregorianCalendar(2010,10,10), new GregorianCalendar(2020,10,10));
		System.out.println(informe);
		assertNotEquals("Devolucion Incorrecta",informe,null);
		assertNotEquals("Devolucion Incorrecta",informe,"El colaborador no posee tareas. \nTOTAL HORAS: 0");
		assertNotEquals("Devolucion Incorrecta",informe,"");
		assertTrue("Devolucion Incorrecta",informe.contains("TOTAL HORAS: 200,00"));
	}
	
	//Se prueba un informe en un periodo sin tareas y colab con tareas.
		@Test
		public void testInformeTareasDeColaborador2() {
			String informe = fixture1.colab1.informeTareasDeColaborador(new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
			assertNotEquals("Devolucion Incorrecta",informe,null);
			assertNotEquals("Devolucion Incorrecta",informe,"El colaborador no posee tareas. \nTOTAL HORAS: 0");
			assertNotEquals("Devolucion Incorrecta",informe,"");
			assertTrue("Devolucion Incorrecta",informe.contains("TOTAL HORAS: 0,00"));
			//Podria lanzar una excepcion.
		}

	//Se prueba el informe en un periodo con tareas.
	@Test
	public void testInformeTodasTareasACargo1() {
		String informe = fixture1.colab1.informeTodasTareasACargo(new GregorianCalendar(2010,10,10), new GregorianCalendar(2020,10,10));
		assertNotEquals("Devolucion Incorrecta",informe,null);
		assertNotEquals("Devolucion Incorrecta",informe,"");
	}
	
	
	//Se prueban los servicios para un cliente registrado en un periodo con tareas cerradas.
	@Test
	public void testServicioPorCliente1() {
		EstructuraAuxiliar estructura = fixture1.colab1.servicioPorCliente(fixture1.client, new GregorianCalendar(2010,10,10), new GregorianCalendar(2020,10,10));
		assertNotEquals("Devolucion Incorrecta",estructura,null);
		assertNotEquals("Devolucion Incorrecta",estructura.getCadena(),null);
		assertNotEquals("Devolucion Incorrecta",estructura.getValor(),null);
	}
	
	//Se prueban los servicios para un cliente no registrado en un periodo con tareas cerradas.
	@Test
	public void testServicioPorCliente2() {
		EstructuraAuxiliar estructura = fixture1.colab1.servicioPorCliente(fixture1.client2, new GregorianCalendar(2010,10,10), new GregorianCalendar(2020,10,10));
		assertNotEquals("Devolucion Incorrecta",estructura,null);
		assertNotEquals("Devolucion Incorrecta",estructura.getCadena(),null);
		assertNotEquals("Devolucion Incorrecta",estructura.getValor(),null);
		fail("Deberia lanzar un error en este caso");
	}
	
	//Se prueba con un colaborador con tareas cerradas.
	@Test
	public void testTodasTareasPausaOCerrada1() {
		boolean result = fixture1.colab1.todasTareasPausaOCerrada();
		assertTrue("Error,devolucion incorrecta",result==true);
	}
	//Se prueba con un colaborador con tareas abiertas.
	@Test
	public void testTodasTareasPausaOCerrada2() {
		boolean result = fixture1.colab2.todasTareasPausaOCerrada();
		assertTrue("Error,devolucion incorrecta",result==false);
	}
}
