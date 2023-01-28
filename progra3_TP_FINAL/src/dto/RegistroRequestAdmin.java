package dto;

import types.TipoUsuario;

public class RegistroRequestAdmin extends RegistroRequest {
	private String email;
	private String ID;
	
	public RegistroRequestAdmin(String nombreUsuario,String contrasena,String email,String ID, String nombre) {
		super(nombreUsuario,contrasena,TipoUsuario.ADMIN, nombre);
		this.email=email;
		this.ID=ID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	
}
