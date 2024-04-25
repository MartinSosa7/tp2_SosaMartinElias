package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import ar.edu.unju.fi.ejercicio01.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio01.model.Producto.OrigenFabricacion;

public class Main {

	static List<Producto> productos = new ArrayList<>();
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
	}
	
	static void menu() {
		
		boolean getOut = true;
		do {
			System.out.println("\nSeleccione una opcion"
					+ "\n1 - Alta de Producto"
					+ "\n2 - Mostrar todos los Productos."
					+ "\n3 - Modificar el Producto por codigo"
					+ "\n4 - Salir"
					+ "\n ingresar opcion: ");
			int option = enterValidatedInteger();
			switch (option) {
			case 1:{
				createProduct();
				break;
			}
			case 2:{
				showProducts();
				break;
			}
			case 3:{
				modifyProduct();
				break;
			}
			case 4:{
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
				System.out.println("Debe ingresar un valor entero valido");
			}
		}while(true);
	}
	
	static double enterValidatedDouble() {
		do {
			try {
				double value = Double.parseDouble(scanner.next());
				return value;
			} catch (Exception e) {
				System.out.println("Debe ingresar un valor decimal valido");
			}
			
		} while (true);
		
	}
	
	static void createProduct() {
		
		Producto newProduct = new Producto();
		
		System.out.println("ingrese codigo");
		newProduct.setCode(enterValidatedInteger());
		scanner.nextLine();
		System.out.println("ingrese descripcion");
		newProduct.setDescription(scanner.nextLine());
		System.out.println("ingrese precio unitario");
		newProduct.setUnitaryPrice(enterValidatedDouble());
		System.out.println("ingrese Origen fabricacion");
		newProduct.setFabricationOrigin(chooseFabricationOrigin());
		System.out.println("ingrese Categoria");
		newProduct.setCategory(chooseCategory());
		
		productos.add(newProduct);
	}
	
	static void showProducts() {
		for (Producto producto : productos) {
			System.out.println(producto.toString());
		}
	}
	
	static OrigenFabricacion chooseFabricationOrigin() {
		do {
			try {
				System.out.println("\nEliga el origen de fabricacion"
						+ "\nARGENTINA"
						+ "\nCHINA"
						+ "\nBRASIL"
						+ "\nURUGUAY");
				OrigenFabricacion origin = OrigenFabricacion.valueOf(scanner.next().toUpperCase());
				return origin;
				
			} catch (Exception e) {
				System.out.println("ingrese un origen valido");
			}
			
			
		} while (true);
	}
	
	
	static Categoria chooseCategory() {
		do {
			try {
				System.out.println("\nEliga la categoria"
						+ "\nTELEFONIA"
						+ "\nINFORMATICA"
						+ "\nELECTROHOGAR"
						+ "\nHERRAMIENTAS");
				Categoria category = Categoria.valueOf(scanner.next().toUpperCase());
				return category;
				
			} catch (Exception e) {
				System.out.println("ingrese una categoria valida");
			}
			
			
		} while (true);
	}
	
	
	static void modifyProduct() {
		
		System.out.println("\nIngrese codigo del producto que desea modificar");
		int code = enterValidatedInteger();
		for (Producto producto : productos) {
			if(producto.getCode() == code) {
				boolean stillModifying = true;
				do {	
					System.out.println("\nSELECCIONE INFO A MODIFICAR"
							+ "\n1-Descripcion: "+producto.getDescription()
							+ "\n2-Precio Unitario: "+producto.getUnitaryPrice()
							+ "\n3-Categoria: "+producto.getCategory()
							+ "\n4-Origen de Fabricacion: "+producto.getFabricationOrigin()
							+ "\n5-Salir");
					int option = enterValidatedInteger();
					scanner.nextLine();
						switch (option) {
						
						case 1:{
							System.out.println("modificando descripcion: ");
							producto.setDescription(scanner.nextLine());
							break;
						}
						
						case 2:{
							System.out.println("moficando Precio: ");
							producto.setUnitaryPrice(enterValidatedDouble());
							break;
						}
						
						case 3:{
							producto.setCategory(chooseCategory());
							break;
						}
						
						case 4:{
							producto.setFabricationOrigin(chooseFabricationOrigin());
							break;
						}
						
						case 5:{
							stillModifying = false;
							break;
						}

						default:
							break;
						}					
					}while(stillModifying);
					break;
				}
			}
				
		}
			
			
}
