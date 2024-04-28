package ar.edu.unju.fi.ejercicio02.model;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;

public class Efemeride {
	
	private Integer code;
	private Mes month;
	private Integer day;
	private String detail;
	
	public Efemeride() {}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Mes getMonth() {
		return month;
	}

	public void setMonth(Mes month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Efemeride [code=" + code + ", month=" + month + ", day=" + day + ", detail=" + detail + "]";
	}
	
	
	
	
}
