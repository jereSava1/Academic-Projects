package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;

public class VistaResultadoEmpleador extends JFrame implements IVistaResultadoEmpleador {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolver;
	private JTextArea textAreaEmpleadosSolicitados;
	private JTextArea textAreaEmpleadosObtenidos;
	private JTextArea textAreaEmpleadosObtenidosEnRonda;
	
	DefaultTableModel model = new DefaultTableModel();
	
	public VistaResultadoEmpleador() {
		setTitle("Resultado Empleador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Empleados contratados");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 171, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 233, 191);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Nombre de Empleado");
		table.setModel(model);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVolver.setBounds(10, 249, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel_1 = new JLabel("Solicitados totales");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(263, 56, 133, 14);
		contentPane.add(lblNewLabel_1);
		
		textAreaEmpleadosSolicitados = new JTextArea();
		textAreaEmpleadosSolicitados.setEnabled(false);
		textAreaEmpleadosSolicitados.setBounds(263, 81, 104, 23);
		contentPane.add(textAreaEmpleadosSolicitados);
		
		JLabel lblNewLabel_1_1 = new JLabel("Obtenidos totales");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(263, 115, 133, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textAreaEmpleadosObtenidos = new JTextArea();
		textAreaEmpleadosObtenidos.setEnabled(false);
		textAreaEmpleadosObtenidos.setBounds(263, 140, 104, 23);
		contentPane.add(textAreaEmpleadosObtenidos);
		
		JLabel lblNewLabel_2 = new JLabel("Obtenidos en la Ronda");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(263, 174, 142, 14);
		contentPane.add(lblNewLabel_2);
		
		textAreaEmpleadosObtenidosEnRonda = new JTextArea();
		textAreaEmpleadosObtenidosEnRonda.setEnabled(false);
		textAreaEmpleadosObtenidosEnRonda.setBounds(263, 199, 104, 23);
		contentPane.add(textAreaEmpleadosObtenidosEnRonda);
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

	@Override
	public void setModel(DefaultTableModel model) {
		this.model = model;
		
	}

	@Override
	public DefaultTableModel getModel() {
		return this.model;
	}

	@Override
	public void setTextAreaEmpleadosSolicitados(String solicitados) {
		this.textAreaEmpleadosSolicitados.setText(solicitados);
		
	}

	@Override
	public void setTextAreaEmpleadosObtenidos(String obtenidos) {
		this.textAreaEmpleadosObtenidos.setText(obtenidos);
	}

	@Override
	public void setTextAreaEmpleadosObtenidosEnRonda(String obtenidos) {
		this.textAreaEmpleadosObtenidosEnRonda.setText(obtenidos);
		
	}
	
	
	
	
	
	
	
	
}


