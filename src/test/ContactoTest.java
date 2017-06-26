package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algochat.Contacto;
import algochat.Grupo;

public class ContactoTest {
	

	@Test 
	
	public void crearContactoYDevolverNombre(){
		Contacto contacto=new Contacto("Lucas");
		assertTrue(contacto.getNombre()=="Lucas");
	}
	
	@Test
	
	public void crearContactoYEnviarMensajeIndividual(){
		Contacto contacto=new Contacto("Lucas");
		String mensaje="Hola";
		contacto.enviarMensaje(mensaje);
		assertTrue(contacto.mensajesEnviadosTotales()==1);
		assertTrue(contacto.mensajesEnviadosDirectos()==1);
	}
	
	@Test
	
	public void crearContactoYEnviar1MensajeIndividualYUnMensajeGrupal(){
		Contacto contacto=new Contacto("Lucas");
		Grupo grupo=new Grupo("Todos");
		String mensaje="Hola";
		String mensaje2="Hola a todos";
		contacto.enviarMensaje(mensaje);
		contacto.enviarMensajeGrupalA(mensaje2,grupo);
		assertTrue(contacto.mensajesEnviadosTotales()==2);
		assertTrue(contacto.mensajesEnviadosDirectos()==1);
	}
	
	@Test
		
	public void crearContactoYEnviar1MensajeIndividualYUnMensajeGrupalNoDebeDarMensajesEnviadosTotales1(){
		Contacto contacto=new Contacto("Lucas");
		Grupo grupo=new Grupo("Todos");
		String mensaje="Hola";
		String mensaje2="Hola a todos";
		contacto.enviarMensaje(mensaje);
		contacto.enviarMensajeGrupalA(mensaje2,grupo);
			assertFalse(contacto.mensajesEnviadosTotales()==1);
		}
	
	@Test
	
	public void siContactoNoRecibeYEnviaMensajesChatNoEstaACtivo(){
		Contacto contacto=new Contacto("Lucas");
		assertFalse(contacto.chatActivo());
	}
	
	public void siContactoEnvia1MensajeChatEstaACtivo(){
		Contacto contacto=new Contacto("Lucas");
		String mensaje="Hola";
		contacto.enviarMensaje(mensaje);
		assertTrue(contacto.chatActivo());
	}
	
	@Test
	
	public void crearContactoYRecibir1Mensaje(){
		Contacto contacto=new Contacto("Lucas");
		String mensaje="Hola";
		contacto.enviarMensaje(mensaje);
		assertTrue(contacto.mensajesEnviadosTotales()==1);
		assertTrue(contacto.mensajesEnviadosDirectos()==1);
	}
	
	@Test 
	
	public void crearContactoYCambiarNombre(){
		Contacto contacto=new Contacto("Lucas");
		assertTrue(contacto.getNombre()=="Lucas");
		contacto.setNombre("Pedro");
		assertTrue(contacto.getNombre()=="Pedro");
	}
	
	@Test
	
	public void borrarImplicaCantidadDeMensajes0(){
		Contacto contacto=new Contacto("Lucas");
		String mensaje="Hola";
		contacto.recibirMensaje(mensaje);
		assertTrue(contacto.mensajesRecibidos()==1);
		contacto.borrarMensajes();
		assertTrue(contacto.mensajesRecibidos()==0);
	}
}