package productos;

public class DecoracionMadera extends Decoracion {

	private static int contador;
	static {
		contador = 0;
	}

	public DecoracionMadera() {
		descripcion="Decoracion madera  ";
		material = "madera";
		precio = 35;
		idProducto = contador++;

	}
	@Override
	public String getDescripcion() {
		return descripcion;
	}
}
