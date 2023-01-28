package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import model.Agencia;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import types.Resultado;
import vista.IVistaComisionesAdmin;
import vista.VistaComisionesAdmin;

public class ControladorComisionesAdmin implements ActionListener {

	private IVistaComisionesAdmin vista;
	private static ControladorComisionesAdmin controladorComisionesAdmin = null;

	private ControladorComisionesAdmin() {
		this.vista = new VistaComisionesAdmin();
		this.vista.setActionListener(this);
	}
	
	public static ControladorComisionesAdmin getControladorComisionesAdmin(){
		if (controladorComisionesAdmin == null) {
			controladorComisionesAdmin = new ControladorComisionesAdmin();
		}
		
		controladorComisionesAdmin.vista.getModel().setRowCount(0);
		
		List<TicketBusquedaDeEmpleado> solicitudes = Agencia.getAgencia().getSolicitudes();

		for (TicketBusquedaDeEmpleado solicitud : solicitudes) {
			String userNameEmpleador = solicitud.getDueno().getNombreUsuario();
			List<TicketBusquedaDeEmpleado> exitos = solicitudes.stream().filter(s -> s.getDueno().getNombreUsuario().equals(userNameEmpleador) && s.getResultado()==Resultado.EXITO). collect(Collectors.toList());
			float comisionEmpleador = 0;
			if( !exitos.isEmpty() ) {
				for (TicketBusquedaDeEmpleado ticketExito : exitos) {
					comisionEmpleador += ticketExito.getComisionAPagar();
				}
				String nombreEmpleador = exitos.get(0).getDueno().getNombre();
				Object[] fila = {
						nombreEmpleador,
						"Empleador",
						comisionEmpleador
				};
				controladorComisionesAdmin.vista.getModel().addRow(fila);
				
			}
		}
		
		List<TicketBusquedaDeEmpleo> busquedas = Agencia.getAgencia().getBusquedas();
		
		for (TicketBusquedaDeEmpleo busqueda : busquedas) {
			String userNameEmpleador = busqueda.getDueno().getNombreUsuario();
			Optional<TicketBusquedaDeEmpleo> exito = busquedas.stream().filter(s -> s.getDueno().getNombreUsuario().equals(userNameEmpleador) && s.getResultado()==Resultado.EXITO).findAny();
			float comisionEmpleado = 0;
			if( exito.isPresent() ) {
				TicketBusquedaDeEmpleo ticket = exito.get();
				String nombreEmpleado = ticket.getDueno().getNombre();
				comisionEmpleado = ticket.getComisionAPagar();
				Object[] fila = {
						nombreEmpleado,	
						"Empleado",
						comisionEmpleado
				};
				controladorComisionesAdmin.vista.getModel().addRow(fila);
			}
		}
		
		controladorComisionesAdmin.vista.setTextAreaComisionTotal( Float.toString( Agencia.getAgencia().getComisiones()) );
		
		controladorComisionesAdmin.vista.mostrar();
		
		return controladorComisionesAdmin;
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
