/**
 * Main.java
 * Programa principal del sistema para resolver un laberinto
 * DMS - 2023.12.20
 * version 0.1.0
 */
package Classes;

import java.util.Scanner;

public class Main {
	
	private static Sesion s1 = new Sesion();
    private static Scanner kb = new Scanner(System.in);
    private static Maze M1 = new Maze();

    public static void main(String[] args) {

        System.out.println(config.WELCOME);

        int option=-1;

        do {
            if (!s1.isLogged()) {
                System.out.print(config.UNLOGGED_MENU); 
                try {
                	 option = Integer.parseInt(kb.nextLine());
                } catch (Exception e) {
                    System.out.println("Probablemente hayas introducido algo que no es un numero");
                }
               
                muestraUnloggedMenu(option);
            } else {
                System.out.print(config.LOGGED_MENU);
                try {
               	 option = Integer.parseInt(kb.nextLine());
               } catch (Exception e) {
                   System.out.println("Probablemente hayas introducido algo que no es un numero");
               }
                muestraLoggedMenu(option);
            }
        } while (option != 0);

        System.out.println(config.GOODBYE);
    }

    private static void muestraUnloggedMenu(int option) {

        if (option == 1) {
            s1.login();
        } else if (option == 2) {
            s1.signup();
        } else if (option == 0) {
           
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private static void muestraLoggedMenu(int option) {

    	if (option == 1) {
    	    M1.loadMaze();
    	}
    	else if (option == 2) {
    	    M1.showMaze();
    	}
    	else if (option == 3) {
    	    M1.setStartEnd();
    	}
    	else if (option == 4) {
    	    System.out.println("Próximamente");
    	}else if (option == 5) {
            s1.showUser();
        } else if (option == 6) {
            s1.logout();
            M1.clear();
        } else if (option == 0) {
           
        } else {
            System.out.println("Opción no válida.");
        }
    }
}