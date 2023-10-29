package co.com.clinicaKarol.views;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import co.com.clinicaKarol.DAO.PacienteDao;
import co.com.clinicaKarol.entityFactory.Factory;
import co.com.clinicaKarol.modelo.Paciente;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaRegistroDatos {

	private JFrame frame;
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JLabel lblEdad;
	private JTextField textFieldDocumento;
	private JTextField textFieldTelefono;
	private JTextField textFieldFonoAudiologo;
	private JLabel lblDocumento;
	private JLabel lblTelefono;
	private JLabel lblFonoaudilogo;
	private JLabel lblDiagnostico;
	private JLabel lblTitulo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel labelAtras;
	private JButton btnAtras;
	private JTextArea textAreaDiagnostico;
	private Paciente paciente;

	/**
	 * Launch the application.
	 */
	public void Iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRegistroDatos window = new VistaRegistroDatos();
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
	public VistaRegistroDatos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Formulario De Datos Personales");
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(363, 90, 352, 30);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		JLabel lblNombre = new JLabel("Nombres y Apellidos");
		lblNombre.setBounds(234, 90, 119, 26);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER); 
		frame.getContentPane().add(lblNombre);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(363, 140, 352, 30);
		frame.getContentPane().add(textFieldEdad);
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(234, 140, 119, 26);
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER); 
		frame.getContentPane().add(lblEdad);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setColumns(10);
		textFieldDocumento.setBounds(363, 190, 352, 30);
		frame.getContentPane().add(textFieldDocumento);
		lblDocumento = new JLabel("Documento");
		lblDocumento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDocumento.setBounds(234, 190, 119, 26);
		frame.getContentPane().add(lblDocumento);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(363, 240, 352, 30);
		frame.getContentPane().add(textFieldTelefono);
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setBounds(234, 240, 119, 26);
		frame.getContentPane().add(lblTelefono);
		
		textFieldFonoAudiologo = new JTextField();
		textFieldFonoAudiologo.setColumns(10);
		textFieldFonoAudiologo.setBounds(363, 286, 352, 30);
		frame.getContentPane().add(textFieldFonoAudiologo);
		lblFonoaudilogo = new JLabel("Evaluador");
		lblFonoaudilogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFonoaudilogo.setBounds(234, 288, 119, 26);
		frame.getContentPane().add(lblFonoaudilogo);
		
		
		textAreaDiagnostico = new JTextArea();
		textAreaDiagnostico.setBounds(363, 346, 352, 125);
		frame.getContentPane().add(textAreaDiagnostico);
		lblDiagnostico = new JLabel("DiagnosticoMedico");
		lblDiagnostico.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagnostico.setBounds(234, 382, 119, 26);
		frame.getContentPane().add(lblDiagnostico);
		
		
		
		lblTitulo = new JLabel("Registro de Datos Personales");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTitulo.setBounds(405, 11, 194, 47);
		frame.getContentPane().add(lblTitulo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VistaRegistroDatos.class.getResource("/co/com/clinicaKarol/imagenes/4.png")));
		lblNewLabel.setBounds(10, 90, 227, 412);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VistaRegistroDatos.class.getResource("/co/com/clinicaKarol/imagenes/2.png")));
		lblNewLabel_1.setBounds(842, 11, 132, 109);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VistaRegistroDatos.class.getResource("/co/com/clinicaKarol/imagenes/8.png")));
		lblNewLabel_2.setBounds(725, 140, 249, 350);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultar.setBounds(405, 501, 119, 38);
		btnConsultar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

				VistaCRUD vista2 = new VistaCRUD();
				vista2.Iniciar();
				frame.dispose();
				//dispose();
			}
		});
		btnConsultar.setLayout(null);
		btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnConsultar.setBackground(SystemColor.window);
		frame.getContentPane().add(btnConsultar);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnContinuar.setBounds(580, 501, 119, 38);
		btnContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				guardarDatos();
				
				VistaRegistroEvaluacion vista = new VistaRegistroEvaluacion(paciente);
				vista.Iniciar();
				frame.dispose();
				//dispose();
			}
		});
		btnContinuar.setLayout(null);
		btnContinuar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnContinuar.setBackground(SystemColor.window);
		frame.getContentPane().add(btnContinuar);
		
		btnAtras = new JButton();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VistaInicio usuario = new VistaInicio();
				usuario.Iniciar();
				System.out.println("ola");
				frame.dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		frame.getContentPane().add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
	}
	
	private void guardarDatos() {
	    String nombre = textFieldNombre.getText();
	    int edad = Integer.parseInt(textFieldEdad.getText());
	    String documento = textFieldDocumento.getText();
	    String telefono = textFieldTelefono.getText();
	    
	    String fonoAudiologo = textFieldFonoAudiologo.getText();
	    
	    String diagnostico = textAreaDiagnostico.getText();

	   
	    System.out.println("Nombre: " + nombre);
	    System.out.println("Edad: " + edad);
	    System.out.println("Documento: " + documento);
	    System.out.println("Teléfono: " + telefono);
	    System.out.println("Fonoaudiólogo: " + fonoAudiologo);
	    System.out.println("Diagnóstico Médico: " + diagnostico);

	    paciente = new Paciente(documento,nombre,edad,telefono,fonoAudiologo,
	    		diagnostico);
		 
		 
	}

}
