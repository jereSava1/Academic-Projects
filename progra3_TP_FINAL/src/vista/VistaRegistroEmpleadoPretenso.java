package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import dto.RegistroRequestEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VistaRegistroEmpleadoPretenso extends JFrame implements IRegistroEmpleado,KeyListener {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldTelefono;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private JTextField textFieldEmail;
	private String nombre;
	private String apellido;
	private String telefono;
	private String usuario;
	private String contrasena;
	private String email;
	private String edad;
	private int edadI;
	private JButton btnRegistrarse;
	private JButton btnVolver;
	private ActionListener actionListener; 
	private JTextField textFieldEdad;
	
	public VistaRegistroEmpleadoPretenso() {
		setTitle("Registro Empleado Pretenso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 373);
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
		this.textFieldNombre.addKeyListener(this);
		
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
		this.textFieldApellido.addKeyListener(this);
		
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
		this.textFieldTelefono.addKeyListener(this);
		
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
		this.textFieldUsuario.addKeyListener(this);
		
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
		this.textFieldContrasena.addKeyListener(this);
		
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
		this.textFieldEmail.addKeyListener(this);
		
		JPanel panelEdad = new JPanel();
		panel.add(panelEdad);
	    
	    JLabel lblEmail_1 =new JLabel("Edad :");
	    panelEdad.add(lblEmail_1);
	    lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JPanel panelTextFieldEdad = new JPanel();
		panel.add(panelTextFieldEdad);
		
		textFieldEdad = new JTextField();
		panelTextFieldEdad.add(textFieldEdad);
		textFieldEdad.setColumns(15);
		this.textFieldEdad.addKeyListener(this);
		
		JPanel panelVolver = new JPanel();
		panel.add(panelVolver);
		
	    btnVolver = new JButton("Volver");
	    panelVolver.add(btnVolver);
		
		JPanel panelRegistrarse = new JPanel();
		panel.add(panelRegistrarse);
		
		btnRegistrarse = new JButton("Registrarse");
		panelRegistrarse.add(btnRegistrarse);
	    btnRegistrarse.setEnabled(false); 
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
	   this.actionListener=actionListener;
	   this.btnVolver.addActionListener(actionListener);
       this.btnRegistrarse.addActionListener(actionListener);
	}

	@Override
	public RegistroRequestEmpleado getFormulario() {
		
		try {
		    this.edadI=Integer.parseInt(this.textFieldEdad.getText());
		}
		catch(Exception exception) {
			JOptionPane.showMessageDialog(null, "No ingreso correctamente su edad", "Error", JOptionPane.ERROR_MESSAGE);
			this.textFieldEdad.setText("");
			RegistroRequestEmpleado req = null;
			this.btnRegistrarse.setEnabled(false);
			return req;
		}
		
		RegistroRequestEmpleado req= new RegistroRequestEmpleado(this.nombre,this.apellido,this.telefono,
		this.usuario,this.contrasena,this.email,this.edadI);
		
		System.out.println(req.getNombreUsuario() + " | " + req.getNombre());
		
		return req;
	}

	@Override
	public void success() {
		JOptionPane.showMessageDialog(this, "Usuario registrado con exito");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.nombre=this.textFieldNombre.getText();
		this.apellido=this.textFieldApellido.getText();
		this.email=this.textFieldEmail.getText();
		this.usuario=this.textFieldUsuario.getText();
		this.contrasena=this.textFieldContrasena.getText();
		this.telefono=this.textFieldTelefono.getText();
		this.edad=this.textFieldEdad.getText();
		this.btnRegistrarse.setEnabled(
		nombre.length()>0 && apellido.length()>0 && email.length()>0 && 
		usuario.length()>0 && contrasena.length()>0 && telefono.length()>0 && edad.length()>0);
	}
	
	public void limpiaCampos() {
		this.textFieldApellido.setText("");
		this.textFieldContrasena.setText("");
		this.textFieldEdad.setText("");
		this.textFieldEmail.setText("");
		this.textFieldNombre.setText("");
		this.textFieldEdad.setText("");
		this.textFieldTelefono.setText("");
	}
		
}


