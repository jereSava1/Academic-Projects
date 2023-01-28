package registroEmpleadoPretenso;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VistaRegistroEmpleadoPretenso extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private JTextField textFieldEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRegistroEmpleadoPretenso frame = new VistaRegistroEmpleadoPretenso();
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
	public VistaRegistroEmpleadoPretenso() {
		setTitle("Registro Empleado Pretenso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelLabelNombre = new JPanel();
		panel.add(panelLabelNombre);
		
		JLabel lblNewLabel = new JLabel("Nombre :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelLabelNombre.add(lblNewLabel);
		
		JPanel panelTextFieldNombre = new JPanel();
		panel.add(panelTextFieldNombre);
		
		textFieldNombre = new JTextField();
		panelTextFieldNombre.add(textFieldNombre);
		textFieldNombre.setColumns(15);
		
		JPanel panelLabelApellido = new JPanel();
		panel.add(panelLabelApellido);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelLabelApellido.add(lblApellido);
		
		JPanel panelTextFieldApellido = new JPanel();
		panel.add(panelTextFieldApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(15);
		panelTextFieldApellido.add(textFieldApellido);
		
		JPanel panelTelefono = new JPanel();
		panel.add(panelTelefono);
		
		JLabel lblTelefono = new JLabel("Telefono :");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelTelefono.add(lblTelefono);
		
		JPanel panelTextFieldTelefono = new JPanel();
		panel.add(panelTextFieldTelefono);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(15);
		panelTextFieldTelefono.add(textFieldTelefono);
		
		JPanel panelLabelUsuario = new JPanel();
		panel.add(panelLabelUsuario);
		
		JLabel lblNombreusuario = new JLabel("Usuario :");
		lblNombreusuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelLabelUsuario.add(lblNombreusuario);
		
		JPanel panelTextFieldUsuario = new JPanel();
		panel.add(panelTextFieldUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setColumns(15);
		panelTextFieldUsuario.add(textFieldUsuario);
		
		JPanel panelLabelContrasena = new JPanel();
		panel.add(panelLabelContrasena);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a :");
		lblContrasena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelLabelContrasena.add(lblContrasena);
		
		JPanel panelTextFieldContrasena = new JPanel();
		panel.add(panelTextFieldContrasena);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setColumns(15);
		panelTextFieldContrasena.add(textFieldContrasena);
		
		JPanel panelLabelEmail = new JPanel();
		panel.add(panelLabelEmail);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelLabelEmail.add(lblEmail);
		
		JPanel panelTextFieldEmail = new JPanel();
		panel.add(panelTextFieldEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(15);
		panelTextFieldEmail.add(textFieldEmail);
		
		JPanel panelButtonVolver = new JPanel();
		panel.add(panelButtonVolver);
		
		JButton btnVolver = new JButton("Volver");
		panelButtonVolver.add(btnVolver);
		
		JPanel panelButtonRegistrarse = new JPanel();
		panel.add(panelButtonRegistrarse);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		panelButtonRegistrarse.add(btnRegistrarse);
	}

}
