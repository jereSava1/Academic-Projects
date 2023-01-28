package vista;

import java.awt.event.ActionListener;

public interface IVistaIEmpleado {
	 void mostrar();
     void esconder();
     void setActionListener(ActionListener actionListener);
     void success(String titulo, String mensaje);
     void failure(String title, String message);
}
