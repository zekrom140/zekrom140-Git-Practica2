	package aa;

	import java.util.Scanner;

	public class Main {

	    // Método que recibe un número y devuelve un array de Usuarios
	    public static Usuario[] crearArrayUsuarios(int numero) {

	        Scanner sc = new Scanner(System.in);

	        Usuario[] usuarios = new Usuario[numero];

	        for (int i = 0; i < numero; i++) {

	            System.out.println("Introduce los datos del usuario " + (i + 1));

	            System.out.print("Nombre: ");
	            String nombre = sc.nextLine();

	            System.out.print("Apellidos: ");
	            String apellidos = sc.nextLine();

	            System.out.print("Email: ");
	            String email = sc.nextLine();

	            usuarios[i] = new Usuario(nombre, apellidos, email);

	            System.out.println();
	        }

	        return usuarios;
	    }

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        System.out.print("¿Cuántos usuarios quieres introducir?: ");
	        int numero = sc.nextInt();
	        sc.nextLine(); 

	        
	        Usuario[] arrayUsuarios = crearArrayUsuarios(numero);

	
	        System.out.println("=== LISTA DE USUARIOS ===");

	        for (Usuario u : arrayUsuarios) {
	            System.out.println(u);
	        }
	    }
	}

	
