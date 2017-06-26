package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algochat.Contacto;
import algochat.Grupo;

public class GrupoTest {
	
@Test 
	
	public void crearGrupoYDevolverNombre(){
		Grupo grupo=new Grupo("futbol");
		assertTrue(grupo.getNombre()=="futbol");
	}
	
	@Test 
	
	public void crearGrupoYAgregar1Integrante(){
		Contacto contacto=new Contacto("Lucas");
		Grupo grupo=new Grupo("futbol");
		grupo.agregarContacto(contacto);
		//El usuario se considera miembro//
		assertTrue(grupo.cantidadDeMiembros()==2);
	}
	
	@Test
	
	public void crearGrupoYRecibirMensajeDeUsuario(){
		Grupo grupo=new Grupo("futbol");
		String mensaje="Hola";
		grupo.recibirMensaje(mensaje);
		assertTrue(grupo.mensajesRecibidos()==1);
	}
	
	@Test
	
	public void crearGrupoYEnviarMensajeAUsuario(){
		Grupo grupo=new Grupo("futbol");
		Contacto contacto=new Contacto("Lucas");
		String mensaje="Hola";
		grupo.agregarContacto(contacto);
		grupo.enviarMensaje(mensaje, contacto.getNombre());
		assertTrue(grupo.mensajesEnviadosTotales()==1);
	}
	
	@Test
	
	public void crearGrupoYEnviarMensajeAUsuarioYVerificarQueContactoEnvioMensaje(){
		Grupo grupo=new Grupo("futbol");
		Contacto contacto=new Contacto("Lucas");
		String mensaje="Hola";
		grupo.agregarContacto(contacto);
		grupo.enviarMensaje(mensaje, contacto.getNombre());
		assertTrue(grupo.mensajesEnviadosTotales()==1);
		assertTrue(contacto.mensajesEnviadosTotales()==1);
	}
	
	@Test
	
	public void crearGrupoYEnviarMensajeAUsuarioYVerificarQueContactoNoEnvioMensajeDirectoAlUsuario(){
		Grupo grupo=new Grupo("futbol");
		Contacto contacto=new Contacto("Lucas");
		String mensaje="Hola";
		grupo.agregarContacto(contacto);
		grupo.enviarMensaje(mensaje, contacto.getNombre());
		assertTrue(grupo.mensajesEnviadosTotales()==1);
		assertFalse(contacto.mensajesEnviadosDirectos()==1);
		assertTrue(contacto.mensajesEnviadosDirectos()==0);
	}
	
	@Test
	
	public void borrarMensajesYVerificarQueLaCantidadDeMensajesEs0(){
		Grupo grupo=new Grupo("futbol");
		String mensaje="Hola";
		grupo.recibirMensaje(mensaje);
		assertTrue(grupo.mensajesRecibidos()==1);
		grupo.borrarMensajes();
		assertTrue(grupo.mensajesRecibidos()==0);
		assertTrue(grupo.mensajesEnviadosTotales()==0);
	}
	
	@Test 
	
	public void crearGrupoYCambiarNombre(){
		Grupo grupo=new Grupo("Todos");
		assertTrue(grupo.getNombre()=="Todos");
		grupo.setNombre("Algunos");
		assertTrue(grupo.getNombre()=="Algunos");
	}
	
	@Test
	
	public void siContactoNoRecibeYEnviaMensajesChatNoEstaACtivo(){
		Grupo grupo=new Grupo("play");
		assertFalse(grupo.chatActivo());
	}
}
