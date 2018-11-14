package TareaTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class TareaTest1 {
	
	public TareaFixture1 fixture = new TareaFixture1();
	
	public TareaTest1() {
		
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
	 * Cambia el estado de una tarea de "abierta" a "pausa".
	 */
	@Test
	public void testActualizoTarea1(){
		try {
			fixture.tarea.actualizoTarea("pausa");
			assertTrue("Error al actualizar estado de la tarea",fixture.tarea.getEstado().getTipoEstado().equalsIgnoreCase("pausa"));
		}catch(Exception e) {
			fail("Esta prueba de actualizoTarea, no debe disparar una excepcion");
		}
		
	}
	
	/*
	 * Cambia el estado de la Tarea de "abierto" a "abierto".
	 */
	@Test
	public void testActualizoTarea2(){
		try {
			fixture.tarea.actualizoTarea("abierto");
			fail("Esta prueba de actualizoTarea debe disparar una excepcion");
		}catch(Exception e) {
			assertEquals("No genera la excepcion de estado invalido",e.getMessage(),"Cambio de estado invalido: de abierto a abierto.");
		}
	}
	
	/*
	 * Cambia el estado de la Tarea de "abierta" a null.
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
	 * Cambia el estado de "abierto" a " ".
	 */
	@Test
	public void testActualizoTarea5(){
		try {
			fixture.tarea.actualizoTarea(" ");
			fail("Esta prueba de actualizoTarea debe disparar una excepcion");
		}catch(Exception e) {
			
		}
	}
	
	/*
	 * Cambia el estado de "abierto" a "terminada".
	 */
	@Test
	public void testActualizoTarea4(){
		try {
			fixture.tarea.actualizoTarea("terminada");
			fail("Esta prueba de actualizoTarea debe disparar una excepcion");
		}catch(Exception e) {
			
		}
	}
	
	@Test
	public void testCostoTotal() {
		try{
			this.fixture.tarea.costoTotal();
			fail("Esta prueba deberia lanzar una excepcion");
		}catch(Exception e) {
			assertEquals("No genera la excepcion correcta",e.getMessage(),"No se puede calcular el costo si la tarea no esta cerrada");
		}
		
	}
	
}
