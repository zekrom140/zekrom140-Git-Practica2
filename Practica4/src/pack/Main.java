package pack;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
	public static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Introduce un email: ");
		String email= kb.nextLine();
		System.out.println("Este es el email: "+email);
		String a = Metodo.sacarNombre(email);
		
		System.out.println("Este es el nombre: "+a);
		
		
		System.out.println("Ahora va a leer un fichero y mostar su contenido: \n");
		ArrayList<User> arr =Metodo.leer() ;
			
		for(int i = 0 ; i<arr.size() ; i++) {
			System.out.print(arr.get(i));
		}
	}
}
