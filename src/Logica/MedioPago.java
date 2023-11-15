package Logica;

public class MedioPago {

	//Atributos
	private String numero;
	private boolean estadoTarjeta;
	private String cvv;
	
	//Metodos
	public MedioPago(String numero, boolean estadoTarjeta, String cvv) {
		super();
		this.numero = numero;
		this.estadoTarjeta = estadoTarjeta;
		this.cvv = cvv;
	}

	public boolean isEstadoTarjeta() {
		return estadoTarjeta;
	}

	public void setEstadoTarjeta(boolean estadoTarjeta) {
		this.estadoTarjeta = estadoTarjeta;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
	
	
}
