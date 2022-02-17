package Main;

import factories.AbstractFactory;
import factories.FactoryProvider;
import productos.Arbol;
import productos.Decoracion;
import productos.Flor;

public class Main {

	public static void main(String[] args) {
		Floristeria.getFloristeria();
		Floristeria.getFloristeria().cargarStockDeProductos();
		Floristeria.getFloristeria().cargarVentasAcumuladas();				
		menuPrincipal(Floristeria.getFloristeria());

	}
/**
 * Menú principal de la aplicación
 * 
 * @param floristeria Objeto de la clase floristeria
 */
	public static void menuPrincipal(Floristeria floristeria) {
		byte opcion;
		boolean exit = false;
		do {
			Console.writeln("*****Menu principal*****");
			Console.writeln("0.salir de la aplicacion.");
			Console.writeln("1.Añadir productos.");
			Console.writeln("2.Retirar productos.");
			Console.writeln("3.Imprimir por pantalla stock.");
			Console.writeln("4.Valor total de los productos.");
			Console.writeln("5.Mostrar lista de compras actuales");
			Console.writeln("6.Mostrar lista de compras antiguas.");
			Console.writeln("7.Total de dinero ganado de ventas");

			opcion = Console.readInt("Elije una opción:");
			switch (opcion) {
			case 0:
				Console.writeln("Has salido de la aplicación.");
				floristeria.guardarStockDeProductos();
				floristeria.guardarTotalVentas();
				floristeria.guardarTickets();
				exit = true;				
				break;
			case 1:
				añadirProductos(floristeria);
				break;
			case 2:
				retirarProductos(floristeria);
				break;
			case 3:
				floristeria.showStock();
				break;
			case 4:
				floristeria.valorTotalStock();
				break;
			case 5:
				floristeria.mostrarVentas();
				break;
			case 6:				
				floristeria.CargarTickets();
				break;
			case 7:
				floristeria.mostrarTotalGanado();
				break;
			default:
				Console.writeError("Debes introducir una opción entre 0 y 6.");
				break;
			}
		} while (!exit);

	}

	/**
	 * Método que añade producto a la Floristeria
	 * 
	 * @param floristeria Objecto de clase Floristeria.
	 */
	public static void añadirProductos(Floristeria floristeria) {
		byte opcion;
		boolean exit = false;
		do {
			Console.writeln("*****Añadir productos*****");
			Console.writeln("0.salir de añadir productos.");
			Console.writeln("1.Añadir flores.");
			Console.writeln("2.Añadir Árboles.");
			Console.writeln("3.Añadir Decoraciones.");
			opcion = Console.readInt("Elije una opcion");
			switch (opcion) {
			case 0:
				Console.writeln("has salido del menú añadir productos");
				exit = true;
				break;
			case 1:
				añadirFlor(floristeria);
				break;
			case 2:
				añadirArbol(floristeria);
				break;
			case 3:
				añadirDecoracion(floristeria);
				break;
			default:
				Console.writeError("Debes escoger una opcion entre 1 y 4");
				break;
			}
		} while (!exit);
	}

	/**
	 * 
	 * Método que retira producto para venta de la floristeria.
	 * 
	 * @param floristeria objeto de la clase Floristeria.
	 */
	public static void retirarProductos(Floristeria floristeria) {
		boolean exit = false;
		Ticket ticket = new Ticket();
		byte opcion;

		do {
			Console.writeln("**Retirar productos**");
			Console.writeln("0.salir de retirar productos.");
			Console.writeln("1.Retirar flores.");
			Console.writeln("2.Retirar Árboles.");
			Console.writeln("3.Retirar Decoraciones.");
			opcion = Console.readInt("Elije una opción: ");
			switch (opcion) {
			case 0:
				Console.writeln("has salido del menú añadir productos");
				exit = true;
				break;
			case 1:
				retirarFlor(floristeria, ticket);
				break;
			case 2:
				retirarArbol(floristeria, ticket);
				break;
			case 3:
				retirarDecoracion(floristeria, ticket);
				break;
			default:
				Console.writeError("Debes escoger una opcion entre 1 y 4");
				break;
			}
		} while (!exit);
		floristeria.añadirTicket(ticket);
	}

