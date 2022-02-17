package factories;

public interface AbstractFactory<T> {

	T create(String tipo);

}
