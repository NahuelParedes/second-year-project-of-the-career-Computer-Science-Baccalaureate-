package Consultas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import Conexiones.Conexion2;
import net.proteanit.sql.DbUtils;
import security_master.Operador_Consultas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
public class Ver_Empleados extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnVolverAtras;
	private JButton btnNewButton;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver_Empleados frame = new Ver_Empleados();
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
	public Ver_Empleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1144, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 55, 1128, 433);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnCargarTabla = new JButton("Actualizar");
		btnCargarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

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
								
								try{
									
									
									String query="select Nombre,Apellido,Ci,CategoriaEmpleado from Empleados";
									   PreparedStatement pst=pruebaCn.prepareStatement(query);
									   ResultSet rs=pst.executeQuery();
									   
									   
									   table.setModel(DbUtils.resultSetToTableModel(rs));
									   
									   
								} catch (Exception ex) {
									ex.printStackTrace();
								
								}
								
								// Aca ejecuta la consulta de que muestr a los empelados en la JTABLE
						
						
						
						
						
						
						
						
					// ------------------------------------------------------------------------------------------	
						
						
						
						
						try{
							
							
							String query="select * from Empleados";
							   PreparedStatement pst=pruebaCn.prepareStatement(query);
							   ResultSet rs=pst.executeQuery();
							   
							   
							   table.setModel(DbUtils.resultSetToTableModel(rs));
							   
				              
									
							   
						} catch (Exception ex) {
							ex.printStackTrace();
						
						} 
						
				
		
				
				
				
				
				
			}
		});
		btnCargarTabla.setBounds(425, 11, 116, 23);
		contentPane.add(btnCargarTabla);
		
		btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Operador_Consultas co = new Operador_Consultas();
				co.setVisible(true);
				dispose();
			}
		});
		btnVolverAtras.setBounds(878, 11, 123, 23);
		contentPane.add(btnVolverAtras);
		
		btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
				
			}
		});
		btnNewButton.setBounds(29, 11, 83, 23);
		contentPane.add(btnNewButton);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\ProyectoFinal\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label.setBounds(0, 0, 1128, 516);
		contentPane.add(label);
	}
}
