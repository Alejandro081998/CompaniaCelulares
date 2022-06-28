package extras;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementacion.Metodos;
import implementacion.implementacionTDA;
import interfaz.AdministradorDeColas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class principal extends JFrame {

	private JPanel contentPane;
	private static principal principal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal = new principal();
					principal.setLocationRelativeTo(null);
					principal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principal() {
		// Metodos.celu.inicializar(10);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] { "PREPAGO", "ABONO", "CELULAR Y LINEA" }));
		comboTipo.setBounds(86, 79, 117, 22);
		contentPane.add(comboTipo);

		JButton btnNewButton = new JButton("SACAR NUMERO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tipoTicket = "";
				tipoTicket = comboTipo.getSelectedItem().toString();

				popUp p;

				switch (tipoTicket) {

				case "PREPAGO":
					p = new popUp("SU NUMERO DE ATENCION ES: <i>PRP" + Metodos.celu.acolar(45)
							+ "</i> <br><br>AGUARDE A SER LLAMADO");
					p.setLocationRelativeTo(principal);
					p.setVisible(true);
					break;

				case "ABONO":
					p = new popUp("SU NUMERO DE ATENCION ES: <i>ABO" + Metodos.celu.acolar(60)
							+ "</i> <br><br>AGUARDE A SER LLAMADO");
					p.setLocationRelativeTo(principal);
					p.setVisible(true);
					break;

				case "CELULAR Y LINEA":
					p = new popUp("SU NUMERO DE ATENCION ES: <i>CLI" + Metodos.celu.acolar(90)
							+ "</i> <br><br>AGUARDE A SER LLAMADO");
					p.setLocationRelativeTo(principal);
					p.setVisible(true);
					break;

				}

			}
		});
		btnNewButton.setBounds(76, 115, 144, 56);
		contentPane.add(btnNewButton);

		JButton btnAdmin = new JButton("TEST");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Metodos.celu.colaVacia()) {
					llamar l = new llamar();
					l.setLocationRelativeTo(principal);
					l.setVisible(true);
				} else {
					popUp p = new popUp("HAY CLIENTES ESPERANDO, LLAME ANTES DE HACER EL TEST");
					p.setLocationRelativeTo(principal);
					p.setVisible(true);
				}
			}
		});
		btnAdmin.setBounds(199, 0, 89, 23);
		contentPane.add(btnAdmin);

		JLabel lblNewLabel = new JLabel("BIENVENIDO CLIENTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(76, 54, 144, 14);
		contentPane.add(lblNewLabel);

		JButton btnLlamar = new JButton("LLAMAR");
		btnLlamar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (String s : Metodos.obtenerTurnos()) {

					try {
						System.out.println(s);
						Thread.sleep(2000);
					} catch (InterruptedException d) {
						// TODO Auto-generated catch block
						d.printStackTrace();
					}
				}
				System.out.println("NO HAY MAS CLIENTES EN ESPERA...");
			}
		});
		btnLlamar.setBounds(0, 0, 89, 23);
		contentPane.add(btnLlamar);

	}

}