	/**
	 * Método que añade flor a la floristeria
	 * 
	 * @param floristeria Objeto de la clase floristeria.
	 */
	
	public static void añadirFlor(Floristeria floristeria) {
		boolean exit = false;
		byte opcion;
		String color = null;
		do {
			Console.writeln("****Añadir flor*****");
			Console.writeln("Elije el color:");
			Console.writeln("0.Salir");
			Console.writeln("1.Blanco");
			Console.writeln("2.Amarilla");
			Console.writeln("3.Naranja");
			Console.writeln("4.Violeta");
			opcion = Console.readInt("Elije una opción: ");
			switch (opcion) {
			case 0:
				exit = true;
				break;
			case 1:
				color = "Blanco";
				break;
			case 2:
				color = "Amarillo";
				break;
			case 3:
				color = "Naranja";
				break;
			case 4:
				color = "Violeta";
				break;
			default:
				Console.writeError("Debes escoger una opcion entre 0 y 4");
				break;
			}

			// Se crea una una factoria de tipo flor.
			AbstractFactory<?> factory = FactoryProvider.getFactory("flor");
			// Se crea un objeto de tipo flor.
			Flor flor = (Flor) factory.create(color);
			// Se añade flor a lista de flores en floristeria
			floristeria.añadirProducto(flor);
		} while (!exit);
	}
	
	/**
	 * 
	 * Método que añade arbol a la floristeria
	 * 
	 * @param floristeria Objeto de clase Floristeria
	 */

	public static void añadirArbol(Floristeria floristeria) {
		boolean exit = false;
		byte opcion;
		String altura = null;
		do {
			Console.writeln("****Añadir árbol*****");
			Console.writeln("Elije la altura(metros):");
			Console.writeln("0.Salir.");
			Console.writeln("1.Entre 1,5 y 1,8");
			Console.writeln("2.Entre 1,8 y 2");
			Console.writeln("3.Mas de 2");
			opcion = Console.readInt("Elije una altura: ");
			switch (opcion) {
			case 0:
				exit = true;
				break;
			case 1:
				altura = "entre 1,5 y 1,8";
				break;
			case 2:
				altura = "entre 1,8 y 2";
				break;
			case 3:
				altura = "mas de 2";
				break;
			default:
				Console.writeError("Debes escoger una opcion entre 0 y 3");
				break;
			}

			// Se crea una una factoria de tipo arbol.
			AbstractFactory<?> factory = FactoryProvider.getFactory("arbol");
			// Se crea un objeto de tipo arbol.
			Arbol arbol = (Arbol) factory.create(altura);
			// Se añade arbol a lista de arboles en floristeria
			floristeria.añadirProducto(arbol);
		} while (!exit);
	}
	
	/**
	 * Método que añade decoración a la floristeria.
	 * 
	 * @param floristeria
	 */

	public static void añadirDecoracion(Floristeria floristeria) {
		boolean exit = false;
		byte opcion;
		String material = null;
		do {
			Console.writeln("****Añadir decoracion*****");
			Console.writeln("Elije material:");
			Console.writeln("0.Salir.");
			Console.writeln("1.Madera");
			Console.writeln("2.Plástico");
			opcion = Console.readInt("Elije una opcion: ");
			switch (opcion) {
			case 0:
				exit = true;
				break;
			case 1:
				material = "madera";
				break;
			case 2:
				material = "plastico";
				break;
			default:
				Console.writeError("Debes escoger una opcion entre 1 y 2");
				break;
			}
			// Se crea una una factoria de tipo decoracion.
			AbstractFactory<?> factory = FactoryProvider.getFactory("decoracion");
			// Se crea un objeto de tipo decoracion.
			Decoracion decoracion = (Decoracion) factory.create(material);
			// Se añade decoracion a lista de decoraciones en floristeria
			floristeria.añadirProducto(decoracion);

		} while (!exit);
	}

