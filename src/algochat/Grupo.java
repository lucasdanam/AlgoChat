package algochat;

import java.util.HashMap;

public class Grupo extends Agendable{
	
	private HashMap<String,Contacto> integrantes;
	
	public Grupo(String nombre){
		super(nombre);
		integrantes=new HashMap<String,Contacto>();
	}
	
	public void agregarContacto(Contacto contacto){
		integrantes.put(contacto.getNombre(),contacto);
	}
	
	public int cantidadDeMiembros(){
		//el usuario es miembro//
		return (integrantes.size()+1);
	}
	
	public void enviarMensaje(String mensaje, String nombreDeContacto){
		this.chat.guardarMensajeEnviado(nombreDeContacto+": "+mensaje);		
		integrantes.get(nombreDeContacto).enviarMensajeGrupalA(mensaje,this);
	}
	
	public void eliminarMensajeEnviado(String mensaje){
		this.chat.eliminarMensajeEnviado(mensaje);
	}
	
	public void borrarMensajes(){
		chat.borrarMensajes();
		for ( String nombreDeContacto : this.integrantes.keySet()){
			Contacto contacto=integrantes.get(nombreDeContacto);
			contacto.eliminarMensajesEnviadosA(this);
		}
	}
}