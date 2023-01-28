package state;

import model.ticket.Ticket;
import types.EstadoTicket;

public class SuspendidoState implements IState {

    private Ticket ticket;
    private EstadoTicket nombre;

    public SuspendidoState() {
    	
    }
    
    public SuspendidoState(Ticket ticket) {
        this.ticket = ticket;
        nombre = EstadoTicket.SUSPENDIDO;
    }

    public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public void setNombre(EstadoTicket nombre) {
		this.nombre = nombre;
	}

	@Override
    public void activar() {
        ticket.setEstadoTicket(new ActivoState(ticket));
    }

    @Override
    public void suspender() {
        System.out.println("El ticket se encuentra suspendido");
    }

    @Override
    public void cancelar() {
        ticket.setEstadoTicket(new CanceladoState(ticket));
    }

    @Override
    public EstadoTicket getNombre() {
        return nombre;
    }
}
