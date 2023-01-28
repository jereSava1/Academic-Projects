package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dto.TicketDTO;
import dto.TicketEmpleadorDTO;
import exception.ConstructorInvalidoException;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import model.usuario.Usuario;
import negocio.TicketService;
import vista.IVistaAltaTicketEmpleado;
import vista.IVistaAltaTicketEmpleador;
import vista.VistaAltaTicketEmpleado;
import vista.VistaAltaTicketEmpleador;

public class ControladorModificarTicketEmpleador implements ActionListener {

	private IVistaAltaTicketEmpleador vista;
	private static ControladorModificarTicketEmpleador controladorModificarTicketEmpleador = null;
	private TicketService ticketService;
	private static TicketEmpleadorDTO ticketSel;

	private ControladorModificarTicketEmpleador() {
		this.vista = new VistaAltaTicketEmpleador();
		this.vista.setActionListener(this);
		this.ticketService = TicketService.getTicketService();
	}

	public static ControladorModificarTicketEmpleador getControladorModificarTicketEmpleador(TicketEmpleadorDTO ticket) {
		if (controladorModificarTicketEmpleador == null) {
			controladorModificarTicketEmpleador = new ControladorModificarTicketEmpleador();
		}
		
		ControladorModificarTicketEmpleador.ticketSel = ticket;
		
		controladorModificarTicketEmpleador.vista.setV1(Agencia.getAgencia().getRemuneracionV1());
		controladorModificarTicketEmpleador.vista.setV2(Agencia.getAgencia().getRemuneracionV2());

		controladorModificarTicketEmpleador.vista.mostrar();
		
		return controladorModificarTicketEmpleador;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("FINALIZAR")) {
			
			String id = ControladorModificarTicketEmpleador.ticketSel.getId(); 
			
			ticketService.modificarTicketDeEmpleador(this.vista.getFormulario(), id);
			this.vista.success("Modificacion de ticket", "Ticket modificado con exito");
			this.vista.esconder();
			ControladorInicioEmpleador controladorInicioEmpleador = ControladorInicioEmpleador.get(true);
			
		} else if (comando.equalsIgnoreCase("VOLVER")) {
			this.vista.esconder();
			ControladorInicioEmpleador controladorInicioEmpleador = ControladorInicioEmpleador.get(true);
		}
	}
}
