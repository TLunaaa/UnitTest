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
	
	@Test
	public void testCambiar_contrasenia1() {
		try {
			fixture1.colab1.cambioContrasenia("123","456","456");
		} catch (GTSPException e) {
			
		}
		assertEquals("No se cambio la contraseña", fixture1.colab1.getContrasenia(),"456");
	}
	
	@Test
	public void testCambiar_contrasenia2() {
		try {
			fixture1.colab1.cambioContrasenia("444","456","456");
		} catch (GTSPException e) {
			assertEquals("No genera la excepcion de contraseña incorrecta",e.getMessage(),"Contraseña actual no incorrecta.");
		}
	}
	
	@Test
	public void testCambiar_contrasenia3() {
		try {
			fixture1.colab1.cambioContrasenia("123","456","777");
		} catch (GTSPException e) {
			assertEquals("No genera la excepcion de contraseñas distintas",e.getMessage(),"La nueva contraseña no coincide.");
		}
	}
	
	@Test
	public void testCambiar_contrasenia4() {
		try {
			fixture1.colab1.cambioContrasenia(null,"456","456");
		} catch (NullPointerException e) {
			fail("Error, no valida null");
		}catch (GTSPException e) {
			
		}
		assertTrue("Error, no valida null",fixture1.colab1.getContrasenia()!=null&& fixture1.colab1.getContrasenia().equals("123"));
	}
	
	@Test
	public void testCambiar_contrasenia5() {
		try {
			fixture1.colab1.cambioContrasenia("123",null,"456");
		} catch (NullPointerException e) {
			fail("Error, no valida null");
		} catch (GTSPException e) {

		}
		assertTrue("Error, no valida null",fixture1.colab1.getContrasenia()!=null&& fixture1.colab1.getContrasenia().equals("123"));
	}
	
	@Test
	public void testCambiar_contrasenia6() {
		try {
			fixture1.colab1.cambioContrasenia("123","456",null);
		} catch (NullPointerException e) {
			fail("Error, no valida null");
		} catch (GTSPException e) {

		}
		assertTrue("Error, no valida null",fixture1.colab1.getContrasenia()!=null&& fixture1.colab1.getContrasenia().equals("123"));
	}
	@Test
	public void testInformeTareasDeColaborador1() {
		String informe = fixture1.colab1.informeTareasDeColaborador(new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
		System.out.println(informe);
		assertNotEquals("Devolucion Incorrecta",informe,null);
		assertNotEquals("Devolucion Incorrecta",informe,"El colaborador no posee tareas. \nTOTAL HORAS: 0");
		assertNotEquals("Devolucion Incorrecta",informe,"");
	}
	
	@Test
	public void testInformeTareasDeColaborador2() {
		try {
			String informe = fixture1.colab1.informeTareasDeColaborador(null, new GregorianCalendar(2010,10,12));
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	@Test
	public void testInformeTareasDeColaborador3() {
		try {
			String informe = fixture1.colab1.informeTareasDeColaborador(new GregorianCalendar(2010,10,10),null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	
	@Test
	public void testInformeTodasTareasACargo1() {
		String informe = fixture1.colab1.informeTodasTareasACargo(new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
		assertNotEquals("Devolucion Incorrecta",informe,null);
		assertNotEquals("Devolucion Incorrecta",informe,"");
	}
	
	@Test
	public void testInformeTodasTareasACargo2() {
		try {
			String informe = fixture1.colab1.informeTodasTareasACargo(null, new GregorianCalendar(2010,10,12));
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	@Test
	public void testInformeTodasTareasACargo3() {
		try {
			String informe = fixture1.colab1.informeTodasTareasACargo(new GregorianCalendar(2010,10,10),null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	
	@Test
	public void testServicioPorCliente1() {
		EstructuraAuxiliar estructura = fixture1.colab1.servicioPorCliente(fixture1.client, new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
		assertNotEquals("Devolucion Incorrecta",estructura,null);
		assertNotEquals("Devolucion Incorrecta",estructura.getCadena(),null);
		assertNotEquals("Devolucion Incorrecta",estructura.getValor(),null);
	}
	
	@Test
	public void testServicioPorCliente2() {
		try {
			EstructuraAuxiliar estructura = fixture1.colab1.servicioPorCliente(fixture1.client,null, new GregorianCalendar(2010,10,12));
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	@Test
	public void testServicioPorCliente3() {
		try {
			EstructuraAuxiliar estructura = fixture1.colab1.servicioPorCliente(fixture1.client, new GregorianCalendar(2010,10,10),null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	
	@Test
	public void testServicioPorCliente4() {
		try {
			EstructuraAuxiliar estructura = fixture1.colab1.servicioPorCliente(null, new GregorianCalendar(2010,10,10),new GregorianCalendar(2010,10,12));
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	
	@Test
	public void testTodasTareasPausaOCerrada1() {
		boolean result = fixture1.colab1.todasTareasPausaOCerrada();
		assertTrue("Error,devolucion incorrecta",result==false);
	}
	
	@Test
	public void testTodasTareasPausaOCerrada2() {
		boolean result = fixture1.colab1.todasTareasPausaOCerrada();
		assertTrue("Error,devolucion incorrecta",result==true);
	}
}
