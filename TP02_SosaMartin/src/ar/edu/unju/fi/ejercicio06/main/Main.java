package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {

	static Converter<FelinoSalvaje, FelinoDomestico> converter;
	
	public static void main(String[] args) {
		FelinoSalvaje gato = new FelinoSalvaje("Tanner", (byte)20, 186f);
		System.out.println("El objeto es nulo? "+ (checkIfNotNull(gato) ? "NO":"SI"));
		showInfo(convertCat(gato));
		
	}
	
	static FelinoDomestico convertCat(FelinoSalvaje feline) {
		converter = (cat)-> new FelinoDomestico(cat.getName(), cat.getAge(), cat.getWeight());
		return converter.convert(feline);
	}
	
	static<T> boolean checkIfNotNull(T feline) {
		return Converter.inNotNull(feline);
	}
	
	static void showInfo(FelinoDomestico feline) {
		converter.mostrarObjeto(feline);
	}

}
