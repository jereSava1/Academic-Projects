package vista;

import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public interface IVistaResultadoEmpleador {
	
	void mostrar();
    void esconder();
    void setActionListener(ActionListener actionListener);
    void setModel(DefaultTableModel model);
    DefaultTableModel getModel();
    void setTextAreaEmpleadosSolicitados(String solicitados);
    void setTextAreaEmpleadosObtenidos(String obtenidos);
    void setTextAreaEmpleadosObtenidosEnRonda(String obtenidos);

}
