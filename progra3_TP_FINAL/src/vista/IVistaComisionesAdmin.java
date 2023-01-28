package vista;

import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public interface IVistaComisionesAdmin {
	 
	 void mostrar();
     void esconder();
     void setActionListener(ActionListener actionListener);
     void setModel(DefaultTableModel model);
     DefaultTableModel getModel();
     void setTextAreaComisionTotal(String comisionTotalAdmin);
     
}
