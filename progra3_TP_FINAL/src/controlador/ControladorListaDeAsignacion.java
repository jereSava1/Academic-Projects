package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import dto.TicketDTO;
import dto.UsuarioPuntuadoDTO;
import model.Agencia;
import model.ticket.Ticket;
import model.usuario.Empleador;
import model.usuario.Usuario;
import model.usuario.UsuarioPuntuado;
import negocio.RondaDeElecciones;
import negocio.TicketService;
import vista.IListaDeAsignaciones;
import vista.VistaListaDeAsignaciones;

import javax.swing.*;

public class ControladorListaDeAsignacion implements ActionListener {
	
	private IListaDeAsignaciones vistaLista;
	private static ControladorListaDeAsignacion controladorListaDeAsignacion = null;
	private static Agencia agencia;
	private TicketService ticketService;
	private static TicketDTO ticketSeleccionado;
	private ControladorListaDeAsignacion() {
		this.vistaLista = new VistaListaDeAsignaciones();
		this.vistaLista.setActionListener(this);
		this.agencia = Agencia.getAgencia();
		this.ticketService = TicketService.getTicketService();
	};
	
	public static ControladorListaDeAsignacion getControladorListaDeAsignacion(boolean mostrar, TicketDTO ticketSeleccionado) {
		if (controladorListaDeAsignacion == null) {
			controladorListaDeAsignacion = new ControladorListaDeAsignacion();
		}
		Usuario usuario = ControladorLogin.getControladorLogin(false).getLogueado();
		List<UsuarioPuntuadoDTO> usuariosPuntuados = null;
		ControladorListaDeAsignacion.ticketSeleccionado = ticketSeleccionado;
		try {
			usuariosPuntuados = ticketSeleccionado.getListaDeAsignaciones();
			DefaultListModel<UsuarioPuntuadoDTO> model = new DefaultListModel<>();
			usuariosPuntuados.forEach(model::addElement);
			controladorListaDeAsignacion.vistaLista.setListaDeAsignacion(model);
		} catch (NullPointerException e) {
			controladorListaDeAsignacion.vistaLista.success("Aviso", "La lista de asignaciones aun no ha sido generada");
		}

		if (mostrar && usuariosPuntuados != null) {
			controladorListaDeAsignacion.vistaLista.mostrar();
		} else if (usuariosPuntuados == null) {
			ControladorInicioEmpleador.get(true);
		}
		return controladorListaDeAsignacion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if( comando.equalsIgnoreCase("Volver") ) {
			this.vistaLista.esconder();
			Usuario usuario = ControladorLogin.getControladorLogin(false).getLogueado();
			if( usuario instanceof Empleador) {
				ControladorInicioEmpleador controladorInicioEmpleador = ControladorInicioEmpleador.get(true);
			}else{
				ControladorInicioEmpleado controladorInicioEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado(true);
			}
		} else if ( comando.equalsIgnoreCase("CONFIRMAR")) {
			List<UsuarioPuntuadoDTO> seleccion = this.vistaLista.getSeleccionados();
			ticketService.seleccionarUsuariosPuntuados(seleccion, ControladorListaDeAsignacion.ticketSeleccionado);

			this.vistaLista.success("Exito", "Seleccion confirmada");
			List<UsuarioPuntuadoDTO> usuariosPuntuados = ticketService.encuentraTicket(ControladorListaDeAsignacion.ticketSeleccionado.getId())
							.getListaDeAsignaciones()
							.stream()
							.map(UsuarioPuntuadoDTO::of).collect(Collectors.toList());
			DefaultListModel<UsuarioPuntuadoDTO> model = new DefaultListModel<>();
			usuariosPuntuados.forEach(model::addElement);
			controladorListaDeAsignacion.vistaLista.setListaDeAsignacion(model);
		}
		
	}
}
