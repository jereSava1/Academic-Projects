package state;

import model.ticket.Ticket;
import types.EstadoTicket;

public class FinalizadoState implements IState{

    private Ticket ticket;
    private EstadoTicket nombre;

    public FinalizadoState() {
    	
    }
    
    public FinalizadoState(Ticket ticket) {
        this.ticket = ticket;
        nombre = EstadoTicket.FINALIZADO;
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
        System.out.println("El ticket se encuentra finalizado");
    }

    @Override
    public void suspender() {
        System.out.println("El ticket se encuentra finalizado");
    }

    @Override
    public void cancelar() {
        System.out.println("El ticket se encuentra finalizado");
    }

    @Override
    public EstadoTicket getNombre() {
        return nombre;
    }

}
