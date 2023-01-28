package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.TicketDeEmpleadoRequest;
import exception.ConstructorInvalidoException;
import exception.NoDuenoDeTicketException;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import negocio.TicketService;
import vista.IVistaAltaTicketEmpleado;
import vista.VistaAltaTicketEmpleado;
import vista.VistaRegistro;

public class ControladorModificarTicketEmpleado implements ActionListener {

	private IVistaAltaTicketEmpleado vista;
	private static ControladorModificarTicketEmpleado controladorModificarTicketEmpleado = null;
	private TicketService ticketService;

	private ControladorModificarTicketEmpleado() {
		this.vista = new VistaAltaTicketEmpleado();
		this.vista.setActionListener(this);
		this.ticketService = TicketService.getTicketService();
	}

	public static ControladorModificarTicketEmpleado getControladorModificarTicketEmpleado() {
		if (controladorModificarTicketEmpleado == null) {
			controladorModificarTicketEmpleado = new ControladorModificarTicketEmpleado();
		}
		controladorModificarTicketEmpleado.vista.setV1(Agencia.getAgencia().getRemuneracionV1());
		controladorModificarTicketEmpleado.vista.setV2(Agencia.getAgencia().getRemuneracionV2());

		controladorModificarTicketEmpleado.vista.mostrar();
		return controladorModificarTicketEmpleado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		String usuario = ControladorLogin.getControladorLogin(false).getVistaLogin().getUsername();
		if (comando.equalsIgnoreCase("FINALIZAR")) {
			try {
				ticketService.modificarTicketDeEmpleado(this.vista.getFormulario(), usuario);
				this.vista.success("Modificacion de ticket", "Ticket modificado con exito");
				this.vista.esconder();
				ControladorInicioEmpleado controladorInicioEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado(true);
			} catch (ConstructorInvalidoException err){ /*cumple contrato*/}
		} else if (comando.equalsIgnoreCase("VOLVER")) {
			this.vista.esconder();
			ControladorInicioEmpleado controladorInicioEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado(true);
		}
	}
}