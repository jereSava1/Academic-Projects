package dto;

import model.ticket.TicketBusquedaDeEmpleado;

public class TicketEmpleadorDTO extends TicketDTO {
  private int empleadosNecesitados;
  private int empleadosObtenidos;

  public int getEmpleadosNecesitados() {
    return empleadosNecesitados;
  }

  public int getEmpleadosObtenidos() {
    return empleadosObtenidos;
  }

  public TicketEmpleadorDTO(TicketBusquedaDeEmpleado ticket) {
    super(ticket);
    this.empleadosNecesitados = ticket.getEmpleadosNecesitados();
    this.empleadosObtenidos = ticket.getEmpleadosObtenidos();
  }

	@Override
	public String toString() {
		return "EmpleadosNecesitados = " + empleadosNecesitados +
			   "|  EmpleadosObtenidos  = "  + empleadosObtenidos + 
			    super.toString();
	}	
  
  
  
  
  
}
