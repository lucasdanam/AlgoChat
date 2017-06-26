package test;

import static org.junit.Assert.*;

import org.junit.Test;

import algochat.Agenda;
import algochat.Contacto;
import algochat.Mensajero;

public class MensajeroTest {
 
	
	@Test
	
	public void enviarMensajeAContactoYVerificarQueCantidadDeMensajesEnviadosAlContactoEs1(){
		
		Contacto contacto= new Contacto("Lucas");
		Agenda agenda=new Agenda();
		agenda.agregarContacto(contacto);
		Mensajero mensajero=new Mensajero(agenda);
		mensajero.enviarMensaje(contacto.getNombre(),"Hola");
		assertTrue(mensajero.cantidadDeMensajesEnviadosA(contacto.getNombre())==1);
		
	}
	
	@Test
	
	public void enviarMensajeAContactoYVerificarCantidadDeMensajesEnviados(){
		
		Contacto contacto= new Contacto("Lucas");
		Agenda agenda=new Agenda();
		agenda.agregarContacto(contacto);
		Mensajero mensajero=new Mensajero(agenda);
		mensajero.enviarMensaje(contacto.getNombre(),"Hola");
		assertTrue(mensajero.cantidadDeMensajesEnviados()==1);
		
	}
	
	@Test
	
	public void borrarMensajes(){
		
		Contacto contacto= new Contacto("Lucas");
		Agenda agenda=new Agenda();
		agenda.agregarContacto(contacto);
		Mensajero mensajero=new Mensajero(agenda);
		mensajero.enviarMensaje(contacto.getNombre(),"Hola");
		mensajero.recibirMensaje(contacto.getNombre(),"Chau");
		assertTrue(mensajero.cantidadDeMensajesEnviados()==1);
		assertTrue(mensajero.cantidadMensajesRecibidos()==1);
		mensajero.borrarMensajesDe("Lucas");
		assertTrue(mensajero.cantidadMensajesRecibidos()==0);
		assertTrue(mensajero.cantidadDeMensajesEnviados()==0);
	}
	
	@Test
	
	public void enviarMensajeAContactoInexistenteCreaUnUsuarioConNombreIngresado(){
		Agenda agenda=new Agenda();
		Mensajero mensajero=new Mensajero(agenda);
		assertFalse(agenda.existeContacto("Lucas"));
		mensajero.enviarMensaje("Lucas", "Hola");
		assertTrue(mensajero.cantidadDeMensajesEnviadosA("Lucas")==1);
	}
}


