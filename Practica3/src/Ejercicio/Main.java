package Ejercicio;

public class Main {
	public static void main(String[] args) {
		String frase= Metodo.pedirFrase();
		String fraseCambiada= Metodo.cambiar(frase) ;
		Metodo.crearFicha(fraseCambiada) ; 
	}
}
