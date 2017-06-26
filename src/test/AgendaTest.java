package test;

import static org.junit.Assert.*;

import org.junit.Test;

import algochat.Agenda;
import algochat.Contacto;
import algochat.ContactoInexistente;
import algochat.Grupo;
import junit.framework.Assert;

public class AgendaTest {
	
	@Test
	
	public void agregarContactoYVerificarQueSeAgrego(){
		
		Contacto contacto=new Contacto("Lucas");
		Agenda agenda=new Agenda();
		agenda.agregarContacto(contacto);
		assertTrue(agenda.cantidadDeContactos()==1);
	}
	
	@Test
	
	public void noAgregarContactoYVerificarQueNoHayContactos(){
		
		Agenda agenda=new Agenda();
		assertTrue(agenda.cantidadDeContactos()==0);
	}
	
	@Test
	
	public void agregarGrupoYVerificarQueSeAgrego(){
		
		Grupo grupo=new Grupo("Lucas");
		Agenda agenda=new Agenda();
		agenda.agregarGrupo(grupo);
		assertTrue(agenda.cantidadDeGrupos()==1);
	}
	
	@Test
	
	public void noAgregarGrupoYVerificarQueNoHayGrupos(){
		
		Agenda agenda=new Agenda();
		assertTrue(agenda.cantidadDeGrupos()==0);
	}
	
	@Test
	
	public void agregarGrupoYVerificarQueExiste(){
		
		Grupo grupo=new Grupo("Tarde");
		Agenda agenda=new Agenda();
		agenda.agregarGrupo(grupo);
		assertTrue(agenda.existeGrupo(grupo.getNombre()));
	}
	
	@Test
	
	public void agregarContactoYVerificarQueExiste(){
		
		Contacto contacto=new Contacto("Lucas");
		Agenda agenda=new Agenda();
		agenda.agregarContacto(contacto);
		assertTrue(agenda.existeContacto(contacto.getNombre()));
	}
	
	@Test

	public void agregar1ContactoQueEnviaMensajeYOtroQueNoHaceNadaYVerificarCantidadDeChats(){
		
		Contacto contacto=new Contacto("Lucas");
		Contacto contacto2=new Contacto("Pedro");
		Agenda agenda=new Agenda();
		agenda.agregarContacto(contacto);
		agenda.agregarContacto(contacto2);
		assertTrue(agenda.cantidadDeChatsIndividuales()==0);
		String mensaje="";
		contacto.enviarMensaje(mensaje);
		assertTrue(agenda.cantidadDeChatsIndividuales()==1);
	}
	
	@Test
	
	public void agregar1ContactoAGrupoYVerificarCantidadDeContactos(){
		Contacto contacto=new Contacto("Lucas");
		Agenda agenda=new Agenda();
		agenda.agregarContacto(contacto);
		Grupo grupo=new Grupo("futbol");
		agenda.agregarGrupo(grupo);
		agenda.agregarContactoAGrupo(contacto.getNombre(),grupo.getNombre());
		//usuario se considera integrante//
		assertTrue(agenda.cantidadDeMiembrosEn(grupo.getNombre())==2);
	}
	
	@Test
	
	public void agregar0ContactoAGrupoYVerificarQueUsuarioEsteEnELGrupo(){
		Agenda agenda=new Agenda();
		Grupo grupo=new Grupo("futbol");
		agenda.agregarGrupo(grupo);
		//usuario se considera integrante//
		assertTrue(agenda.cantidadDeMiembrosEn(grupo.getNombre())==1);
	}
	
	@Test
	
	public void agregarContactoYObtenerlo(){
		Contacto contacto=new Contacto("Lucas");
		Contacto contacto2 = null;
		Agenda agenda=new Agenda();
		agenda.agregarContacto(contacto);
		try{
			contacto2=agenda.obtenerContacto("Lucas");
		}catch(ContactoInexistente e){
			fail("Contacto Inexistente");
		}
		assertTrue(contacto2==contacto);
	}
	
	@Test
	
	public void noAgregarContactoeIntentarObtenerlo(){
		
		boolean fallo=false;
		Agenda agenda=new Agenda();
		try{
			Contacto contacto=agenda.obtenerContacto("Lucas");
		}catch(ContactoInexistente e){
			fallo=true;
		}
		assertTrue(fallo);
	}
}
