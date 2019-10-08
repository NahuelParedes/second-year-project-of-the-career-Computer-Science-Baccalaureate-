package security_master;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexiones.Conexion2;
import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Gestor_Operador extends JFrame {

	private JPanel contentPane;

	
	public Gestor_Operador() {
		setTitle("Operador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 377, 289);
		contentPane.add(panel);
		
		JButton btnAltaEmpleado = new JButton("Alta Empleado");
		btnAltaEmpleado.setBounds(290, 98, 167, 23);
		btnAltaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Alta_EmpleadoOPERADOR Alta_Em = new Alta_EmpleadoOPERADOR();
				Alta_Em.setVisible(true);
				dispose();
			}
		});
		panel.setLayout(null);
		panel.add(btnAltaEmpleado);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
				
				
				

				/* conecta la base de datos */
				
				Conexion2 llamada=new Conexion2();

				   
	             llamada.getConnection();
	       
	 
				
					
				Connection pruebaCn=Conexion2.getConnection();
				
				
				/* conecta la base de datos */
				
				if (pruebaCn!=null) {
				
					java.sql.Statement stm = null;
					try {
						stm = pruebaCn.createStatement();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		
				
				
				
				
				}
				
				
				
				
				
				
				Operador_Consultas Consultas = new Operador_Consultas();
				Consultas.setVisible(true);
				dispose();
	
			
				
			}
		});
		btnConsultas.setBounds(290, 212, 167, 23);
		panel.add(btnConsultas);
		
		JLabel lblGestionDeEmpleados = new JLabel("Gestion de Empleados del Operador");
		lblGestionDeEmpleados.setForeground(Color.WHITE);
		lblGestionDeEmpleados.setBounds(208, 11, 373, 34);
		lblGestionDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblGestionDeEmpleados);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal main = new Principal();
				main.setVisible(true);
				dispose();
				
			}
		});
		btnAtras.setBounds(571, 304, 76, 23);
		panel.add(btnAtras);
		
		JButton btnContratacionServicio = new JButton("Contratacion Servicio");
		btnContratacionServicio.setBounds(290, 153, 167, 23);
		panel.add(btnContratacionServicio);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(675, 304, 76, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		panel.add(btnSalir);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Nahuel\\Desktop\\Programacion\\security_master\\Imagenes\\seguridad_iconos-01.png"));
		label_1.setBounds(83, 56, 363, 259);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Nahuel\\Desktop\\Programacion\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label.setBounds(0, 0, 774, 352);
		panel.add(label);
	}
		
	}


