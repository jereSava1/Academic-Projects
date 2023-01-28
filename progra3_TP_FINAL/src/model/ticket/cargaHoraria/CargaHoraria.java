package model.ticket.cargaHoraria;

import interfaces.Puntajes;

public abstract class CargaHoraria implements Puntajes {
	private String valor;
	private int peso;

	public abstract float calculaPuntaje(CargaHoraria cargaHoraria);

	public CargaHoraria() {
		
	}
	
	protected CargaHoraria(String valor, int peso) {
		this.valor = valor;
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
