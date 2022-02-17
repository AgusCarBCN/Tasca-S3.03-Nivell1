package Main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import productos.*;
import factories.ArbolFactory;
import factories.DecoracionFactory;
import factories.FlorFactory;

public class Floristeria {

	private List<Producto> listaDeProductos;
	private ArrayList<Ticket> listaDeTickets;
	private Set<Producto> setDeProductos;
	private double totalVentas;
	private static Floristeria floristeria;

	private Floristeria() {
		listaDeProductos = new ArrayList<>();
		listaDeTickets = new ArrayList<>();

	}

	public static Floristeria getFloristeria() {
		if (floristeria == null) {
			floristeria = new Floristeria();
		}
		return floristeria;

	}

	public double getTotalVentas() {
		return totalVentas;
	}

	public void setTotalVentas(double totalVentas) {
		this.totalVentas = totalVentas;
	}
	/**
	 * Método añadir producto
	 * @param producto Producto a añadir.
	 */
	
	public void añadirProducto(Producto producto) {
		listaDeProductos.add(producto);

	}

	/**
	 * Método añadir ticket
	 * 
	 * @param ticket Ticket a añadir a la lista de tickets de floristeria.
	 */
	public void añadirTicket(Ticket ticket) {
		if (!ticket.getVacio()) {
			listaDeTickets.add(ticket);
		}
	}

	/**
	 * Método retirar Flor 
	 * 
	 * @param color color de la flor a retirar por venta.
	 * @param descripcion descripción del producto a retirar por venta de producto..
	 * @param ticket Ticket donde irá el producto retirado para venta.
	 */
	public void retirarFlor(String color, String descripcion, Ticket ticket) {
		if (listaDeProductos.size() == 0) {
			Console.writeError("La lista esta vacia");
		} else {
			boolean encontrada = false;
			FlorFactory factory;
			Producto flor;
			Iterator<Producto> it = listaDeProductos.iterator();
			while (it.hasNext() && !encontrada) {
				flor = it.next();
				if (flor.getDescripcion().equals(descripcion)) {
					it.remove();
					encontrada = true;
				}
			}
			if (encontrada) {
				factory = new FlorFactory();
				ticket.addProducto(factory.create(color));
			} else {
				Console.writeError("Flor no encontrada");
			}
		}
	}
	
	/**
	 * Método retirar Arbol 
	 * 
	 * @param altura altura del arbol a retirar por venta.
	 * @param descripcion descripción del producto a retirar por venta de producto..
	 * @param ticket Ticket donde irá el producto retirado para venta.
	 */

	public void retirarArbol(String altura, String descripcion, Ticket ticket) {
		if (listaDeProductos.size() == 0) {
			Console.writeError("La lista esta vacia");
		} else {
			boolean encontrado = false;
			ArbolFactory factory;
			Producto arbol;
			Iterator<Producto> it = listaDeProductos.iterator();
			while (it.hasNext() && !encontrado) {
				arbol = it.next();
				if (arbol.getDescripcion().equals(descripcion)) {
					it.remove();
					encontrado = true;
				}
			}
			if (encontrado) {
				factory = new ArbolFactory();
				ticket.addProducto(factory.create(altura));
			} else {
				Console.writeError("Arbol no encontrado");
			}
		}
	}

	
	/**
	 * Método retirar Decoración  
	 * 
	 * @param material material de la decoración  a retirar por venta.
	 * @param descripcion descripción del producto a retirar por venta de producto..
	 * @param ticket Ticket donde irá el producto retirado para venta.
	 */
	public void retirarDeco(String material, String descripcion, Ticket ticket) {
		if (listaDeProductos.size() == 0) {
			Console.writeError("La lista esta vacia");
		} else {
			boolean encontrado = false;
			DecoracionFactory factory;
			Producto deco;
			Iterator<Producto> it = listaDeProductos.iterator();
			while (it.hasNext() && !encontrado) {
				deco = it.next();
				if (deco.getDescripcion().equals(descripcion)) {
					it.remove();
					encontrado = true;
				}
			}
			if (encontrado) {
				factory = new DecoracionFactory();
				ticket.addProducto(factory.create(material));
			} else {
				Console.writeError("Arbol no encontrado");
			}
		}
	}

