package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import dto.EmpleadorDTO;
import model.Agencia;
import model.usuario.Empleador;
import vista.IVistaAltaTicketEmpleado;
import vista.IVistaMuestraListasAdmin;
import vista.VistaAltaTicketEmpleado;
import vista.VistaMuestraEmpleadoresAdmin;
import vista.VistaMuestraEmpleadosAdmin;

public class ControladorMuestraEmpleadoresAdmin implements ActionListener {

	private IVistaMuestraListasAdmin vista;
	private static ControladorMuestraEmpleadoresAdmin controladorMuestraEmpleadoresAdmin = null;

	private ControladorMuestraEmpleadoresAdmin() {
		this.vista = new VistaMuestraEmpleadoresAdmin();
		this.vista.setActionListener(this);
	}
	
	public static ControladorMuestraEmpleadoresAdmin getControladorMuestraEmpleadoresAdmin(){
		if (controladorMuestraEmpleadoresAdmin == null) {
			controladorMuestraEmpleadoresAdmin = new ControladorMuestraEmpleadoresAdmin();
		}
		
		List<EmpleadorDTO> empleadores = Agencia.getAgencia().listarEmpleadores();
		
		controladorMuestraEmpleadoresAdmin.vista.getModel().setRowCount(0);
		empleadores.forEach( empleador -> {
			Object[] fila = {
				empleador.getNombre(),
				empleador.getRubro(),
				empleador.getTipoPersona(),
				empleador.getPuntaje()
			};
			controladorMuestraEmpleadoresAdmin.vista.getModel().addRow(fila);
		});
		
		controladorMuestraEmpleadoresAdmin.vista.mostrar();
		
		return controladorMuestraEmpleadoresAdmin;
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
