package vista;

import java.awt.event.ActionListener;
import dto.RegistroRequestAdmin;
import dto.RegistroRequestEmpleador;

public interface IRegistroEmpleador {

	void mostrar();
	void esconder();
	void setActionListener(ActionListener actionListener);
	RegistroRequestEmpleador getFormulario();
	void success();
	void limpiaCampos();
}
