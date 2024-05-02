package ar.edu.unju.fi.ejercicio06.model;

public class FelinoDomestico {

	private String name;
	private Byte age;
	private Float weight;
	
	public FelinoDomestico() {}

	
	
	public FelinoDomestico(String name, Byte age, Float weight) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getAge() {
		return age;
	}

	public void setAge(Byte age) {
		this.age = age;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}



	@Override
	public String toString() {
		return "FelinoDomestico [name=" + name + ", age=" + age + ", weight=" + weight + "]";
	}
	
	
	
	
}
