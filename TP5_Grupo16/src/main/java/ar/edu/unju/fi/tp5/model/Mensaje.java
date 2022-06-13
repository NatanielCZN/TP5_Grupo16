package ar.edu.unju.fi.tp5.model;

import org.springframework.stereotype.Component;

@Component
public class Mensaje {
	private String id;
	private String propietario;
	private String tpage;
	private String tmsj;
	private String mensaje;
	
	public Mensaje() {
		
	}
	
	public Mensaje(String id, String propietario, String tpage, String tmsj, String mensaje) {
		this.id = id;
		this.propietario = propietario;
		this.tpage = tpage;
		this.tmsj = tmsj;
		this.mensaje = mensaje;
	}

	/*
	 * Metodos accesores
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
	public String getTpage() {
		return tpage;
	}

	public void setTpage(String tpage) {
		this.tpage = tpage;
	}

	public String getTmsj() {
		return tmsj;
	}

	public void setTmsj(String tmsg) {
		this.tmsj = tmsg;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Mensaje [tpage=" + tpage + ", tmsg=" + tmsj + ", mensaje=" + mensaje + "]";
	}
}