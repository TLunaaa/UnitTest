package Cerrado;

import modelo.*;

public class CerradoFixture1 {
	
	Estado cerrado;
	
	public CerradoFixture1() {
		
	}
	
	public void setUp() {
		Tarea tarea = new Tarea(null, null, null);
		this.cerrado = new Cerrado(tarea);
		tarea.setEstado(cerrado);
	}
	
	public void tearDown() {}
}
