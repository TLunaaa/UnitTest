package AdministradorTest;

import org.junit.Test;

import modelo.EstructuraAuxiliar;
import modelo.GTSPException;

import org.junit.Before;
import org.junit.After;
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
	
	@Test
	public void testInformeEstadoTareas() {
		try {
			String informe = fixture1.admin.InformeEstadoTareas();
			assertEquals("Resultado Nulo",informe,null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	
	@Test
	public void testInformeTareasColaborador1(){
		try {
			String informe = fixture1.admin.InformeTareasColaborador(fixture1.colab1, new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
			assertEquals("Resultado Nulo",informe,null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
		catch(GTSPException e) {
			fail("Error exception indeseada");
		}
	}
	
	@Test
	public void testInformeTareasColaborador2(){
		try {
			String informe = fixture1.admin.InformeTareasColaborador(fixture1.colab2, new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
			fail("No se lanzo una excepcion");
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
		catch(GTSPException e) {
			
		}
	}
	
	@Test
	public void testInformeTotalTareasCliente1() {
		try {
			String informe = fixture1.admin.InformeTotalTareasCliente(fixture1.client,new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
			assertEquals("Resultado Nulo",informe,null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
	@Test
	public void testinformeTodasTareasACargo1() {
		try {
			String informe = fixture1.admin.informeTodasTareasACargo(new GregorianCalendar(2010,10,10), new GregorianCalendar(2010,10,12));
			assertEquals("Resultado Nulo",informe,null);
		}
		catch(NullPointerException e) {
			fail("Error, no valida null");
		}
	}
}