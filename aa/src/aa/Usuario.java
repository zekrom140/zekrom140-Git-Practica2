package aa;

public class Usuario {
				

	    public String nombre;
	    public String apellidos;
	    public String email;

	   
	    public Usuario() {
	    }

	   
	    public Usuario(String nombre, String apellidos, String email) {
	        this.nombre = nombre;
	        this.apellidos = apellidos;
	        this.email = email;
	    }

	    @Override
	    public String toString() {
	        return "Nombre: " + nombre +
	               ", Apellidos: " + apellidos +
	               ", Email: " + email;
	    }
	}
	
	

