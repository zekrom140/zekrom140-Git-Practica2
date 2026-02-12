package Ejercicio;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Metodo {
	public static Scanner kb = new Scanner(System.in);
	public static String pedirFrase() {
		System.out.println("Introduce una frase para crear su ficha: ");
		String frase= kb.nextLine();
		return frase;
	}
	public static String cambiar(String texto) {
		String frase = texto.replaceAll( "\\b\\w*(ar|er|ir)\\b" , "VERBO");
		return frase;
	}
	public static long getTime() {
		Date d = new Date();
		return d.getTime();
	}
	public static void crearFicha(String frase) {
		
		String ruta = "assets/"+getTime()+".txt";
		try (BufferedWriter br = new BufferedWriter(new FileWriter(ruta))){
			br.write(frase);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
