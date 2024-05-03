package ar.edu.unju.fi.ejercicio07.main;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio07.utils.ProductosArrayList;

public class Main {

	static List<Producto> productos = ProductosArrayList.productsArray();
	
	static List<Producto> productosIncrementados;
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		menu();
	}

	static void menu() {
		boolean sessionOpen = true;
		do {
			System.out.println("\n**MENU**"
					+ "\n1 – Mostrar productos "
					+ "\n2 – Mostrar los productos faltantes"
					+ "\n3 – Incrementar los precios de los productos en un 20%"
					+ "\n4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta"
					+ "\n5 – Ordenar los productos por precio de forma descendente."
					+ "\n6 - Mostrar los productos con los nombres en mayúsculas. "
					+ "\n7 Salir...");
			int option = enterValidatedInteger();
			switch (option) {
				case 1:{
					showProducts();
					break;
				}
				case 2:{
					showMissingProducts();
					break;
				}	
				case 3:{
					incrementProductsCostToExtraTwentyPercert();
					break;
				}	
				case 4:{
					showElectrhogarCategoryReadyForSell();
					break;
				}
				case 5:{
					fallingOrderProductsByPrices();
					break;
				}
				case 6:{
					showProductsWithUpperCaseNames();
					break;
				}
				case 7:{
					sessionOpen = false;
					System.out.println("sesion terminada...");
					break;
				}
				default:
					break;
				}
			
		} while (sessionOpen);
	}
	
	static int enterValidatedInteger() {
		do {
			try {
				int value = Integer.parseInt(scanner.next());
				return value;
			} catch (Exception e) {
				System.out.println("ingrese un valor entero valido");
			}
		} while (true);
	}
	
	static void showProducts() {
		
		Consumer<Producto> consumerProductos = (product) -> {
			if (product.isDisponibilityState()) {
            System.out.println(product.toString());
			}
		};
		productos.forEach(consumerProductos);
	}

	static void showMissingProducts() {
		
		Predicate<Producto> predicateProductos = (product) -> product.isDisponibilityState()==false;
			productos.stream()
			.filter(predicateProductos)
			.collect(Collectors.toList())
			.forEach(product -> System.out.println(product));
	}
	
	
	static void incrementProductsCostToExtraTwentyPercert() {
	
		Function<Producto, Producto> incrementTwentyPercent = (product) -> {
			product.setUnitaryPrice(product.getUnitaryPrice()+(product.getUnitaryPrice()*0.20d));
			return product;
		};
		productosIncrementados = productos.stream()
				.map(incrementTwentyPercent)
				.collect(Collectors.toList());
		
		productosIncrementados.forEach(product -> System.out.println(product));
	}
	
	static void showElectrhogarCategoryReadyForSell() {
		
		Predicate<Producto> electroCategoryForSell = (producto) -> {
			if(producto.getCategory().equals(Categoria.ELECTROHOGAR) && producto.isDisponibilityState())
				return true;
			return false;
		};
		productos.stream()
		.filter(electroCategoryForSell)
		.collect(Collectors.toList())
		.forEach(product -> System.out.println(product));
		
	}
	
	static void fallingOrderProductsByPrices() {
		Collections.sort(productos, Comparator.comparing(Producto::getUnitaryPrice).reversed());
		productos.forEach(product -> System.out.println(product));
	}
	
	static void showProductsWithUpperCaseNames() {
		Function<Producto,Producto> upperCaseProducts = (product) -> {
			product.setDescription(product.getDescription().toUpperCase());
			return product;
		};
		
		(productos.stream()
				.map(upperCaseProducts)
				.collect(Collectors.toList()))
				.forEach(product -> System.out.println(product));
	}
	
}