	/**
	 * 
	 * Método que abre menú retirar flor de floristeria.
	 * 
	 * @param floristeria
	 * @param ticket
	 */
	public static void retirarFlor(Floristeria floristeria, Ticket ticket) {
		boolean exit = false;
		byte opcion;
		String color = null;
		String descripcion = null;
		do {
			Console.writeln("****Retirar una flor*****");
			Console.writeln("Elije el color:");
			Console.writeln("0.Salir");
			Console.writeln("1.Blanco");
			Console.writeln("2.Amarilla");
			Console.writeln("3.Naranja");
			Console.writeln("4.Violeta");
			opcion = Console.readInt("Elije un color: ");
			switch (opcion) {
			case 0:
				exit = true;
				break;
			case 1:
				color = "Blanco";
				descripcion = "Flor blanca        ";
				break;
			case 2:
				color = "Amarillo";
				descripcion = "Flor amarilla      ";
				break;
			case 3:
				color = "Naranja";
				descripcion = "Flor naranja       ";
				break;
			case 4:
				color = "Violeta";
				descripcion = "Flor violeta       ";
				break;
			default:
				Console.writeError("Debes escoger una opcion entre 1 y 4");
				break;
			}
			if (opcion != 0)
				floristeria.retirarFlor(color, descripcion, ticket);
		} while (!exit);

	}
/**
 * Método que abre menu para retirar arbol de floristeria.
 * 
 * @param floristeria
 * @param ticket
 */
	public static void retirarArbol(Floristeria floristeria, Ticket ticket) {
		boolean exit = false;
		byte opcion;
		String descripcion = null;
		String altura = null;
		do {
			Console.writeln("****Retirar árbol*****");
			Console.writeln("Elije la altura(metros):");
			Console.writeln("0.Salir");
			Console.writeln("1.Entre 1,5 y 1,8");
			Console.writeln("2.Entre 1,8 y 2");
			Console.writeln("3.Mas de 2");
			opcion = Console.readInt("Elije una altura: ");
			switch (opcion) {
			case 0:
				exit = true;
				break;
			case 1:
				altura = "entre 1,5 y 1,8";
				descripcion = "Arbol 1,5 y 1,8 m. ";
				break;
			case 2:
				altura = "entre 1,8 y 2";
				descripcion = "Arbol 1,8 y 2,0 m. ";
				break;
			case 3:
				altura = "mas de 2";
				descripcion = "Arbol mas de 2 m.  ";
				break;
			default:
				Console.writeError("Debes escoger una opcion entre 1 y 3");
				break;
			}
			if (opcion != 0)
				floristeria.retirarArbol(altura, descripcion, ticket);

		} while (!exit);

	}
	
	/**
	 * 
	 * Método que abre menú para retirar decoración de floristeria.
	 * 
	 * @param floristeria
	 * @param ticket
	 */

	public static void retirarDecoracion(Floristeria floristeria, Ticket ticket) {
		boolean exit = false;
		byte opcion;
		String material = null;
		String descripcion = null;
		do {
			Console.writeln("****Retirar decoracion*****");
			Console.writeln("Elije material:");
			Console.writeln("0.Salir.");
			Console.writeln("1.Madera");
			Console.writeln("2.Plástico");
			opcion = Console.readInt("Elije un material: ");
			switch (opcion) {
			case 0:
				exit = true;
				break;
			case 1:
				material = "madera";
				descripcion = "Decoracion madera  ";
				break;
			case 2:
				material = "plastico";
				descripcion = "Decoracion plastico";
				break;
			default:
				Console.writeError("Debes escoger una opcion entre 1 y 2");
				break;
			}
			if (opcion != 0)
				floristeria.retirarDeco(material, descripcion, ticket);

		} while (!exit);
	}
}