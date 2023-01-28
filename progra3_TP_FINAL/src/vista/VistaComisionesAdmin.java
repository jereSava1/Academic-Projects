package vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class VistaComisionesAdmin extends JFrame implements IVistaComisionesAdmin {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolver;
	private JTextArea textAreaComisionTotal;
	
	DefaultTableModel model = new DefaultTableModel();

	public VistaComisionesAdmin() {
		setTitle("Comisiones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 174);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Nombre");
		model.addColumn("Tipo de usuario");
		model.addColumn("Comision");
		table.setModel(model);
		
		JLabel lblNewLabel = new JLabel("Comision total");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(322, 196, 102, 14);
		contentPane.add(lblNewLabel);
		
		textAreaComisionTotal = new JTextArea();
		textAreaComisionTotal.setEnabled(false);
		textAreaComisionTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textAreaComisionTotal.setBounds(322, 221, 102, 22);
		contentPane.add(textAreaComisionTotal);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVolver.setBounds(10, 212, 89, 31);
		contentPane.add(btnVolver);
	}
	
	@Override
	public void setTextAreaComisionTotal(String comisionTotalAdmin) {
		this.textAreaComisionTotal.setText(comisionTotalAdmin);
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
}
