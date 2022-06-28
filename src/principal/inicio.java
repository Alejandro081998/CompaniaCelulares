package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import extras.popUp;
import extras.principal;
import implementacion.Metodos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inicio extends JFrame {

	private JPanel contentPane;
	private static inicio inicio;
	private JTextField txtVendedores;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio = new inicio();
					inicio.setLocationRelativeTo(null);
					inicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public inicio() {
		Metodos met = new Metodos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 248, 145);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("INGRESE CANTIDAD DE VENDEDORES:");
		lblNewLabel.setBounds(10, 11, 212, 23);
		contentPane.add(lblNewLabel);

		txtVendedores = new JTextField();
		txtVendedores.setBounds(66, 40, 86, 20);
		contentPane.add(txtVendedores);
		txtVendedores.setColumns(10);

		JButton btnIniciar = new JButton("INICIAR PROGRAMA");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!txtVendedores.getText().isEmpty()) {

					int puestos = Integer.parseInt(txtVendedores.getText().toString());

					if (puestos > 0) {

						Metodos.celu.inicializar(puestos);

						dispose();

						principal pp = new principal();
						pp.setLocationRelativeTo(inicio);
						pp.setVisible(true);

						popUp p = new popUp("SISTEMA INICIALIZADO");
						p.setLocationRelativeTo(inicio);
						p.setVisible(true);

					} else {
						popUp p = new popUp("INGRESE UN DATO VALIDO");
						p.setLocationRelativeTo(inicio);
						p.setVisible(true);

					}

				} else {
					popUp p = new popUp("COMPLETE TODOS LOS CAMPOS");
					p.setLocationRelativeTo(inicio);
					p.setVisible(true);

				}

			}
		});
		btnIniciar.setBounds(37, 71, 147, 23);
		contentPane.add(btnIniciar);
	}
}
