package security_master;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexiones.Conexion2;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/* los mas importantes */
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
/* los mas importantes */

public class Gestor_Admin extends JFrame {
	
	private JPanel contentPane;

	
	public Gestor_Admin() {
		setTitle("Gestor de Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 673, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 657, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAltaEmpleado = new JButton("Alta Empleado");
		
		btnAltaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				Alta_EmpleadoADMIN Alta_EmA = new Alta_EmpleadoADMIN();
				Alta_EmA.setVisible(true);
				dispose();



				
				
				
				
				
				
				
				
					
				
				
				
				
				
					
			}
		});
		
		JButton btnCambioDeCategoria = new JButton("Cambio de Categoria de empleado");
		btnCambioDeCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Cambio_Categoria cc = new Cambio_Categoria();
				cc.setVisible(true);
				dispose();
				
				
				
				
			}
		});
		btnCambioDeCategoria.setBounds(216, 273, 238, 23);
		panel.add(btnCambioDeCategoria);
		btnAltaEmpleado.setBounds(201, 84, 211, 23);
		panel.add(btnAltaEmpleado);
		
		JButton btnBajaEmpleado = new JButton("Baja Empleado");
		btnBajaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				Baja_Empleado Baja = new Baja_Empleado();
				Baja.setVisible(true);
				dispose();
				
				
				
				

				
				
				
				
				
				
				
			}
		});
		btnBajaEmpleado.setBounds(242, 130, 195, 23);
		panel.add(btnBajaEmpleado);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.setBounds(242, 221, 195, 23);
		panel.add(btnConsultas);
		
		JLabel lblGestionDeEmpleados = new JLabel("Gestion de Empleados del Administrador");
		lblGestionDeEmpleados.setForeground(Color.WHITE);
		lblGestionDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGestionDeEmpleados.setBounds(119, 11, 418, 34);
		panel.add(lblGestionDeEmpleados);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Principal home = new Principal();
				home.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(23, 441, 95, 23);
		panel.add(btnAtras);
		
		JButton btnContratacionServicio = new JButton("Contratacion Servicio");
		btnContratacionServicio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
			
				ContratacionDeServicio Contratacion = new ContratacionDeServicio();
				Contratacion.setVisible(true);
				dispose();
			
			}
		});
		btnContratacionServicio.setBounds(242, 177, 195, 23);
		panel.add(btnContratacionServicio);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnSalir.setBounds(540, 441, 86, 23);
		panel.add(btnSalir);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Nahuel\\Desktop\\Programacion\\security_master\\Imagenes\\seguridad_iconos-01.png"));
		label_1.setBounds(25, 84, 387, 252);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\ProyectoFinal\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label.setBounds(0, 0, 647, 479);
		panel.add(label);
	}
}
