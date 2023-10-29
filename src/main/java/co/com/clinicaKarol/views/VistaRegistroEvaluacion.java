package co.com.clinicaKarol.views;

import javax.persistence.EntityManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import co.com.clinicaKarol.DAO.EvaluacionesDao;
import co.com.clinicaKarol.DAO.PacienteDao;
import co.com.clinicaKarol.Datos.OpcionesCodigos;
import co.com.clinicaKarol.entityFactory.Factory;
import co.com.clinicaKarol.modelo.Evaluaciones;
import co.com.clinicaKarol.modelo.Paciente;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;


public class VistaRegistroEvaluacion {
    private JFrame frmClinicaX;
    private JComboBox comboBox;
    private JComboBox comboBox_1;
    private OpcionesCodigos opcionesCodigos = new OpcionesCodigos();
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
	private JButton btnAtras;
	private JLabel labelAtras;
	String itemDato = "";
	Paciente paciente;

    public void Iniciar() {
        EventQueue.invokeLater(() -> {
            try {
                VistaRegistroEvaluacion window = new VistaRegistroEvaluacion(this.paciente);
                window.frmClinicaX.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @wbp.parser.entryPoint
     */
    public VistaRegistroEvaluacion(Paciente paci) {
    	this.paciente = paci;
        initialize();
        cargarDatosEnComboBox();
    }

    private void initialize() {
        frmClinicaX = new JFrame();
        frmClinicaX.setTitle("Evaluacion Paciente");
        frmClinicaX.setBounds(100, 100, 1050, 600);
        frmClinicaX.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmClinicaX.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Evaluacion del Paciente");
        lblNewLabel.setBounds(423, 77, 141, 40);
        frmClinicaX.getContentPane().add(lblNewLabel);

        comboBox = new JComboBox(); // Reemplaza los elementos con los que desees inicializar el JComboBox
        comboBox.setBounds(36, 128, 821, 40);
        frmClinicaX.getContentPane().add(comboBox);
        
        comboBox_1 = new JComboBox();
        comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0: No hay dificultad", "1: Dificultad Ligera", "2: Dificultad Moderada", "3: Dificultad Grave", "4: Dificultad Completa", "8: Sin Especificar", "9: No aplicable"}));
        comboBox_1.setBounds(878, 128, 146, 40);
        frmClinicaX.getContentPane().add(comboBox_1);
        
        
        JButton btnMostrarIndice = new JButton("Registrar");
        btnMostrarIndice.setBounds(707, 179, 150, 40);
        frmClinicaX.getContentPane().add(btnMostrarIndice);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(VistaRegistroEvaluacion.class.getResource("/co/com/clinicaKarol/imagenes/2.png")));
        lblNewLabel_1.setBounds(915, 11, 109, 106);
        frmClinicaX.getContentPane().add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(VistaRegistroEvaluacion.class.getResource("/co/com/clinicaKarol/imagenes/5.png")));
        lblNewLabel_2.setBounds(10, 179, 964, 371);
        frmClinicaX.getContentPane().add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon(VistaRegistroEvaluacion.class.getResource("/co/com/clinicaKarol/imagenes/1.png")));
        lblNewLabel_3.setBounds(56, 11, 314, 106);
        frmClinicaX.getContentPane().add(lblNewLabel_3);


        btnMostrarIndice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = comboBox.getSelectedIndex();
                
                if (selectedIndex != -1) {
                	int aux = (comboBox_1.getSelectedIndex() + 1);
                	
                	itemDato += (aux + ",");
                    System.out.println("Índice seleccionado en el ComboBox: " + selectedIndex);
                    opcionesCodigos.eliminarDato(selectedIndex);
                    cargarDatosEnComboBox();
                } else {
                    System.out.println("Ningún elemento seleccionado en el ComboBox.");
                }
            }
        });
        
        btnAtras = new JButton();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				itemDato=itemDato.substring(0, itemDato.length() - 1);
				System.out.println(itemDato);
				GuardarInfo();
				VistaRegistroDatos usuario = new VistaRegistroDatos();
				usuario.Iniciar();
				frmClinicaX.dispose();				
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
		frmClinicaX.getContentPane().add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);



    }

    private void cargarDatosEnComboBox() {
        String[] datos = this.opcionesCodigos.getListaDeStrings().toArray(new String[0]);
        comboBox.setModel(new DefaultComboBoxModel<>(datos));
    }
    
    public void GuardarInfo() {
    	
    	
    	EntityManager em = Factory.crearCon();
		 
		PacienteDao xd = new PacienteDao(em);
		
		 Evaluaciones evaluaciones = new Evaluaciones(this.itemDato,this.paciente);
		 
		 
		 EvaluacionesDao evaluacionesDao = new EvaluacionesDao(em);
		 
		 em.getTransaction().begin();	
		 evaluacionesDao.Guardar(evaluaciones);	 
		 PacienteDao pacienteDao = new PacienteDao(em);
		 pacienteDao.Guardar(this.paciente);
		 
		 em.getTransaction().commit();// cambios permanentes
		 em.close();// cierra la conexion
		
    	
    }
}
