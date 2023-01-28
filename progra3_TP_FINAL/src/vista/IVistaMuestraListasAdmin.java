package vista;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import model.usuario.Empleado;
import model.usuario.UsuarioPuntuado;

public interface IVistaMuestraListasAdmin {
	
	void mostrar();
    void esconder();
    void setActionListener(ActionListener actionListener);
    void setModel(DefaultTableModel model);
    DefaultTableModel getModel();

}
