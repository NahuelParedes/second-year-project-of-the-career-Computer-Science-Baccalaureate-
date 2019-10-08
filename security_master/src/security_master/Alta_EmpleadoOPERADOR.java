package security_master;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ComboBoxUI;

import Conexiones.Conexion2;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Color;

public class Alta_EmpleadoOPERADOR extends JFrame {
	int arte = 0;
	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private JTextField textFieldNombre;
	private JTextField textFieldEdad;
	private JTextField textFieldCI;
	private JTextField textFieldDireccion;
	private JTextField textFieldEmail;
	private ButtonGroup botones=new ButtonGroup();
	private ButtonGroup botones1=new ButtonGroup();
	private ButtonGroup botones2=new ButtonGroup();
	private JTextField textFieldApellido;
	private JComboBox comboBoxArmas;
	private JComboBox comboBoxLibreta;
	private JComboBox comboBoxFull;
	private JTable table;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	public Alta_EmpleadoOPERADOR() {
		setTitle("Alta de empleados !");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 200, 1040, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 1014, 662);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblIngresoYModificacion = new JLabel("Alta Empleado");
		lblIngresoYModificacion.setForeground(Color.WHITE);
		lblIngresoYModificacion.setBounds(382, 11, 173, 19);
		lblIngresoYModificacion.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblIngresoYModificacion);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(35, 60, 73, 19);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNombre);
		
		JLabel lblEdad = new JLabel("Fecha de nacimiento (Entre \"-\" )");
		lblEdad.setForeground(Color.WHITE);
		lblEdad.setBounds(35, 142, 210, 31);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblEdad);
		
		JLabel lblCi = new JLabel("CI:");
		lblCi.setForeground(Color.WHITE);
		lblCi.setBounds(35, 182, 46, 14);
		lblCi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblCi);
		
		JLabel lblDomicilio = new JLabel("Direccion");
		lblDomicilio.setForeground(Color.WHITE);
		lblDomicilio.setBounds(35, 222, 73, 14);
		lblDomicilio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblDomicilio);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(35, 260, 73, 14);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblEmail);
		
		JLabel lblPorteDeArmas = new JLabel("Porte de Armas:");
		lblPorteDeArmas.setForeground(Color.WHITE);
		lblPorteDeArmas.setBounds(35, 411, 122, 14);
		lblPorteDeArmas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblPorteDeArmas);
		
		
		JLabel lblLibreta = new JLabel("Libreta de Conducir:");
		lblLibreta.setForeground(Color.WHITE);
		lblLibreta.setBounds(35, 455, 140, 14);
		lblLibreta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblLibreta);
		
		JLabel lblDefensaPersonal = new JLabel("Defensa Personal:");
		lblDefensaPersonal.setForeground(Color.WHITE);
		lblDefensaPersonal.setBounds(39, 333, 140, 14);
		lblDefensaPersonal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblDefensaPersonal);
		
		JLabel lblHorarioFulltime = new JLabel("Horario fulltime:");
		lblHorarioFulltime.setForeground(Color.WHITE);
		lblHorarioFulltime.setBounds(35, 502, 104, 14);
		lblHorarioFulltime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblHorarioFulltime);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(118, 61, 173, 20);
		textFieldNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(255, 149, 98, 20);
		panel.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		textFieldCI = new JTextField();
		textFieldCI.setBounds(118, 181, 173, 20);
		panel.add(textFieldCI);
		textFieldCI.setColumns(10);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(118, 221, 173, 20);
		panel.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(118, 259, 173, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JButton btnGuardar = new JButton("Ingresar");
		btnGuardar.setBounds(103, 567, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
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

				
				try{
					if ( comboBoxArmas.getSelectedItem()==("Si") && comboBoxLibreta.getSelectedItem()==("Si")&&comboBoxFull.getSelectedItem()==("Si")) {
						 String query="insert into Empleados (Ci,Nombre,Apellido,FechaNac,Direccion,Email,Estado,EstadoBaja,CategoriaEmpleado,sexo,desempe�o) values(?,?,?,?,?,?,0,1,'VIP','"+comboBox_1.getSelectedItem()+"','"+comboBox_2.getSelectedItem()+"')";
						
						 
						 PreparedStatement pst=pruebaCn.prepareStatement(query);
						  
		                    pst.setString(1, textFieldCI.getText());
		                    pst.setString(2, textFieldNombre.getText());
		                    pst.setString(3, textFieldApellido.getText());
		                    pst.setString(4, textFieldEdad.getText());
		                    pst.setString(5, textFieldDireccion.getText());                
		                    pst.setString(6, textFieldEmail.getText());
   
		                      pst.execute();

		                      
		                      
		                      JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
		                      
		                      pst.close();
		              
		                      
					} 
				
					else if (comboBoxArmas.getSelectedItem()==("No") && comboBoxLibreta.getSelectedItem()==("Si")&&comboBoxFull.getSelectedItem()==("Si")) {
						String query="insert into Empleados (Ci,Nombre,Apellido,FechaNac,Direccion,Email,Estado,EstadoBaja,CategoriaEmpleado,sexo,desempe�o) values(?,?,?,?,?,?,0,1,'Alto A','"+comboBox_1.getSelectedItem()+"','"+comboBox_2.getSelectedItem()+"')";
			 PreparedStatement pst=pruebaCn.prepareStatement(query);
			  
                pst.setString(1, textFieldCI.getText());
                pst.setString(2, textFieldNombre.getText());
                pst.setString(3, textFieldApellido.getText());
                pst.setString(4, textFieldEdad.getText());
                pst.setString(5, textFieldDireccion.getText());                
                pst.setString(6, textFieldEmail.getText());

                  pst.execute();

                  JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
                  
                  pst.close();
					}
					
					else if (comboBoxArmas.getSelectedItem()==("Si") && comboBoxLibreta.getSelectedItem()==("No")&&comboBoxFull.getSelectedItem()==("No")) {
						String query="insert into Empleados (Ci,Nombre,Apellido,FechaNac,Direccion,Email,Estado,EstadoBaja,CategoriaEmpleado,sexo,desempe�o) values(?,?,?,?,?,?,0,1,'Alto B','"+comboBox_1.getSelectedItem()+"','"+comboBox_2.getSelectedItem()+"')";
						 PreparedStatement pst=pruebaCn.prepareStatement(query);
						  
			                pst.setString(1, textFieldCI.getText());
			                pst.setString(2, textFieldNombre.getText());
			                pst.setString(3, textFieldApellido.getText());
			                pst.setString(4, textFieldEdad.getText());
			                pst.setString(5, textFieldDireccion.getText());                
			                pst.setString(6, textFieldEmail.getText());

			                  pst.execute();

			                  JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
			                  
			                  pst.close();
								}
					
					
					else if (comboBoxArmas.getSelectedItem()==("Si") && comboBoxLibreta.getSelectedItem()==("Si")&&comboBoxFull.getSelectedItem()==("No")) {
						String query="insert into Empleados (Ci,Nombre,Apellido,FechaNac,Direccion,Email,Estado,EstadoBaja,CategoriaEmpleado,sexo,desempe�o) values(?,?,?,?,?,?,0,1,'Alto C','"+comboBox_1.getSelectedItem()+"','"+comboBox_2.getSelectedItem()+"')";						 PreparedStatement pst=pruebaCn.prepareStatement(query);
						  
			                pst.setString(1, textFieldCI.getText());
			                pst.setString(2, textFieldNombre.getText());
			                pst.setString(3, textFieldApellido.getText());
			                pst.setString(4, textFieldEdad.getText());
			                pst.setString(5, textFieldDireccion.getText());                
			                pst.setString(6, textFieldEmail.getText());

			                  pst.execute();

			                  JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
			                  
			                  pst.close();
								}		
					
					
					
					else if (comboBoxArmas.getSelectedItem()==("No") && comboBoxLibreta.getSelectedItem()==("No")&&comboBoxFull.getSelectedItem()==("Si")) {
						String query="insert into Empleados (Ci,Nombre,Apellido,FechaNac,Direccion,Email,Estado,EstadoBaja,CategoriaEmpleado,sexo,desempe�o) values(?,?,?,?,?,?,0,1,'Medio A','"+comboBox_1.getSelectedItem()+"','"+comboBox_2.getSelectedItem()+"')";
						 PreparedStatement pst=pruebaCn.prepareStatement(query);
						  
			                pst.setString(1, textFieldCI.getText());
			                pst.setString(2, textFieldNombre.getText());
			                pst.setString(3, textFieldApellido.getText());
			                pst.setString(4, textFieldEdad.getText());
			                pst.setString(5, textFieldDireccion.getText());                
			                pst.setString(6, textFieldEmail.getText());

			                  pst.execute();

			                  JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
			                  
			                  pst.close();
								}
					
					
					else if (comboBoxArmas.getSelectedItem()==("No") && comboBoxLibreta.getSelectedItem()==("Si")&&comboBoxFull.getSelectedItem()==("No")) {
						String query="insert into Empleados (Ci,Nombre,Apellido,FechaNac,Direccion,Email,Estado,EstadoBaja,CategoriaEmpleado,sexo,desempe�o) values(?,?,?,?,?,?,0,1,'Medio B','"+comboBox_1.getSelectedItem()+"','"+comboBox_2.getSelectedItem()+"')";
						 PreparedStatement pst=pruebaCn.prepareStatement(query);
						  
			                pst.setString(1, textFieldCI.getText());
			                pst.setString(2, textFieldNombre.getText());
			                pst.setString(3, textFieldApellido.getText());
			                pst.setString(4, textFieldEdad.getText());
			                pst.setString(5, textFieldDireccion.getText());                
			                pst.setString(6, textFieldEmail.getText());

			                  pst.execute();

			                  JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
			                  
			                  pst.close();
								}
					
					
					else if (comboBoxArmas.getSelectedItem()==("Si") && comboBoxLibreta.getSelectedItem()==("No")&&comboBoxFull.getSelectedItem()==("No")) {
						String query="insert into Empleados (Ci,Nombre,Apellido,FechaNac,Direccion,Email,Estado,EstadoBaja,CategoriaEmpleado,sexo,desempe�o) values(?,?,?,?,?,?,0,1,'Medio C','"+comboBox_1.getSelectedItem()+"','"+comboBox_2.getSelectedItem()+"')";;
						 PreparedStatement pst=pruebaCn.prepareStatement(query);
						  
			                pst.setString(1, textFieldCI.getText());
			                pst.setString(2, textFieldNombre.getText());
			                pst.setString(3, textFieldApellido.getText());
			                pst.setString(4, textFieldEdad.getText());
			                pst.setString(5, textFieldDireccion.getText());                
			                pst.setString(6, textFieldEmail.getText());

			                  pst.execute();

			                  JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
			                  
			                  pst.close();
								}
					
					else if (comboBoxArmas.getSelectedItem()==("No") && comboBoxLibreta.getSelectedItem()==("No")&&comboBoxFull.getSelectedItem()==("No")) {
						String query="insert into Empleados (Ci,Nombre,Apellido,FechaNac,Direccion,Email,Estado,EstadoBaja,CategoriaEmpleado,sexo,desempe�o) values(?,?,?,?,?,?,0,1,'Bajo','"+comboBox_1.getSelectedItem()+"','"+comboBox_2.getSelectedItem()+"')";
						 PreparedStatement pst=pruebaCn.prepareStatement(query);
						  
			                pst.setString(1, textFieldCI.getText());
			                pst.setString(2, textFieldNombre.getText());
			                pst.setString(3, textFieldApellido.getText());
			                pst.setString(4, textFieldEdad.getText());
			                pst.setString(5, textFieldDireccion.getText());                
			                pst.setString(6, textFieldEmail.getText());

			                  pst.execute();

			                  JOptionPane.showMessageDialog(null, "Empleado ingresado con exito!");
			                  
			                  pst.close();
								}
					
					
					
					
					try{
						
						
						String query="select e.Ci, e.Nombre, e.Apellido, e.FechaNac, e.CategoriaEmpleado, a.NombreArteMarcial from Empleados e inner join Practica on e.Ci = Practica.Ci inner join ArtesMarciales a on Practica.CodArteMarcial = a.CodArteMarcial ";
						   PreparedStatement pst=pruebaCn.prepareStatement(query);
						   ResultSet rs=pst.executeQuery();
						   
						   
						   table.setModel(DbUtils.resultSetToTableModel(rs));
						   
						   
					} catch (Exception ex) {
						ex.printStackTrace();
					
					}
				
					String holi = String.valueOf(comboBox.getSelectedIndex()+1);
					
					String query="insert into Practica values("+textFieldCI.getText()+", "+holi+")";
					 PreparedStatement pst=pruebaCn.prepareStatement(query);

		                  pst.execute();
		                  
		                  pst.close();
							
				
		
					
					
					
					
					//LIMPIA LOS TEXTFIELD
				   textFieldCI.setText(null);
                    textFieldNombre.setText(null);
                    textFieldApellido.setText(null);
                    textFieldEdad.setText(null);
                    textFieldDireccion.setText(null);
                    textFieldEmail.setText(null);
                    
                    
           
                } catch(Exception e1) {
                
                	e1.printStackTrace();     
				
		
				
				}
				
				
				
			
			}
		});
		panel.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(931, 628, 73, 23);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		panel.add(btnSalir);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(35, 104, 55, 14);
		panel.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(118, 103, 173, 20);
		panel.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JButton btnVolverAtras = new JButton("Volver atras");
		btnVolverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestor_Operador Ges_Op = new Gestor_Operador();
				Ges_Op.setVisible(true);
				dispose();
			}
		});
		btnVolverAtras.setBounds(789, 628, 104, 23);
		panel.add(btnVolverAtras);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				
			
	
				
			
			}	});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Boxeo", "Kick Boxing", "Karate", "Wing Chun", "Jiu-Jitsu", "Aikido", "Muay Thai"}));
		comboBox.setToolTipText("Boxeo\r\nKick Boxing\r\nKarate\r\nWing Chun\r\nJiu-Jitsu\r\nAikido\r\nMuay Thai");
		comboBox.setBounds(159, 332, 115, 20);
		panel.add(comboBox);
		
		comboBoxArmas = new JComboBox();
		comboBoxArmas.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxArmas.setBounds(167, 410, 49, 20);
		panel.add(comboBoxArmas);
		
		comboBoxLibreta = new JComboBox();
		comboBoxLibreta.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxLibreta.setBounds(167, 454, 50, 20);
		panel.add(comboBoxLibreta);
		
		comboBoxFull = new JComboBox();
		comboBoxFull.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBoxFull.setBounds(167, 501, 49, 20);
		panel.add(comboBoxFull);
		
		JScrollPane scrollPaneAlta = new JScrollPane();
		scrollPaneAlta.setBounds(466, 73, 527, 511);
		panel.add(scrollPaneAlta);
		
		table = new JTable();
		scrollPaneAlta.setViewportView(table);
		
		JLabel lblSecso = new JLabel("Sexo");
		lblSecso.setForeground(Color.WHITE);
		lblSecso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSecso.setBounds(35, 294, 73, 14);
		panel.add(lblSecso);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboBox_1.setBounds(118, 294, 98, 19);
		panel.add(comboBox_1);
		
		JLabel lblDesempeo = new JLabel("Desempe\u00F1o");
		lblDesempeo.setForeground(Color.WHITE);
		lblDesempeo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDesempeo.setBounds(284, 333, 73, 14);
		panel.add(lblDesempeo);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Master", "Bueno", "Medio", "Bajo"}));
		comboBox_2.setBounds(367, 332, 89, 20);
		panel.add(comboBox_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(343, 73, 5, 5);
		panel.add(tabbedPane);
		
		JLabel lblEj = new JLabel("Ej:    22-2-1998");
		lblEj.setForeground(Color.WHITE);
		lblEj.setBounds(364, 152, 92, 14);
		panel.add(lblEj);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\ProyectoFinal\\security_master\\Imagenes\\textura-fondo-azul-1573.jpg"));
		label.setBounds(0, 0, 1028, 662);
		panel.add(label);

	}
}
