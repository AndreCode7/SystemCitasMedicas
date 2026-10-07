package vistasSystem;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistrosCitas extends JFrame {
	
	private GestorMemoria gestor;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JTextField txtNombre;
	private JTextField txtTelefono;

	public VentanaRegistrosCitas(GestorMemoria gestorPrincipal) {
		this.gestor = gestorPrincipal;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI: ");
		lblDni.setBounds(72, 158, 48, 14);
		contentPane.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(113, 155, 96, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad: ");
		lblEdad.setBounds(548, 186, 48, 14);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(586, 183, 62, 20);
		contentPane.add(txtEdad);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(241, 158, 62, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(306, 155, 220, 20);
		contentPane.add(txtNombre);
		
		JLabel lblDoctores = new JLabel("Doctores: ");
		lblDoctores.setBounds(241, 213, 76, 17);
		contentPane.add(lblDoctores);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(126, 210, 96, 20);
		contentPane.add(txtTelefono);
		
		JComboBox<String> cbDoctores = new JComboBox<String>();
		cbDoctores.setBounds(306, 210, 220, 22);
		contentPane.add(cbDoctores);
		
		JLabel lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setBounds(58, 210, 62, 20);
		contentPane.add(lblTelefono);
		
		JLabel lblTitulo = new JLabel("Sistema - Centro de Salud");

		java.util.ArrayList<Doctor> listaDoctores = gestor.obtenerDoctores();


		for (int i = 0; i < listaDoctores.size(); i++) {
		    Doctor doc = listaDoctores.get(i);
		    cbDoctores.addItem(doc.getNombre());
		}
		cbDoctores.setSelectedIndex(-1);
		
		lblTitulo.setBackground(new Color(0, 153, 204));
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 0, 683, 59);
		contentPane.add(lblTitulo);
		
		JLabel lblTituloMenu = new JLabel("Menú Registro - Citas Pacientes ");
		lblTituloMenu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTituloMenu.setBounds(187, 70, 339, 59);
		contentPane.add(lblTituloMenu);
		
		JLabel lblHora = new JLabel("Hora de Cita: ");
		lblHora.setBounds(360, 260, 89, 14);
		contentPane.add(lblHora);
		
		JLabel lblFecha = new JLabel("Fecha de Cita: ");
		lblFecha.setBounds(133, 260, 89, 14);
		contentPane.add(lblFecha);
		
		JButton btnAnular = new JButton("Anular");
		btnAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    String dniTexto = txtDni.getText();
				    
				    if (dniTexto.isEmpty()) {
				        javax.swing.JOptionPane.showMessageDialog(null, "Por favor ingrese el DNI del paciente para anular su cita.");
				        return;
				    }
				    
				    int dni = Integer.parseInt(dniTexto);
				    gestor.anularCita(dni);
				    
				    javax.swing.JOptionPane.showMessageDialog(null, "Se ha procesado la anulación de la cita para el DNI: " + dni);
				    txtDni.setText("");
				    
				} catch (NumberFormatException ex) {
				    javax.swing.JOptionPane.showMessageDialog(null, "Error: El DNI debe contener solo números.");
				}
			}
		});
		btnAnular.setBounds(306, 325, 96, 33);
		contentPane.add(btnAnular);
		
		JComboBox<String> cbFechaCita = new JComboBox<String>();
		cbFechaCita.setModel(new DefaultComboBoxModel<String>(new String[] {"", "07/10/2026", "08/10/2026", "09/10/2026"}));
		cbFechaCita.setBounds(232, 256, 118, 18);
		contentPane.add(cbFechaCita);
		
		JComboBox<String> cbhoraCita = new JComboBox<String>();
		cbhoraCita.setModel(new DefaultComboBoxModel<String>(new String[] {"", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00"}));
		cbhoraCita.setActionCommand("");
		cbhoraCita.setBounds(437, 256, 128, 18);
		contentPane.add(cbhoraCita);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String dniTexto = txtDni.getText();
				    String nombre = txtNombre.getText();
				    String edadTexto = txtEdad.getText();
				    String telefonoTexto = txtTelefono.getText();
				    
				    if (cbDoctores.getSelectedIndex() == -1 || cbFechaCita.getSelectedIndex() <= 0 || cbhoraCita.getSelectedIndex() <= 0) {
				        javax.swing.JOptionPane.showMessageDialog(null, "Seleccione un Doctor, Fecha y Hora válidas.");
				        return; 
				    }
				    
				    int indiceDoctor = cbDoctores.getSelectedIndex();
				    Doctor doctor = gestor.obtenerDoctores().get(indiceDoctor);
				    String fecha = cbFechaCita.getSelectedItem().toString();
				    String hora = cbhoraCita.getSelectedItem().toString();
				    
				    if (dniTexto.isEmpty() || nombre.isEmpty() || edadTexto.isEmpty() || telefonoTexto.isEmpty()) {
				        javax.swing.JOptionPane.showMessageDialog(null, "Debe completar todos los datos.");
				        return;
				    }
				    
				    int dni = Integer.parseInt(dniTexto);
				    int edad = Integer.parseInt(edadTexto);
				    int telefono = Integer.parseInt(telefonoTexto);
				    
				    Paciente paciente = new Paciente(dni, nombre, edad, telefono);
				    Cita nuevaCita = new Cita(paciente, doctor, fecha, hora);
				    
				    gestor.registrarCita(nuevaCita);
				    javax.swing.JOptionPane.showMessageDialog(null, "¡Cita registrada con éxito!");
				    
				    txtDni.setText("");
				    txtNombre.setText("");
				    txtEdad.setText("");
				    txtTelefono.setText("");
				    cbDoctores.setSelectedIndex(-1);
				    cbFechaCita.setSelectedIndex(0);
				    cbhoraCita.setSelectedIndex(0);
				    
				} catch (NumberFormatException ex) {
				    javax.swing.JOptionPane.showMessageDialog(null, "Error: DNI, edad y teléfono deben ser números.");
				}
			}
		});
		btnRegistrar.setBounds(142, 325, 96, 33);
		contentPane.add(btnRegistrar);
		
		JButton btnAtras = new JButton("Principal");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(469, 325, 96, 33);
		contentPane.add(btnAtras);

	}
}
