package administrador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementacion.Metodos;
import popUp.popUp;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class administrador extends JFrame {

	private JPanel contentPane;
	private static administrador administrador;
	private DefaultComboBoxModel<Integer> listaPuestos = new DefaultComboBoxModel<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administrador = new administrador();
					administrador.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public administrador() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 246, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox comboPrioridad = new JComboBox();
		comboPrioridad.setModel(new DefaultComboBoxModel(new String[] { "BAJA", "MEDIA", "ALTA" }));
		comboPrioridad.setBounds(56, 35, 113, 22);
		contentPane.add(comboPrioridad);

		JButton btnNewButton = new JButton("SACAR NUMERO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				popUp p;

				switch (comboPrioridad.getSelectedItem().toString()) {

				case "BAJA":
					p = new popUp(
							"SU NUMERO DE ATENCION ES: " + Metodos.celu.acolar(1) + " \n\n AGUARDE A SER LLAMADO");
					p.setLocationRelativeTo(administrador);
					p.setVisible(true);
					break;

				case "MEDIA":
					p = new popUp(
							"SU NUMERO DE ATENCION ES: " + Metodos.celu.acolar(2) + " \n\n AGUARDE A SER LLAMADO");
					p.setLocationRelativeTo(administrador);
					p.setVisible(true);
					break;

				case "ALTA":
					p = new popUp(
							"SU NUMERO DE ATENCION ES: " + Metodos.celu.acolar(3) + " \n\n AGUARDE A SER LLAMADO");
					p.setLocationRelativeTo(administrador);
					p.setVisible(true);
					break;

				}
			}
		});
		btnNewButton.setBounds(43, 68, 138, 22);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("PRIORIDAD:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(67, 10, 99, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("---------------------------------------------------");
		lblNewLabel_1.setBounds(10, 101, 209, 14);
		contentPane.add(lblNewLabel_1);

		JComboBox comboPuesto = new JComboBox();
		comboPuesto.setBounds(56, 145, 113, 22);
		contentPane.add(comboPuesto);

		comboPuesto.setModel(listaPuestos);

		for (int i = 1; i <= Metodos.celu.cantPuestos(); i++) {
			listaPuestos.addElement(i);
		}

		JButton btnLlamarSiguiente = new JButton("LLAMAR SIGUIENTE");
		btnLlamarSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ticket;
				int puesto = comboPuesto.getSelectedIndex() + 1;
				popUp p;
				ticket = Metodos.celu.desacolar(puesto);

				if (ticket == -1 || ticket == -2 || ticket == 0) {

					if (ticket == -1) {
						p = new popUp("NO HAY CLIENTES ESPERANDO");
						p.setLocationRelativeTo(administrador);
						p.setVisible(true);
					}

					if (ticket == -2) {
						p = new popUp("TU PUESTO NO PUEDE RECIBIR CLIENTES, LIBERALO");
						p.setLocationRelativeTo(administrador);
						p.setVisible(true);
					}

					if (ticket == 0) {
						p = new popUp("EL SISTEMA NO SE HA INICIALIZADO");
						p.setLocationRelativeTo(administrador);
						p.setVisible(true);
					}

				} else {
					p = new popUp("TURNO NUMERO: " + ticket + " ACERQUESE AL PUESTO NUMERO: " + puesto);
					p.setLocationRelativeTo(administrador);
					p.setVisible(true);

				}

			}

		});
		btnLlamarSiguiente.setBounds(35, 178, 157, 22);
		contentPane.add(btnLlamarSiguiente);

		JLabel lblPuesto = new JLabel("PUESTO:");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setBounds(67, 120, 99, 14);
		contentPane.add(lblPuesto);

		JButton btnDisponible = new JButton("DISPONIBLE");
		btnDisponible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				popUp p;
				boolean liberado;
				int puesto = comboPuesto.getSelectedIndex() + 1;
				liberado = Metodos.celu.liberarPuesto(puesto);
				
				if(liberado) {
					p = new popUp("PUESTO: " +  puesto + " LIBERADO");
					p.setLocationRelativeTo(administrador);
					p.setVisible(true);
				}else {
					p = new popUp("ERROR A LIBERAR PUESTO, PUEDE QUE YA LO HAYAS LIBERADO");
					p.setLocationRelativeTo(administrador);
					p.setVisible(true);
				}
				
			}
		});
		btnDisponible.setBounds(43, 211, 138, 22);
		contentPane.add(btnDisponible);
	}
}
