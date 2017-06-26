package algochat;
import java.util.LinkedList;

public class Chat {

		private LinkedList<String> mensajesEnviados;
		private LinkedList<String> mensajesRecibidos;
		private LinkedList<String> conversacion;
		
		public Chat(){
			this.mensajesRecibidos=new LinkedList<String>();
			this.mensajesEnviados=new LinkedList<String>();
			this.conversacion=new LinkedList<String>();
		}
		
		public void guardarMensajeEnviado(String mensaje){
			this.mensajesEnviados.addFirst(mensaje);
			this.conversacion.addFirst(mensaje);
		}
		
		public void guardarMensajeRecibido(String mensaje){
			this.mensajesRecibidos.addFirst(mensaje);
			this.conversacion.addFirst(mensaje);
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
		
		public void eliminarMensajeEnviado(String mensaje){
			mensajesEnviados.remove(mensaje);
			conversacion.remove(mensaje);
		}
		
		public void borrarMensajes(){
			this.mensajesEnviados.removeAll(mensajesEnviados);
			this.mensajesRecibidos.removeAll(mensajesRecibidos);
			this.conversacion.removeAll(conversacion);
		}
}