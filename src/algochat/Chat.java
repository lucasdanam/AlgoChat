package algochat;
import java.util.LinkedList;

public class Chat {

		private LinkedList<String> mensajesEnviados;
		private LinkedList<String> mensajesRecibidos;
		private LinkedList<String> conversacion;
		private String nombre;
		
		public Chat(String nombre){
			mensajesEnviados=new LinkedList<String>();
			mensajesRecibidos=new LinkedList<String>();
			conversacion=new LinkedList<String>();
			this.nombre=nombre;
		}
		
		public void guardarMensajeEnviado(String mensaje){
			this.mensajesEnviados.addFirst(mensaje);
			this.conversacion.addFirst("Yo: "+mensaje);
		}
		
		public void guardarMensajeRecibido(String mensaje){
			this.mensajesRecibidos.addFirst(mensaje);
			this.conversacion.addFirst(nombre+": "+mensaje);
		}
		
		public String obtenerMensaje(int posicion){
			return conversacion.get(posicion-1);
		}
		
		public boolean estaActivo(){
			return (conversacion.size()>0);
		}
		
		public String get(int posicion){
			return conversacion.get(posicion-1);
		}
		
		public int cantidadDeMensajesEnviados(){
			return this.mensajesEnviados.size();
		}
		
		public int cantidadDeMensajesRecibidos(){
			return this.mensajesRecibidos.size();
		}
}


