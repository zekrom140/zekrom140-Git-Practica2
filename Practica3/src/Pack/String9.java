package Pack;

public class String9 {
	
	public static void main(String[] args) {
		String texto = "No pienso quedar 234.123.0.23 ni huir, eso equivale a perder.";
		
		System.out.println(texto);
		
		System.out.println(texto.replaceAll("\\b(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[1-9]|0)\\b","Coocked"));
		
		System.out.println(texto.substring(17,29));
		
	}
	

}
