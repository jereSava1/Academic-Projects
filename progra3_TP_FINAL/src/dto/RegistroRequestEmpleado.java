package dto;

import types.TipoUsuario;

public class RegistroRequestEmpleado extends RegistroRequest {

	private String apellido;
	private String telefono;
	private String email;
	private int edad;
	private String nombreCompleto;
	
	
	public RegistroRequestEmpleado( String nombre,String apellido,String telefono,String nombreUsuario, String contrasena,String email,int edad) {
		
		super(nombreUsuario, contrasena, TipoUsuario.EMPLEADO, nombre);
	    this.telefono = telefono;
	    this.email = email;
	    this.apellido = apellido;
		this.nombreCompleto = nombre + " " + this.apellido;
	    this.edad = edad;
	    
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	

	
	
}
