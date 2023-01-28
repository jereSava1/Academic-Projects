package vista;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dto.UsuarioPuntuadoDTO;


//La utilizamos para ver los empleados pretensos de UN solo ticket
public class VistaListaDeAsignaciones extends JFrame implements IListaDeAsignaciones {

	private JPanel contentPane;
	private JButton btnVolver;
	private DefaultListModel<UsuarioPuntuadoDTO> listaAsignacion;
	private JButton btnConfirmar;
	private JScrollPane scrollPane;
	private JList<UsuarioPuntuadoDTO> list;
	
	@Override
	public void setListaDeAsignacion(DefaultListModel<UsuarioPuntuadoDTO> lista) {
		this.listaAsignacion = lista;
		this.list.setModel(lista);
	}

	public VistaListaDeAsignaciones() {
		
		//List<UsuarioPuntuado> listaEmpleados = ticket.getListaDeAsignaciones();
		
		setTitle("Lista de Asignaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 227, 89, 23);
		contentPane.add(btnVolver);
		listaAsignacion = new DefaultListModel<UsuarioPuntuadoDTO>();
		
		btnConfirmar = new JButton("Confirmar elecciones");
		btnConfirmar.setActionCommand("CONFIRMAR");
		btnConfirmar.setBounds(285, 228, 141, 21);
		contentPane.add(btnConfirmar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 414, 211);
		contentPane.add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
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
		this.btnConfirmar.addActionListener(actionListener);
	}
	public void success(String title, String message){
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public List<UsuarioPuntuadoDTO> getSeleccionados() {
		return list.getSelectedValuesList();
	}
}
