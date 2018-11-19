package AdministradorTest;

import org.junit.Test;

import modelo.GTSPException;

import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import java.util.GregorianCalendar;


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
	
	
	@Test
	public void testInformeEstadoTareas() {
		try {
			String informe = fixture2.admin.InformeEstadoTareas();
			assertEquals("Resultado Nulo",informe,null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
}
