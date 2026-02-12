package pack;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Validar {
	private static Scanner kb = new Scanner(System.in);
	
	
	public static void validarMatricula(String texto) {
		String regex = "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0|[0-9]\\.[1-9])"
				+ "\\-(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0|[0-9]\\.[1-9])"
				+ "\\-(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0|[0-9]\\.[1-9])"
				+ "\\-((?=.*[A-Z])(?=.*[0-9])[A-Z0-9]{4})";				
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(texto);
		
		if(matcher.matches()) {
			System.out.println("Es Correcta.");
		}
		else {
			System.out.println("Es Incorrecta.");
		}
		
	}
	
	public static void fijo() {
		String texto = "Hola Juan, tienes 3 mensajes";

		Pattern p = Pattern.compile("\\d");
		Matcher m = p.matcher(texto);

		System.out.println(m.find()); // true
	}
	
	public static void validarIp(String ip) {
		boolean val;
		String regex = "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0)"
				+ "\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0)"
				+ "\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0)"
				+ "\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0)";
		
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(ip);
		
		val = matcher.matches();
		if(val) {
			System.out.println("La ip es correcta.");
		}
		else {
			System.out.println("La ip es incorrecta.");
		}
	
		
	}
	
	public static String getIp() {
		System.out.print("Introduce una ip o codigo: ");
		String ip = kb.nextLine();
		return ip;
	}
	
	public static int menu() {
		int num = -1;
		System.out.print("\nMenu\n-------------\n1. Validar IP.\n2. Validar Codigo\n0. Salir\nHas elegido: ");
		try {
			num = Integer.parseInt(kb.nextLine());
		}catch(Exception e) {
			System.out.println("\nDebes introducir un numero.");
		}
		return num;
	}
}
