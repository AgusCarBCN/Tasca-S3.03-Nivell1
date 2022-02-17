package factories;

import productos.Decoracion;
import productos.DecoracionMadera;
import productos.DecoracionPlastico;

public class DecoracionFactory implements AbstractFactory<Decoracion> {

	@Override
	public Decoracion create(String material) {
		Decoracion decoracion = null;
		if (material.equalsIgnoreCase("madera")) {
			decoracion = new DecoracionMadera();
		} else if (material.equalsIgnoreCase("plastico")) {
			decoracion = new DecoracionPlastico();

		}
		return decoracion;

	}

}
