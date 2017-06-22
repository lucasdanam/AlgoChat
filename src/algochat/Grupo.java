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
	
	public void guardarMensajeRecibido(String mensaje, String nombreDeContacto){
		this.chat.guardarMensajeRecibido(mensaje);		
		integrantes.get(nombreDeContacto).guardarMensajeRecibidoEnGrupo();

		
	}
}
