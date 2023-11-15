package Logica;

import java.time.LocalDate;

public class Persona {

	//Atributos
	private String nombre;
	private String apellido;
		//Represents a date (year, month, day (yyyy-MM-dd))
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private String login;
	private String password;
	
	//Metodos
	public Persona(String nombre, String apellido, LocalDate fechaNacimiento, String nacionalidad, String login,
			String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.login = login;
		this.password = password;
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

	protected String getLogin() {
		return login;
	}

	protected void setLogin(String login) {
		this.login = login;
	}

	protected String getPassword() {
		return password;
	}

	protected void setPassword(String password) {
		this.password = password;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	
	
}
