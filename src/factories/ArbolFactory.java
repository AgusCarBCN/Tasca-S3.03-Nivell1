package factories;

import productos.*;


public class ArbolFactory implements AbstractFactory<Arbol>{

	@Override
	public Arbol create(String altura) {
		Arbol arbol = null;
		if (altura.equalsIgnoreCase("entre 1,5 y 1,8")) {
			arbol = new ArbolTipo1();
		} else if (altura.equalsIgnoreCase("entre 1,8 y 2")) {
			arbol = new ArbolTipo2();
		} else if (altura.equalsIgnoreCase("mas de 2")) {
			arbol = new ArbolTipo3();
		} 
					
		return arbol;
	}

}
