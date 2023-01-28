package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dto.RegistroRequestEmpleado;
import model.Agencia;
import vista.IRegistroEmpleado;
import vista.VistaRegistroEmpleadoPretenso;

public class ControladorRegistroEmpleado implements ActionListener {
	private IRegistroEmpleado vista;
	private Agencia agencia;
	private static ControladorRegistroEmpleado controladorRegistroEmpleado = null;

	private ControladorRegistroEmpleado() {
		this.vista = new VistaRegistroEmpleadoPretenso();
		this.vista.setActionListener(this);
		this.agencia = Agencia.getAgencia();
	}
	public static ControladorRegistroEmpleado getControladorRegistroEmpleado(boolean mostrar) {
		if (controladorRegistroEmpleado == null) {
			controladorRegistroEmpleado = new ControladorRegistroEmpleado();
		}
		if( mostrar )
			controladorRegistroEmpleado.vista.mostrar();
		return controladorRegistroEmpleado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			String comando = e.getActionCommand();
			if (comando.equalsIgnoreCase("REGISTRARSE")) {
				if(vista.getFormulario()!=null) {
				  agencia.registrarEmpleado(vista.getFormulario());
				  this.vista.success();
				  this.vista.esconder();
				  this.vista.limpiaCampos();
				  ControladorLogin controladorReg = ControladorLogin.getControladorLogin(true);
				}else {
					ControladorRegistroEmpleado controladorRegistroEmpleado = ControladorRegistroEmpleado.getControladorRegistroEmpleado(true);
				}
			}else if (comando.equalsIgnoreCase("VOLVER")){
				ControladorRegistro controladorReg = ControladorRegistro.getControladorRegistro(); //Controlador para la vista del registro
				this.vista.limpiaCampos();
				this.vista.esconder();
		}

	}
	
	
}
