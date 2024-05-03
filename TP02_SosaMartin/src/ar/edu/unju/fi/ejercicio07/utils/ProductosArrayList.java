package ar.edu.unju.fi.ejercicio07.utils;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercicio05.model.Producto;

public class ProductosArrayList {

	
	public static List<Producto> productsArray(){
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto(1, "Teléfono móvil inteligente", 599.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, true));
        productos.add(new Producto(2, "Portátil ultradelgado", 999.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto(3, "Aspiradora robotizada", 349.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(4, "Taladro percutor inalámbrico", 129.99, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.HERRAMIENTAS, true));
        productos.add(new Producto(5, "Auriculares inalámbricos con cancelación de ruido", 149.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.TELEFONIA, false));
        productos.add(new Producto(6, "Procesador de alimentos multifunción", 79.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(7, "Cámara de seguridad inteligente para el hogar", 199.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(8, "Impresora láser a color", 299.99, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto(9, "Plancha de vapor de alta potencia", 49.99, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(10, "Mochila para portátil resistente al agua", 39.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, false));
        productos.add(new Producto(11, "Monitor de computadora de alta definición", 199.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
        productos.add(new Producto(12, "Altavoz Bluetooth portátil", 79.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, true));
        productos.add(new Producto(13, "Cafetera programable con molinillo integrado", 89.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.ELECTROHOGAR, false));
        productos.add(new Producto(14, "Juego de destornilladores de precisión", 19.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.HERRAMIENTAS, false));
        productos.add(new Producto(15, "Teclado mecánico para gaming", 69.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));

	    return productos;
	}
	
}
