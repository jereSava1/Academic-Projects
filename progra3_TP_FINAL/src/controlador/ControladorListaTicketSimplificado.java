package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import dto.TicketSimplificadoDTO;
import negocio.TicketService;
import vista.IListaTicketSimplificado;
import vista.VistaListaTicketSimplificado;

import javax.swing.*;

public class ControladorListaTicketSimplificado implements ActionListener {
	private final IListaTicketSimplificado vista;
	private static ControladorListaTicketSimplificado instancia = null;
	
	private ControladorListaTicketSimplificado() {
		this.vista = new VistaListaTicketSimplificado();
		this.vista.setActionListener(this);
	}

	public static ControladorListaTicketSimplificado get(){
		if (instancia == null){
			instancia = new ControladorListaTicketSimplificado();
		}
		String username = ControladorLogin.getControladorLogin(false).getLogueado().getNombreUsuario();
		List<TicketSimplificadoDTO> list =  TicketService.getTicketService().encuentraTicketSimplificado(username);
		DefaultListModel<TicketSimplificadoDTO> model = new DefaultListModel<>();
		list.forEach(model::addElement);
		
		instancia.vista.setModel(model);
		instancia.vista.mostrar();
		
		return instancia;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equalsIgnoreCase("VOLVER")) {
			ControladorInicioEmpleador.get(true);
			this.vista.esconder();
		}
	}
}
