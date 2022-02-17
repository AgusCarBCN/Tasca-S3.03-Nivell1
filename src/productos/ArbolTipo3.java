package productos;

public class ArbolTipo3 extends Arbol{
	
	private static int contador;
	static {
		contador = 0;
	}

	public ArbolTipo3() {
		descripcion="Arbol mas de 2 m.  ";
		precio = 55;
		idProducto = contador++;
		intervaloAltura = "mas de 2";
	}

	
	
}
