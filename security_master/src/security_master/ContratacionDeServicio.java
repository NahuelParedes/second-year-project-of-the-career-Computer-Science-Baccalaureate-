package security_master;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexiones.Conexion2;
import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ContratacionDeServicio extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFecha;
	private JTextField textField_1;
	private JTextField textFieldNroCliente;
	private JScrollPane scrollPane;
	private JTable tables;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContratacionDeServicio frame = new ContratacionDeServicio();
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
	public ContratacionDeServicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Elija el empleado que desea contratar:");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label.setBounds(43, 460, 276, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Fecha fin contrato :");
		label_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		label_1.setBounds(43, 514, 276, 14);
		contentPane.add(label_1);
		
	
		
		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(329, 525, 217, 27);
		contentPane.add(textFieldFecha);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(329, 459, 217, 27);
		contentPane.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"VIP", "Alto", "Medio", "Bajo"}));
		comboBox.addActionListener(new ActionListener() {
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
				
				else {
					JOptionPane.showMessageDialog(null, "Error en la conexion...");
				}				
			
						/* aca ejecuta una consulta  */
				
				
				label_2.setText("Bienvenido a la contratación tipo "+comboBox.getSelectedItem());
				try{
					
					
					String query="select Nombre,Apellido,Ci,CategoriaEmpleado from Empleados where CategoriaEmpleado like '"+comboBox.getSelectedItem()+"%'";
					   PreparedStatement pst=pruebaCn.prepareStatement(query);
					   ResultSet rs=pst.executeQuery();
					   
					   
					   tables.setModel(DbUtils.resultSetToTableModel(rs));
					   
					   
					   
					   
				} catch (Exception ex) {
					ex.printStackTrace();
				
				}
			
			}
		});
		comboBox.setBounds(442, 426, 132, 20);
		contentPane.add(comboBox);
		
		JButton button = new JButton("Contratar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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

				
			
				
								
				String query="insert into Servicio (CategoriaServicio,FechaFinal,NroCliente) values('"+comboBox.getSelectedItem()+"','"+textFieldFecha.getText()+"',"+textFieldNroCliente.getText()+")";
				 PreparedStatement pst = null;
				  
				try {
					pst = pruebaCn.prepareStatement(query);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  

	                  try {
						pst.execute();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

	                  JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
	                  
	                  try {
						pst.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
								
					
							//---------------------
	          		query="update persona set CodServicio = select CodServicio from Servicio where NroCliente = "+textFieldNroCliente.getText()+" and CategoriaServicio = '"+comboBox.getSelectedItem()+"' and FechaInicio = '12-12-2017')";
					 pst = null;
					  
					try {
						pst = pruebaCn.prepareStatement(query);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					  

		                  try {
							pst.execute();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

		                  JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
		                  
		                  try {
							pst.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	              	try{
						
						
						query="select CodServicio from Servicio where NroCliente = "+textFieldNroCliente.getText()+" and CategoriaServicio = '"+comboBox.getSelectedItem()+"' and FechaInicio = CONVERT (date, SYSDATETIME())";
						 
						pst=pruebaCn.prepareStatement(query);
						   ResultSet rs=pst.executeQuery();
						   String nombreDelUsuario = "";
						  while(rs.next()){
							   nombreDelUsuario = rs.getString("CodServicio");
						  }
						   JOptionPane.showMessageDialog(null, "Error en la conexion..."+nombreDelUsuario);
						   
						   
					} catch (Exception ex) {
						ex.printStackTrace();
					
					}		
								
								
								
			
			}
		});
		button.setBounds(698, 503, 132, 71);
		contentPane.add(button);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 99, 930, 316);
		contentPane.add(scrollPane);
		
		tables = new JTable();
		scrollPane.setViewportView(tables);
		
		label_2 = new JLabel("Bienvenido a la contrataci\u00F3n tipo VIP");
		label_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		label_2.setBounds(268, 58, 364, 27);
		contentPane.add(label_2);
		
		textFieldNroCliente = new JTextField();
		textFieldNroCliente.setColumns(10);
		textFieldNroCliente.setBounds(329, 589, 217, 27);
		contentPane.add(textFieldNroCliente);
		
		JLabel lblNumeroDeCliente = new JLabel("Numero de cliente :");
		lblNumeroDeCliente.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNumeroDeCliente.setBounds(43, 595, 276, 14);
		contentPane.add(lblNumeroDeCliente);
	}
}
