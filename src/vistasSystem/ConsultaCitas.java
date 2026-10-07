package vistasSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ConsultaCitas extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaCitas;
	private GestorMemoria gestor;
	private javax.swing.table.DefaultTableModel modeloTabla;

	/**
	 * Create the frame.
	 */
	public ConsultaCitas(GestorMemoria gestorPrincipal) {
		
		this.gestor = gestorPrincipal;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Sistema - Centro de Salud");
		lblTitulo.setBackground(new Color(0, 153, 204));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 683, 59);
		contentPane.add(lblTitulo);
		
		JLabel lblTituloMenu = new JLabel("Menú Consulta - Registros Citas");
		lblTituloMenu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTituloMenu.setBounds(181, 56, 339, 59);
		contentPane.add(lblTituloMenu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 126, 558, 262);
		contentPane.add(scrollPane);
		
		tablaCitas = new JTable();
		scrollPane.setViewportView(tablaCitas);
		
		JButton btnCitasRegistrada = new JButton("Citas Registrada");
		btnCitasRegistrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloTabla.setColumnCount(0);
				modeloTabla.setRowCount(0);

				modeloTabla.addColumn("DNI Paciente");
				modeloTabla.addColumn("Paciente");
				modeloTabla.addColumn("Doctor");
				modeloTabla.addColumn("Fecha");
				modeloTabla.addColumn("Hora");

				try {
				    for (Cita cita : gestor.obtenerCitas()) {
				        int dni = cita.getPaciente().getDni();
				        String nombrePaciente = cita.getPaciente().getNombre();
				        String nombreDoctor = cita.getDoctor().getNombre(); 
				        String fecha = cita.getFecha();
				        String hora = cita.getHora();
				        
				        modeloTabla.addRow(new Object[]{dni, nombrePaciente, nombreDoctor, fecha, hora});
				    }
				} catch (Exception ex) {
				    javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar las citas: " + ex.getMessage());
				}
			}
		});
		btnCitasRegistrada.setBounds(90, 421, 135, 43);
		contentPane.add(btnCitasRegistrada);
		
		JButton btnMostrarHorarios = new JButton("Mostrar Horarios");
		btnMostrarHorarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				modeloTabla.setColumnCount(0); 
				modeloTabla.setRowCount(0);    

				modeloTabla.addColumn("Día");
				modeloTabla.addColumn("Turno");
				modeloTabla.addColumn("Hora Disponible");

				String[] dias = {"07/10", "08/10", "09/10"};

				for (String dia : dias) {
				    modeloTabla.addRow(new Object[]{dia, "Mañana", "07:00 - 08:00"});
				    modeloTabla.addRow(new Object[]{dia, "Mañana", "08:00 - 09:00"});
				    modeloTabla.addRow(new Object[]{dia, "Mañana", "09:00 - 10:00"});
				    modeloTabla.addRow(new Object[]{dia, "Mañana", "10:00 - 11:00"});
				    modeloTabla.addRow(new Object[]{dia, "Mañana", "11:00 - 12:00"});
				    modeloTabla.addRow(new Object[]{dia, "Tarde",  "12:00 - 13:00"});
				    modeloTabla.addRow(new Object[]{dia, "Tarde",  "13:00 - 14:00"});
				}
			}
		});
		btnMostrarHorarios.setBounds(461, 421, 135, 43);
		contentPane.add(btnMostrarHorarios);

		modeloTabla = new javax.swing.table.DefaultTableModel();
		modeloTabla.setColumnCount(0);
		modeloTabla.setRowCount(0);
		modeloTabla.addColumn("DNI Paciente");
		modeloTabla.addColumn("Paciente");
		modeloTabla.addColumn("Doctor");
		modeloTabla.addColumn("Fecha");
		modeloTabla.addColumn("Hora");

		tablaCitas.setModel(modeloTabla);
		
		JButton btnAtras = new JButton("Principal");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(272, 421, 135, 43);
		contentPane.add(btnAtras);
	}
}