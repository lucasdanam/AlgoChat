package algochat;

public class AlgoChat {
	
	private String nombre;
	private Agenda agenda;
	private Mensajero mensajero;

	public AlgoChat(String name){
		this.nombre=name;
		this.agenda=new Agenda();
		this.mensajero=new Mensajero(agenda);
	}
	
	public void agregarContacto(String nombreContacto){
		Contacto contacto=new Contacto(nombreContacto);
		agenda.agregarContacto(contacto);
	}
	
	public int cantidadDeGrupos(){
		return agenda.cantidadDeGrupos();
	}
	
	public int cantidadDeContactos(){
		return agenda.cantidadDeContactos();
	}
	
	public int cantidadDeChatsGrupales(){
		return agenda.cantidadDeChatsGrupales();
	}
    
	public int cantidadDeChatsIndividuales(){
		return agenda.cantidadDeChatsIndividuales();
	}
	
	public int cantidadDeMensajesEnviados(){
		return mensajero.cantidadDeMensajesEnviados();
	}
	
	public String nombreUsuario(){
		return nombre;
	}
	
	public boolean existeContacto(String nombre){
		return agenda.existeContacto(nombre);
	}
	
	public boolean existeGrupo(String nombre){
		return agenda.existeGrupo(nombre);
	}
	
	public void recibirMensajeDe(String nombre,String mensaje){
		mensajero.recibirMensaje(nombre,mensaje);
	}
	
	public int cantidadTotalMensajesRecibidos(){
		return mensajero.cantidadMensajesRecibidos();
	}
	
	public int cantidadMensajesDe(String nombre){
		return mensajero.cantidadDeMensajesDe(nombre);
	}
	
	public void enviarMensajeA(String nombre, String mensaje){
		mensajero.enviarMensaje(nombre,mensaje);
	}
	
	public int cantidadTotalMensajesEnviados(){
		return mensajero.cantidadDeMensajesEnviados();
	}
    
	public int cantidadMensajesEnviadosA(String nombre){
		return mensajero.cantidadDeMensajesEnviadosA(nombre);
	}
	
	public void crearGrupo(String nombre){
		Grupo grupo=new Grupo(nombre);
		agenda.agregarGrupo(grupo);
	}
	
	public Chat obtenerConversacionCon(String nombre){
		return mensajero.obtenerConversacionCon(nombre);
	}
	
	public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo){
		Contacto contacto=agenda.obtenerContacto(nombreContacto);
		agenda.obtenerGrupo(nombreGrupo).agregarContacto(contacto);
			
	}
	
	public int cantidadMiembrosEnGrupo(String grupo){
		return agenda.obtenerGrupo(grupo).cantidadDeMiembros();
	}
	
	recibirMensajeDeGrupo(String nombreGrupo,String nombreContacto,String mensaje){
		mensajero.recibirMensajeDeGrupo(nombreGrupo,nombreContacto,mensaje);
	}
}