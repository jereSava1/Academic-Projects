package model.ticket.experiencia;

import interfaces.Puntajes;

public abstract class ExperienciaPrevia implements Puntajes {
	private String valor;
	private int peso;

	public abstract float calculaPuntaje(ExperienciaPrevia experienciaPrevia);

	public ExperienciaPrevia() {
	}
	
	public ExperienciaPrevia(String valor, int peso) {
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
