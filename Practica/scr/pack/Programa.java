package pack;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;   
import java.io.FileWriter;
import java.io.IOException;

public class Programa {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String domain = getDomainToSearch();
		ArrayList<User> usersDomain = checkEmails(domain);
		
		if(usersDomain == null){
			System.out.println("No se encuentran coincidencias en de usuarios con el dominio.");
		}else {
			createMailHTML(usersDomain);
		}
		
	}
	
	public static boolean createMailHTML(ArrayList<User> usersDomain) {
		Date fecha = new Date();
		for(int i = 0; i < usersDomain.size();i++) {
			String html = "<html lang=\"es\">\n"
					+ "<head>\n"
					+ "</head>\n"
					+ "<body>\n"
					+ "	<div style=\"padding: 20px; background-color: #b2e2f2;\">\n"
					+ "		<div style=\"text-align: center; margin-bottom: 20px;\"><h1>Enhorabuena</h1></div>\n"
					+ "		<div>\n"
					+ "			<div style=\"margin-bottom: 10px; font-size:20px;\">Tus datos actuales son:</div>\n"
					+ "			<div>Nombre:" + usersDomain.get(i).getNombre() + "</div>\n"
					+ "			<div>Apellidos: " + usersDomain.get(i).getApellidos() + "</div>\n"
					+ "			<div>DNI:" + usersDomain.get(i).getDni() + "</div>\n"
					+ "			<div>Direcci&oacute;n:" + usersDomain.get(i).getDireccion() + "</div>\n"
					+ "			<div>Tel&eacute;fono:" +  usersDomain.get(i).getNumero() + "</div>\n"
					+ "			<div>Email:" + usersDomain.get(i).getEmail() + "</div>\n"
					+ "		</div>\n"
					+ "		<div style=\"margin: 20px 0px\">\n"
					+ "			<div>Si necesitas m&aacute;s informaci&oacute;n, llama al tel&eacute;fono del centro 968 26 69 22 o visita la web <span style=\"font-weight: bold;\"><a href=\"https://iescierva.net\" target=\"_blank\">IES Cierva</a></span>\n"
					+ "		</div>\n"
					+ "		\n"
					+ "		<div style=\"margin: 20px 0px; text-align: center;\">\n"
					+ "			<img src=\"https://moodle.iescierva.net/pluginfile.php/1/theme_adaptable/adaptablemarkettingimages/0/logoIES_280x80.jpg\" alt=\"logo_iescierva\" />\n"
					+ "		</div>\n"
					+ "	</div>\n"
					+ "</body>\n"
					+ "</html>";
		
			String[] email = usersDomain.get(i).getEmail().split("@");
			
			try {
			      FileWriter myWriter = new FileWriter("./output/" + email[0] + "_" + fecha.getTime() +  ".html");
			      myWriter.write(html);
			      myWriter.close(); 
			      System.out.println("Correo para " +usersDomain.get(i).getNombre() + " " + usersDomain.get(i).getApellidos() +  " enviado con exito.");
			    } catch (IOException e) {
			      System.out.println("ERROR: Ocurrio algun error en el envio de los correos");
			      e.printStackTrace();
			    }
			
		
		}
		
		return true;
	}
	
	public static String getDomainToSearch() {
		System.out.print("Introduzca un dominio de correo electronico: ");
		String email = sc.nextLine();
		return email;
	}
	
	public static ArrayList<User> checkEmails(String domain) {
			
		ArrayList<User> usersDomain = new ArrayList<User>();
 		File myObj = new File("./assets/usuarios.txt");

	    try (Scanner myReader = new Scanner(myObj)) {
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        String[] userData = data.split("&");
	        String userDomain = getDomain(userData[4]);
	        if(userDomain.contains(domain) && userData.length == 7) {
	        	usersDomain.add(new User(userData[0],userData[1],userData[2],userData[3],userData[4],userData[5],userData[6]));
	        }
	      }
	    } catch (FileNotFoundException e) {
		    e.printStackTrace();
	    }
	    if(usersDomain.size() > 0) {
			return usersDomain;

	    }else {
	    	return null;
	    }
	}
	
	
	public static String getDomain(String email) {
		String[] emailParted = email.split("@");
		return emailParted[1];
	}
}
