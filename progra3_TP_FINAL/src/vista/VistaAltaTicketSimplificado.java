package vista;

import vista.IVistaAltaTicketSimplificado;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.TicketSimplificadoRequest;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;

public class VistaAltaTicketSimplificado extends JFrame implements IVistaAltaTicketSimplificado,MouseListener{

	private JPanel contentPane;
	private ButtonGroup grupoLocacion,grupoRubro;
	private JButton btnVolver;
	private JButton btnFinalizar;
	private ActionListener actionListener;
	private String tipoDeTrabajo;
	private String locacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaTicketSimplificado frame = new VistaAltaTicketSimplificado();
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
	public VistaAltaTicketSimplificado() {
		setBackground(Color.WHITE);
		setTitle("Ticket Simplificado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Ingrese el tipo de trabajo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));
		
		JRadioButton rdbtnSalud = new JRadioButton("Salud");
		rdbtnSalud.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(rdbtnSalud);
		rdbtnSalud.setActionCommand("Salud");
		
		JRadioButton rdbtnComercioLocal = new JRadioButton("Comercio Local");
		rdbtnComercioLocal.setActionCommand("Comercio_Local");
		rdbtnComercioLocal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(rdbtnComercioLocal);
		
		JRadioButton rdbtnComercioInternacional = new JRadioButton("Comercio Internacional");
		rdbtnComercioInternacional.setActionCommand("Comercio_Internacional");
		rdbtnComercioInternacional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_2.add(rdbtnComercioInternacional);
		
		this.grupoRubro = new ButtonGroup();
		this.grupoRubro.add(rdbtnComercioInternacional);
		this.grupoRubro.add(rdbtnComercioLocal);
		this.grupoRubro.add(rdbtnSalud);
		rdbtnComercioInternacional.addMouseListener(this);
		rdbtnComercioLocal.addMouseListener(this);
		rdbtnSalud.addMouseListener(this);
		

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese la locacion:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_3.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 0, 0, 0));
		
		JRadioButton rdbtnHomeOffice = new JRadioButton("Home Office");
		rdbtnHomeOffice.setActionCommand("HomeOffice");
		rdbtnHomeOffice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(rdbtnHomeOffice);
		
		JRadioButton rdbtnPresencial = new JRadioButton("Presencial");
		rdbtnPresencial.setActionCommand("Presencial");
		rdbtnPresencial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(rdbtnPresencial);
		
		JRadioButton rdbtnAmbas = new JRadioButton("Ambas");
		rdbtnAmbas.setActionCommand("indistinto");
		rdbtnAmbas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_4.add(rdbtnAmbas);
		
		this.grupoLocacion = new ButtonGroup();
		this.grupoLocacion.add(rdbtnAmbas);
		this.grupoLocacion.add(rdbtnPresencial);
		this.grupoLocacion.add(rdbtnHomeOffice);
		rdbtnHomeOffice.addMouseListener(this);
		rdbtnPresencial.addMouseListener(this);
		rdbtnAmbas.addMouseListener(this);
		
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new GridLayout(1, 0, 0, 0));
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(btnVolver);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(btnFinalizar);
		btnFinalizar.setEnabled(false);
		
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		this.setVisible(true);
	}

	@Override
	public void esconder() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		// TODO Auto-generated method stub
		this.btnFinalizar.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void limpiaCampos() {
		// TODO Auto-generated method stub
		this.grupoLocacion.clearSelection();
		this.grupoRubro.clearSelection();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	if(this.grupoRubro.getSelection() != null)
		this.tipoDeTrabajo = this.grupoRubro.getSelection().getActionCommand();
	if(this.grupoLocacion.getSelection()!=null)
		this.locacion = this.grupoLocacion.getSelection().getActionCommand();
	if(this.grupoRubro.getSelection()!=null && this.grupoLocacion.getSelection()!=null)
		 this.btnFinalizar.setEnabled(true);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TicketSimplificadoRequest getTicketSimplificado() {
		
		TicketSimplificadoRequest req=null;
		System.out.println(this.grupoRubro.getSelection().getActionCommand());
		System.out.println(this.grupoLocacion.getSelection().getActionCommand());
		try {
			req = new TicketSimplificadoRequest(this.grupoLocacion.getSelection().getActionCommand(),this.grupoRubro.getSelection().getActionCommand());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return req;
	}

	@Override
	public void failure(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void success(String title, String message) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	

}
