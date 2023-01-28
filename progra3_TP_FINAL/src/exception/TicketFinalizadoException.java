package exception;

public class TicketFinalizadoException extends Exception {
	private String dato;

	public TicketFinalizadoException(String message, String dato) {
		super(message);
		this.setDato(dato);
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}
}
