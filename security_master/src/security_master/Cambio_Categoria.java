package security_master;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexiones.Conexion2;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Cambio_Categoria extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldCiCat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cambio_Categoria frame = new Cambio_Categoria();
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
	public Cambio_Categoria() {
		setTitle("Cambio de Categoria del Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1135, 648);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 30, 1052, 370);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblElijaAlCi = new JLabel("Elija la CI del empleado que quiere cambia de categoria :");
		lblElijaAlCi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblElijaAlCi.setBounds(48, 435, 404, 24);
		contentPane.add(lblElijaAlCi);
		
		JLabel lblNewLabel = new JLabel("Seleccione  la nueva categoria del empleado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(48, 490, 327, 14);
		contentPane.add(lblNewLabel);
		
		textFieldCiCat = new JTextField();
		textFieldCiCat.setBounds(461, 439, 147, 20);
		contentPane.add(textFieldCiCat);
		textFieldCiCat.setColumns(10);
		
		JComboBox comboBoxNEW = new JComboBox();
		comboBoxNEW.setModel(new DefaultComboBoxModel(new String[] {"VIP", "ALTO A", "ALTO B", "ALTO C", "MEDIO A", "MEDIO B", "MEDIO C", "BAJO"}));
		comboBoxNEW.setBounds(461, 489, 85, 20);
		contentPane.add(comboBoxNEW);
		
	
		
		
		JButton btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(new ActionListener() {
			private PreparedStatement pst1;

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
																																																					
					// ------------------------------------------------------------------------------------------	
						
							
								
					
							
								
								

								try
				                {
				                    
									String query=" update Empleados set CategoriaEmpleado = '"+comboBoxNEW.getSelectedItem()+"' where Ci = '"+textFieldCiCat.getText()+"'";	
				                    // JOptionPane.showMessageDialog(null, query);
				                    textFieldCiCat.setText(null);
				                    PreparedStatement pst=pruebaCn.prepareStatement(query);
				                    
				                    
				                    pst.execute();
				                    
				                    JOptionPane.showMessageDialog(null, "Empleado dado de baja con exito!");
				                    
				                    pst.close();
				             
				                    
				                    
				                } catch(Exception e1) {
				                
				                	e1.printStackTrace();     
								
				                	 JOptionPane.showMessageDialog(null, "Empleado cambiado de categoria con exito!");
							
				                	 
								}



								
								
								
								
								
								
								
								
								
								
								
						
						
				
				
				
				
				
				
			}
		});
		btnCambiar.setBounds(668, 438, 89, 23);
		contentPane.add(btnCambiar);
		
		JButton btnActualizarListaDe = new JButton("Actualizar lista de empleados");
		btnActualizarListaDe.addActionListener(new ActionListener() {
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
							
							
							String query="select Nombre, Apellido, Ci, CategoriaEmpleado from Empleados";
							   PreparedStatement pst=pruebaCn.prepareStatement(query);
							   ResultSet rs=pst.executeQuery();
							   
							   
							   table.setModel(DbUtils.resultSetToTableModel(rs));
							   
				              
									
							   
						} catch (Exception ex) {
							ex.printStackTrace();
						
						} 
						

			
			}
		});
		btnActualizarListaDe.setBounds(695, 534, 212, 23);
		contentPane.add(btnActualizarListaDe);
		
		JLabel lblparaVerLos = new JLabel("(Para ver los empleados tendra que actualizar)");
		lblparaVerLos.setBounds(785, 568, 294, 14);
		contentPane.add(lblparaVerLos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnSalir.setBounds(1017, 534, 73, 23);
		contentPane.add(btnSalir);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gestor_Admin ga = new Gestor_Admin();
				ga.setVisible(true);
				dispose();
				
				
			}
		});
		btnAtras.setBounds(934, 534, 73, 23);
		contentPane.add(btnAtras);
	}
}
