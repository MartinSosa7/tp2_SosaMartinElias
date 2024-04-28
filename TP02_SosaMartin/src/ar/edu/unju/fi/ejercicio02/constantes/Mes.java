package ar.edu.unju.fi.ejercicio02.constantes;

public enum Mes {
	
	ENERO(1),
	FEBRERO(2),
	MARZO(3), 
	ABRIL(4), 
	MAYO(5), 
	JUNIO(6), 
	JULIO(7), 
	AGOSTO(8), 
	SEPTIEMBRE(9), 
	OCTUBRE(10), 
	NOVIEMBRE(11), 
	DICIEMBRE(12);
	
	private Integer monthNumericValue;

	private Mes(Integer monthNumericValue) {
		this.monthNumericValue = monthNumericValue;
	}

	public Integer getMonthNumericValue() {
		return monthNumericValue;
	}	
	
	
	
}
