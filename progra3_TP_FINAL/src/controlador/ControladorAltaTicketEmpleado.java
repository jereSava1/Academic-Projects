package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.TicketDeEmpleadoRequest;
import dto.TicketDeEmpleadorRequest;
import exception.ConstructorInvalidoException;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.Empleado;
import vista.IVistaAltaTicketEmpleado;
import vista.IVistaIEmpleador;
import vista.VistaAltaTicketEmpleado;

public class ControladorAltaTicketEmpleado implements ActionListener {

	private IVistaAltaTicketEmpleado vista;
	private static ControladorAltaTicketEmpleado controladorAltaTicket=null;
	private Agencia agencia;
	
	private ControladorAltaTicketEmpleado() {
		this.vista = new VistaAltaTicketEmpleado();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorAltaTicketEmpleado get(){
		if(controladorAltaTicket==null)
			controladorAltaTicket = new ControladorAltaTicketEmpleado();
		controladorAltaTicket.vista.setV1(Agencia.getAgencia().getRemuneracionV1());
        controladorAltaTicket.vista.setV2(Agencia.getAgencia().getRemuneracionV2());
        controladorAltaTicket.vista.mostrar();
		return controladorAltaTicket;
	}
	
	public void setVista(IVistaAltaTicketEmpleado vista) {
		this.vista=vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if (comando.equalsIgnoreCase("FINALIZAR")) {
			//Guardo Ticket
			
			TicketDeEmpleadoRequest request=null;
			try {
				request = this.vista.getFormulario();
			} catch (ConstructorInvalidoException e2) {
				e2.printStackTrace();
			}
			
			if(request == null) {
				this.vista.setPeso(0);
				ControladorAltaTicketEmpleado controladorAltaTicket = ControladorAltaTicketEmpleado.get();
			}else {
			    try {
				    request = this.vista.getFormulario();
				    String usuario = ControladorLogin.getControladorLogin(false).getLogueado().getNombreUsuario();
				    agencia.crearTicketBusquedaDeEmpleo(request, usuario);
				    this.vista.success("Ticket creado", "Ticket creado con exito");
				    ControladorInicioEmpleado CEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado(true);
			     } 
			    catch (Exception e1) {
				    e1.printStackTrace();
			     }
			  this.vista.esconder();
			  this.vista.limpiaCampos();
			}
		}else if(comando.equalsIgnoreCase("VOLVER")) {
			this.vista.esconder();
			ControladorInicioEmpleado CEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado(true);
			this.vista.limpiaCampos();
		}
		
	}

}
