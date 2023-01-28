package exception;

public class LimiteExcedidoException extends Exception {
	private int dato;

	public LimiteExcedidoException(int dato) {
		super("Se superó la cantidad de candidatos a seleccionar");
		this.dato = dato;
	}
}
