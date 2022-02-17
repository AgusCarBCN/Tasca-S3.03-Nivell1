package productos;

public class DecoracionPlastico extends Decoracion{

	private static int contador;
	static {
		contador = 0;
	}

	public DecoracionPlastico() {
		descripcion="Decoracion plastico";		
		material="plastico";
		precio = 15;
		idProducto = contador++;
	}
	
	@Override
	public String getDescripcion() {
		return descripcion;
	}
	
}
