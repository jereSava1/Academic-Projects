package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dto.RegistroRequestEmpleador;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.Font;
import java.awt.FlowLayout;

public class VistaRegistroEmpleador extends JFrame implements IRegistroEmpleador,KeyListener,MouseListener{

	private JPanel General;
	private JTextField TextFieldNombre;
	private JTextField TextFieldUsuario;
	private JTextField TextFieldContrasena;
	private ButtonGroup GrupoTipoPersona,GrupoRubro;
    private JButton BotonVolver;
    private JButton BotonRegistrarse;
    private ActionListener actionListener;
    private String nombre;
    private String usuario;
    private String contrasena;
    private String TipoPersona;
    private String Rubro;

	public VistaRegistroEmpleador() {
		setTitle("Registro de Empleador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 409);
		General = new JPanel();
		General.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(General);
		General.setLayout(new BorderLayout(0, 0));
		
		JPanel Central = new JPanel();
		General.add(Central, BorderLayout.CENTER);
		Central.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel PanelNombre = new JPanel();
		Central.add(PanelNombre);
		
		JLabel lblNewLabel = new JLabel("Nombre o Razon Social:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelNombre.add(lblNewLabel);
		
		JPanel PanelTextNombre = new JPanel();
		Central.add(PanelTextNombre);
		
		TextFieldNombre = new JTextField();
		PanelTextNombre.add(TextFieldNombre);
		TextFieldNombre.setColumns(10);
		this.TextFieldNombre.addKeyListener(this);
		
		JPanel PanelTipoPersona = new JPanel();
		Central.add(PanelTipoPersona);
		
		JLabel lblNewLabel_1 = new JLabel("Segun su tipo de persona:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelTipoPersona.add(lblNewLabel_1);
		
		JPanel PanelBotonTipoPersona = new JPanel();
		Central.add(PanelBotonTipoPersona);
		PanelBotonTipoPersona.setLayout(new GridLayout(2, 0, 0, 0));
		
		JRadioButton BotonPersonaJuridica = new JRadioButton("Persona Juridica");
		BotonPersonaJuridica.setActionCommand("JURIDICA");
		BotonPersonaJuridica.setHorizontalAlignment(SwingConstants.CENTER);
		BotonPersonaJuridica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelBotonTipoPersona.add(BotonPersonaJuridica);
		
		JRadioButton BotonPersonaFisica = new JRadioButton("Persona Fisica");
		BotonPersonaFisica.setActionCommand("FISICA");
		BotonPersonaFisica.setHorizontalAlignment(SwingConstants.CENTER);
		BotonPersonaFisica.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelBotonTipoPersona.add(BotonPersonaFisica);
		
		GrupoTipoPersona = new ButtonGroup();
        GrupoTipoPersona.add(BotonPersonaFisica);
        GrupoTipoPersona.add(BotonPersonaJuridica);
        BotonPersonaFisica.addMouseListener(this);
        BotonPersonaJuridica.addMouseListener(this);
		
		JPanel PanelRubro = new JPanel();
		Central.add(PanelRubro);
		
		JLabel lblNewLabel_2 = new JLabel("Rubro al que se dedica:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelRubro.add(lblNewLabel_2);
		
		JPanel PanelBotonesRubro = new JPanel();
		Central.add(PanelBotonesRubro);
		PanelBotonesRubro.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JRadioButton BotonSalud = new JRadioButton("Salud");
		BotonSalud.setActionCommand("SALUD");
		BotonSalud.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelBotonesRubro.add(BotonSalud);
		
		JRadioButton BotonComercioLocal = new JRadioButton("Comercio Local");
		BotonComercioLocal.setActionCommand("COMERCIO_LOCAL");
		BotonComercioLocal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelBotonesRubro.add(BotonComercioLocal);
		
		JRadioButton BotonComercioInternacional = new JRadioButton("Comercio Internacional");
		BotonComercioInternacional.setActionCommand("COMERCIO_INTERNACIONAL");
		BotonComercioInternacional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelBotonesRubro.add(BotonComercioInternacional);
		
		GrupoRubro = new ButtonGroup();
        GrupoRubro.add(BotonComercioLocal);
        GrupoRubro.add(BotonSalud);
        GrupoRubro.add(BotonComercioInternacional);
        BotonComercioLocal.addMouseListener(this);
        BotonSalud.addMouseListener(this);
        BotonComercioInternacional.addMouseListener(this);
        
		
		JPanel PanelUsuario = new JPanel();
		Central.add(PanelUsuario);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelUsuario.add(lblNewLabel_3);
		
		JPanel PanelTextUsuario = new JPanel();
		Central.add(PanelTextUsuario);
		
		TextFieldUsuario = new JTextField();
		PanelTextUsuario.add(TextFieldUsuario);
		TextFieldUsuario.setColumns(10);
		this.TextFieldUsuario.addKeyListener(this);
		
		JPanel PanelContrasena = new JPanel();
		Central.add(PanelContrasena);
		
		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PanelContrasena.add(lblNewLabel_4);
		
		JPanel PanelTextCntrasena = new JPanel();
		Central.add(PanelTextCntrasena);
		
		TextFieldContrasena = new JTextField();
		PanelTextCntrasena.add(TextFieldContrasena);
		TextFieldContrasena.setColumns(10);
		this.TextFieldContrasena.addKeyListener(this);
		
		JPanel Sur = new JPanel();
		General.add(Sur, BorderLayout.SOUTH);
		Sur.setLayout(new GridLayout(0, 2, 0, 0));
		
		BotonVolver = new JButton("Volver");
		BotonVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Sur.add(BotonVolver);
		
		BotonRegistrarse = new JButton("Registrarse");
		BotonRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Sur.add(BotonRegistrarse);
		BotonRegistrarse.setEnabled(false);
	}

	public void setActionListener(ActionListener actionListener) {
        this.BotonVolver.addActionListener(actionListener);
        this.BotonRegistrarse.addActionListener(actionListener);
        this.actionListener = actionListener;
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
	public RegistroRequestEmpleador getFormulario() {
		RegistroRequestEmpleador req = new RegistroRequestEmpleador(this.usuario, this.contrasena, this.TipoPersona, this.Rubro, this.nombre);
		return req;
	}

	@Override
	public void success() {
		JOptionPane.showMessageDialog(this, "Usuario registrado con exito");
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
		
		if(this.GrupoRubro.getSelection()!=null && this.GrupoTipoPersona.getSelection()!=null) {
			this.TipoPersona = this.GrupoTipoPersona.getSelection().getActionCommand();
			this.Rubro = this.GrupoRubro.getSelection().getActionCommand();
			if(usuario.length()>0 && nombre.length()>0 && contrasena.length()>0)
				this.BotonRegistrarse.setEnabled(true);
	   }
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.nombre = this.TextFieldNombre.getText();
		this.usuario = this.TextFieldUsuario.getText();
		this.contrasena = this.TextFieldContrasena.getText();
		
		if(usuario.length() > 0 && contrasena.length() > 0 && nombre.length() > 0)
			if(this.GrupoRubro.getSelection()!=null && this.GrupoTipoPersona.getSelection()!=null)
				this.BotonRegistrarse.setEnabled(true);
	}
	
	public void limpiaCampos() {
		this.GrupoRubro.clearSelection();
		this.GrupoTipoPersona.clearSelection();
		this.TextFieldContrasena.setText("");
		this.TextFieldUsuario.setText("");
		this.TextFieldNombre.setText("");
		
	}
}
