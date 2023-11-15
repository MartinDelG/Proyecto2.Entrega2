package Logica;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Reserva {

	//Atributos
	private String ID;
	private String cliente;
	private String categoriaSolicitada;
	//private MedioPago metodoPago;
	private String montoAPagar;
	private String sedeRecogida;
	private String sedeDevolucion;
	//Represents both a date and a time (yyyy-MM-dd-HH-mm-ss-ns)
	private LocalDate fechaReserva;
	private LocalTime horaDevolucion;
	private String vehiculoAsignado;
	private ArrayList<String> seguros;
	private ArrayList<String> conductoresAdicionales;
	private LocalDate fechaRecogida;

	
	//Metodos
	public Reserva(String id, String cliente, String categoriaSolicitada,String sedeRecogida,
			String sedeDevolucion, LocalDate fechaReserva, LocalTime horaDevolucion, String vehiculoAsignado,
			ArrayList<String> seguros, ArrayList<String> conductoresAdicionales, LocalDate fechaRecogida) {
		super();
		this.ID = id; 
		this.cliente = cliente;
		this.categoriaSolicitada = categoriaSolicitada;
		//this.montoAPagar = montoAPagar;
		this.sedeDevolucion = sedeDevolucion;
		this.fechaReserva = fechaReserva;
		this.horaDevolucion = horaDevolucion;
		this.vehiculoAsignado = vehiculoAsignado;
		this.seguros = seguros;
		this.conductoresAdicionales = conductoresAdicionales;
		this.fechaRecogida = fechaRecogida;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getCategoriaSolicitada() {
		return categoriaSolicitada;
	}


	public void setCategoriaSolicitada(String categoriaSolicitada) {
		this.categoriaSolicitada = categoriaSolicitada;
	}


	public String getSedeDevolucion() {
		return sedeDevolucion;
	}


	public void setSedeRecogida(String sedeRecogida) {
		this.sedeRecogida = sedeRecogida;
	}

	public String getSedeRecogida() {
		return sedeRecogida;
	}


	public void setSedeDevolucion(String sedeDevolucion) {
		this.sedeDevolucion = sedeDevolucion;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}


	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}


	public LocalTime getHoraDevolucion() {
		return horaDevolucion;
	}


	public void setHoraDevolucion(LocalTime horaDevolucion) {
		this.horaDevolucion = horaDevolucion;
	}


	public String getVehiculoAsignado() {
		return vehiculoAsignado;
	}


	public void setVehiculoAsignado(String vehiculoAsignado) {
		this.vehiculoAsignado = vehiculoAsignado;
	}


	public ArrayList<String> getSeguros() {
		return seguros;
	}


	public void setSeguros(ArrayList<String> seguros) {
		this.seguros = seguros;
	}


	public ArrayList<String> getConductoresAdicionales() {
		return conductoresAdicionales;
	}


	public void setConductoresAdicionales(ArrayList<String> conductoresAdicionales) {
		this.conductoresAdicionales = conductoresAdicionales;
	}


	public LocalDate getFechaRecogida() {
		return fechaRecogida;
	}


	public void setFechaRecogida(LocalDate fechaRecogida) {
		this.fechaRecogida = fechaRecogida;
	}


	public String getMontoAPagar() {
		return montoAPagar;
	}
	
	public void setMontoAPagar(String montoAPagar) {
		this.montoAPagar = montoAPagar;
	}
	
	
	public String getID() {
		return ID;
	}
	
	public String calcularCosto(Aplicacion aplicacion,boolean temp,Categoria categoria, LocalDate fechaDevolucion, LocalDate fechaRecogida) {
		int diasNecesidad = (int)(ChronoUnit.DAYS.between(fechaRecogida, fechaDevolucion)+1);
		int tarifaDiaria = 0;
		if (temp) {
			tarifaDiaria += categoria.getTarifaTemporadaAlta()*diasNecesidad;
			for (String elemento : this.seguros) {
				tarifaDiaria += Integer.parseInt(aplicacion.getSeguros().get(elemento).getCostoExtra())*diasNecesidad;
			}
			for (String elemento : this.conductoresAdicionales) {
				tarifaDiaria += categoria.getValorExtraConductorAdd()*diasNecesidad;
			}
			if (!this.sedeRecogida.equals(this.sedeDevolucion)) {
				tarifaDiaria +=  categoria.getValorExtraOtraSede();
			}
			return String.valueOf(tarifaDiaria);
		}
		else {
			tarifaDiaria += categoria.getTarifaTemporadaBaja()*diasNecesidad;
			for (String elemento : this.seguros) {
				tarifaDiaria += Integer.parseInt(aplicacion.getSeguros().get(elemento).getCostoExtra())*diasNecesidad;
			}
			for (String elemento : this.conductoresAdicionales) {
				tarifaDiaria += categoria.getValorExtraConductorAdd()*diasNecesidad;
			}
			if (!this.sedeRecogida.equals(this.sedeDevolucion)) {
				tarifaDiaria +=  categoria.getValorExtraOtraSede();
			}
			return String.valueOf(tarifaDiaria);
		}
	}
	public void calcularCostoo(Aplicacion aplicacion,Categoria deseada,ArrayList <Cliente> conducAdicionales,ArrayList<Seguro> seguros,Vehiculo asignado,Sede sedeReclamo, Sede sedeDevolucion,LocalDate fechaReclamo, LocalDate fechaDevolucion, boolean temporadaAlta) {
		
		if (asignado.equals(null)) {this.montoAPagar = "-1";}
		else {
			int tarifaDiaria = 0;
			int tarifaTotal = 0;
			int dias = (int)(ChronoUnit.DAYS.between(fechaReclamo, fechaDevolucion)+1);
			for (Seguro elemento : seguros) {
				tarifaDiaria += Integer.parseInt(elemento.getCostoExtra());
			}
			if (temporadaAlta == true) {tarifaDiaria += aplicacion.getCategorias().get(deseada.getNombre()).getTarifaTemporadaAlta();}
			else {tarifaDiaria += aplicacion.getCategorias().get(deseada.getNombre()).getTarifaTemporadaBaja();}
			tarifaTotal += tarifaDiaria * dias;
			if (!sedeReclamo.equals(sedeDevolucion)) {tarifaTotal += aplicacion.getCategorias().get(deseada.getNombre()).getValorExtraOtraSede();}
			tarifaTotal += aplicacion.getCategorias().get(deseada.getNombre()).getValorExtraConductorAdd() * conducAdicionales.size();
			this.montoAPagar = ""+tarifaTotal;
		}
	}
}
	
