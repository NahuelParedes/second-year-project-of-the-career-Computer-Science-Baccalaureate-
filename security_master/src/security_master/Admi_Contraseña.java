package security_master;

public class Admi_Contrase�a {

	public Admi_Contrase�a() {
		
		
	}
	
	String Usuario= "";
	String Contrase�a= "";
	
	public int Pass() {
		
		Usuario = Boton_Admin.textFieldUsuario.getText();
		Contrase�a= Boton_Admin.passwordFieldContrase�a.getText();
		
		if (Usuario.equals("admin") && Contrase�a.equals("1234")){
	
			return 1;
		}
		
		else {
			
			return 0;
		}
		
	}
	
}
