package ar.edu.unju.fi.tp5.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tp5.model.Docente;

@Component
public class ListaDocente {
	
	private List<Docente> listaDocentes;

	/*
	 * Constructor no parametrizado
	 */
	public ListaDocente() {
		// Crear el ArrayList
		this.listaDocentes = new ArrayList<>();
		// Precargar el ArrayList de docentes
		this.listaDocentes.add(new Docente(1,"Nataniel","Cazon","natanielarg@gmail.com",4251193));
		this.listaDocentes.add(new Docente(2,"Ariel","Saravia","arielarg@gmail.com",4204204));
		this.listaDocentes.add(new Docente(3,"Josemi","Quintana","josemiarg@gmail.com",1234567));
	}
	
	/*
	 * Metodos accesores
	 */
	public List<Docente> getListaDocentes() {
		return listaDocentes;
	}
	public void setListaDocentes(List<Docente> listaDocentes) {
		this.listaDocentes = listaDocentes;
	}
}