package productos;

import java.util.Objects;

public  class Producto implements Comparable<Producto> {

	protected String descripcion;
	protected double precio;
	protected int idProducto;
	protected static int contador;
	
	public Producto() {
		
	}
	public Producto(int idProducto,String descripcion,double precio) {
		this.idProducto=idProducto;
		this.descripcion=descripcion;
		this.precio=precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public int getIdProducto() {
		return idProducto;
	}

	

	
	@Override
	public int hashCode() {
		return Objects.hash(descripcion);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(descripcion, other.descripcion);
	}
	@Override
	public int compareTo(Producto o) {
		return descripcion.compareTo(o.getDescripcion());
	}

}
