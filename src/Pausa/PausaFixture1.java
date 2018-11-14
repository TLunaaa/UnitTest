package Pausa;

import modelo.*;

public class PausaFixture1 {
	
	Estado pausa;
	
	public PausaFixture1() {
		
	}
	
	public void setUp() {
		Tarea tarea = new Tarea(null, null, null);
		this.pausa = new Pausa(tarea);
		tarea.setEstado(pausa);
	}
	
	public void tearDown() {}
}
