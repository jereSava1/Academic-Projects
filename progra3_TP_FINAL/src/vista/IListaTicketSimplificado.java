package vista;

import dto.TicketSimplificadoDTO;

import javax.swing.*;

public interface IListaTicketSimplificado extends IVistaGeneral {
	void setModel(DefaultListModel<TicketSimplificadoDTO> model);
}
