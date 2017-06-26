package algochat;

public abstract class Agendable {
	
	protected String nombre;
	protected Chat chat;
	
	public Agendable(String nombre){
		this.nombre=nombre;
		this.chat=new Chat();
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public boolean chatActivo(){
		return chat.estaActivo();
	}
	
	public int mensajesRecibidos(){
		return(this.chat.cantidadDeMensajesRecibidos());
	}
	
	public void enviarMensaje(String mensaje){
		chat.guardarMensajeEnviado(this.nombre+": "+mensaje);
	}
	
	public void recibirMensaje(String mensaje){
		chat.guardarMensajeRecibido("Yo: "+mensaje);
	}
	
	public Chat getChat(){
		return chat;
	}
	
	public int mensajesEnviadosTotales(){
		return this.chat.cantidadDeMensajesEnviados();
	}
	
	public int mensajesEnviadosDirectos(){
		return (this.chat.cantidadDeMensajesEnviados());
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
}
