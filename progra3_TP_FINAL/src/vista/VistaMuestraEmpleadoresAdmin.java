package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.usuario.Empleado;
import model.usuario.UsuarioPuntuado;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

public class VistaMuestraEmpleadoresAdmin extends JFrame implements IVistaMuestraListasAdmin {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolver;
	
	DefaultTableModel model = new DefaultTableModel();	
	
	public VistaMuestraEmpleadoresAdmin() {
		setTitle("Lista de empleadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 205);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Nombre");
		model.addColumn("Rubro");
		model.addColumn("Tipo de Persona");
		model.addColumn("Puntaje");
		table.setModel(model);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 227, 89, 23);
		contentPane.add(btnVolver);
	}

	
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
	public DefaultTableModel getModel() {
		return this.model;
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
	}
}
