package Consultas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexiones.Conexion2;
import net.proteanit.sql.DbUtils;
import security_master.Boton_Admin;
import security_master.Operador_Consultas;
import security_master.Principal;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Ver_DadosDeBaja extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ver_DadosDeBaja frame = new Ver_DadosDeBaja();
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
	public Ver_DadosDeBaja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 42, 1092, 423);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				System.exit(0);
				
			}
		});
		btnSalir.setBounds(45, 507, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Operador_Consultas consultas = new Operador_Consultas();
				consultas.setVisible(true);
				dispose();
				
				
			}
		});
		btnVolverAtras.setBounds(921, 507, 120, 23);
		contentPane.add(btnVolverAtras);
		
		JLabel lblEmpleadosDadosDe = new JLabel("Empleados dados de baja");
		lblEmpleadosDadosDe.setForeground(Color.WHITE);
		lblEmpleadosDadosDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblEmpleadosDadosDe.setBounds(391, 11, 230, 23);
		contentPane.add(lblEmpleadosDadosDe);
		
		JButton btnActualizarLista = new JButton("Actualizar lista");
		btnActualizarLista.addActionListener(new ActionListener() {
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
							
							
							String query="select * from Empleados where EstadoBaja=0";
							   PreparedStatement pst=pruebaCn.prepareStatement(query);
							   ResultSet rs=pst.executeQuery();
							   
							   
							   table.setModel(DbUtils.resultSetToTableModel(rs));
							   
				              
									
							   
						} catch (Exception ex) {
							ex.printStackTrace();
						
						} 
						
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnActualizarLista.setBounds(494, 507, 127, 23);
		contentPane.add(btnActualizarLista);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\ProyectoFinal\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label.setBounds(0, 0, 1092, 541);
		contentPane.add(label);
	}
}
