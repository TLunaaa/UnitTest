package AdministradorTest;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;



public class AdminTest2 {
	
	AdminFixture2 fixture2 = new AdminFixture2();
	
	public AdminTest2() {
		
	}
	
	/**
	 * Inicio Fixture
	 */
	
	@Before
	public void setUp() {
		fixture2.setUp();
	}
	
	//Se prueba el informe sin tareas registradas
	@Test
	public void testInformeEstadoTareas() {
		try {
			String informe = fixture2.admin.InformeEstadoTareas();
			assertNotEquals("Resultado Nulo",informe,null);
			//Posible falta de aviso de tareas no registradas?
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
}
