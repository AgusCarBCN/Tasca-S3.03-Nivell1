package productos;

public class FlorBlanca extends Flor {

	
	static {
		contador = 0;
	}

	public FlorBlanca() {		
		descripcion="Flor blanca        ";
		color = "Blanco";
		precio = 2.8;
		idProducto = ++contador;
	}

}
