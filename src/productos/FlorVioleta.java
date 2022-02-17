package productos;

public class FlorVioleta extends Flor {

	
	static {
		contador = 0;
	}

	public FlorVioleta() {		
		descripcion="Flor violeta       ";
		color = "Violeta";
		precio = 6.5;
		idProducto = ++contador;

	}
}
