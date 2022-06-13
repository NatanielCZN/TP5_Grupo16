package ar.edu.unju.fi.tp5.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp5.model.Mensaje;

@Component
public class ListaMensaje {
	
	private List<Mensaje> listaMensajes;
	
	public ListaMensaje() {
		this.listaMensajes = new ArrayList<>();
		
		this.listaMensajes.add(new Mensaje("legajo_ocupado", "docente", "LEGAJO UTILIZADO","ERROR LEGAJO","El numero de legajo con el que intento registrarse como docente, ya existe."));
		
	}
	
	public List<Mensaje> getListaMensajes() {
		return this.listaMensajes;
	}

	public void setListaMensajes(List<Mensaje> listaMensajes) {
		this.listaMensajes = listaMensajes;
	}
}