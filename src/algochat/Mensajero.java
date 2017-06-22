package algochat;

import java.util.HashMap;

public class Mensajero {
	private Agenda agenda;
	
	public Mensajero(Agenda agenda){
		this.agenda=agenda;
	}
	
	public void recibirMensaje(String nombre, String mensaje){
		Agendable agendable=agenda.obtenerContacto(nombre);
		agendable.guardarMensajeRecibido(mensaje);
	}
	
	public void enviarMensaje(String nombre, String mensaje){
		Agendable agendable=agenda.obtenerContacto(nombre);
		agendable.guardarMensajeEnviado(mensaje);
	}
	
	public int cantidadDeMensajesEnviados(){
		int cantidadDeMensajes=0;
		HashMap<String,Agendable> listaDeAgendados= agenda.obtenerListado();
		if(listaDeAgendados.isEmpty()) return cantidadDeMensajes;
		for (String key : listaDeAgendados.keySet()){
			Agendable agendable=listaDeAgendados.get(key);
			cantidadDeMensajes+=agendable.mensajesEnviados();
		}
		return cantidadDeMensajes;
	}
	
	public int cantidadMensajesRecibidos(){
		int cantidadDeMensajes=0;
		HashMap<String,Agendable> listaDeAgendados= agenda.obtenerListado();
		if(listaDeAgendados.isEmpty()) return cantidadDeMensajes;
		for (String key : listaDeAgendados.keySet()){
			Agendable agendable=listaDeAgendados.get(key);
			cantidadDeMensajes+=agendable.mensajesRecibidos();
		}
		return cantidadDeMensajes;
	}	
	
	public int cantidadDeMensajesDe(String nombre){
		Agendable agendable=agenda.obtenerContacto(nombre);
		return agendable.mensajesRecibidos();
	}
	
	public int cantidadDeMensajesEnviadosA(String nombre){
		Agendable agendable=agenda.obtenerContacto(nombre);
		return agendable.mensajesEnviados();
	}
	
	public Chat obtenerConversacionCon(String nombre){
		Agendable agendable=agenda.obtenerContacto(nombre);
		return agendable.getChat();
	}
	
	public void recibirMensajeDeGrupo(String nombreGrupo,String nombreContacto,String mensaje){
		Grupo grupo=agenda.obtenerGrupo(nombreGrupo);
		grupo.guardarMensajeRecibido(mensaje,nombreContacto);
	}
}
