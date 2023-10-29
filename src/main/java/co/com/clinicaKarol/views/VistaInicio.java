package co.com.clinicaKarol.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;





public class VistaInicio {

	private JFrame frame;
	int xMouse, yMouse;

	/**
	 * Launch the application.
	 */
	public void Iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInicio window = new VistaInicio();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaInicio() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Evaluación funcional de usuarios con discapacidad");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaInicio.class.getResource("/co/com/clinicaKarol/imagenes/1.png")));
		lblNewLabel.setBounds(10, 11, 300, 100);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VistaInicio.class.getResource("/co/com/clinicaKarol/imagenes/2.png")));
		lblNewLabel_1.setBounds(855, 11, 119, 116);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VistaInicio.class.getResource("/co/com/clinicaKarol/imagenes/6.png")));
		lblNewLabel_2.setBounds(10, 138, 964, 412);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(12, 138, 199));
		
		JPanel btnLogin = new JPanel(); 
		btnLogin.setBounds(517, 41, 83, 70);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaRegistroDatos vista = new VistaRegistroDatos();
				vista.Iniciar();
				frame.dispose();
				//dispose();
			}
		});
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnLogin.setBackground(SystemColor.window);
		frame.getContentPane().add(btnLogin);
		
		JLabel imagenLogin = new JLabel("");
		imagenLogin.setBounds(0, 0, 80, 70);
		btnLogin.add(imagenLogin);
		imagenLogin.setHorizontalAlignment(SwingConstants.CENTER);
		imagenLogin.setIcon(new ImageIcon(VistaInicio.class.getResource("/co/com/clinicaKarol/imagenes/logo2.jpeg")));
		
		JLabel lblTitulo = new JLabel("INICIAR");
		lblTitulo.setBounds(517, 11, 83, 24);
		lblTitulo.setBackground(SystemColor.window);
		frame.getContentPane().add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Roboto Light", Font.PLAIN, 20));
		
		
	}

}
