package algochat;

import java.util.HashMap;

public abstract class Agenda {
	
	HashMap<String,Agendable> agendados;
	
	public Agenda(){
		agendados = new HashMap<String,Agendable>();
		
	}
	
	public void agregarAgendado(Agendable agendable){
		agendados.put(agendable.getNombre(),agendable);
	}
	
	public void AsignarMensajeEnviado(MensajeEnviado mensaje, String alias){
	
		Agendable agendable;
		agendable= agendados.get(alias);
		if(agendable!=null)
			throw new DestinatarioInexistente();
	}

}
