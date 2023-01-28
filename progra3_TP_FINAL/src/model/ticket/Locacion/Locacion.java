package model.ticket.Locacion;

import interfaces.Puntajes;
import model.ticket.DatosDeEmpleo;

public abstract class Locacion extends DatosDeEmpleo implements Puntajes {


	public abstract float calculaPuntaje(Locacion locacion);

	public Locacion() {
		// TODO Auto-generated constructor stub
	}
	
	public Locacion(String valor, int peso) {
		super(valor, peso);
	}
}
