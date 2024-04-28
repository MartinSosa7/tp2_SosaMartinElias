package ar.edu.unju.fi.ejercicio04.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;
import ar.edu.unju.fi.ejercicio04.model.Jugador;

public class Main {

	static List<Jugador> jugadoresArray = new ArrayList<>();
	
	static Scanner scanner = new Scanner(System.in);
	
	static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public static void main(String[] args) {
		menu();
	}
	
	

	static void menu() {
		
		boolean getOut = true;
		do {
			System.out.println("\n**Seleccione una opcion**"
					+ "\n1 - Alta de jugador"
					+ "\n2 - Mostrar todos los jugadores"
					+ "\n3 - Modificar la posicion de un jugador"
					+ "\n4 - Eliminar un jugador"
					+ "\n5 - Salir"
					+ "\n ingresar opcion: ");
			int option = enterValidatedInteger();
			switch (option) {
			case 1:{
				createPlayer();
				break;
			}
			case 2:{
				showAllPlayers();
				break;
			}
			case 3:{
				modifyPlayer();
				break;
			}
			case 4: {
				deletePlayer();
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
		do {
			try {
				int value = Integer.parseInt(scanner.next());
				return value;
			} catch (Exception e) {
				System.out.println("ingrese valor entero valido");
			}
			
		} while (true);
		
	}
	
	static float enterValidatedFloat() {
		do {
			try {
				float floatValue = Float.parseFloat(scanner.next());
				return floatValue;
			} catch (Exception e) {
				System.out.println("ingres valor decimal valido");
			}
			
		} while (true);
	}
	
	static LocalDate enterValidatedDate() {
		do {
			try {
				LocalDate dateValue = LocalDate.parse(scanner.next(), FORMATTER);
				return dateValue;
			} catch (Exception e) {
				System.out.println("ingresa una fecha valida de tipo dd/MM/yyyy");
			}
			
		} while (true);
	}
	
	static void createPlayer() {
		Jugador newPlayer = new Jugador();
		
		scanner.nextLine();
		System.out.println("ingrese nombre");
		newPlayer.setName(scanner.nextLine());
		System.out.println("ingrese apellido");
		newPlayer.setSurname(scanner.nextLine());
		System.out.println("ingrese fecha de nacimiento");
		newPlayer.setBirthday(enterValidatedDate());
		System.out.println("ingrese Nacionalidad");
		scanner.nextLine();
		newPlayer.setNacionality(scanner.nextLine());;
		System.out.println("ingrese Estatura");
		newPlayer.setHeight(enterValidatedFloat());
		System.out.println("ingrese Peso");
		newPlayer.setWeight(enterValidatedFloat());
		System.out.println("ingrese Posicion");
		newPlayer.setPosition(choosePosition());
		
		jugadoresArray.add(newPlayer);
		
	}
	
	static Posicion choosePosition(){
		do {
			try {
				System.out.println("**Posiciones**"
						+ "\nARQUERO"
						+ "\nDEFENSA"
						+ "\nMEDIO"
						+ "\nDELANTERO");
				Posicion position = Posicion.valueOf(scanner.next());
				return position;
			} catch (Exception e) {
				System.out.println("ingrese posicion valida");
			}
			
		} while (true);
		
	}
	
	static void showAllPlayers() {
		System.out.println("\nJUGADORES:");
		jugadoresArray.forEach(player -> System.out.println(player));
	}
	
	static void modifyPlayer() {
		scanner.nextLine();
		System.out.println("ingrese nombre");
		String nameValue = scanner.nextLine();
		System.out.println("ingrese apellido");
		String surNameValue = scanner.nextLine();
		for (Jugador jugador : jugadoresArray) {
			if(jugador.getName().equals(nameValue) && jugador.getSurname().equals(surNameValue)) {
				boolean stillModifying = true;
				do {
					System.out.println("\n**POSICION JUGADOR**"
							+ "\nJugador: "+jugador.getName()+" "+jugador.getSurname()
							+ "\n1 - POSICION: "+jugador.getPosition()
							+ "\n2 - Salir");
					int option = enterValidatedInteger();
					switch (option) {
						case 1:{
							jugador.setPosition(choosePosition());
							break;
						}	
						case 2:{
							stillModifying = false;
							break;
						}
					}
					
					
				} while (stillModifying);
				
			}
			break;
		}
		
		
	}

	static void deletePlayer() {
		scanner.nextLine();
		System.out.println("ingrese nombre");
		String nameValue = scanner.nextLine();
		System.out.println("ingrese apellido");
		String surNameValue = scanner.nextLine();
		Iterator<Jugador> iterator = jugadoresArray.iterator();
		while(iterator.hasNext()) {
			Jugador it = iterator.next();
			if(it.getName().equals(nameValue) && it.getSurname().equals(surNameValue)) {
				iterator.remove();
				break;
			}
		}
	}
	
}
