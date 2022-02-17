package productos;

public class FlorNaranja extends Flor{

	
	static {
		contador = 0;
	}

	public FlorNaranja() {		
		descripcion="Flor naranja       ";
		color = "Naranja";
		precio = 4.8;
		idProducto = ++contador;
	}
}
