package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import dto.EmpleadorDTO;
import dto.TicketEmpleadorDTO;
import dto.UsuarioPuntuadoDTO;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import model.usuario.UsuarioPuntuado;
import vista.IVistaMuestraListasAdmin;
import vista.IVistaResultadoEmpleador;
import vista.VistaMuestraEmpleadoresAdmin;
import vista.VistaResultadoEmpleador;

public class ControladorResultadoEmpleador implements ActionListener {

	private IVistaResultadoEmpleador vista;
	private static ControladorResultadoEmpleador controladorResultadoEmpleador = null;

	private ControladorResultadoEmpleador() {
		this.vista = new VistaResultadoEmpleador();
		this.vista.setActionListener(this);
	}
	
	public static ControladorResultadoEmpleador getControladorResultadoEmpleador(TicketEmpleadorDTO ticket){
		if (controladorResultadoEmpleador == null) {
			controladorResultadoEmpleador = new ControladorResultadoEmpleador();
		}
		
    	List<UsuarioPuntuadoDTO> listaAsignacionTicket = ticket.getListaDeAsignaciones();
    	List<UsuarioPuntuadoDTO> contratados = listaAsignacionTicket.stream().filter(s -> s.isContratado()). collect(Collectors.toList());
		System.out.println(contratados);
    	
		controladorResultadoEmpleador.vista.getModel().setRowCount(0);
		contratados.forEach( contratado -> {
			Object[] fila = {
				contratado.getUsername()
			};
			controladorResultadoEmpleador.vista.getModel().addRow(fila);
		});
		
		controladorResultadoEmpleador.vista.mostrar();
		
		controladorResultadoEmpleador.vista.setTextAreaEmpleadosObtenidos(Integer.toString( ticket.getEmpleadosObtenidos() ));
		controladorResultadoEmpleador.vista.setTextAreaEmpleadosSolicitados(Integer.toString( ticket.getEmpleadosNecesitados() ));
		controladorResultadoEmpleador.vista.setTextAreaEmpleadosObtenidosEnRonda( Integer.toString( contratados.size() ) );
		
		return controladorResultadoEmpleador;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if( comando.equalsIgnoreCase("Volver") ) {
			this.vista.esconder();
			ControladorInicioEmpleador controladorInicioEmpleador = ControladorInicioEmpleador.get(true);
		}
		
	}

}
