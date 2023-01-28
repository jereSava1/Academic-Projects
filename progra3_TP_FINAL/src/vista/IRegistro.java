package vista;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;

import dto.RegistroRequest;

public interface IRegistro {
	void mostrar();

	void esconder();

	ButtonGroup getG();

	void setActionListener(ActionListener actionListener);
	
	void limpiaCampos();
}
