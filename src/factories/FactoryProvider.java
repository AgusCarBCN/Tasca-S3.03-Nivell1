package factories;

public class FactoryProvider {

	public static AbstractFactory<?> getFactory(String tipoFactoria) {
		
		AbstractFactory<?> factory=null;
		if("flor".equals(tipoFactoria)) {
			factory= new FlorFactory();
		}else if("arbol".equals(tipoFactoria)) {
			factory= new ArbolFactory();
		}else if("decoracion".equals(tipoFactoria)) {
			factory= new DecoracionFactory();
		}
		
		return factory;
		
	}
}
