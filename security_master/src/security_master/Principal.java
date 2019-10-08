package security_master;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Dimension;
import java.awt.Color;

public class Principal extends JFrame {

	private JPanel contentPane;


	public Principal() {
		
		
		setTitle("Security Master");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 738, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 727, 351);
		panel.setToolTipText("");
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBienvenidosASecurity = new JLabel("Bienvenidos a Security Master");
		lblBienvenidosASecurity.setForeground(Color.WHITE);
		lblBienvenidosASecurity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBienvenidosASecurity.setBounds(212, 0, 295, 49);
		panel.add(lblBienvenidosASecurity);
		
		JLabel lblIngresarComo = new JLabel("INGRESAR COMO:");
		lblIngresarComo.setForeground(Color.WHITE);
		lblIngresarComo.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblIngresarComo.setBounds(261, 74, 167, 61);
		panel.add(lblIngresarComo);
		
		JButton btnOperador = new JButton("Operador");
		btnOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gestor_Operador Ges_Op = new Gestor_Operador();
				Ges_Op.setVisible(true);
				dispose();
				
			}
		});
		btnOperador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOperador.setBounds(261, 161, 167, 37);
		panel.add(btnOperador);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Boton_Admin Admin = new Boton_Admin();
				Admin.setVisible(true);
				dispose();
				
			}
		});
		btnAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdministrador.setBounds(261, 258, 167, 31);
		panel.add(btnAdministrador);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBounds(656, 317, 61, 23);
		panel.add(btnSalir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Nahuel\\Desktop\\Imagen Login.jpg"));
		label.setBounds(0, 0, 777, 363);
		panel.add(label);
	}
}
