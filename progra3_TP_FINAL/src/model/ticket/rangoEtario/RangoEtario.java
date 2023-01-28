package model.ticket.rangoEtario;

import interfaces.Puntajes;

public abstract class RangoEtario implements Puntajes {
	private String valor;
	private int peso;

	public abstract float calculaPuntaje(RangoEtario rango);

	public RangoEtario() {
		// TODO Auto-generated constructor stub
	}
	
	public RangoEtario(String dato, int peso) {
		this.valor = dato;
		this.peso = peso;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getValor() {
		return valor;
	}

	public int getPeso() {
		return peso;
	}
}
