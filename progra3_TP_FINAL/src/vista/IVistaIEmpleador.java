package vista;

import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import dto.TicketEmpleadorDTO;
import model.ticket.TicketBusquedaDeEmpleado;

public interface IVistaIEmpleador {
     void mostrar();
     void esconder();
     void setActionListener(ActionListener actionListener);
     JList getListaTickets();
     void setListaTickets(JList listaTickets);
     DefaultListModel<TicketEmpleadorDTO> getTickets();
     void setTickets(DefaultListModel<TicketEmpleadorDTO> tickets);
     void setModel(DefaultListModel<TicketEmpleadorDTO> model);
     void addTicket(TicketEmpleadorDTO ticket);
     void removeTicket(TicketEmpleadorDTO ticket);
     TicketEmpleadorDTO getTicketSeleccionado();
     void success(String titulo, String mensaje);
     void failure(String title, String message);
     TicketEmpleadorDTO getSeleccionado();
} 
