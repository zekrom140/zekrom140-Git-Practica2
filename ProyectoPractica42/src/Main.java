

public class Main {
	public static void main(String args[]) {
		int option = -1;
		do {
			option = Validar.menu();
			if(option==1) {
				String ip = Validar.getIp();
				Validar.validarIp(ip);
				Validar.fijo();
			}
			else if(option==2){
				String ip = Validar.getIp();
				Validar.validarMatricula(ip);
			}			
		}while(option!=0);
	}
}
