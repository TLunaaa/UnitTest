package Servicio;

import modelo.Servicio;

public class ServicioFixture3 {
	
	Servicio myServicio;
	
	public ServicioFixture3(){}
	
	
	public void setUp()
	{
		myServicio = new Servicio(" ", "bicho raro", 200);
	}	
	
	public void tearDown() {}
}
