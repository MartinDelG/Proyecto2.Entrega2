package Logica;

import java.util.ArrayList;

public class Vehiculo {

	//Atributos
	private String id;
	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String tipoTransmision;
	private String precio;
	private String categoria;
	private String sedeActual;
	private String clienteActual;
	private ArrayList<Integer> disponibilidad;
	
	//Métodos
	public Vehiculo(String id, String placa, String marca, String modelo, String color, String tipoTransmision,
			String precio, String categoria, String sedeActual, String clienteActual,
			ArrayList<Integer> disponibilidad) {
		super();
		this.id = id;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.tipoTransmision = tipoTransmision;
		this.precio = precio;
		this.categoria = categoria;
		this.sedeActual = sedeActual;
		this.clienteActual = clienteActual;
		this.disponibilidad = disponibilidad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSedeActual() {
		return sedeActual;
	}

	public void setSedeActual(String sedeActual) {
		this.sedeActual = sedeActual;
	}

	public String getClienteActual() {
		return clienteActual;
	}

	public void setClienteActual(String clienteActual) {
		this.clienteActual = clienteActual;
	}

	public ArrayList<Integer> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(ArrayList<Integer> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setTipoTransmision(String tipoTransmision) {
		this.tipoTransmision = tipoTransmision;
	}
	
	
	
	
}
