package model.usuario;

public class Administrador extends Usuario {
	private String ID;
	private String email;

	public Administrador() {
		// TODO Auto-generated constructor stub
	}
	
	public Administrador(String nombreUsuario, String contrasena, String ID, String email) {
		super(nombreUsuario, contrasena);
		this.email = email;
		this.ID = ID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
