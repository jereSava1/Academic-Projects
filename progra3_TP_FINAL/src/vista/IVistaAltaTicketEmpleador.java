package vista;

import java.awt.event.ActionListener;

import dto.TicketDeEmpleadorRequest;

public interface IVistaAltaTicketEmpleador {
	 void mostrar();
     void esconder();
     void setActionListener(ActionListener actionListener);
     void limpiaCampos();
     TicketDeEmpleadorRequest getFormulario();
     void setV1(float v1);
     void setV2(float v2);
     float getV1();
     float getV2();
     int getEmpleados();
     void setEmpleados(int empleados);
     int getPeso();
     void setPeso(int peso);
 	 void success(String message,String title);
 	 void failure(String message,String title);
}
