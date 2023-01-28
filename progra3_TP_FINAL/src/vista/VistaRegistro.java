package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;

public class VistaRegistro extends JFrame implements IRegistro, MouseListener {

	private JPanel contentPane;
	public ButtonGroup G;
	private ActionListener actionListener;
	private JButton btnSiguiente;
	private JButton btnVolver;

	public VistaRegistro() {
		setTitle("Tipo de Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panelCentral.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnEmpleador = new JRadioButton("Empleador");
		rdbtnEmpleador.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(rdbtnEmpleador);
		rdbtnEmpleador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnEmpleador.setActionCommand("EMPLEADOR");

		JPanel panel_1 = new JPanel();
		panelCentral.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "name_9375483177500");
		panel_3.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnAdministrador = new JRadioButton("Administrador");
		rdbtnAdministrador.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(rdbtnAdministrador);
		rdbtnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnAdministrador.setActionCommand("ADMIN");

		JPanel panel_2 = new JPanel();
		panelCentral.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));

		JRadioButton rdbtnEmpleado = new JRadioButton("Empleado");
		rdbtnEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(rdbtnEmpleado);
		rdbtnEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnEmpleado.setActionCommand("EMPLEADO");

		this.G = new ButtonGroup();
		this.G.add(rdbtnEmpleado);
		this.G.add(rdbtnAdministrador);
		this.G.add(rdbtnEmpleador);
		rdbtnEmpleado.addMouseListener(this);
		rdbtnAdministrador.addMouseListener(this);
		rdbtnEmpleador.addMouseListener(this);

		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(1, 1, 0, 0));

		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSur.add(btnVolver);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSiguiente.setActionCommand("SIGUIENTE");
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelSur.add(btnSiguiente);
		btnSiguiente.setEnabled(false);

		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Seleccione tipo de usuario con el que desea registrarse:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6.add(lblNewLabel);

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
		this.btnVolver.addActionListener(actionListener);
		this.btnSiguiente.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public ButtonGroup getG() {
		return this.G;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.btnSiguiente.setEnabled(this.G.getSelection().toString() != null);
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
	public void limpiaCampos() {
		this.G.clearSelection();
		
	}
	
}
