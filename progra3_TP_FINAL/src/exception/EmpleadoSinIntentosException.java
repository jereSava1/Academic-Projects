package exception;

public class EmpleadoSinIntentosException extends Exception {
	private String dato;

	public EmpleadoSinIntentosException(String message, String nombreUsuario) {
		super(message);
		this.dato = nombreUsuario;
	}
}
