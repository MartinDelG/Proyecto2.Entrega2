package Logica;

public class Categoria {

	//Atributos
	private String nombre;
	private Integer tarifaTemporadaAlta;
	private Integer tarifaTemporadaBaja;
	private Integer valorExtraOtraSede;
	private Integer valorExtraConductorAdd;

	//Metodos
	public Categoria(String nombre, Integer tarifaTemporadaAlta, Integer tarifaTemporadaBaja, Integer valorExtraOtraSede,
			Integer valorExtraConductorAdd) {
		super();
		this.nombre = nombre;
		this.tarifaTemporadaAlta = tarifaTemporadaAlta;
		this.tarifaTemporadaBaja = tarifaTemporadaBaja;
		this.valorExtraOtraSede = valorExtraOtraSede;
		this.valorExtraConductorAdd = valorExtraConductorAdd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTarifaTemporadaAlta() {
		return tarifaTemporadaAlta;
	}

	public void setTarifaTemporadaAlta(int tarifaTemporadaAlta) {
		this.tarifaTemporadaAlta = tarifaTemporadaAlta;
	}

	public int getTarifaTemporadaBaja() {
		return tarifaTemporadaBaja;
	}

	public void setTarifaTemporadaBaja(int tarifaTemporadaBaja) {
		this.tarifaTemporadaBaja = tarifaTemporadaBaja;
	}

	public int getValorExtraOtraSede() {
		return valorExtraOtraSede;
	}

	public void setValorExtraOtraSede(int valorExtraOtraSede) {
		this.valorExtraOtraSede = valorExtraOtraSede;
	}

	public int getValorExtraConductorAdd() {
		return valorExtraConductorAdd;
	}

	public void setValorExtraConductorAdd(int valorExtraConductorAdd) {
		this.valorExtraConductorAdd = valorExtraConductorAdd;
	}
	
	
	
}
