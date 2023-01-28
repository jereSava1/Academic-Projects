package model.usuario;

import java.util.Date;


public class ListaDeAsignaciones implements Comparable<ListaDeAsignaciones> {
	private Date fechaDeGeneracion;
	private Usuario usuario;
	private Float puntaje;
	private boolean seleccionado;
	private boolean contratado;

	public ListaDeAsignaciones(Usuario usuario, float puntaje) {
		this.usuario = usuario;
		this.puntaje = puntaje;
		this.fechaDeGeneracion = new Date();
		this.seleccionado = false;
		this.contratado = false;
	}

	public ListaDeAsignaciones() {
	}

	// Getters y Setters publicos

	public Date getFechaDeGeneracion() {
		return fechaDeGeneracion;
	}

	public void setFechaDeGeneracion(Date fechaDeGeneracion) {
		this.fechaDeGeneracion = fechaDeGeneracion;
	}

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

	public boolean isContratado() {
		return contratado;
	}

	public void setContratado(boolean contratado) {
		this.contratado = contratado;
	}

	@Override
	public int compareTo(ListaDeAsignaciones item) {
		return this.getPuntaje().compareTo(item.getPuntaje());
	}
}
