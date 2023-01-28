package vista;

import java.awt.event.ActionListener;
import dto.RegistroRequestAdmin;

public interface IRegistroAdmin {
	void mostrar();
	void esconder();
	void success();
	void setActionListener(ActionListener actionListener);
	RegistroRequestAdmin getFormulario();
    void limpiaCampos();
}