package algochat;

import java.util.HashMap;

public class Mensajero {
	private Agenda agenda;
	
	public Mensajero(Agenda agenda){
		this.agenda=agenda;
	}
	
	public void recibirMensaje(String nombre, String mensaje){
		Contacto contacto;
		try{
			contacto=agenda.obtenerContacto(nombre);
		}catch(ContactoInexistente e){
			contacto=new Contacto("");
			agenda.agregarContacto(contacto);
		}
		contacto.enviarMensaje(mensaje);
	}
	
	public void enviarMensaje(String nombre, String mensaje){
		Contacto contacto;
		try{
			contacto=agenda.obtenerContacto(nombre);
		}catch(ContactoInexistente e){
			contacto=new Contacto("");
			agenda.agregarContacto(contacto);
		}
		contacto.recibirMensaje(mensaje);
	}
	
	public int cantidadDeMensajesEnviados(){
		int cantidadDeMensajes=0;
		HashMap<String,Agendable> listaDeAgendados= agenda.obtenerListado();
		if(listaDeAgendados.isEmpty()) return cantidadDeMensajes;
		for (String key : listaDeAgendados.keySet()){
			Agendable agendable=listaDeAgendados.get(key);
			cantidadDeMensajes+=agendable.mensajesRecibidos();
		}
		return cantidadDeMensajes;
	}
	
	public int cantidadMensajesRecibidos(){
		int cantidadDeMensajes=0;
		HashMap<String,Agendable> listaDeAgendados= agenda.obtenerListado();
		if(listaDeAgendados.isEmpty()) return cantidadDeMensajes;
		for (String key : listaDeAgendados.keySet()){
			Agendable agendable=listaDeAgendados.get(key);
			cantidadDeMensajes+=agendable.mensajesEnviadosDirectos();
		}
		return cantidadDeMensajes;
	}	
	
	public int cantidadDeMensajesDe(String nombre){
		Contacto contacto;
		try{
			contacto=agenda.obtenerContacto(nombre);
		}catch(ContactoInexistente e){
			contacto=new Contacto("");
			agenda.agregarContacto(contacto);
		}
		return contacto.mensajesEnviadosTotales();
	}
	
	public int cantidadDeMensajesEnviadosA(String nombre){
		Contacto contacto;
		try{
			contacto=agenda.obtenerContacto(nombre);
		}catch(ContactoInexistente e){
			contacto=new Contacto("");
			agenda.agregarContacto(contacto);
		}
		return contacto.mensajesRecibidos();
	}
	
	public Chat obtenerConversacionCon(String nombre){
		Contacto contacto;
		try{
			contacto=agenda.obtenerContacto(nombre);
		}catch(ContactoInexistente e){
			contacto=new Contacto("");
			agenda.agregarContacto(contacto);
		}
		return contacto.getChat();
	}
	
	public void recibirMensajeDeGrupo(String nombreGrupo,String nombreContacto,String mensaje){
		Grupo grupo;
		try{
			grupo=agenda.obtenerGrupo(nombreGrupo);
		}catch(GrupoInexistente e){
			grupo=new Grupo("");
			agenda.agregarGrupo(grupo);
		}
		grupo.enviarMensaje(mensaje,nombreContacto);
	}
	
	public void enviarMensajeAGrupo(String nomGrupo, String mensaje){
		Grupo grupo;
		try{
			grupo=agenda.obtenerGrupo(nomGrupo);
		}catch(GrupoInexistente e){
			grupo=new Grupo("");
			agenda.agregarGrupo(grupo);
		}
		grupo.recibirMensaje(mensaje);
	}
	
	public Chat obtenerConversacionConGrupo(String nombre){
		Grupo grupo;
		try{
			grupo=agenda.obtenerGrupo(nombre);
		}catch(GrupoInexistente e){
			grupo=new Grupo("");
			agenda.agregarGrupo(grupo);
		}
		return grupo.getChat();
	}
	
	public int cantidadDeMensajesRecibidosDelGrupo(String nombreGrupo){
		Grupo grupo;
		try{
			grupo=agenda.obtenerGrupo(nombreGrupo);
		}catch(GrupoInexistente e){
			grupo=new Grupo("");
			agenda.agregarGrupo(grupo);
		}
		return grupo.mensajesEnviadosTotales();
	}
	
	public int cantidadDeMensajesEnviadosAGrupo(String nombre){
		Grupo grupo;
		try{
			grupo=agenda.obtenerGrupo(nombre);
		}catch(GrupoInexistente e){
			grupo=new Grupo("");
			agenda.agregarGrupo(grupo);
		}
		return grupo.mensajesRecibidos();
	}
	
	public void borrarMensajesDe(String nombreContacto){
		Contacto contacto;
		try{
			contacto=agenda.obtenerContacto(nombreContacto);
		}catch(ContactoInexistente e){
			contacto=new Contacto("");
			agenda.agregarContacto(contacto);
		}
		contacto.borrarMensajes();
	}
	
	public void borrarMensajesDeGrupo(String nombreGrupo){
		Grupo grupo;
		try{
			grupo=agenda.obtenerGrupo(nombreGrupo);
		}catch(GrupoInexistente e){
			grupo=new Grupo("");
			agenda.agregarGrupo(grupo);
		}
		grupo.borrarMensajes();
	}
}