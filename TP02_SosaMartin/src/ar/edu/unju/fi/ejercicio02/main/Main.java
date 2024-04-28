package ar.edu.unju.fi.ejercicio02.main;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;
import ar.edu.unju.fi.ejercicio02.model.Efemeride;

public class Main {

	static List<Efemeride> efemeridesArray = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
	}
	
	static void menu() {
		
		boolean getOut = true;
		do {
			System.out.println("\n**Seleccione una opcion**"
					+ "\n1 - Crear Efemeride"
					+ "\n2 - Mostrar efemerides"
					+ "\n3 - Eliminar Efemeride"
					+ "\n4 - Modificar Efemeride"
					+ "\n5 - Salir"
					+ "\n ingresar opcion: ");
			int option = enterValidatedInteger();
			switch (option) {
			case 1:{
				createEfemeride();
				break;
			}
			case 2:{
				showEfemerides();
				break;
			}
			case 3:{
				deleteEfemeride();
				break;
			}
			case 4: {
				modifyEfemeride();
				break;
			}
			case 5:{
				System.out.println("sesion terminada...");
				getOut = false;
				break;
			}

			default:
				break;
			}
			
			
		} while (getOut);
		
	}
	
	static int enterValidatedInteger() {
		while (true) {
			try {
				int value = Integer.parseInt(scanner.next());
				return value;
			} catch (Exception e) {
				System.out.println("ingrese un valor entero valido");
			}
			
		}
	}
	
	static void createEfemeride() {
		Efemeride newEfemeride = new Efemeride();
		
		System.out.println("Ingrese codigo");
		newEfemeride.setCode(enterValidatedInteger());
		System.out.println("ingrese mes");
		newEfemeride.setMonth(chooseMonth());
		System.out.println("ingrese dia");
		newEfemeride.setDay(enterValidatedInteger());
		System.out.println("ingrese detalle");
		scanner.nextLine();
		newEfemeride.setDetail(scanner.nextLine());
		
		efemeridesArray.add(newEfemeride);
	}
	
	static Mes chooseMonth() {
		int validMonth; 
		do {
			System.out.println("elige un mes [1,12]");
			validMonth = scanner.nextInt();
			
		} while (validMonth>12 || validMonth <1);
		Mes month = null;
		for (Mes currentlyMonth : Mes.values()) {
			if(currentlyMonth.getMonthNumericValue() == validMonth)
				month = currentlyMonth;
		}
	
		return month;
	}

	static void showEfemerides() {
		System.out.println("\nEFEMERIDES: ");
		efemeridesArray.forEach((efemeride)-> System.out.println(efemeride));
	}
	
	static void deleteEfemeride() {
		System.out.println("ingrese codigo del efemeride a borrar");
		int codeToDelete = enterValidatedInteger();
		Iterator<Efemeride> iteratorEfemeride = efemeridesArray.iterator();
		while (iteratorEfemeride.hasNext()) {
			Efemeride efemeride = iteratorEfemeride.next();
			if(efemeride.getCode()== codeToDelete) {
				iteratorEfemeride.remove();
				break;
			}
		}
				
	}

	static void modifyEfemeride() {
		System.out.println("ingrese CODIGO del efemeride a MODIFICAR");
		int codeToModify = enterValidatedInteger();
		for (Efemeride efemeride : efemeridesArray) {
			
			if(efemeride.getCode() == codeToModify) {
				boolean stillModifying = true;
				do {
					System.out.println("\nSeleccione que valor MODIFICAR "
							+ "\n1- Mes actual: "+efemeride.getMonth()
							+ "\n2- dia: "+efemeride.getDay()
							+ "\n3- detalle: "+efemeride.getDetail()
							+ "\n4- Salir"
							+ "\nOpcion: ");
					int option = enterValidatedInteger();
					scanner.nextLine();
					switch (option) {
						
						case 1:{
							System.out.println("ingrese nuevo mes");
							efemeride.setMonth(chooseMonth());
							break;
						}
						case 2:{
							System.out.println("ingrese nuevo dia");
							efemeride.setDay(enterValidatedInteger());;
							break;
						}
						case 3:{
							System.out.println("ingrese nuevo detalle");
							efemeride.setDetail(scanner.nextLine());
							break;
						}
						case 4:{
							stillModifying = false;
							break;
						}
						
					}	
					
				} while (stillModifying);				
			}
			break;
			
		}
		
	}
}
