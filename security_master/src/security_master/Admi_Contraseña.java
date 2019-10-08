package security_master;

public class Admi_Contraseña {

	public Admi_Contraseña() {
		
		
	}
	
	String Usuario= "";
	String Contraseña= "";
	
	public int Pass() {
		
		Usuario = Boton_Admin.textFieldUsuario.getText();
		Contraseña= Boton_Admin.passwordFieldContraseña.getText();
		
		if (Usuario.equals("admin") && Contraseña.equals("1234")){
	
			return 1;
		}
		
		else {
			
			return 0;
		}
		
	}
	
}
