package exception;

public class ConstructorInvalidoException extends Exception {
	private String dato;

	public ConstructorInvalidoException(String dato) {
		super("Constructor llamado con parametros invalidos");
		this.dato = dato;
	}

	public String getDato() {
		return dato;
	}

}
