package ar.edu.unju.fi.ejercicio01.model;

public class Producto {

	private Integer code;
	private String description;
	private Double unitaryPrice;
	private OrigenFabricacion fabricationOrigin;
	private Categoria category;
	
	
	public enum OrigenFabricacion {
		ARGENTINA,
		CHINA,
		BRASIL,
		URUGUAY
	}
	
	public enum Categoria {
		TELEFONIA,
		INFORMATICA,
		ELECTROHOGAR,
		HERRAMIENTAS
	}
	
	public Producto() {}

	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(Double unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public OrigenFabricacion getFabricationOrigin() {
		return fabricationOrigin;
	}

	public void setFabricationOrigin(OrigenFabricacion fabricationOrigin) {
		this.fabricationOrigin = fabricationOrigin;
	}

	public Categoria getCategory() {
		return category;
	}

	public void setCategory(Categoria category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Producto [code=" + code + ", description=" + description + ", unitaryPrice=" + unitaryPrice
				+ ", fabricationOrigin=" + fabricationOrigin + ", category=" + category + "]";
	}
	
	
	
}
