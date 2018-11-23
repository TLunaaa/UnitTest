package Servicio;

import modelo.Servicio;

/*
 * Escenario donde se tiene un servicio por hora.
 */

public class ServicioFixture1 {
	
	Servicio myServicio;
	
	public ServicioFixture1(){}
	
	
	public void setUp()
	{
		myServicio = new Servicio("Probando", "por hora", 22);
	}	
	
	public void tearDown() {}
}
