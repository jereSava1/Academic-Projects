package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.TicketEmpleadorDTO;
import model.ticket.TicketSimplificado;
import vista.IVistaGeneral;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class VistaEleccionTicketSimplificado extends JFrame implements IVistaEleccionTicketSimplificado,MouseListener {

	private JPanel contentPane;
	private JButton btnVolver;
	private JButton btnSeleccionar;
	private JRadioButton rdbtnHomeOffice;
	private JRadioButton rdbtnPresencial;
	private JRadioButton rdbtnAmbas;
	private ActionListener actionListener;
	private ButtonGroup grupoLocacion;
	private String tipoLocacion = null;
	
	private DefaultListModel<TicketSimplificado> tickets;
	private JList<TicketSimplificado> listaTickets;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEleccionTicketSimplificado frame = new VistaEleccionTicketSimplificado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaEleccionTicketSimplificado() {
		setTitle("Eleccion Ticket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 414, 147);
		contentPane.add(scrollPane);
		
		this.listaTickets = new JList();
		scrollPane.setViewportView(listaTickets);
		listaTickets.addMouseListener(this);
		
		JLabel lblNewLabel = new JLabel("Ingrese Locacion: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 137, 14);
		contentPane.add(lblNewLabel);
		
		rdbtnHomeOffice = new JRadioButton("Home Office");
		rdbtnHomeOffice.setActionCommand("HomeOffice");
		rdbtnHomeOffice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnHomeOffice.setBounds(10, 32, 109, 23);
		contentPane.add(rdbtnHomeOffice);
		rdbtnHomeOffice.addMouseListener(this);
		
		rdbtnPresencial = new JRadioButton("Presencial");
		rdbtnPresencial.setActionCommand("Presencial");
		rdbtnPresencial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnPresencial.setBounds(166, 32, 109, 23);
		contentPane.add(rdbtnPresencial);
		rdbtnPresencial.addMouseListener(this);
		
		rdbtnAmbas = new JRadioButton("Ambas");
		rdbtnAmbas.setActionCommand("Indistinto");
		rdbtnAmbas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnAmbas.setBounds(319, 32, 109, 23);
		contentPane.add(rdbtnAmbas);
		rdbtnAmbas.addMouseListener(this);
		
		grupoLocacion = new ButtonGroup();
		grupoLocacion.add(rdbtnAmbas);
		grupoLocacion.add(rdbtnHomeOffice);
		grupoLocacion.add(rdbtnPresencial);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(10, 224, 99, 26);
		contentPane.add(btnVolver);
		
		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSeleccionar.setBounds(301, 224, 123, 26);
		contentPane.add(btnSeleccionar);
		
		btnSeleccionar.setEnabled(false);
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
		this.btnSeleccionar.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void mouseClicked(MouseEvent e) {	
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(this.grupoLocacion.getSelection() != null)
	        this.tipoLocacion = this.grupoLocacion.getSelection().getActionCommand();
		if(this.grupoLocacion.getSelection() != null && this.listaTickets.getSelectedValue()!=null)
			this.btnSeleccionar.setEnabled(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void limpiaCampos() {
		this.grupoLocacion.clearSelection();
		this.btnSeleccionar.setEnabled(false);
	}

	@Override
	public void setModel(DefaultListModel<TicketSimplificado> model) {
		// TODO Auto-generated method stub
		this.listaTickets.setModel(model);
	}
	
	public TicketSimplificado getTicketSeleccionado() {
		return this.listaTickets.getSelectedValue();
	}

	@Override
	public String getTipoLocacion() {
		// TODO Auto-generated method stub
		return this.tipoLocacion;
	}

	@Override
	public void success(String message,String title) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void failure(String message,String title) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
	}
	
}
