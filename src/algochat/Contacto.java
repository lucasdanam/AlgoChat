package algochat;

import java.util.HashMap;

public class Contacto extends Agendable{
	
	private HashMap<Grupo,String> mensajesGrupalesEnviados;
	
	public Contacto(String nombre){
		super(nombre);
		this.mensajesGrupalesEnviados=new HashMap<Grupo,String>();
	}
	
	public void enviarMensajeGrupalA(String mensaje, Grupo grupo){
		this.mensajesGrupalesEnviados.put(grupo,this.nombre+": "+mensaje);
	}
	
	public int mensajesEnviadosDirectos(){
		return (this.chat.cantidadDeMensajesEnviados());
	}
	
	public int mensajesEnviadosTotales(){
		return (this.chat.cantidadDeMensajesEnviados()+this.mensajesGrupalesEnviados.size());
	}
	
	public void borrarMensajes(){
		chat.borrarMensajes();
		for (Grupo grupo : this.mensajesGrupalesEnviados.keySet()){
			String mensaje=mensajesGrupalesEnviados.get(grupo);
			grupo.eliminarMensajeEnviado(mensaje);
			this.mensajesGrupalesEnviados.remove(grupo,mensaje);
		}
	}
	
	public void eliminarMensajesEnviadosA(Grupo grupo){
			this.mensajesGrupalesEnviados.remove(grupo);
	}
}
