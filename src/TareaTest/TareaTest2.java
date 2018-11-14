package TareaTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TareaTest2 {
	
	public TareaFixture2 fixture = new TareaFixture2();
	
	public TareaTest2() {
		
	}
	
	/**
	 * Inicio Fixture
	 */
	
	@Before
	public void setUp() {
		fixture.setUp();
	}
	
	@After
	public void tearDown() {
		fixture.tearDown();
	}
	/*
	 * Fin del fixture
	 */
	
	/*
	 * Cambia el estado de una tarea de "cerrada" a "abierto"/"pausa".
	 */
	@Test
	public void testActualizoTarea1(){
		try {
			fixture.tarea.actualizoTarea("abierto");
			fail("Esta prueba de actualizoTarea debe disparar una excepcion");
		}catch(Exception e) {
			assertEquals("Error en la excepcion lanzada",e.getMessage(),"Cambio de estado invalido: de cerrado a abierto.");
		}
	}
	
	/*
	 * Cambia el estado de la Tarea de "cerrado" a "cerrado".
	 */
	@Test
	public void testActualizoTarea2(){
		try {
			fixture.tarea.actualizoTarea("cerrado");
			fail("Esta prueba de actualizoTarea debe disparar una excepcion");
		}catch(Exception e) {
			assertEquals("No genera la excepcion de estado invalido",e.getMessage(),"Cambio de estado invalido: de cerrado a cerrado.");
		}
	}
	
	/*
	 * Cambia el estado de la Tarea de "cerrado" a null.
	 */
	@Test
	public void testActualizoTarea3(){
		try {
			fixture.tarea.actualizoTarea(null);
			fail("Esta prueba de actualizoTarea debe disparar una excepcion");
		}catch(NullPointerException e) {
			fail("Esta prueba de actualizoTarea debe disparar una excepcion de estado invalido");
		}catch(Exception e) {
			
		}
	}
	
	
	/*
	 * Cambia el estado de "cerrado" a " ".
	 */
	@Test
	public void testActualizoTarea5(){
		try {
			fixture.tarea.actualizoTarea(" ");
			fail("Esta prueba de actualizoTarea debe disparar una excepcion");
		}catch(Exception e) {
			assertFalse("Se lanzo una excepcion incorrecta",e.getMessage().equalsIgnoreCase("Cambio de estado invalido: de cerrado a pausa."));
		}
	}
	
	/*
	 * Cambia el estado de "cerrado" a "terminada".
	 */
	@Test
	public void testActualizoTarea4(){
		try {
			fixture.tarea.actualizoTarea("terminada");
			fail("Esta prueba de actualizoTarea debe disparar una excepcion");
		}catch(Exception e) {
			assertFalse("Se lanzo una excepcion incorrecta",e.getMessage().equalsIgnoreCase("Cambio de estado invalido: de cerrado a pausa."));
		}
	}
	
	@Test
	public void testCostoTotal() {
		final double cost;
		try{
			cost = this.fixture.tarea.costoTotal();
			assertTrue("El costoTotal esta mal calculado",cost == 300); //El costo del servicio es fijo y su valor es 300
		}catch(Exception e) {
			fail("Esta prueba no deberia lanzar una excepcion");
		}
		
	}

}
