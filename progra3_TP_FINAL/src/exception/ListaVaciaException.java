package exception;

public class ListaVaciaException extends Exception {
	private String dato;

	public ListaVaciaException(String message) {
		super(message);
	}
}
