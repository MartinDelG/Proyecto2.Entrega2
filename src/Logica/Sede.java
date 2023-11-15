package Logica;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Sede {

	//Atributos
	private String nombre;
		//Represents both a date and a time (HH-mm-ss-ns)
	private LocalTime horaApertura;
	private LocalTime horaCierre;
	private ArrayList<String> empleados;
	private String administrador;
	private ArrayList<String> carrosEnSede;
		
	
	//Metetodos
	public Sede(String nombre, LocalTime horaApertura, LocalTime horaCierre, ArrayList<String> empleados,
			String administrador, ArrayList<String> carrosEnSede) {
		super();
		this.nombre = nombre;
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
		this.empleados = empleados;
		this.administrador = administrador;
		this.carrosEnSede = carrosEnSede;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public LocalTime getHoraApertura() {
		return horaApertura;
	}


	public void setHoraApertura(LocalTime horaApertura) {
		this.horaApertura = horaApertura;
	}


	public LocalTime getHoraCierre() {
		return horaCierre;
	}


	public void setHoraCierre(LocalTime horaCierre) {
		this.horaCierre = horaCierre;
	}


	public ArrayList<String> getEmpleados() {
		return empleados;
	}


	public void setEmpleados(ArrayList<String> empleados) {
		this.empleados = empleados;
	}


	public String getAdministrador() {
		return administrador;
	}


	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}


	public ArrayList<String> getCarrosEnSede() {
		return carrosEnSede;
	}


	public void setCarrosEnSede(ArrayList<String> carrosEnSede) {
		this.carrosEnSede = carrosEnSede;
	}
	
	
	
	
	
	
}
