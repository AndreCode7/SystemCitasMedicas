package vistasSystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class VentanaAcceso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAcceso frame = new VentanaAcceso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAcceso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Acceso - Centro de Salud");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(28, 11, 369, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(96, 79, 72, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Contraseña:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(66, 123, 102, 33);
		contentPane.add(lblNewLabel_1_1);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtUsuario.setBounds(178, 81, 136, 29);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtContraseña.setBounds(178, 127, 136, 29);
		contentPane.add(txtContraseña);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String usuario=txtUsuario.getText();
				String clave= new String(txtContraseña.getPassword());
				
				if (usuario.equals("salud")&& clave.equals("12345")) 
				{
					JOptionPane.showMessageDialog(null,"Acceso Permitido");
					
					MainVentana ventanaPrincipal = new MainVentana();
					ventanaPrincipal.setVisible(true);
					
					dispose();
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Acceso Denegado. Datos incorrectos ","Error",JOptionPane.ERROR_MESSAGE);
				
					txtUsuario.setText("");
					txtContraseña.setText("");
					txtUsuario.requestFocus();
				}
				
				
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnIngresar.setBounds(178, 189, 147, 33);
		contentPane.add(btnIngresar);

	}
}
