package Logica;

import java.time.LocalDate;

public class Licencia {

	//Atributos
	private String id;
	private String pais;
		//Represents a date (year, month, day (yyyy-MM-dd))
	private LocalDate fechaVencimiento;
	private String foto;

	//Metodos
	public Licencia(String id, String pais, LocalDate fechaVencimiento, String foto) {
		super();
		this.id = id;
		this.pais = pais;
		this.fechaVencimiento = fechaVencimiento;
		this.foto = foto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
