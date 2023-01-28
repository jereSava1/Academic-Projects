package vista;

import dto.TicketSimplificadoDTO;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;

public class VistaListaTicketSimplificado extends JFrame implements KeyListener, IListaTicketSimplificado {
	private JButton btnVolver;
	private DefaultListModel<TicketSimplificadoDTO> modelLista;
	private JList list;

	public VistaListaTicketSimplificado() {
		setTitle("Lista Tickets Simplificados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 467);

		modelLista = new DefaultListModel<>();
		getContentPane().setLayout(null);
		
		btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVolver.setBounds(10, 374, 98, 43);
		btnVolver.setActionCommand("VOLVER");
		getContentPane().add(btnVolver);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 406, 353);
		getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
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
		// TODO Auto-generated method stub

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
	public void setModel(DefaultListModel<TicketSimplificadoDTO> model) {
		this.modelLista = model;
		this.list.setModel(modelLista);
	}
}
