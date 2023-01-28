package vista;

import java.awt.event.ActionListener;

public interface IVistaSesionAdmin {
	 void mostrar();
     void esconder();
     void setActionListener(ActionListener actionListener);
     float getMaximo();
     float getMinimo();
     void limpiaCampos();
     void error(String error, String titulo);
     void success(String ok, String titulo);
     void setMinimo(float minimo);
     void setMaximo(float maximo);
}
