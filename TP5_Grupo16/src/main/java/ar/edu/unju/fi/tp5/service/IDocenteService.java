package ar.edu.unju.fi.tp5.service;

import ar.edu.unju.fi.tp5.model.Docente;
import ar.edu.unju.fi.tp5.util.ListaDocente;

/*
 * El cuerpo de la interface contiene las declaraciones de metodos abstractos
 */
public interface IDocenteService {
	
	public Docente getDocente();
	public boolean verificarDocente(Docente docente);
	public boolean guardarDocente(Docente docente);
	public void modificarDocente(Docente docente);
	public void eliminarDocente(int legajo);
	public ListaDocente getListaDocente(); 
	public Docente buscarDocente(int legajo);
}