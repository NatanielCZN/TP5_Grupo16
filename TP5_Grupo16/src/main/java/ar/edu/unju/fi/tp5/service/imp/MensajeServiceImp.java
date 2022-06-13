package ar.edu.unju.fi.tp5.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp5.model.Mensaje;
import ar.edu.unju.fi.tp5.service.IMensajeService;
import ar.edu.unju.fi.tp5.util.ListaMensaje;

@Service("MensajeServiceImpList")
public class MensajeServiceImp implements IMensajeService {

	@Autowired
	private ListaMensaje listaMensaje;
	
	@Override
	public Mensaje getErrorParamMsj(String id) {
		// Retorna un mensaje de legajo utilizado
		int posicion = 0;
		for(Mensaje msj : listaMensaje.getListaMensajes()) {
			if(msj.getId().equals(id)) {
				return listaMensaje.getListaMensajes().get(posicion);				
			}
			posicion++;
		}
		return null;
	}

}