	/**
	 * Método que muestra productos en el stock
	 */
	public void showStock() {

		if (listaDeProductos.size() != 0) {
			setDeProductos = new HashSet<Producto>(listaDeProductos);
			List<Producto> listaOrdenada = new ArrayList<>(setDeProductos);
			Collections.sort(listaOrdenada);
			Console.writeln("                  Stock de Productos");
			Console.writeln("-----------------------------------------------------");
			Console.writeln("Producto                 cantidad");
			Console.writeln("-----------------------------------------------------");
			for (Producto producto : listaOrdenada) {
				Console.writeln(
						producto.getDescripcion() + "         " + Collections.frequency(listaDeProductos, producto));
			}
			Console.writeln("-----------------------------------------------------");
		}
		else {
			Console.writeError("No hay productos en la floristeria");
		}

	}
	/**
	 *Método que muestra valor total del stock. 
	 */
	public void valorTotalStock() {
		double valorTotal = 0;
		setDeProductos = new HashSet<Producto>(listaDeProductos);
		if (listaDeProductos.size() != 0) {			
			for (Producto producto : setDeProductos) {
				valorTotal += producto.getPrecio() * Collections.frequency(listaDeProductos, producto);
			}
		}

		Console.write("El valor total del stock de productos es: ");
		Console.write(valorTotal+"\n");
		
		

	}
	
	/**
	 * 
	 * Método que muestra el historial de ventas
	 */
	public void mostrarVentas() {
		if(listaDeTickets.size()==0) {
			Console.writeError("No hay tickets de venta actuales");
		}
		for (Ticket ticket : listaDeTickets) {
			ticket.showTicket();
		}
	}
	
	/**
	 * 
	 * Método que muestra el total de lo ganado en las ventas.
	 */

	public void mostrarTotalGanado() {
		Console.write("La floristeria ha ganado hasta el monento: ");
		Console.write(totalVentasAcumulado()+"\n");
	}

	
	/**
	 * 
	 * Método que calcula el total de ventas acumulado
	 * 
	 * @return Retorna el total de ventas acumulado
	 */
	public double totalVentasAcumulado() {
		double totalVentas = getTotalVentas();
		for (Ticket ticket : listaDeTickets) {
			totalVentas += ticket.valorTotal();
		}
		return totalVentas;

	}

	/**
	 * Método que carga el archivo de texto donde se almancenan los productos de forma persistente.
	 * 
	 */
	public void cargarStockDeProductos() {
		try {
			File archivo = new File("listaDeProductos.txt");
			if (archivo.exists()) {
				BufferedReader br = new BufferedReader(new FileReader("listaDeProductos.txt"));
				String linea;
				while ((linea = br.readLine()) != null) {
					StringTokenizer stoken1 = new StringTokenizer(linea, "|");
					int id = Integer.parseInt(stoken1.nextToken());
					double precio = Double.parseDouble(stoken1.nextToken());
					String descripcion = stoken1.nextToken();
					Producto producto = new Producto(id, descripcion, precio);
					añadirProducto(producto);
				}
				br.close();
			} else
				Console.writeError("El arhivo listaDeProductos no existe");
		} catch (Exception e) {
			Console.writeError("Error al cargar fichero" + e);
		}
	}
	
	/**
	 * 
	 * Método donde se carga el archivo que almacena el total del importe de ventas acumuladas
	 * 
	 */

	public void cargarVentasAcumuladas() {
		try {
			File archivo = new File("ventasAcumuladas.txt");
			if (archivo.exists()) {
				BufferedReader br = new BufferedReader(new FileReader("ventasAcumuladas.txt"));
				String linea;
				while ((linea = br.readLine()) != null) {
					StringTokenizer stoken1 = new StringTokenizer(linea, "|");
					double totalVentas = Double.parseDouble(stoken1.nextToken());
					setTotalVentas(totalVentas);

				}
				br.close();
			} else
				Console.writeError("El archivo ventasAcumuladas no existe");
		} catch (Exception e) {
			Console.writeError("Error al cargar fichero" + e);
		}

	}

	/**
	 * Método que guarda la lista de productos del stock en archivo de texto listaDeProductos
	 * 
	 */
	public void guardarStockDeProductos() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("listaDeProductos.txt"));
			for (Producto producto : listaDeProductos)
				pw.println(producto.getIdProducto() + "|" + producto.getPrecio() + "|" + producto.getDescripcion());
			pw.close();
		} catch (Exception e) {
			Console.writeError("Error al guardar fichero " + e);
		}
	}

	/**
	 * Método que guara el total de ventas en archivo de texto ventasAcumuladas.txt
	 * 
	 */
	public void guardarTotalVentas() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("ventasAcumuladas.txt"));
			pw.println(totalVentasAcumulado() + "|");
			pw.close();
		} catch (Exception e) {
			Console.writeError("Error al guardar fichero " + e);
		}
	}
	
	/**
	 * Método que guarda  lista de tickets en archivo tickets.txt 
	 * 
	 */
	public void guardarTickets()
	{
		for(Ticket ticket:listaDeTickets) {
			ticket.guardarTicket();
		}
		
	}
	public void CargarTickets() {
		String line = null;
		try (BufferedReader readFast = new BufferedReader(new FileReader("tickets.txt"));) {
			while ((line = readFast.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.err.println("No hay tickets que mostrar");
		}
	}

}
