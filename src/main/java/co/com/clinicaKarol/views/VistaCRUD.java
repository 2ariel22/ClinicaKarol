package co.com.clinicaKarol.views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import co.com.clinicaKarol.DAO.PacienteDao;
import co.com.clinicaKarol.Datos.CustomTableModel;
import co.com.clinicaKarol.Datos.OpcionesCodigos;
import co.com.clinicaKarol.entityFactory.Factory;
import co.com.clinicaKarol.modelo.Paciente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VistaCRUD {

	private JFrame frame;
	private JTextField txtBuscar;
	private JTable tabla;
	private DefaultTableModel modelo;
	private JButton btnAtras;
	private JLabel labelAtras;
	private JTable table;
	private CustomTableModel customTableModel;
	private List<String> tuListaDeDatos;

	/**
	 * Launch the application.
	 */
	public void Iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCRUD window = new VistaCRUD();
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
	public VistaCRUD() {
		tuListaDeDatos = (ArrayList<String>) new OpcionesCodigos().getListaDeStrings();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Búsqueda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(400, 52, 175, 39);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER); 
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VistaInicio.class.getResource("/co/com/clinicaKarol/imagenes/2.png")));
		lblNewLabel_1.setBounds(855, 11, 119, 116);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(142, 123, 193, 35);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		frame.getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(142, 160, 193, 2);
		frame.getContentPane().add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        String documento = txtBuscar.getText();
		        if (documento != "") {
		            EntityManager em = Factory.crearCon();
		            Paciente pacien = new PacienteDao(em).BuscarId(documento);

		            String[] elementosEvaluaciones = pacien.getEvaluaciones().get(0).getDatos().split(",");
		            List<String> listaDeDatosEvaluaciones = new ArrayList<>(Arrays.asList(elementosEvaluaciones));

		            List<String> resultado = new ArrayList<>();
		        

		            for (int i = 0; i < listaDeDatosEvaluaciones.size(); i++) {
		                String datoPaciente = tuListaDeDatos.get(i);
		                String datoEvaluaciones = "<strong>:"+listaDeDatosEvaluaciones.get(i);
		              

		      
		                StringBuilder resultadoBuilder = new StringBuilder(datoPaciente);

		                // Insertar cadena2 en la posición deseada
		                int posicionInsercion = datoPaciente.indexOf("</strong></HTML>");
		                if (posicionInsercion != -1) {
		                    resultadoBuilder.insert(posicionInsercion, datoEvaluaciones);
		                }

		                // Obtener la cadena final
		                String aux = resultadoBuilder.toString();
		                resultado.add(aux);
		            }
		            tuListaDeDatos = resultado;
		            System.out.println(resultado);
		            customTableModel.setData(tuListaDeDatos);
		            customTableModel.setCurrentPage(0); // Reiniciar la página a la primera
		            customTableModel.fireTableDataChanged();
		            
		            modelo.addRow(new Object[]{
		            		pacien.getNOMBRE_APELLIDO(),
		            		pacien.getDOCUMENTO(),
		            		pacien.getEDAD(),
		            		pacien.getTELEFONO(),
		            		pacien.getDate(),
		            		pacien.getFONOAUDIOLOGO(),
		            		pacien.getDIAGNOSTICO()});
		            
		            em.close();
		        }
		        
		    }
		});



		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(10, 123, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		frame.getContentPane().add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 950, 328);
		frame.getContentPane().add(panel);
		
		
	
		
		int filasPorPagina = 4;
		
		customTableModel = new CustomTableModel(tuListaDeDatos, filasPorPagina);

		JTable table = new JTable(customTableModel);
		

		// Aumenta el tamaño de la fuente de la tabla
		Font font = new Font("Arial", Font.PLAIN, 14); // Cambia "Arial" y 16 según tus preferencias
		table.setFont(font);

		// Aumenta el tamaño de las filas y columnas
		table.setRowHeight(70); // Cambia 30 según tus preferencias
		table.getColumnModel().getColumn(0).setPreferredWidth(200); // Cambia 200 según tus preferencias

		// Crea un JScrollPane si tienes muchas filas y columnas
		JScrollPane scrollPane = new JScrollPane(table);

		// Crea un panel o usa uno existente
	

		// Agrega la JTable o el JScrollPane al panel
		panel.add("Evaluacion",scrollPane);
		
		JTable table2 = new JTable();
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) table2.getModel();
		modelo.addColumn("Nombre y Apellido");
		modelo.addColumn("Documento");
		modelo.addColumn("Edad");
		modelo.addColumn("Telefono");
		modelo.addColumn("Fecha");
		modelo.addColumn("Fonoaudiologo");
		modelo.addColumn("Diagnostico");
		
		JScrollPane scroll_table2 = new JScrollPane(table2);
		//panel.addTab("Reservas", scroll_table2, null);
		panel.add("Paciente",scroll_table2);
		scroll_table2.setVisible(true);
		
		
		// Crear botones de "Anterior" y "Siguiente"
        JButton btnAnterior = new JButton("Anterior");
        JButton btnSiguiente = new JButton("Siguiente");

        // Agregar ActionListener para los botones
        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customTableModel.previousPage();
            }
        });

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customTableModel.nextPage();
            }
        });

        // Agregar los botones al panel
        btnAnterior.setLayout(null);
        btnAnterior.setBackground(Color.BLUE);
        btnAnterior.setBounds(30, 508, 102, 36);
		frame.getContentPane().add(btnAnterior);
       
		btnSiguiente.setLayout(null);
		btnSiguiente.setBackground(Color.BLUE);
		
		btnSiguiente.setBounds(145, 508, 102, 36);
		frame.getContentPane().add(btnSiguiente);

		// Ajusta la tabla al ancho del panel
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(669, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		frame.getContentPane().add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(848, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		frame.getContentPane().add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(VistaCRUD.class.getResource("/co/com/clinicaKarol/imagenes/1.png")));
		lblNewLabel_2.setBounds(60, 11, 308, 100);
		frame.getContentPane().add(lblNewLabel_2);
		
		 btnAtras = new JButton();
		 btnAtras.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					VistaRegistroDatos usuario = new VistaRegistroDatos();
					usuario.Iniciar();
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
	
	

}
