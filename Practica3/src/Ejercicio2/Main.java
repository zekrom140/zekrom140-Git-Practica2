package Ejercicio2;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		
		String a = Metodo.pedirDominio();
		ArrayList<Usuario> arr = Metodo.recogerUsuario() ; 
		
		Metodo.crearHtml(arr,a);
	}
}
