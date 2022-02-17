package productos;

public class FlorAmarilla extends Flor {

	
	static {
		contador = 0;
	}

	public FlorAmarilla() {		
		descripcion="Flor amarilla      ";
		color = "Amarillo";
		precio = 3.5;
		idProducto = ++contador;

	}
	

}
