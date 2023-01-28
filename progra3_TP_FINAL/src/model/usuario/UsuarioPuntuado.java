package model.usuario;

import java.io.Serializable;
import java.util.Date;

/**
 * El usuario puntuado se encontrara dentro de la lista de asignaciones, tanto
 * del empleador, como del empleado.
 */
public class UsuarioPuntuado implements Comparable<UsuarioPuntuado>, Serializable {
	private Date fechaDeGeneracion;
	private Usuario usuario;
	/**
	 * puntaje de coincidencias empleado-empleador Determinara el orden en de los
	 * usuarios en las listas de asignaciones.
	 */
	private Float puntaje;
	/**
	 * permite concocer cuandos se ha elegido a un usuario en la ronda de elecciones
	 */
	private boolean seleccionado;
	/**
	 * permite conocer cuando se ha contratado a un usuario en la ronda de
	 * contrataciones
	 */
	private boolean contratado;
	
	public UsuarioPuntuado(Usuario usuario, float puntaje) {
		this.usuario = usuario;
		this.puntaje = puntaje;
		this.fechaDeGeneracion = new Date();
		this.seleccionado = false;
		this.contratado = false;
	}
	public UsuarioPuntuado(){}

	
	public void setFechaDeGeneracion(Date fechaDeGeneracion) {
		this.fechaDeGeneracion = fechaDeGeneracion;
	}
	public void setContratado(boolean contratado) {
		this.contratado = contratado;
	}
	@Override
	public String toString() {
		return "usuario=" + usuario + ", puntaje=" + puntaje;
	}

	/**
	 * Se sobreescribe el compareTo con el objetivo de poder ordenar una lista de
	 * UsuariosPuntuados por el campo puntaje.
	 * 
	 * @param item se corresponde a un usuario dentro de la lista de asignacion
	 *             (UsuarioPuntuado)
	 * @return
	 */
	@Override
	public int compareTo(UsuarioPuntuado item) {
		return this.getPuntaje().compareTo(item.getPuntaje());
	}

	// GETTERS Y SETTERS
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Float getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Float puntaje) {
		this.puntaje = puntaje;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	public Date getFechaDeGeneracion() {
		return fechaDeGeneracion;
	}

	public boolean isContratado() {
		return contratado;
	}

}
