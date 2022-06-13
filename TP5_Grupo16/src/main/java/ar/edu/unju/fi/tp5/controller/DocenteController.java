package ar.edu.unju.fi.tp5.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp5.model.Docente;
import ar.edu.unju.fi.tp5.service.IDocenteService;
import ar.edu.unju.fi.tp5.service.IMensajeService;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	// Inyecto una implementacion de una interface
	@Autowired
	// Elijo a cual implementacion hago referencia
	@Qualifier("DocenteServiceImpList")
	private IDocenteService docenteService;
	
	@Autowired
	@Qualifier("MensajeServiceImpList")
	private IMensajeService mensajeService;
	
	// Creo una constante de clase tipo Log
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);

	/**
	 * Obtengo la URL de la pagina "lista_docentes".
	 * Esta mostrara el listado de docentes.
	 * @param model
	 * @return
	 */
	@GetMapping("/lista")
	public String getDocentesPage(Model model) {
		model.addAttribute("docentes", docenteService.getListaDocente().getListaDocentes());
		return "lista_docentes";
	}
	
	/**
	 * Obtengo la URL de la pagina "nuevo_docente".
	 * Esta mostrara el formulario para agregar un nuevo docente.
	 * @param model
	 * @return
	 */
	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		model.addAttribute("docente", docenteService.getDocente());
		return "nuevo_docente";
	}
	
	/**
	 * Metodo que agregara un Docente a la lista, pasado por parametro
	 * @param nuevoDocente
	 * @param bindingR
	 * @return
	 */
	@PostMapping("/guardar")
	public ModelAndView guardarNuevoDocente(@Validated @ModelAttribute("docente") Docente nuevoDocente, BindingResult bindingR) {
		/*
		 * @Validated proviene de Spring Framework Validation
		 * El objeto "bindingR" contiene el resultado de la validacion.
		 * (Errores que pueden haber ocurrido)
		 */
		if(bindingR.hasErrors()) {
			ModelAndView modelAV = new ModelAndView("nuevo_docente");
			modelAV.addObject("docente", nuevoDocente);
			return modelAV;
		}
		
		if(docenteService.verificarDocente(nuevoDocente)) {
			ModelAndView modelAV = new ModelAndView("redirect:/docente/lista");
			
			if(docenteService.guardarDocente(nuevoDocente)) {
				LOGGER.info("Se agrego un objeto a la lista de docentes");
			}
			else {
				LOGGER.info("No se pudo agregar un objeto a la lista de docentes");
			}			
			return modelAV;
		}
		else {
			ModelAndView modelAV = new ModelAndView("msj_paramutilizado");
			modelAV.addObject("mensaje", mensajeService.getErrorParamMsj("legajo_ocupado"));
			return modelAV;
		}	
	}
	
	/**
	 * Obtengo la URL de la pagina "edicion_docente" de acuerdo a su numero de legajo.
	 * Esta mostrara el formulario para edicion.
	 * "{legajo}" es una variable que viene en la URL.
	 * @param legajo
	 * @return
	 */
	@GetMapping("/editar/{legajo}")
	public ModelAndView getEditarDatosDocentePage(@PathVariable(value="legajo") int legajo) {
		ModelAndView modelAV = new ModelAndView("edicion_docente");
		Docente docente = docenteService.buscarDocente(legajo);
		modelAV.addObject("docente", docente);
		return modelAV;
	}
	
	/**
	 * Metodo que modificara los datos de un Docente de acuerdo a los cambios hechos en el formulario.
	 * @param docenteMod
	 * @param bindingR
	 * @return
	 */
	@PostMapping("/modificar")
	public ModelAndView editarDatosDocente(@Validated @ModelAttribute("docente") Docente docenteMod, BindingResult bindingR) {
		if(bindingR.hasErrors()) {
			ModelAndView modelAV = new ModelAndView("edicion_docente");
			modelAV.addObject("docente", docenteMod);
			return modelAV;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/docente/lista");
		docenteService.modificarDocente(docenteMod);
		return mav;
	}
	
	/**
	 * Metodo que eliminara un Docente de la lista.
	 * @param legajo
	 * @return
	 */
	@GetMapping("/eliminar/{legajo}")
	public ModelAndView eliminarDocente(@PathVariable("legajo") int legajo) {
		ModelAndView modelAV = new ModelAndView("redirect:/docente/lista");
		docenteService.eliminarDocente(legajo);
		return modelAV;
	}
}