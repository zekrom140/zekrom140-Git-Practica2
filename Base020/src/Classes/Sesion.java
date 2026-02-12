package Classes;

import java.io.*;
import java.util.Scanner;

public class Sesion {

    private User user;
    private boolean logged;

    private static final String FILE_PATH = "assets/files/";
    private static final String USERS_FILE = "users.txt";

    private Scanner kb = new Scanner(System.in);

    public Sesion() {
        logged = false;
        user = null;
    }

    public boolean isLogged() {
        return logged;
    }

    public void login() {
    	 
    	String password="",username="";
    	do {
     		System.out.print("Nombre de usuario: ");
     		username = kb.nextLine();
     		if(username=="") {
    			System.out.println("Lo ha dejado en blanco repitalo.");
    		}
         
         }while(username=="");

    	 do {
    	 	System.out.print("Contraseña: ");
    	 	 password = kb.nextLine();
    	 	if(password=="") {
    			System.out.println("Lo ha dejado en blanco repitalo.");
    		}
    	 }while(password=="");

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + USERS_FILE))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("#");

                if (data[0].equalsIgnoreCase(username) && data[1].equals(password)) {
                    user = new User(data[0], data[1], data[2], data[3],
                            data[4], data[5], data[6], data[7]);
                    logged = true;
                    System.out.println("Sesión iniciada correctamente.");
                    return;
                }
            }

            System.out.println("Usuario / contraseña incorrectos.");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }

    public void signup() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH + USERS_FILE, true))) {
        	String username="";
            do {
        		System.out.print("Nombre de usuario: ");
        		username = kb.nextLine();
        		if(username=="") {
        			System.out.println("Lo ha dejado en blanco repitalo.");
        		}
            }while(username=="");

            if (userExists(username)) {
                System.out.println("El usuario ya existe.");
                return;
            }
            String password="";
            do {
        	 	System.out.print("Contraseña: ");
        	 	 password = kb.nextLine();
        	 	if(password=="") {
        			System.out.println("Lo ha dejado en blanco repitalo.");
        		}
        	 }while(password=="");
            
            System.out.print("Nombre completo: ");
            String name = kb.nextLine();
            
            System.out.print("NIF: ");
            String nif = kb.nextLine();
            
            System.out.print("Email: ");
            String email = kb.nextLine();
            
            System.out.print("Dirección: ");
            String address = kb.nextLine();
            
            System.out.print("Fecha de nacimiento: ");
            String birthdate = kb.nextLine();

            String role = "user";
            bw.newLine();
            bw.write(username + "#" + password + "#" + name + "#" + nif + "#" +
                    email + "#" + address + "#" + birthdate + "#" + role);
            

            System.out.println("Registrado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al fichero.");
        }
    }

    private boolean userExists(String username) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH + USERS_FILE))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.split("#")[0].equals(username)) {
                    return true;
                }
            }

        } catch (IOException e) {
          System.out.println("Error al comprobar el usuario.");
        }

        
        return false;
    }


    public void showUser() {
        if (user != null) {
            System.out.println(user);
        }
    }

    public void logout() {
        logged = false;
        user = null;
        System.out.println("Cerrando sesión...");
    }
}

