package productos;

public class ArbolTipo2 extends Arbol {

	private static int contador;
	static {
		contador = 0;
	}

	public ArbolTipo2() {		
		descripcion="Arbol 1,8 y 2,0 m. ";		
		precio = 55;
		idProducto = contador++;
		intervaloAltura = "entre 1,8 y 2";
	}
	

}
