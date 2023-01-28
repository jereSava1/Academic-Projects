package vista;

import dto.TicketSimplificadoRequest;
import vista.IVistaGeneral;

public interface IVistaAltaTicketSimplificado extends IVistaGeneral {
	
	TicketSimplificadoRequest getTicketSimplificado();
	void limpiaCampos();
	void failure(String title, String error);
	void success(String title, String message);

}
