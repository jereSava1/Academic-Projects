package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;

import dto.TicketEmpleadorDTO;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import negocio.RondaDeContrataciones;
import negocio.TicketService;
import vista.IVistaIEmpleador;
import vista.VistaSesionEmpleador;

public class ControladorInicioEmpleador implements ActionListener{

	private IVistaIEmpleador vista;
	private static ControladorInicioEmpleador controladorInicioEmpleador=null;
	private Agencia agencia;
	private TicketService ticketService;
	
	private ControladorInicioEmpleador() {
		this.vista = new VistaSesionEmpleador();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
		this.ticketService = TicketService.getTicketService();
	};
	
	public static ControladorInicioEmpleador get(boolean mostrar){
		if(controladorInicioEmpleador==null)
			controladorInicioEmpleador = new ControladorInicioEmpleador();
		
		String nombreEmpleador = ControladorLogin.getControladorLogin(false).getLogueado().getNombreUsuario();
		List<TicketEmpleadorDTO> solicitudes = Agencia.getAgencia().getListaSolicitudes(nombreEmpleador);
		DefaultListModel<TicketEmpleadorDTO> lista = new DefaultListModel<>();
		solicitudes.forEach(lista::addElement);
		
		controladorInicioEmpleador.vista.setModel(lista);

		if( mostrar )
			controladorInicioEmpleador.vista.mostrar();
		
		return controladorInicioEmpleador;
	}
	
	public void setVista(IVistaIEmpleador vista) {
		this.vista=vista;
	}
	

	public IVistaIEmpleador getVista() {
		return vista;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equalsIgnoreCase("Baja")) {
			TicketEmpleadorDTO ticket = this.vista.getTicketSeleccionado();
			if(ticket!=null) {
				try {
					ticketService.bajaTicketEmpleador(ticket);
					this.vista.success("Baja de ticket", "Ticket borrado con exito");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				String nombreEmpleador = ControladorLogin.getControladorLogin(false).getLogueado().getNombreUsuario();
				DefaultListModel updatedList = new DefaultListModel();
				List<TicketEmpleadorDTO> solicitudes = Agencia.getAgencia().getListaSolicitudes(nombreEmpleador);
				solicitudes.forEach(updatedList::addElement);
				this.vista.setModel(updatedList);
			} else {
				this.vista.failure("Error", "Seleccione un ticket");
			}
	    }else if(comando.equalsIgnoreCase("Modificar ticket")) {
	    
	    	TicketEmpleadorDTO ticket = this.vista.getTicketSeleccionado();
	    	
	    	if( this.vista.getTicketSeleccionado() != null ){
	    		this.vista.esconder();
	    		ControladorModificarTicketEmpleador controladorModificarTicketEmpleador = ControladorModificarTicketEmpleador.getControladorModificarTicketEmpleador(ticket);
	    	}else{
	    		this.vista.failure("Error", "Seleccione un ticket");
	    	}
	    	
	    }else if(comando.equalsIgnoreCase("Alta ticket")) {
	    	this.vista.esconder();
	    	ControladorAltaTicketEmpleador controladorAltaTicket = ControladorAltaTicketEmpleador.get();
	    	
	    }else if(comando.equalsIgnoreCase("Lista de Asignacion")) {
				if (this.vista.getTicketSeleccionado() != null) {
					ControladorListaDeAsignacion controladorListaAsignacion = ControladorListaDeAsignacion.getControladorListaDeAsignacion(true, this.vista.getTicketSeleccionado());
					this.vista.esconder();
				} else {
					this.vista.failure("Error", "Seleccione un ticket");
				}
	    }else if(comando.equalsIgnoreCase("Ronda de Elecciones")) {
	    	
	    }else if(comando.equalsIgnoreCase("Resultado")) {
	    	if( this.vista.getTicketSeleccionado() != null) {
	    		if( RondaDeContrataciones.isActivada() ) {
	    			this.vista.esconder();
	    			ControladorResultadoEmpleador controladorResultadoEmpleador = ControladorResultadoEmpleador.getControladorResultadoEmpleador(this.vista.getTicketSeleccionado());
	    		}else{
	    			this.vista.failure("Error", "Ronda de contrataciones inactiva");
	    		}	
	    	}else {
	    		this.vista.failure("Error", "Seleccione un ticket");
	    	}
	    	
	    }else if(comando.equalsIgnoreCase("Cerrar sesion")) {
	    	this.vista.esconder();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin(true);
	    } else if (comando.equalsIgnoreCase("VER_TICKETS_SIMPLIFICADOS")){
				this.vista.esconder();
				ControladorListaTicketSimplificado controladorListaTicketSimplificado = ControladorListaTicketSimplificado.get();
		}else if(comando.equalsIgnoreCase("Generar Ticket Simplificado")) {
            this.vista.esconder();
            ControladorAltaTicketSimplificado controladorTSimplificado = ControladorAltaTicketSimplificado.get();
        }
	}
}
