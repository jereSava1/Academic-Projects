package model.ticket;

import interfaces.Puntajes;

/**
 * Clase abstracta que modela el comportamiento de los datos que requieren los
 * usuarios en funcion de sus preferencias. ATRIBUTOS: valor: Identificacion del
 * dato de empleo peso: importancia que le da el usuario a este dato de empleo
 */
public abstract class DatosDeEmpleo implements Puntajes {
	
	private String valor;
	private int peso;

	/**
	 * Metodo abstracto que define el calculo de puntaje segun el valor del match de
	 * los datos de empleo del empleado y empleador, teniendo en cuenta sus
	 * correspondientes pesos.
	 *
	 * pre: datoDeEmpleo != null pos: se calcula el puntaje de manera correcta segun
	 * valor del match de los datos de empleo
	 *
	 *
	 * @param datoDeEmpleo dato para provocar el matcheo
	 * @return float, Valor del matcheo teniendo en cuenta el peso(importancia)
	 *         tomada por el usuario
	 */
	public abstract float calculaPuntaje(DatosDeEmpleo datoDeEmpleo);
	
	protected DatosDeEmpleo(String valor, int peso) {
		this.valor = valor;
		this.peso = peso;
	}
	
	public DatosDeEmpleo() {
	}
	
	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}
	
	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getPeso() {
		return peso;
	}
	

}
