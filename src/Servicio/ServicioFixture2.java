package Servicio;

import modelo.Servicio;

/*
 * Escenario donde se tiene un servicio fijo.
 */

public class ServicioFixture2 {
	
	Servicio myServicio;
	
	public ServicioFixture2(){}
	
	
	public void setUp()
	{
		myServicio = new Servicio("Probando", "fijo", 650);
	}	
	
	public void tearDown() {}
}
