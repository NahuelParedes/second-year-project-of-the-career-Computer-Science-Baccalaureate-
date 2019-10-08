package Consultas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexiones.Conexion2;
import net.proteanit.sql.DbUtils;
import security_master.Operador_Consultas;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Buscar_Empleado extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTable table;
	private JTextField textFieldCi;
	private JTable table2;
	private JTable tableCat;
	private JTable tableFecha;
	private JTextField textFieldFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar_Empleado frame = new Buscar_Empleado();
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
	public Buscar_Empleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1107, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1081, 531);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Buscar empleado por su Nombre y Apellido", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblIngreseElNombre = new JLabel("Ingrese el nombre");
		lblIngreseElNombre.setForeground(Color.WHITE);
		lblIngreseElNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblIngreseElNombre.setBounds(35, 405, 176, 20);
		panel.add(lblIngreseElNombre);
		
		JLabel lblIngreseElApellido = new JLabel("Ingrese el apellido");
		lblIngreseElApellido.setForeground(Color.WHITE);
		lblIngreseElApellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblIngreseElApellido.setBounds(35, 445, 176, 20);
		panel.add(lblIngreseElApellido);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(201, 407, 124, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(201, 447, 124, 20);
		panel.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1076, 362);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				// ------------------------------------------------------------------------------------------	
				
				
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
								
								else {
									JOptionPane.showMessageDialog(null, "Error en la conexion...");
								}				
							
										/* aca ejecuta una consulta  */
								
								// Aca ejecuta la consulta de que muestr a los empelados en la JTABLE
								
							
						
						
						
					// ------------------------------------------------------------------------------------------	
						
						
						
						
						try{
							
				
								String query="select * from Empleados where Nombre = '"+textFieldNombre.getText()+"' and Apellido = '"+textFieldApellido.getText()+"'";
								   PreparedStatement pst=pruebaCn.prepareStatement(query);
								   ResultSet rs=pst.executeQuery();
								   
								   
								   table.setModel(DbUtils.resultSetToTableModel(rs));
								
								
								
				
							
							   
				              
									
							   
						} catch (Exception ex) {
							ex.printStackTrace();
							
							JOptionPane.showMessageDialog(null, "Error!, ingrese un nombre y apellido valido porfavor.");
							
						
						} 
						
				
				
				
				
				
			}
		});
		btnBuscar.setBounds(411, 445, 89, 23);
		panel.add(btnBuscar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(965, 469, 89, 23);
		panel.add(btnSalir);
		
		JButton btnAtras_2 = new JButton("Atras");
		btnAtras_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Operador_Consultas co = new Operador_Consultas();
				co.setVisible(true);
				dispose();
			}
		});
		btnAtras_2.setBounds(854, 469, 89, 23);
		panel.add(btnAtras_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\ProyectoFinal\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label.setBounds(0, 0, 1076, 503);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Por su CI", null, panel_1, null);
		
		JButton btnBuscar_1 = new JButton("Buscar");
		btnBuscar_1.setBounds(477, 445, 89, 23);
		btnBuscar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				// ------------------------------------------------------------------------------------------	
				
				
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
								
								else {
									JOptionPane.showMessageDialog(null, "Error en la conexion...");
								}				
							
										/* aca ejecuta una consulta  */
								
								// Aca ejecuta la consulta de que muestr a los empelados en la JTABLE
								
							
						
						
						
					// ------------------------------------------------------------------------------------------	
						
						
						
						
						try{
							
				
								String query="select * from Empleados where Ci = '"+textFieldCi.getText()+"' ";
								   PreparedStatement pst=pruebaCn.prepareStatement(query);
								   ResultSet rs=pst.executeQuery();
								   
								   
								 
								table2.setModel(DbUtils.resultSetToTableModel(rs));
								
								
								
				
							
							   
				              
									
							   
						} catch (Exception ex) {
							ex.printStackTrace();
						
							JOptionPane.showMessageDialog(null, "Error!, ingrese correctamente la cedula porfavor.");
							
						} 
				
				
				
				
				
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnBuscar_1);
		
		JLabel lblIngreseCedulaDe = new JLabel("Ingrese cedula de identidad:");
		lblIngreseCedulaDe.setForeground(Color.WHITE);
		lblIngreseCedulaDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblIngreseCedulaDe.setBounds(31, 443, 243, 23);
		panel_1.add(lblIngreseCedulaDe);
		
		textFieldCi = new JTextField();
		textFieldCi.setBounds(285, 446, 148, 20);
		panel_1.add(textFieldCi);
		textFieldCi.setColumns(10);
		
		JButton btnSalir_1 = new JButton("Salir");
		btnSalir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir_1.setBounds(962, 469, 89, 23);
		panel_1.add(btnSalir_1);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Operador_Consultas co = new Operador_Consultas();
				co.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(847, 469, 89, 23);
		panel_1.add(btnAtras);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 11, 1076, 401);
		panel_1.add(scrollPane_1);
		
		table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("D:\\ProyectoFinal\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label_1.setBounds(0, 0, 1076, 503);
		panel_1.add(label_1);
		
		JPanel panelCat = new JPanel();
		tabbedPane.addTab("Por su categoria", null, panelCat, null);
		panelCat.setLayout(null);
		
		JLabel lblSeleccioneLaCategoria = new JLabel("Seleccione la categoria:");
		lblSeleccioneLaCategoria.setForeground(Color.WHITE);
		lblSeleccioneLaCategoria.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblSeleccioneLaCategoria.setBounds(35, 438, 228, 20);
		panelCat.add(lblSeleccioneLaCategoria);
		
		JComboBox comboBoxCat = new JComboBox();
		comboBoxCat.setModel(new DefaultComboBoxModel(new String[] {"VIP", "ALTO A", "ALTO B", "ALTO C", "MEDIO A", "MEDIO B", "MEDIO C", "BAJO"}));
		comboBoxCat.setBounds(256, 440, 107, 20);
		panelCat.add(comboBoxCat);
		
		JButton btnBuscar_2 = new JButton("Buscar");
		btnBuscar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				// ------------------------------------------------------------------------------------------	
				
				
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
								
								else {
									JOptionPane.showMessageDialog(null, "Error en la conexion...");
								}				
							
										/* aca ejecuta una consulta  */
								
								// Aca ejecuta la consulta de que muestr a los empelados en la JTABLE
								
							
						
						
						
					// ------------------------------------------------------------------------------------------	
						
						
						
						
						try{
							
				
								String query="select * from Empleados where CategoriaEmpleado = '"+comboBoxCat.getSelectedItem()+"' ";
								   PreparedStatement pst=pruebaCn.prepareStatement(query);
								   ResultSet rs=pst.executeQuery();
								   
								   
								 
								tableCat.setModel(DbUtils.resultSetToTableModel(rs));
								
								
								
				
							
							   
				              
									
							   
						} catch (Exception ex) {
							ex.printStackTrace();
						
						} 
				
				
				
				
				
			}
			
		});
		btnBuscar_2.setBounds(423, 439, 89, 23);
		panelCat.add(btnBuscar_2);
		
		JButton btnSalir_2 = new JButton("Salir");
		btnSalir_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir_2.setBounds(965, 469, 89, 23);
		panelCat.add(btnSalir_2);
		
		JButton btnAtras_1 = new JButton("Atras");
		btnAtras_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Operador_Consultas co = new Operador_Consultas();
				co.setVisible(true);
				dispose();
			}
		});
		btnAtras_1.setBounds(846, 469, 89, 23);
		panelCat.add(btnAtras_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 1056, 406);
		panelCat.add(scrollPane_2);
		
		tableCat = new JTable();
		scrollPane_2.setViewportView(tableCat);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("D:\\ProyectoFinal\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label_2.setForeground(Color.BLUE);
		label_2.setBounds(0, 0, 1076, 503);
		panelCat.add(label_2);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Por su fecha de nacimiento", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 1056, 402);
		panel_3.add(scrollPane_3);
		
		tableFecha = new JTable();
		scrollPane_3.setViewportView(tableFecha);
		
		JLabel lblIngreseLaFecha = new JLabel("Ingrese la fecha de nacimiento :");
		lblIngreseLaFecha.setForeground(Color.WHITE);
		lblIngreseLaFecha.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIngreseLaFecha.setBounds(31, 442, 256, 19);
		panel_3.add(lblIngreseLaFecha);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(297, 443, 99, 20);
		panel_3.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel lblPorfavorLaFecha = new JLabel("Porfavor la fecha de nacimiento ingresela entre guiones  Ejemplo:   22-2-1998");
		lblPorfavorLaFecha.setForeground(Color.WHITE);
		lblPorfavorLaFecha.setBounds(10, 478, 490, 14);
		panel_3.add(lblPorfavorLaFecha);
		
		JButton btnBuscar_3 = new JButton("Buscar");
		btnBuscar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				// ------------------------------------------------------------------------------------------	
				
				
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
								
								else {
									JOptionPane.showMessageDialog(null, "Error en la conexion...");
								}				
							
										/* aca ejecuta una consulta  */
								
								// Aca ejecuta la consulta de que muestr a los empelados en la JTABLE
								
							
						
						
						
					// ------------------------------------------------------------------------------------------	
						
						
						
						
						try{
							
				
								String query="select * from Empleados where FechaNac = '"+textFieldFecha.getText()+"' ";
								   PreparedStatement pst=pruebaCn.prepareStatement(query);
								   ResultSet rs=pst.executeQuery();
								   
								   
								 
								tableFecha.setModel(DbUtils.resultSetToTableModel(rs));
								
								
								
				
							
							   
				              
									
							   
						} catch (Exception ex) {
							ex.printStackTrace();
							
							JOptionPane.showMessageDialog(null, "Error!, ingrese la fecha correctamente como se indico porfavor");
							
							
						
						} 
				
				
				
			}
		});
		btnBuscar_3.setBounds(430, 442, 89, 23);
		panel_3.add(btnBuscar_3);
		
		JButton btnSalir_3 = new JButton("Salir");
		btnSalir_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir_3.setBounds(977, 454, 89, 23);
		panel_3.add(btnSalir_3);
		
		JButton btnVolverAtras = new JButton("Atras");
		btnVolverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Operador_Consultas co = new Operador_Consultas();
				co.setVisible(true);
				dispose();
			}
		});
		btnVolverAtras.setBounds(864, 454, 89, 23);
		panel_3.add(btnVolverAtras);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("D:\\ProyectoFinal\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label_3.setBounds(0, 0, 1086, 503);
		panel_3.add(label_3);
		
	
	}
}
