package pack;

public class User {
	private String id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String email;
	private String direccion;
	private String numero;
	
	public User(String id, String nombre, String apellidos, String dni, String email, String direccion, String numero) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.direccion = direccion;
		this.numero = numero;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if(id.length() > 0) {
			this.id = id;
		}
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre.length() > 0) {
			this.nombre = nombre;
		}
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		if(apellidos.length() > 0) {
			this.apellidos = apellidos;
		}
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		if(dni.length() > 0) {
			this.dni = dni;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(email.length() > 0) {
			this.email = email;
		}
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		if(direccion.length() > 0) {
			this.direccion = direccion;
		}
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		if(numero.length() > 0) {
			this.numero = numero;
		}
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", email="
				+ email + ", direccion=" + direccion + ", numero=" + numero + "]";
	}	
}
