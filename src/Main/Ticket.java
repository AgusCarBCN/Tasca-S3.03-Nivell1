package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import productos.Producto;

public class Ticket {
	/**
	 * 
	 */

	private static int contador;
	private int ticketId;
	private List<Producto> listaDeProductos;
	private Set<Producto> setDeProductos;
	private boolean vacio = true;

	static {
		contador = 0;
	}

	public Ticket() {
		listaDeProductos = new ArrayList<>();
		ticketId = contador++;
		vacio = false;
	}

	public boolean getVacio() {
		return vacio;
	}

	public void addProducto(Producto producto) {
		listaDeProductos.add(producto);
		vacio = false;
	}

	/**
	 * 
	 * Método que muestra un ticket de compra pasada.
	 */
	public void showTicket() {
		Console.writeln("------------------------------------------------");
		Console.writeln("C.  CONCEPTO                    PRECIO   IMPORTE");
		Console.writeln("------------------------------------------------");
		if (listaDeProductos.size() != 0) {
			setDeProductos = new HashSet<Producto>(listaDeProductos);
			List<Producto> listaOrdenada = new ArrayList<>(setDeProductos);
			for (Producto producto : listaOrdenada) {
				Console.writeln(Collections.frequency(listaDeProductos, producto) + "   " + producto.getDescripcion()
						+ "          " + producto.getPrecio() + "      "
						+ producto.getPrecio() * Collections.frequency(listaDeProductos, producto));
			}
		}

		Console.writeln("------------------------------------------------");
		Console.writeln("TOTAL..........................." + valorTotal());
		Console.writeln("------------------------------------------------");
	}
	
	/**
	 * 
	 * Método que guarda ticket en archivo ticket.txt.
	 */

	public void guardarTicket() {
		List<Producto> listaOrdenada = new ArrayList<>(setDeProductos);
		setDeProductos = new HashSet<Producto>(listaDeProductos);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("tickets.txt", true));
			pw.println("------------------------------------------------");
			pw.println("C.  CONCEPTO                    PRECIO   IMPORTE");
			pw.println("------------------------------------------------");
			for (Producto producto : listaOrdenada) {
				pw.println(Collections.frequency(listaDeProductos, producto) + "   " + producto.getDescripcion()
						+ "          " + producto.getPrecio() + "      "
						+ producto.getPrecio() * Collections.frequency(listaDeProductos, producto));
			}
			pw.println("------------------------------------------------");
			pw.close();
		} catch (Exception e) {
			Console.writeError("Error al guardar fichero " + e);
		}
	}

	/**
	 * Método que devuelve valor total de cada venta realizada
	 * 
	 * @return valor total de venta realizada.
	 */

	public double valorTotal() {
		double valorTotal = 0;
		if (listaDeProductos.size() != 0) {
			setDeProductos = new HashSet<Producto>(listaDeProductos);
			for (Producto producto : setDeProductos) {
				valorTotal += producto.getPrecio() * Collections.frequency(listaDeProductos, producto);
			}
		}

		return valorTotal;

	}

}
