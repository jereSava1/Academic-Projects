package state;

import model.ticket.Ticket;
import types.EstadoTicket;

public class CanceladoState implements IState{

    private Ticket ticket;
    private EstadoTicket nombre;

    public CanceladoState() {
    	
    }
    
    public CanceladoState(Ticket ticket) {
        this.ticket = ticket;
        nombre = EstadoTicket.CANCELADO;
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
        System.out.println("El ticket se encuentra cancelado");
    }

    @Override
    public void suspender() {
        System.out.println("El ticket se encuentra cancelado");
    }

    @Override
    public void cancelar() {
        System.out.println("El ticket se encuentra cancelado");
    }

    @Override
    public EstadoTicket getNombre() {
        return nombre;
    }

}
