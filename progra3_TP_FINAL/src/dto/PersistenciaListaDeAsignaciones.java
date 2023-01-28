package dto;

import model.ticket.Ticket;
import model.usuario.UsuarioPuntuado;

import java.io.Serializable;
import java.util.List;

public class PersistenciaListaDeAsignaciones implements Serializable {
  private List<UsuarioPuntuado> listaDeAsignaciones;

  public List<UsuarioPuntuado> getListaDeAsignaciones() {
    return listaDeAsignaciones;
  }

  public void setListaDeAsignaciones(List<UsuarioPuntuado> listaDeAsignaciones) {
    this.listaDeAsignaciones = listaDeAsignaciones;
  }

  public String getTicketId() {
    return ticketId;
  }

  public void setTicketId(String ticketId) {
    this.ticketId = ticketId;
  }

  private String ticketId;

  public PersistenciaListaDeAsignaciones(){}

  public static PersistenciaListaDeAsignaciones of(Ticket ticket){
    PersistenciaListaDeAsignaciones persistencia = new PersistenciaListaDeAsignaciones();
    persistencia.setListaDeAsignaciones(ticket.getListaDeAsignaciones());
    persistencia.setTicketId(ticket.getId());
    return persistencia;
  }
}
