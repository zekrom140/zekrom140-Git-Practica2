package Classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;


public class Metodo {
	private static Scanner kb = new Scanner(System.in);
	private static String ruta="assets/usuarios.txt";
	private static String rute="output/";
	public static ArrayList<Usuario> leer(){
		
		ArrayList<Usuario> arr = new ArrayList<>();
		
		try (BufferedReader rd = new BufferedReader(new FileReader(ruta))){
			
			
			String line;
			while((line= rd.readLine())!= null) {
				
				String[] datos = line.split("&");
				
				
				 Usuario user= new Usuario(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]);
				
				arr.add(user);
				
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;
	}
	
	public static void generarHtml(ArrayList<Usuario> arr) {
		Date fecha = new Date();
		System.out.print("Selecciona un dominio (gmail, hotmail, yahoo, outlook, ...): ");
		String domi= kb.nextLine();
		String nombre="";
		String texto ="Se han enviado a: \n";
		
		String regex = ".*@" + domi + "\\..*";
		Pattern pattern = Pattern.compile(regex);

		for (int i = 0; i < arr.size(); i++) {
		    Matcher matcher = pattern.matcher(arr.get(i).getEmail());
			
			if(matcher.matches()) {
				String html= "<html lang=\"es\">\r\n"
						+ "<head>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "	<div style=\"padding: 20px; background-color: #b2e2f2;\">\r\n"
						+ "		<div style=\"text-align: center; margin-bottom: 20px;\"><h1>Enhorabuena</h1></div>\r\n"
						+ "		<div>\r\n"
						+ "			<div style=\"margin-bottom: 10px; font-size:20px;\">Tus datos actuales son:</div>\r\n"
						+ "			<div>Nombre: "+ arr.get(i).getNombre() +" </div>\r\n"
						+ "			<div>Apellidos: "+ arr.get(i).getApellidos() +"</div>\r\n"
						+ "			<div>DNI: "+ arr.get(i).getDni() +"</div>\r\n"
						+ "			<div>Direcci&oacute;n: "+ arr.get(i).getDireccion() +"</div>\r\n"
						+ "			<div>Tel&eacute;fono: "+ arr.get(i).getTelefono() +"</div>\r\n"
						+ "			<div>Email: "+ arr.get(i).getEmail() +"</div>\r\n"
						+ "		</div>\r\n"
						+ "		<div style=\"margin: 20px 0px\">\r\n"
						+ "			<div>Si necesitas m&aacute;s informaci&oacute;n, llama al tel&eacute;fono del centro 968 26 69 22 o visita la web <span style=\"font-weight: bold;\"><a href=\"https://iescierva.net\" target=\"_blank\">IES Cierva</a></span>\r\n"
						+ "		</div>\r\n"
						+ "		\r\n"
						+ "		<div style=\"margin: 20px 0px; text-align: center;\">\r\n"
						+ "			<img src=\"https://moodle.iescierva.net/pluginfile.php/1/theme_adaptable/adaptablemarkettingimages/0/logoIES_280x80.jpg\" alt=\"logo_iescierva\" />\r\n"
						+ "		</div>\r\n"
						+ "	</div>\r\n"
						+ "</body>\r\n"
						+ "</html>";
				nombre = arr.get(i).getNombre();
				String Route= rute + nombre + fecha.getTime() +".html";
				try(BufferedWriter br = new BufferedWriter(new FileWriter(Route))){
					
					br.write(html);
					
					texto += arr.get(i).getEmail() +"\n";
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.print(texto);
		
		
		
	}
	
	
}
