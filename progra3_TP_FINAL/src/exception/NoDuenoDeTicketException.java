package exception;

import model.ticket.Ticket;

public class NoDuenoDeTicketException extends Exception {
	private Ticket dato;

	public NoDuenoDeTicketException(Ticket ticket, String message) {
		super(message);
		this.dato = ticket;
	}

}
