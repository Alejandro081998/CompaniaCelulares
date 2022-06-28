package extras;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementacion.Metodos;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class llamar extends JFrame {

	private JPanel contentPane;
	private static llamar llamar;
	private DefaultListModel<String> listaTurnos = new DefaultListModel<>();
	private DefaultComboBoxModel<Integer> listaPuestos = new DefaultComboBoxModel<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					llamar = new llamar();
					llamar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public llamar() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 216, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTest = new JLabel("EJECUTANDO TEST...");
		lblTest.setBounds(36, 23, 138, 14);
		contentPane.add(lblTest);

		// lblTest.setVisible(false);

		JList listaTickets = new JList();
		// listaTickets.setBounds(10, 48, 175, 243);

		listaTickets.setModel(listaTurnos);
		listaTickets.setVisibleRowCount(2);
		listaTickets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		for(String s : Metodos.Test()) {
			listaTurnos.addElement(s);
		}
		
		lblTest.setText("TEST TERMINADO");

		JScrollPane scrollLista;
		scrollLista = new JScrollPane();
		scrollLista.setBounds(10, 48, 177, 245);
		scrollLista.setViewportView(listaTickets);

		contentPane.add(scrollLista);

	}
}
