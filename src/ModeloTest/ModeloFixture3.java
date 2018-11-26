package ModeloTest;

import modelo.Administrador;
import modelo.Cliente;
import modelo.Colaborador;
import modelo.GTSPException;
import modelo.Modelo;
import modelo.Servicio;
import modelo.Tarea;

public class ModeloFixture3 {
	
	public Modelo modelo = new Modelo();
	public Administrador admin;
	public Colaborador colab1;
	public Colaborador colab2;
	public Cliente client1;
	public Cliente client2;
	public Servicio serv1;
	public Servicio serv2;
	public Tarea tarea1;
	public Tarea tarea2;
	
	public ModeloFixture3() {
		
	}
	
	public void setUp() {
		admin = new Administrador("Carlos Rico","crico@crico.com.ar","223457898","crico","felipefelipe");
		colab1 = new Colaborador("Felipe Evans","fevans@gmail.com","223415984","fevans","empiezacon8");
		colab2 = new Colaborador("nada","nada@gmail.com","000","nada","nadapass");
		client1 = new Cliente("Paco Martinez", "paco_negocios@fimdp.com.ar","22624579","2168491","emprendedor","emprendedoresmdp");
		client2 = new Cliente("Jhon Ford", "jhon_contact@gmail.com","22624579","2168491","emprendedor","emprendedoresmdp");
		serv1 = new Servicio("Servicio1","fijo",500);
		serv2 = new Servicio("Servicio2","fijo",300);
		tarea1 = new Tarea(colab1,client1,serv1);
		tarea2 = new Tarea(colab2,client2,serv2);
		modelo.addUsuario(colab1);
		modelo.addUsuario(colab2);
		modelo.addTarea(colab1,tarea1);
		modelo.setUsserActual(admin);
		modelo.addCliente(client1);
		modelo.addUsuario(colab1);
		modelo.addServicio(serv1);
		modelo.addServicio(serv2);
		try {
			modelo.actualizoEstado(Integer.toString(tarea1.getID()), "cerrado");
			modelo.actualizoEstado(Integer.toString(tarea2.getID()), "cerrado");
		}catch(GTSPException e) {
			
		}
	}
	
	public void tearDown() {
		modelo = new Modelo();
	}
	
}