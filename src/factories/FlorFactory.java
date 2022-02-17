package factories;


import productos.Flor;
import productos.FlorAmarilla;
import productos.FlorBlanca;
import productos.FlorNaranja;
import productos.FlorVioleta;

public class FlorFactory implements AbstractFactory<Flor> {

	@Override
	public Flor create(String color) {
		Flor flor = null;
		if (color.equalsIgnoreCase("Blanco")) {
			flor = new FlorBlanca();
		} else if (color.equalsIgnoreCase("Amarillo")) {
			flor = new FlorAmarilla();
		} else if (color.equalsIgnoreCase("Violeta")) {
			flor = new FlorVioleta();
		} else if (color.equalsIgnoreCase("Naranja")) {
			flor = new FlorNaranja();
			
		}
		return flor;

	}
}