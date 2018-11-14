package Abierto;

import modelo.*;

public class AbiertoFixture1 {
	
	Estado abierto;
	
	public AbiertoFixture1() {
		
	}
	
	public void setUp() {
		Tarea tarea = new Tarea(null, null, null);
		this.abierto = new Abierto(tarea);
		tarea.setEstado(abierto);
	}
	
	public void tearDown() {}
}
