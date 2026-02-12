package pack;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.regex.Matcher;
public class Metodo {
	private static Scanner kb = new Scanner(System.in);
	public static boolean validar() {
		System.out.print("Introduce un cp: ");
		String texto= kb.nextLine();
		
		String regex = "(2[0-4][0-9]|255|0|1[0-9]{2}|[0-9]{2}|[1-9])"
				+ "\\.(2[0-4][0-9]|255|0|1[0-9]{2}|[0-9]{2}|[1-9])"
				+ "\\.(2[0-4][0-9]|255|0|1[0-9]{2}|[0-9]{2}|[1-9])"
				+ "\\.(2[0-4][0-9]|255|0|1[0-9]{2}|[0-9]{2}|[1-9])";
		
		Pattern pattern= Pattern.compile(regex); 
		Matcher matcher= pattern.matcher(texto);
		
		
		
		return matcher.matches(); 
	}
}
