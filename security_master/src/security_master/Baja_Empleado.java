package security_master;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexiones.Conexion2;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Baja_Empleado extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCi;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Baja_Empleado frame = new Baja_Empleado();
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
	public Baja_Empleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 989, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseLaCedula = new JLabel("BAJA DE EMPLEADO");
		lblIngreseLaCedula.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIngreseLaCedula.setBounds(398, 0, 171, 56);
		contentPane.add(lblIngreseLaCedula);
		
		JLabel lblIngreseLaCi = new JLabel("Ingrese la CI del empleado que quiere dar de baja:");
		lblIngreseLaCi.setForeground(Color.BLACK);
		lblIngreseLaCi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIngreseLaCi.setBounds(18, 477, 327, 14);
		contentPane.add(lblIngreseLaCi);
		
		textFieldCi = new JTextField();
		textFieldCi.setBounds(365, 472, 249, 27);
		contentPane.add(textFieldCi);
		textFieldCi.setColumns(10);
		
		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.addActionListener(new ActionListener() {
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
				
			
				
				try
                {
                    
                    String query="update Empleados set EstadoBaja = 0 where Ci ='"+textFieldCi.getText()+"'";
                    // JOptionPane.showMessageDialog(null, query);
                    textFieldCi.setText(null);
                    PreparedStatement pst=pruebaCn.prepareStatement(query);
                    
                    
                    pst.execute();
                    
                    JOptionPane.showMessageDialog(null, "Empleado dado de baja con exito!");
                    
                    pst.close();
             
                    
                    
                } catch(Exception e1) {
                
                	e1.printStackTrace();     
				
                	 JOptionPane.showMessageDialog(null, "Este empleado no se puede eliminar porque tienen un contrato vigente.");
			
                	 
				}



				try{
					
					
					String query="select Ci, Nombre, Apellido, CategoriaEmpleado from Empleados where EstadoBaja = 1";
					   PreparedStatement pst=pruebaCn.prepareStatement(query);
					   ResultSet rs=pst.executeQuery();
					   
					   
					   table.setModel(DbUtils.resultSetToTableModel(rs));
					   
					   
				} catch (Exception ex) {
					ex.printStackTrace();
				
				}
				
		
				
				
			}
		});
		btnDarDeBaja.setBounds(624, 472, 101, 27);
		contentPane.add(btnDarDeBaja);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(874, 545, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Gestor_Admin Ges_Ad = new Gestor_Admin();
				Ges_Ad.setVisible(true);
				dispose();
				
			}
		});
		btnVolverAtras.setBounds(743, 545, 113, 23);
		contentPane.add(btnVolverAtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 47, 953, 381);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Actualizar la lista de Empleados");
		btnNewButton.addActionListener(new ActionListener() {
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
					
					try{
				
			
					String query="select * from Empleados whe"
							+ "re EstadoBaja = 1";
					   PreparedStatement pst=pruebaCn.prepareStatement(query);
					   ResultSet rs=pst.executeQuery();
					   
					  
					   table.setModel(DbUtils.resultSetToTableModel(rs));
					   
					   
				} catch (Exception e1) {
					e1.printStackTrace();
				
				}
				
				}
				
				
				
				
			}
		});
		btnNewButton.setBounds(735, 474, 228, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setIcon(new ImageIcon("C:\\Users\\Nahuel\\Desktop\\Programacion\\security_master\\Imagenes\\bkg.jpg"));
		label.setBounds(0, 0, 973, 579);
		contentPane.add(label);
	}
}
