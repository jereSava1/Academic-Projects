package vista;

import java.awt.event.ActionListener;

import dto.TicketDeEmpleadoRequest;
import exception.ConstructorInvalidoException;

public interface IVistaAltaTicketEmpleado {
	 void mostrar();
     void esconder();
     void setActionListener(ActionListener actionListener);
     void limpiaCampos();
     void success(String titulo, String mensaje);
     TicketDeEmpleadoRequest getFormulario() throws ConstructorInvalidoException;
     float getV1();
     float getV2();
     void setV1(Float v1);
     void setV2(Float v2);
     int getPeso();
     void setPeso(int peso);
}
