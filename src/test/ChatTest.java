package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algochat.Chat;

public class ChatTest {

	@Test
	
	public void agregarMensajeRecibidoYVerificarQueSeAgregoUnMensaje(){
		Chat chat=new Chat();
		String mensaje="Hola";
		chat.guardarMensajeEnviado(mensaje);
		assertTrue(chat.cantidadDeMensajesEnviados()==1);	
	}
	
	@Test
	
	public void agregarMensajeEnviadoYVerificarQueSeAgregoUnMensaje(){
		Chat chat=new Chat();
		String mensaje="Hola";
		chat.guardarMensajeRecibido(mensaje);
		assertTrue(chat.cantidadDeMensajesRecibidos()==1);	
	}
	
	@Test
	
	public void agregarMensajeEnviadoYVerificarQueChatEstaActivo(){
		Chat chat=new Chat();
		String mensaje="Hola";
		chat.guardarMensajeRecibido(mensaje);
		assertTrue(chat.estaActivo());	
	}
	

	@Test
	
	public void siNoAgregamosMensajeChatNoEstaActivo(){
		Chat chat=new Chat();
		assertFalse(chat.estaActivo());
	}
	
	@Test
	
	public void agregarMensajeEnviadoYVerificarQueConversacionTieneElMensaje(){
		Chat chat=new Chat();
		String mensaje="Hola";
		chat.guardarMensajeRecibido(mensaje);
		assertTrue(chat.get(1)=="Hola");
		assertFalse(chat.get(1)=="Chau");
	}
	
	@Test
	
	public void agregarMensajeEnviadoYEliminarlo(){
		Chat chat=new Chat();
		String mensaje="Hola";
		chat.guardarMensajeEnviado(mensaje);
		assertTrue(chat.cantidadDeMensajesEnviados()==1);	
		chat.eliminarMensajeEnviado("Hola");
		assertTrue(chat.cantidadDeMensajesEnviados()==0);	
	}
	
	@Test
	
	public void agregar2MensajeYBorrarTodos(){
		Chat chat=new Chat();
		String mensaje="Hola";
		chat.guardarMensajeEnviado(mensaje);
		String mensaje2="Chau";
		chat.guardarMensajeRecibido(mensaje2);
		assertTrue(chat.cantidadDeMensajesEnviados()==1);
		assertTrue(chat.cantidadDeMensajesRecibidos()==1);
		chat.borrarMensajes();
		assertTrue(chat.cantidadDeMensajesEnviados()==0);	
		assertTrue(chat.cantidadDeMensajesRecibidos()==0);
	}
}
