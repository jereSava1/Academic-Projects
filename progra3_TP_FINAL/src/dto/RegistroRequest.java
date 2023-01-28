package dto;

import types.TipoUsuario;

public class RegistroRequest {
	private String nombreUsuario;
	private String contrasena;
	private TipoUsuario tipo;
	private String nombre;

	public RegistroRequest(String n, String c, TipoUsuario t, String nombre) {
		this.nombreUsuario = n;
		this.contrasena = c;
		this.tipo = t;
		this.nombre = nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getNombre() { return this.nombre; }
	public void setNombre(String n) { this.nombre = n; }
}
