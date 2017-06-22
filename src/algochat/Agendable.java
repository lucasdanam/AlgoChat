package algochat;
import java.util.ArrayList;

public class Agendable {
	
	protected String nombre;
	protected Chat chat;
	
	public Agendable(String nombre){
		this.nombre=nombre;
		this.chat=new Chat(nombre);
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public boolean chatActivo(){
		return chat.estaActivo();
	}
	
	public int mensajesEnviados(){
		return(this.chat.cantidadDeMensajesEnviados());
	}
	
	public int mensajesRecibidos(){
		return(this.chat.cantidadDeMensajesRecibidos());
	}
	
	public void guardarMensajeRecibido(String mensaje){
		chat.guardarMensajeRecibido(mensaje);
	}
	
	public void guardarMensajeEnviado(String mensaje){
		chat.guardarMensajeEnviado(mensaje);
	}
	
	public Chat getChat(){
		return chat;
	}
}
