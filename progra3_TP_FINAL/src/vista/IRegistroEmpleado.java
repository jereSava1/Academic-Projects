package vista;

import java.awt.event.ActionListener;

import dto.RegistroRequestEmpleado;

public interface IRegistroEmpleado {
	void mostrar();
	void esconder();
	void setActionListener(ActionListener actionListener);
	RegistroRequestEmpleado getFormulario();
	void success();
    void limpiaCampos();
}
