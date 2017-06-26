package algochat;

import java.util.HashMap;

public class Agenda {
	
	private HashMap<String,Agendable> agendaGeneral;
	private HashMap<String,Contacto> agendaDeContactos;
	private HashMap<String,Grupo> agendaDeGrupos;
	
	public Agenda(){
		agendaGeneral = new HashMap<String,Agendable>();
		agendaDeContactos = new HashMap<String,Contacto>();
		agendaDeGrupos = new HashMap<String,Grupo>();
	}
	
	public void agregarGrupo(Grupo agendable) {
		agendaGeneral.put(agendable.getNombre(),agendable);
		agendaDeGrupos.put(agendable.getNombre(),agendable);
	}
	
	public void agregarContacto(Contacto agendable){
		agendaGeneral.put(agendable.getNombre(),agendable);
		agendaDeContactos.put(agendable.getNombre(),agendable);
	}
	
	public int cantidadDeContactos(){
		return agendaDeContactos.size();
	}
	
	public int cantidadDeChatsIndividuales(){
		int cantidadDeChats=0;
		if(agendaDeContactos.isEmpty()) return cantidadDeChats;
		for (String key : agendaDeContactos.keySet()){
			Agendable agendable=agendaDeContactos.get(key);
			if (agendable.chatActivo())
				cantidadDeChats++;
		}
		return cantidadDeChats;
	}
	
	public int cantidadDeGrupos(){
		return agendaDeGrupos.size();
	}
	
	public int cantidadDeChatsGrupales(){
		int cantidadDeChats=0;
		if(agendaDeGrupos.isEmpty()) return cantidadDeChats;
		for (String key : agendaDeGrupos.keySet()){
			Agendable agendable=agendaDeGrupos.get(key);
			if (agendable.chatActivo())
				cantidadDeChats++;
		}
		return cantidadDeChats;
	}
	
	public Contacto obtenerContacto(String nombre) throws ContactoInexistente{
		if (!this.existeContacto(nombre)) throw new ContactoInexistente();
		return agendaDeContactos.get(nombre);
	}
	
	public Grupo obtenerGrupo(String nombre) throws GrupoInexistente{
		if (!this.existeGrupo(nombre)) throw new GrupoInexistente();
		return this.agendaDeGrupos.get(nombre);
	}
	
	public boolean existeGrupo(String nombre){
		return agendaDeGrupos.containsKey(nombre);
	}
	
	public boolean existeContacto(String nombre){
		return agendaDeContactos.containsKey(nombre);
	}
	
	public HashMap<String,Agendable> obtenerListado(){
		return this.agendaGeneral;
	}
	
	public void agregarContactoAGrupo(String nombreContacto,String nombreGrupo){
		Contacto contacto;
		Grupo grupo;
		try{
			contacto=this.obtenerContacto(nombreContacto);
		}catch(ContactoInexistente e){
			contacto=new Contacto("");
			this.agregarContacto(contacto);
		}
		try{
			grupo=this.obtenerGrupo(nombreGrupo);
		}catch(GrupoInexistente e){
			grupo=new Grupo("");
			this.agregarGrupo(grupo);
		}
		grupo.agregarContacto(contacto);
	}
	
	public int cantidadDeMiembrosEn(String nombreGrupo){
		Grupo grupo;
		try{
			grupo=this.obtenerGrupo(nombreGrupo);
		}catch(GrupoInexistente e){
			grupo=new Grupo("");
			this.agregarGrupo(grupo);
		}
		return grupo.cantidadDeMiembros();
	}
}