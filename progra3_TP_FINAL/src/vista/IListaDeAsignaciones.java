package vista;

import java.awt.event.ActionListener;
import java.util.List;

import dto.UsuarioPuntuadoDTO;

import javax.swing.*;

public interface IListaDeAsignaciones {
	void mostrar();
    void esconder();
    void setActionListener(ActionListener actionListener);
    void setListaDeAsignacion(DefaultListModel<UsuarioPuntuadoDTO> lista);
    void success(String title, String message);
    List<UsuarioPuntuadoDTO> getSeleccionados();
}
