package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import implementacion.Metodos;
import implementacion.implementacionTDA;
import interfaz.AdministradorDeColas;
import loguin.loguin;
import popUp.popUp;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

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
		Metodos met = new Metodos();
		Metodos.celu.inicializar(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SACAR NUMERO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				popUp p = new popUp("SU NUMERO DE ATENCION ES: " + Metodos.celu.acolar(1) + " \n\n AGUARDE A SER LLAMADO");
				p.setLocationRelativeTo(principal);
				p.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(76, 79, 144, 56);
		contentPane.add(btnNewButton);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loguin l = new loguin();
				l.setLocationRelativeTo(principal);
				l.setVisible(true);
				//dispose();
			}
		});
		btnAdmin.setBounds(199, 0, 89, 23);
		contentPane.add(btnAdmin);
		
		JLabel lblNewLabel = new JLabel("BIENVENIDO CLIENTE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(76, 54, 144, 14);
		contentPane.add(lblNewLabel);
	}

}
