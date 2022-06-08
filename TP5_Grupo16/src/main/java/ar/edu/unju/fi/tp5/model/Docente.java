package ar.edu.unju.fi.tp5.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/*
 * Objeto Bind que Spring podra gestionar.
 */
@Component
public class Docente {
	
	@Min(value = 1, message = "El numero de legajo debe tener como minimo 1 digito")
	@Positive(message = "El numero de legajo debe ser positivo")
	private long legajo;
	@Size(min = 3, max = 100, message = "El nombre debe tener entre 3 a 100 caracteres")
	@NotEmpty(message = "El nombre del docente no puede estar vacio")
	private String nombre;
	@Size(min = 3, max = 100, message = "Los apellido debe tener entre 4 a 100 caracteres")
	@NotEmpty(message = "El apellido del docente no puede estar vacio")
	private String apellido;
	@NotEmpty(message = "La direccion de correo electronico no puede estar vacia")
	@Email
	private String email;
	@Min(value = 100, message = "El numero de telefono debe tener como manimo 3 digitos")
	@Positive(message = "El numero de telefono debe ser positivo")
	private long telefono;
	
	/*
	 * Constructor no parametrizado
	 */
	public Docente() {
		
	}

	/*
	 * Constructor parametrizado
	 */
	public Docente(long legajo, String nombre, String apellido, String email, long telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	/*
	 * Metodos accesores
	 */
	public long getLegajo() {
		return legajo;
	}
	public void setLegajo(long legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Docente [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
}