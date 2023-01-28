package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import controlador.ControladorAltaTicketEmpleador;
import controlador.ControladorInicioEmpleado;
import dto.TicketSimplificadoRequest;
import model.Agencia;
import model.usuario.Empleador;
import negocio.BolsaDeTrabajoService;
import vista.IVistaAltaTicketSimplificado;
import vista.VistaAltaTicketSimplificado;

public class ControladorAltaTicketSimplificado implements ActionListener{

	private IVistaAltaTicketSimplificado vista;
	private static ControladorAltaTicketSimplificado controladorAltaTicket=null;
	private Agencia agencia;
	
	private ControladorAltaTicketSimplificado() {
		this.vista = new VistaAltaTicketSimplificado();
		this.agencia = Agencia.getAgencia();
		this.vista.setActionListener(this);
	};
	
	public static ControladorAltaTicketSimplificado get(){
		if(controladorAltaTicket==null)
			controladorAltaTicket = new ControladorAltaTicketSimplificado();
		controladorAltaTicket.vista.mostrar();
		return controladorAltaTicket;
	}
	
	public void setVista(IVistaAltaTicketSimplificado vista) {
		this.vista=vista;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equalsIgnoreCase("FINALIZAR")) {
			//Guardo el ticket en la "Bolsa de empleo", aca pasa la concurrencia
			TicketSimplificadoRequest req = this.vista.getTicketSimplificado();
			Empleador empleador = (Empleador) ControladorLogin.getControladorLogin(false).getLogueado();
			req.setNombreUsuario(empleador.getNombreUsuario());
			BolsaDeTrabajoService.getBolsaDeTrabajoService().agregarTicketSimplificado(req,empleador);
			this.vista.esconder();
			this.vista.limpiaCampos();
			ControladorInicioEmpleador CEmpleado = ControladorInicioEmpleador.get(true);
		}else if(comando.equalsIgnoreCase("VOLVER")) {
			this.vista.esconder();
			this.vista.limpiaCampos();
			ControladorInicioEmpleador CEmpleado = ControladorInicioEmpleador.get(true);
		}
	}

	public void falla() {
		  this.vista.failure("Error", "Llego al limite de Tickets Simplificados");
	}

}
