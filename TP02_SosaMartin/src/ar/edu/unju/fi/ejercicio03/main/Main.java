package ar.edu.unju.fi.ejercicio03.main;

import ar.edu.unju.fi.ejercicio03.constantes.Provincia;

public class Main {

	static Provincia[] provinciasArray;
	
	public static void main(String[] args) {
		provinciasArray = Provincia.values();
		showProvinciesInfo(provinciasArray);
	}
	
	static void showProvinciesInfo(Provincia[] provinciesArray) {
		for (Provincia provincia : provinciesArray) {
			System.out.println("Provincia: "+provincia+", Poblacion: "+provincia.getPopulation()+", Superficie: "+provincia.getSurface()+", Densidad Poblacional: "+provincia.calculatePopulationDensity());
		}
		
	}

}
