package ar.edu.unju.fi.tp5.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Docente;
import ar.edu.unju.fi.tp5.service.IDocenteService;
import ar.edu.unju.fi.tp5.util.ListaDocente;

/*
 * Esta clase es un Bind de Spring y responde a un Service.
 * Ósea que es una clase especial que necesitamos para poder operar con la capa de servicios.
 */
@Service("DocenteServiceImpList")
public class DocenteServiceImp implements IDocenteService {

	@Autowired
	private ListaDocente listaDocente;
	
	@Override
	public Docente getDocente() {
		// Retorna un objeto de la clase Docente
		return new Docente();
	}

	@Override
	public boolean verificarDocente(Docente docente) {
		for(Docente doc : this.listaDocente.getListaDocentes()) {
			if(doc.getLegajo() == docente.getLegajo()) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean guardarDocente(Docente docente) {
		// Guarda un objeto Docente en la lista de docentes
		// boolean respuesta = listaDocente.getListaDocentes().add(docente);
		return this.listaDocente.getListaDocentes().add(docente);
	}

	@Override
	public void modificarDocente(Docente docente) {
		// Buscar el Docente con el legajo especificado y actualizar sus atributos
		for(Docente doce : this.listaDocente.getListaDocentes()) {
			if(doce.getLegajo() == docente.getLegajo()) {
				doce.setNombre(docente.getNombre());
				doce.setApellido(docente.getApellido());
				doce.setEmail(docente.getEmail());
				doce.setTelefono(docente.getTelefono());
			}
		}
	}

	@Override
	public void eliminarDocente(int legajo) {
		// Elimino un Docente de la lista de docentes
		int posicion = 0;
		for(Docente doc : this.listaDocente.getListaDocentes()) {
			if(doc.getLegajo() == legajo) {
				this.listaDocente.getListaDocentes().remove(posicion);
				break;
			}
			posicion++;
		}
	}

	@Override
	public ListaDocente getListaDocente() {
		// Retorna el objeto que accede a la lista de docentes
		return this.listaDocente;
	}

	@Override
	public Docente buscarDocente(int legajo) {
		// Busca un Docente por legajo y devuelve el objeto asociado al numero de legajo
		Optional<Docente> docente = this.listaDocente.getListaDocentes().stream().filter(d -> d.getLegajo() == legajo).findFirst();
		return docente.get();
	}
}