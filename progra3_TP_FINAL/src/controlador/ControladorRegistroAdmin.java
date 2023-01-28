package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.RegistroRequestAdmin;
import model.Agencia;
import vista.IRegistroAdmin;
import vista.VistaRegistro;
import vista.VistaRegistroAdmin;

public class ControladorRegistroAdmin implements ActionListener {
	private IRegistroAdmin vista;
	private Agencia agencia;
	private static ControladorRegistroAdmin controladorRegistroAdmin = null;
	
	private ControladorRegistroAdmin() {
		this.vista = new VistaRegistroAdmin();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};

	public static ControladorRegistroAdmin getControladorRegistroAdmin(boolean mostrar) {
		if (controladorRegistroAdmin == null) {
			controladorRegistroAdmin = new ControladorRegistroAdmin();
		}
		if( mostrar )
			controladorRegistroAdmin.vista.mostrar();
		return controladorRegistroAdmin;
	}

	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("REGISTRO")) {
			this.agencia.registrarAdmin(vista.getFormulario());
			this.vista.success();
			this.vista.esconder();
			this.vista.limpiaCampos();
			ControladorLogin controladorLogin= ControladorLogin.getControladorLogin(true);
		} else if (comando.equalsIgnoreCase("VOLVER")) {
			ControladorRegistro controladorReg = ControladorRegistro.getControladorRegistro(); //Contralador para la vista del registro
			this.vista.limpiaCampos();
			this.vista.esconder();
		}
	}
}	

