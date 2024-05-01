package ar.edu.unju.fi.ejercicio05.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	
	static List<Producto> productosArray = new ArrayList<>();
	
	static List<Producto> carritoDeCompras = new ArrayList<>();
	
	public static void main(String[] args) {
		initilizeProducts();
		menu();
	}
	
	static void menu() {
		boolean sessionOpen = true;
		do {
			System.out.println("\n**MENU**"
					+ "\n1 - Mostrar Productos"
					+ "\n2 - Realizar Compra"
					+ "\n3 - Salir");
			int option = enterValidatedInteger();
			switch (option) {
				case 1:{
					showProducts();
					break;
				}
				case 2:{
					buyProducts();
					break;
				}
				case 3:{
					System.out.println("\nSesion terminada...");
					sessionOpen = false;
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
				System.out.println("\nIngrese un valor entero valido");
			}
			
		} while (true);
		
	}
	
	static void creditCardPayment(Double amount) {
		PagoTarjeta creditCardPayment = new PagoTarjeta();
		System.out.println("\nIngrese numero de tarjeta");
		creditCardPayment.setCardNumber(scanner.next());
		creditCardPayment.setPaidAmount(amount);
		creditCardPayment.realizarPago(amount);
		creditCardPayment.imprimirRecibo();
	}
	
	static void cashPayment(Double amount) {
		PagoEfectivo cashPayment = new PagoEfectivo();
		cashPayment.setPaidAmount(amount);
		cashPayment.realizarPago(amount);
		cashPayment.imprimirRecibo();
	}
	
	
	static void showProducts() {
		System.out.println("\n**PRODUCTOS**");
		productosArray.forEach(product -> System.out.println(product));
	}
	
	static void buyProducts() {
		boolean stillBuying = true;
		do {
			System.out.println("\n**ELEGIR PRODUCTOS**");
			productosArray.forEach(producto -> System.out.println("Codigo: " + producto.getCode() + ", Producto: " + producto.getDescription() + ", HAY STOCK?: " + (producto.isDisponibilityState() ? "SI" : "NO")));					
			System.out.println("\n\n Seleccione el codigo del producto que desea comprar");
			int codeToBuy = enterValidatedInteger();
			for (Producto producto : productosArray) {
				if(producto.getCode() == codeToBuy && producto.isDisponibilityState()) {
					producto.setDisponibilityState(false);
					carritoDeCompras.add(producto);
				}
			}
			System.out.println("\nTerminar Compra? (S/n)");
			String answer = scanner.next().toUpperCase();
			if(answer.equals("S"))
				stillBuying = false;
			
		} while (stillBuying);
		
		payoutMenu();
		
	}
	
	static void payoutMenu() {
		boolean choosingPayoutMethod = true;
		do {
			System.out.println("\n\n**CARRITO DE COMPRA**");
			carritoDeCompras.forEach(producto -> System.out.println(producto.getDescription() + " precio: "+producto.getUnitaryPrice()));
			double total = 0d;
			for (Producto producto : carritoDeCompras) {
				total+=producto.getUnitaryPrice();
			}
			System.out.println("\nTOTAL: "+ total);
			System.out.println("\n*Elegir metodo de pago*"
					+ "\n1 - Pago Efectivo"
					+ "\n2 - Pago con Tarjeta");
			int option = enterValidatedInteger();
			switch (option) {
				case 1:{
					cashPayment(total);
					choosingPayoutMethod = false;
					break;
				}
				case 2:{
					creditCardPayment(total);
					choosingPayoutMethod = false;
				}
				default:
					break;
			}
			
			
		} while (choosingPayoutMethod);
		
		carritoDeCompras.clear();
		
	}
	
	
	static void initilizeProducts() {
		 	productosArray.add(new Producto(1, "Teléfono móvil inteligente", 599.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
	        productosArray.add(new Producto(2, "Portátil ultradelgado", 999.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
	        productosArray.add(new Producto(3, "Aspiradora robotizada", 349.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
	        productosArray.add(new Producto(4, "Taladro percutor inalámbrico", 129.99, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
	        productosArray.add(new Producto(5, "Auriculares inalámbricos con cancelación de ruido", 149.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
	        productosArray.add(new Producto(6, "Procesador de alimentos multifunción", 79.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
	        productosArray.add(new Producto(7, "Cámara de seguridad inteligente para el hogar", 199.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
	        productosArray.add(new Producto(8, "Impresora láser a color", 299.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
	        productosArray.add(new Producto(9, "Plancha de vapor de alta potencia", 49.99, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
	        productosArray.add(new Producto(10, "Mochila para portátil resistente al agua", 39.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
	        productosArray.add(new Producto(11, "Monitor de computadora de alta definición", 199.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
	        productosArray.add(new Producto(12, "Altavoz Bluetooth portátil", 79.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
	        productosArray.add(new Producto(13, "Cafetera programable con molinillo integrado", 89.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
	        productosArray.add(new Producto(14, "Juego de destornilladores de precisión", 19.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, true));
	        productosArray.add(new Producto(15, "Teclado mecánico para gaming", 69.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
	}
	

}
