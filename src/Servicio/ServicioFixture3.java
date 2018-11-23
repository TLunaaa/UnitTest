package Servicio;

import modelo.Servicio;

/*
 * Escenario con un servicio sin descripcion y datos erronos.
 */

public class ServicioFixture3 {
	
	Servicio myServicio;
	
	public ServicioFixture3(){}
	
	
	public void setUp()
	{
		myServicio = new Servicio(" ", "bicho raro", 200);
	}	
	
	public void tearDown() {}
}
