package security_master;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexiones.Conexion2;
import Consultas.Buscar_Empleado;
import Consultas.Ver_DadosDeBaja;
import Consultas.Ver_Empleados;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;



import java.sql.*;
import javax.swing.*;
import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;


public class Operador_Consultas extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operador_Consultas frame = new Operador_Consultas();
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
	public Operador_Consultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVerTodosLos = new JButton("Ver todos los empleados");
		btnVerTodosLos.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnVerTodosLos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0){
			
				Ver_Empleados VerEmp = new Ver_Empleados();
				VerEmp.setVisible(true);
				dispose();
				
			}
		});
		btnVerTodosLos.setBounds(235, 84, 188, 23);
		contentPane.add(btnVerTodosLos);
		
		JLabel lblBienvenidoALas = new JLabel("Bienvenido a las consultas");
		lblBienvenidoALas.setForeground(Color.WHITE);
		lblBienvenidoALas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblBienvenidoALas.setBounds(217, 11, 236, 23);
		contentPane.add(lblBienvenidoALas);
		
		JButton btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestor_Operador go = new Gestor_Operador();
				go.setVisible(true);
				dispose();
				
			}
		});
		btnVolverAtras.setBounds(548, 308, 114, 23);
		contentPane.add(btnVolverAtras);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(27, 308, 114, 23);
		contentPane.add(btnSalir);
		
		JButton btnVerEmpleadosDados = new JButton("Ver empleados dados de baja");
		btnVerEmpleadosDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Ver_DadosDeBaja bajas = new Ver_DadosDeBaja();
				bajas.setVisible(true);
				dispose();
				
				
				
				
			}
		});
		btnVerEmpleadosDados.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnVerEmpleadosDados.setBounds(235, 135, 188, 23);
		contentPane.add(btnVerEmpleadosDados);
		
		JButton btnBuscarUnEmpleado = new JButton("Buscar un empleado");
		btnBuscarUnEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Buscar_Empleado buscar = new Buscar_Empleado();
				buscar.setVisible(true);
				dispose();
				
				
			}
		});
		btnBuscarUnEmpleado.setFont(new Font("Tahoma", Font.ITALIC, 11));
		btnBuscarUnEmpleado.setBounds(235, 184, 188, 23);
		contentPane.add(btnBuscarUnEmpleado);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\ProyectoFinal\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label.setBounds(0, 0, 672, 342);
		contentPane.add(label);
	}
}
