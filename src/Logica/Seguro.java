package Logica;

public class Seguro {

	//Atributos
	private String id;
	private String nombre;
	private String costoExtra;
	
	//Metodos
	public Seguro(String id,String nombre, String costo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costoExtra = costo;
	}
	
	public String getId() {
		return nombre;
	}

	public void setId(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCostoExtra() {
		return costoExtra;
	}

	public void setCostoExtra(String costoExtra) {
		this.costoExtra = costoExtra;
	}
	
	
	
}
