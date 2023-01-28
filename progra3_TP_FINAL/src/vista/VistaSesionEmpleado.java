package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class VistaSesionEmpleado extends JFrame implements IVistaIEmpleado{

	private JPanel contentPane;
	private JButton btnAltaTicket;
	private JButton btnBajaTicket;
	private JButton btnListaEmpleadores;
	private JButton btnRondaEleccion;
	private JButton btnResultado;
	private JButton btnCerrarSesion;
	private JButton btnModificaTicket;
	private JButton btnVerTicket;

	public VistaSesionEmpleado() {
		setTitle("Sesion Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Baja del ticket: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(lblNewLabel_1);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		btnBajaTicket = new JButton("Dar de baja mi ticket");
		btnBajaTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(btnBajaTicket);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Modificar el ticket:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_6.add(lblNewLabel_2);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		
		btnModificaTicket = new JButton("Modifica mi ticket");
		btnModificaTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_7.add(btnModificaTicket);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Alta del ticket: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAltaTicket = new JButton("Generar mi ticket");
		btnAltaTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(btnAltaTicket);
		
		JPanel panel_1_1 = new JPanel();
		panel.add(panel_1_1);
		
		JLabel lblListaDeEmpleadores = new JLabel("Lista de empleadores: ");
		lblListaDeEmpleadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1_1.add(lblListaDeEmpleadores);
		
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1);
		
		btnListaEmpleadores = new JButton("Ver Lista");
		btnListaEmpleadores.setVerticalAlignment(SwingConstants.BOTTOM);
		btnListaEmpleadores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_1.add(btnListaEmpleadores);
		
		JPanel panel_1_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1_2.getLayout();
		panel.add(panel_1_2);
		
		JLabel lblRondaDeEleccion = new JLabel("Ronda de eleccion");
		lblRondaDeEleccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1_2.add(lblRondaDeEleccion);
		
		JPanel panel_2_2 = new JPanel();
		panel.add(panel_2_2);
		
		btnRondaEleccion = new JButton("Ingresar");
		btnRondaEleccion.setActionCommand("Ingresar");
		btnRondaEleccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_2.add(btnRondaEleccion);
		
		JPanel panel_1_3 = new JPanel();
		panel.add(panel_1_3);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1_3.add(lblResultado);
		
		JPanel panel_2_3 = new JPanel();
		panel.add(panel_2_3);
		
		btnResultado = new JButton("Ver Resultado");
		btnResultado.setVerticalAlignment(SwingConstants.BOTTOM);
		btnResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_3.add(btnResultado);
		
		JPanel panel_1_2_1 = new JPanel();
		panel.add(panel_1_2_1);
		
		JLabel lblVerTicketSimplificado = new JLabel("Ver Ticket Simplificado");
		lblVerTicketSimplificado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1_2_1.add(lblVerTicketSimplificado);
		
		JPanel panel_2_2_1 = new JPanel();
		panel.add(panel_2_2_1);
		
		btnVerTicket = new JButton("Ver Tickets");
		btnVerTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2_2_1.add(btnVerTicket);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		btnCerrarSesion = new JButton("Cerrar sesion");
		btnCerrarSesion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(btnCerrarSesion);
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
		
		this.btnCerrarSesion.addActionListener(actionListener);
		this.btnAltaTicket.addActionListener(actionListener);
		this.btnListaEmpleadores.addActionListener(actionListener);
		this.btnResultado.addActionListener(actionListener);
		this.btnBajaTicket.addActionListener(actionListener);
		this.btnModificaTicket.addActionListener(actionListener);
		this.btnVerTicket.addActionListener(actionListener);
		this.btnRondaEleccion.addActionListener(actionListener);
	}

	@Override
	public void failure(String error, String titulo) {
		JOptionPane.showMessageDialog(null, titulo, error, JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void success(String ok, String titulo) {
		JOptionPane.showMessageDialog(null, titulo, ok, JOptionPane.INFORMATION_MESSAGE);
	}

}
