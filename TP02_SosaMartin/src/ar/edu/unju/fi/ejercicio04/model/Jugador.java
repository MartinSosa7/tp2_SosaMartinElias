package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

public class Jugador {

	private String name;
	private String surname;
	private LocalDate birthday;
	private String nacionality;
	private Float height;
	private Float weight;
	private Posicion position;
	
	public Jugador() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public Float getHeight() {
		return height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public Posicion getPosition() {
		return position;
	}

	public void setPosition(Posicion position) {
		this.position = position;
	}

	
	public int calculateAge() {
		return  LocalDate.now().getDayOfYear() - this.birthday.getDayOfYear();
	}

	@Override
	public String toString() {
		return "Jugador [name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", nacionality="
				+ nacionality + ", height=" + height + ", weight=" + weight + ", position=" + position + "]";
	}

	
}
