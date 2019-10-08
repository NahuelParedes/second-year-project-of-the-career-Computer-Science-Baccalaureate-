package Conexiones;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;



public class Conexion2 {

	public static Connection cn;
	public static  Connection getConnection(){
	
try{
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	cn=DriverManager.getConnection("jdbc:sqlserver://Nahuel-PC:1433;databaseName=ProyectoFinal", "ProyectoFinal", "123");
	
	
	
	
} catch (Exception e){
	
	cn=null;
}


return cn;
		
	
	}
	
	public static void main(String[] args) throws SQLException{
		
	Connection pruebaCn=Conexion2.getConnection();
	
	
	if (pruebaCn!=null) {
		
		
		JOptionPane.showMessageDialog(null, "Conexion exitosa!");
		JOptionPane.showMessageDialog(null, pruebaCn);
		java.sql.Statement stm=pruebaCn.createStatement();
		ResultSet rst=stm.executeQuery("select * from empleados");
		
		
	
		
	} else {
		JOptionPane.showMessageDialog(null, "Error en la conexion...");
	}
	
	}
	
}
