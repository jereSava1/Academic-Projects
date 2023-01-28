package vista;

import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

import dto.TicketEmpleadorDTO;
import model.ticket.TicketSimplificado;

public interface IVistaEleccionTicketSimplificado{
	void mostrar();
	void esconder();
	void setActionListener(ActionListener actionListener);
	void limpiaCampos();
	void setModel(DefaultListModel<TicketSimplificado> model);
    TicketSimplificado getTicketSeleccionado();
	String getTipoLocacion();
	void success(String message,String title);
	void failure(String message,String title);
}
