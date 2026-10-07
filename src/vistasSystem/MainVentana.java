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

public class MainVentana extends JFrame {
	
	private GestorMemoria gestor;
		
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaPantalla;

	
	public MainVentana() {
		
		gestor = new GestorMemoria();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 669, 535);
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
		lblTitulo.setBounds(0, 0, 651, 59);
		contentPane.add(lblTitulo);
		
		JButton btnGestorCita = new JButton("Gestión de Cita");
		btnGestorCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistrosCitas ventana = new VentanaRegistrosCitas(gestor);
				ventana.setVisible(true);
			}
		});
		btnGestorCita.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGestorCita.setBounds(38, 184, 134, 31);
		contentPane.add(btnGestorCita);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaCitas ventanaConsultas = new ConsultaCitas(gestor); 
				ventanaConsultas.setVisible(true);
			}
		});
		btnConsultas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultas.setBounds(188, 184, 134, 31);
		contentPane.add(btnConsultas);
		
		JButton btnDoctores = new JButton("Doctores");
		btnDoctores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDoctoresEnTabla();
			}
		});
		
		btnDoctores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDoctores.setBounds(348, 184, 134, 31);
		contentPane.add(btnDoctores);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 259, 446, 143);
		contentPane.add(scrollPane);
		
		tablaPantalla = new JTable();
		scrollPane.setViewportView(tablaPantalla);
		
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalir.setBounds(509, 184, 134, 31);
		contentPane.add(btnSalir);
		
		JLabel lblTituloMenu = new JLabel("Menú Principal - Centro de Salud");
		lblTituloMenu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTituloMenu.setBounds(159, 67, 339, 59);
		contentPane.add(lblTituloMenu);
	}
	
	private void cargarDoctoresEnTabla() {
        String[] columnas = {"Nombre del Doctor", "Especialidad", "Código CMP"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(null, columnas);
        
        java.util.ArrayList<Doctor> lista = gestor.obtenerDoctores();
        
        for (int i = 0; i < lista.size(); i++) {
            Doctor doc = lista.get(i);
            Object[] fila = {doc.getNombre(), doc.getEspecialidad(), doc.getCodigoCMP()};
            modelo.addRow(fila);
        }
        tablaPantalla.setModel(modelo);
    }
}
