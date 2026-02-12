package pack;
	
	public class User {

	    private String username;
	    private String password;
	    private String name;
	    private String nif;
	    private String email;
	    private String address;
	    private String birthdate;
	    private String role;
  
	    public User(String username, String password, String name, String nif,String email, String address, String birthdate, String role) {
	        this.username = username;
	        this.password = password;  
	        this.name = name; 
	        this.nif = nif;  
	        this.email = email;
	        this.address = address;
	        this.birthdate = birthdate;
	        this.role = role; 
	    }
  
	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() { 
	        return password;
	    } 

	    
	    public String toString() {
	        return "Usuario: " + username +"\nNombre completo: " + name +"\nNIF: " + nif +"\nEmail: " + email +"\nDirección: " + address +"\nFecha de nacimiento: " + birthdate +"\nRol: " + role+"\n\n";
	    }
	}

