package productos;

public class ArbolTipo1 extends Arbol {

	private static int contador;
	static {
		contador = 0;
	}

	public ArbolTipo1() {
		descripcion = "Arbol 1,5 y 1,8 m. ";
		precio = 55;
		idProducto = contador++;
		intervaloAltura = "entre 1,5 y 1,8";
	}

	

}
