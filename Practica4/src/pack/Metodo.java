package pack;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Metodo {
	public static String sacarNombre(String email) {
		
		
		int num= 0;

		Pattern p = Pattern.compile("@");
		Matcher m = p.matcher(email);

		while (m.find()) {
		  num =  m.start();
		  
		}
		
		
		return  email.substring(0, num);
	}
	
	public static String ruta = "./assets/users.txt";
	public static ArrayList<User> leer() {
		
		ArrayList<User> arr = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(ruta))){
			String linea;
			while(( linea = br.readLine() ) != null) {
				String[] dato= linea.split("#");
				
				User u = new User(dato[0],dato[1],dato[2],dato[3],dato[4],dato[5],dato[6],dato[7]);
				
				arr.add(u);
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
}
