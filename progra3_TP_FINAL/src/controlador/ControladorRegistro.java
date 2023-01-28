package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Agencia;
import vista.*;

public class ControladorRegistro implements ActionListener {
	private IRegistro vistaRegistro;
	private static ControladorRegistro controladorRegistro = null;

	private ControladorRegistro() {
		this.vistaRegistro = new VistaRegistro();
		this.vistaRegistro.setActionListener(this);
	}

	public static ControladorRegistro getControladorRegistro(){
		if (controladorRegistro == null) {
			controladorRegistro = new ControladorRegistro();
		}
		controladorRegistro.vistaRegistro.mostrar();
		return controladorRegistro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("SIGUIENTE")) {
			String comando = this.vistaRegistro.getG().getSelection().getActionCommand();
			if (comando.equalsIgnoreCase("admin")) {
				if(Agencia.getAgencia().getAdministrador() != null)
				  JOptionPane.showMessageDialog(null, "Ya existe un administrador", "Error", JOptionPane.ERROR_MESSAGE);
				else {
				  this.vistaRegistro.esconder();
				  ControladorRegistroAdmin controladorAdmin = ControladorRegistroAdmin.getControladorRegistroAdmin(true);
				}  
			} else if (comando.equalsIgnoreCase("empleado")) {
				this.vistaRegistro.esconder();
				ControladorRegistroEmpleado controladorRegistroEmpleado = ControladorRegistroEmpleado.getControladorRegistroEmpleado(true);
			} else if (comando.equalsIgnoreCase("empleador")) {

				this.vistaRegistro.esconder();
				ControladorRegistroEmpleador controladorEmpleador = ControladorRegistroEmpleador.getControladorRegistroEmpleador(true);
			}
			this.vistaRegistro.limpiaCampos();
		} else if (e.getActionCommand().equalsIgnoreCase("VOLVER")) {
			this.vistaRegistro.esconder();
			this.vistaRegistro.limpiaCampos();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin(true);
		}
	}

}
