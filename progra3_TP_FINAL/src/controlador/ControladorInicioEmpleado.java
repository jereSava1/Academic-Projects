package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

import dto.TicketDTO;
import dto.UsuarioPuntuadoDTO;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleo;
import model.ticket.TicketSimplificado;
import model.usuario.Usuario;
import model.usuario.UsuarioPuntuado;
import negocio.RondaDeContrataciones;
import negocio.RondaDeEncuentro;
import negocio.TicketService;
import state.CanceladoState;
import vista.IVistaIEmpleado;
import vista.VistaSesionEmpleado;

public class ControladorInicioEmpleado implements ActionListener {

	private IVistaIEmpleado vista;
	private static ControladorInicioEmpleado controladorInicioEmpleado=null;
	private Agencia agencia;
	
	private ControladorInicioEmpleado() {
		this.vista = new VistaSesionEmpleado();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorInicioEmpleado getControladorInicioEmpleado(boolean mostrar){
		if(controladorInicioEmpleado==null)
			controladorInicioEmpleado = new ControladorInicioEmpleado();
		if( mostrar )
			controladorInicioEmpleado.vista.mostrar();
		return controladorInicioEmpleado;
	}
	
	public void setVista(IVistaIEmpleado vista) {
		this.vista=vista;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		Usuario usuario = ControladorLogin.getControladorLogin(false).getLogueado();
			
		TicketBusquedaDeEmpleo ticket = TicketService.getTicketService().encuentraTicketEmpleado(usuario);
		TicketDTO ticketDTO = null;
		if( ticket != null )
			ticketDTO = new TicketDTO( ticket );
        
		if(comando.equalsIgnoreCase("Dar de baja mi ticket")) {
			
			if( ticket!=null ) {
				agencia.cancelaTicket(ticketDTO);
				this.vista.success("Ticket", "Ticket dado de baja con exito");
			}
			else
				this.vista.failure("Error", "Usted no tiene creado un ticket de busqueda de empleo");
			
	    }else if(comando.equalsIgnoreCase("Modifica mi ticket")) {
	    	
	    	if( ticket != null ) {
	    		this.vista.esconder();
	    		ControladorModificarTicketEmpleado controladorModificarTicketEmpleado = ControladorModificarTicketEmpleado.getControladorModificarTicketEmpleado();
	    	}
			else
				this.vista.failure("Error", "Usted no tiene creado un ticket de busqueda de empleo");
	    	
	    }else if(comando.equalsIgnoreCase("Generar mi ticket")) {
	    	
	    	if( ticket == null ) {
	    		this.vista.esconder();
		    	ControladorAltaTicketEmpleado controladorAltaTicketEmpleado = ControladorAltaTicketEmpleado.get();
	    	}
	    	else{
	    		this.vista.failure("Error", "Usted ya tiene un ticket de busqueda de empleo activo");
	    	}
	    	
		
	    }else if(comando.equalsIgnoreCase("VER LISTA")) {
	    	
	    	if( (ticket!=null) && (RondaDeEncuentro.isActivada())) {

					ControladorListaDeAsignacion controladorListaEmpleadores = ControladorListaDeAsignacion.getControladorListaDeAsignacion(true, ticketDTO);
					this.vista.esconder();
	    	}else {
	    		if( ticket == null )
	    			this.vista.failure("Error", "Usted no tiene creado un ticket de busqueda de empleo");
	    		else
	    			this.vista.failure("Error", "No se ha ejecutado la ronda de encuentros");
	    	}
	    	
	    	
	    }else if(comando.equalsIgnoreCase("INGRESAR")) {
	    	
	    	if( ( ticket != null ) && ( RondaDeEncuentro.isActivada() == true) ) {
	    		this.vista.esconder();
	    			ControladorListaDeAsignacion controladorListaDeAsignacion = ControladorListaDeAsignacion.getControladorListaDeAsignacion(true, ticketDTO);
	    	}else {
	    		if( ticket == null )
	    			this.vista.failure("Error", "Usted no tiene creado un ticket de busqueda de empleo");
	    		else
	    			this.vista.failure("Error", "No se ha ejecutado la ronda de encuentros");
	    	}
	    	
	    }else if(comando.equalsIgnoreCase("VER RESULTADO")) {
	    	if(  RondaDeContrataciones.isActivada() ) {
	    		UsuarioPuntuadoDTO contratado = ticketDTO.getListaDeAsignaciones().stream().filter(UsuarioPuntuadoDTO::isContratado).findAny().orElse(null);
	    		if( contratado != null ) {
	    			this.vista.success( "Resultado", "Has sido contratado por: " + contratado.getUsername());
	    		}else {
	    			this.vista.success("Resultado", "No has sido contratado" );
	    		}
	    	}else{
	    		this.vista.failure("Resultado", "Ronda de contrataciones inactiva" );
	    	}
	    	
	    	
	    }else if(comando.equalsIgnoreCase("CERRAR SESION")) {
	    	this.vista.esconder();
			ControladorLogin controladorLogin = ControladorLogin.getControladorLogin(true);
	    }else if(comando.equalsIgnoreCase("VER TICKETS")) {
            
            String userName = ControladorLogin.getControladorLogin(false).getLogueado().getNombreUsuario();

            if( Agencia.getAgencia().estaAsignado(userName) ) {
            	this.vista.failure( "Error", "Usted ya posee un Ticket Simplificado");
            }else {
            	this.vista.esconder();
            	ControladorEleccionTicketSimplificado controladorEleccion = ControladorEleccionTicketSimplificado.getControladorEleccionTicketSimplificado();            	
            }
            
        }
  }
}	
