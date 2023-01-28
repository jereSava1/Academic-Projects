package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;

import controlador.ControladorInicioEmpleado;
import controlador.ControladorLogin;
import dto.TicketEmpleadorDTO;
import factory.LocacionFactory;
import model.Agencia;
import model.ticket.DatosDeEmpleo;
import model.ticket.TicketSimplificado;
import model.usuario.Empleado;
import negocio.BolsaDeTrabajoService;
import vista.IVistaAltaTicketSimplificado;
import vista.IVistaEleccionTicketSimplificado;
import vista.VistaAltaTicketSimplificado;
import vista.VistaEleccionTicketSimplificado;

public class ControladorEleccionTicketSimplificado implements ActionListener{

	private IVistaEleccionTicketSimplificado vista;
	private static ControladorEleccionTicketSimplificado controladorEleccionTicketSimplificado=null;
	private Agencia agencia;

	private ControladorEleccionTicketSimplificado() {
		this.vista = new VistaEleccionTicketSimplificado();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorEleccionTicketSimplificado getControladorEleccionTicketSimplificado(){
		if(controladorEleccionTicketSimplificado == null)
			controladorEleccionTicketSimplificado = new ControladorEleccionTicketSimplificado();
		
		String nombreEmpleador = ControladorLogin.getControladorLogin(false).getLogueado().getNombreUsuario();
		List<TicketSimplificado> tickets = Agencia.getAgencia().getBolsaDeTrabajo();
		DefaultListModel<TicketSimplificado> lista = new DefaultListModel<>();
		tickets.forEach(lista::addElement);
		
		controladorEleccionTicketSimplificado.vista.setModel(lista);
		
		
		controladorEleccionTicketSimplificado.vista.mostrar();
		return controladorEleccionTicketSimplificado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equalsIgnoreCase("SELECCIONAR")) {
			TicketSimplificado ticket = this.vista.getTicketSeleccionado();
			if(ticket!=null) {
				Empleado empleado = (Empleado) ControladorLogin.getControladorLogin(false).getLogueado();
				try {
					DatosDeEmpleo locacion = LocacionFactory.getLocacion(this.vista.getTipoLocacion(),1); //CHEQUEAR
					BolsaDeTrabajoService.getBolsaDeTrabajoService().verificaEmpleado(ticket, empleado, locacion);
				}
				catch(Exception exception) {
					this.vista.failure(exception.getMessage(), "ERROR");
				}
			}
			if( ticket.getAsignacion() != null) {
				Agencia.getAgencia().addTicketSimplificadoAsignado(ticket);
				this.vista.success("Se guardo su ticket con exito!", "Asignacion de Tickets Simplificados");
			}
			else
				this.vista.failure("No coincidio la locacion", "Error");
			this.vista.esconder();
			ControladorInicioEmpleado CEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado(true);
			this.vista.limpiaCampos();
		}else if(comando.equalsIgnoreCase("VOLVER")) {
			this.vista.esconder();
			ControladorInicioEmpleado CEmpleado = ControladorInicioEmpleado.getControladorInicioEmpleado(true);
			this.vista.limpiaCampos();
		}
		
	}

	public void falla() {
		  this.vista.failure("El ticket que intenta aceder esta tomado", "Error");
	}

}
