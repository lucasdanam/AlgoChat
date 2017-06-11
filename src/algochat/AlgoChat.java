package algochat;
	
public class AlgoChat {
	
	private String nombre;
	private AgendaGrupos grupos;
	private AgendaContactos contactos;
	
	public AlgoChat(String name){
		this.nombre=name;
	}
	
	public void agregarContacto(String nombreContacto){
		Contacto contacto=new Contacto();
		contacto setNombre(nombreContacto);
		contactos agregar(Contacto);
	}
	
	public String nombreUsuario(){
		return nombre;
	}

}
