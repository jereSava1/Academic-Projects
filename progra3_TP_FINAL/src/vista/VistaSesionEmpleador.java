package vista;

import dto.TicketEmpleadorDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaSesionEmpleador extends JFrame implements IVistaIEmpleador{

	private JPanel contentPane;
	private JButton btnAltaTicket;
	private JButton btnBajaTicket;
	private JButton btnModificarTicket;
	private JButton btnListaDeAsignacion;
	private JButton btnResultado;
	private JButton btnCerrarSesion;
	private JButton btnGenerarTicketSimplificado;
	private JButton btnVerTicketsSimplificados;
	
	private DefaultListModel<TicketEmpleadorDTO> tickets;
	private JList<TicketEmpleadorDTO> listaTickets;

	public VistaSesionEmpleador() {
		setTitle("Sesion Empleador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 550, 353);
		contentPane.add(scrollPane);
		
		this.listaTickets = new JList();
		tickets = new DefaultListModel<>();
		this.listaTickets.setModel(tickets);
		scrollPane.setViewportView(listaTickets);
		listaTickets.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);
		
		btnAltaTicket = new JButton("Alta Ticket");
		btnAltaTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAltaTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAltaTicket.setBounds(10, 21, 195, 33);
		contentPane.add(btnAltaTicket);
		
		btnBajaTicket = new JButton("Baja Ticket");
		btnBajaTicket.setActionCommand("BAJA");
		btnBajaTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBajaTicket.setBounds(586, 81, 169, 38);
		contentPane.add(btnBajaTicket);
		
		btnModificarTicket = new JButton("Modificar Ticket");
		btnModificarTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModificarTicket.setBounds(586, 140, 169, 38);
		contentPane.add(btnModificarTicket);
		
		btnListaDeAsignacion = new JButton("Lista de asignacion");
		btnListaDeAsignacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnListaDeAsignacion.setBounds(586, 207, 169, 38);
		contentPane.add(btnListaDeAsignacion);
		
		btnResultado = new JButton("Resultado");
		btnResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnResultado.setBounds(586, 270, 169, 38);
		contentPane.add(btnResultado);
		
		btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCerrarSesion.setBounds(10, 435, 125, 45);
		contentPane.add(btnCerrarSesion);
		
		btnGenerarTicketSimplificado = new JButton("Generar Ticket Simplificado");
		btnGenerarTicketSimplificado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGenerarTicketSimplificado.setBounds(291, 18, 206, 38);
		contentPane.add(btnGenerarTicketSimplificado);
		
		btnVerTicketsSimplificados = new JButton("Ver Tickets Simplificados");
		btnVerTicketsSimplificados.setActionCommand("VER_TICKETS_SIMPLIFICADOS");
		btnVerTicketsSimplificados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerTicketsSimplificados.setBounds(549, 18, 206, 38);
		contentPane.add(btnVerTicketsSimplificados);
	}
	

	public void addTicket(TicketEmpleadorDTO ticket) {
		tickets.addElement(ticket);
		this.listaTickets.setModel(tickets);
	}
	
	public void removeTicket(TicketEmpleadorDTO ticket) {
		tickets.removeElement(ticket);
		this.listaTickets.setModel(tickets);
	}
	
	public JList getListaTickets() {
		return listaTickets;
	}
	
	public void setListaTickets(JList listaTickets) {
		this.listaTickets = listaTickets;
	}
	
	public DefaultListModel<TicketEmpleadorDTO> getTickets() {
		return tickets;
	}

	public void setTickets(DefaultListModel<TicketEmpleadorDTO> tickets) {
		this.tickets = tickets;
	}
	
	

	@Override
	public void mostrar() {
		this.setVisible(true);
		
	}

	@Override
	public void esconder() {
		this.setVisible(false);
		
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnAltaTicket.addActionListener(actionListener);
		this.btnListaDeAsignacion.addActionListener(actionListener);
		this.btnResultado.addActionListener(actionListener);
		this.btnCerrarSesion.addActionListener(actionListener);
		this.btnBajaTicket.addActionListener(actionListener);
		this.btnModificarTicket.addActionListener(actionListener);
		this.btnGenerarTicketSimplificado.addActionListener(actionListener);
		this.btnVerTicketsSimplificados.addActionListener(actionListener);
	}

	@Override
	public void setModel(DefaultListModel<TicketEmpleadorDTO> model) {
		this.listaTickets.setModel(model);
	}	
		
	public TicketEmpleadorDTO getTicketSeleccionado() {
		return this.listaTickets.getSelectedValue();
	}

	public void success(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void failure(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public TicketEmpleadorDTO getSeleccionado() {
		return this.listaTickets.getSelectedValue();
	}
}
