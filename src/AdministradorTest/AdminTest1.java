package AdministradorTest;

import org.junit.Test;
import modelo.GTSPException;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.GregorianCalendar;


public class AdminTest1 {
	
	AdminFixture1 fixture1 = new AdminFixture1();
	
	public AdminTest1() {
		
	}
	
	/**
	 * Inicio Fixture
	 */
	
	@Before
	public void setUp() {
		fixture1.setUp();
	}
	//Se prueba el informe sin entradas con una tarea
	@Test
	public void testInformeEstadoTareas() {
		try {
			String informe = fixture1.admin.InformeEstadoTareas();
			assertNotEquals("Resultado Nulo",informe,null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	
	//Se prueba el informe con datos correctos y un periodo que registra tareas, colab con tareas.
	@Test
	public void testInformeTareasColaborador1(){
		try {
			String informe = fixture1.admin.InformeTareasColaborador(fixture1.colab1, new GregorianCalendar(2010,10,10), new GregorianCalendar(2020,10,12));
			assertNotEquals("Resultado Nulo",informe,null);
			assertFalse("Devolucion Incorrecta",informe.contains("no posee tareas"));
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
		catch(GTSPException e) {
			fail("Error exception indeseada");
		}
	}
	
	//Se prueba el informe con datos correctos y un periodo que registra tareas, colab sin tareas.
		@Test
		public void testInformeTareasColaborador2(){
			try {
				fixture1.colab1.getTareas().clear();
				String informe = fixture1.admin.InformeTareasColaborador(fixture1.colab1, new GregorianCalendar(2010,10,10), new GregorianCalendar(2020,10,12));
				assertNotEquals("Resultado Nulo",informe,null);
				assertTrue("Devolucion Incorrecta",informe.contains("no posee tareas"));
			}
			catch(NullPointerException e) {
				fail("Error, no valida null");
			}
			catch(GTSPException e) {
				fail("Error exception indeseada");
			}
		}
			
	//Se prueba el informe con un colaborador no registrado en la BD, mismo periodo.
	@Test
	public void testInformeTareasColaborador3(){
		try {
			String informe = fixture1.admin.InformeTareasColaborador(fixture1.colab2, new GregorianCalendar(2010,10,10), new GregorianCalendar(2020,10,12));
			fail("No se lanzo una excepcion");
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
		catch(GTSPException e) {
			assertEquals("No lanza la excepcion esperada","Su colaborador no existe en la base de datos.",e.getMessage());
		}
	}
	//Se prueba el informe con un cliente registrado
	@Test
	public void testInformeTotalTareasCliente1() {
		try {
			String informe = fixture1.admin.InformeTotalTareasCliente(fixture1.client,new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
			assertNotEquals("Resultado Nulo",informe,null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	
	//Se prueba el informe con un cliente no registrado
		@Test
		public void testInformeTotalTareasCliente2() {
			try {
				String informe = fixture1.admin.InformeTotalTareasCliente(fixture1.client2,new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
				assertNotEquals("Resultado Nulo",informe,null);
				fail("No detecta un cliente no registrado.");
			}
			catch(NullPointerException e) {
				fail("Error, no valida null");
			}
		}
	
	//Se prueba el informe en un periodo que registra tareas.
	@Test
	public void testinformeTodasTareasACargo1() {
		try {
			String informe = fixture1.admin.informeTodasTareasACargo(new GregorianCalendar(2010,10,10), new GregorianCalendar(2020,10,12));
			assertNotEquals("Resultado Nulo",informe,null);
			assertNotEquals("Devolucion Incorrecta",informe,"");
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	
	//Se prueba el informe en un periodo que no registra tareas.
		@Test
		public void testinformeTodasTareasACargo2() {
			try {
				String informe = fixture1.admin.informeTodasTareasACargo(new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
				assertNotEquals("Resultado Nulo",informe,null);
				assertEquals("Devolucion Incorrecta",informe,"");
				//Podria lanzar excepcion.
			}
			catch(NullPointerException e) {
				fail("Error, no valida null");
			}
		}
}