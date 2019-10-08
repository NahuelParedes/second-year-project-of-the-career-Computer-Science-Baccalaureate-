package security_master;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Boton_Admin extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldUsuario;
	public static JPasswordField passwordFieldContrase�a;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Boton_Admin() {
		setTitle("Security Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 600, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 362);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Admi_Contrase�a Datos = new Admi_Contrase�a();
		
		JButton ingresarContrase�a = new JButton("Ingresar");
		ingresarContrase�a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (Datos.Pass()==1 ){
						
					
					Gestor_Admin Ges_Ad = new Gestor_Admin();
					JOptionPane.showMessageDialog(null, "         �Ingreso exitoso! \n �Bienvenido al gestor de administrador!");
					
					Ges_Ad.setVisible(true);
					dispose();
					
				}
				
				else {
					
					JOptionPane.showMessageDialog(null, "Contrase�a o Usuario incorrectos, vuelva a intentarlo.");
					
					Boton_Admin Admin = new Boton_Admin();
					Admin.setVisible(true);
					dispose();
				}
				
		
				
			}
		}
		
				
		            		);
		ingresarContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ingresarContrase�a.setBounds(313, 186, 89, 23);
		panel.add(ingresarContrase�a);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(292, 97, 128, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JButton SalirContrase�a = new JButton("Salir");
		SalirContrase�a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		SalirContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 13));
		SalirContrase�a.setBounds(471, 301, 89, 23);
		panel.add(SalirContrase�a);
		
		passwordFieldContrase�a = new JPasswordField();
		passwordFieldContrase�a.setBounds(292, 145, 128, 20);
		panel.add(passwordFieldContrase�a);
		
		JLabel IngreseUsuario = new JLabel("Ingrese Usuario:");
		IngreseUsuario.setForeground(Color.WHITE);
		IngreseUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IngreseUsuario.setBounds(111, 97, 128, 17);
		panel.add(IngreseUsuario);
		
		JLabel IngreseContrase�a = new JLabel("Ingrese Contrase\u00F1a:");
		IngreseContrase�a.setForeground(Color.WHITE);
		IngreseContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 15));
		IngreseContrase�a.setBounds(112, 139, 141, 28);
		panel.add(IngreseContrase�a);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setForeground(Color.WHITE);
		lblAdministrador.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblAdministrador.setBounds(221, 11, 141, 44);
		panel.add(lblAdministrador);
		
		JButton btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Principal main = new Principal();
				main.setVisible(true);
				dispose();
				
			}
		});
		btnVolverAtras.setBounds(319, 301, 110, 23);
		panel.add(btnVolverAtras);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Nahuel\\Desktop\\fondo red.jpg"));
		label.setBounds(0, 0, 584, 338);
		panel.add(label);
	}
}
