package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import dto.EmpleadoDTO;
import model.Agencia;
import vista.IVistaMuestraListasAdmin;
import vista.VistaAltaTicketEmpleado;
import vista.VistaMuestraEmpleadosAdmin;

public class ControladorMuestraEmpleadosAdmin implements ActionListener {

	private IVistaMuestraListasAdmin vista;
	private static ControladorMuestraEmpleadosAdmin controladorMuestraEmpleadosAdmin = null;
	private Agencia agencia;
	private ControladorMuestraEmpleadosAdmin() {
		this.vista = new VistaMuestraEmpleadosAdmin();
		this.vista.setActionListener(this);
		this.agencia = Agencia.getAgencia();
	}
	
	public static ControladorMuestraEmpleadosAdmin getControladorMuestraEmpleadosAdmin(){
		if (controladorMuestraEmpleadosAdmin == null) {
			controladorMuestraEmpleadosAdmin = new ControladorMuestraEmpleadosAdmin();
		}

		List<EmpleadoDTO> empleados = Agencia.getAgencia().listarEmpleados();
		
		controladorMuestraEmpleadosAdmin.vista.getModel().setRowCount(0);
		empleados.forEach( empleado -> {
			Object[] fila = {
				empleado.getNombre(),	
				empleado.getEmail(),
				empleado.getTelefono(),
				empleado.getPuntaje()
			};
			controladorMuestraEmpleadosAdmin.vista.getModel().addRow(fila);
		});
		
		controladorMuestraEmpleadosAdmin.vista.mostrar();
		
		return controladorMuestraEmpleadosAdmin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if( comando.equalsIgnoreCase("Volver") ) {
			this.vista.esconder();
			ControladorSesionAdmin CAdmin = ControladorSesionAdmin.get();
		}
		
	}

}
