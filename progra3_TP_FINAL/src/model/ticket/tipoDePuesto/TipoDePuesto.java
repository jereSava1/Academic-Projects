package model.ticket.tipoDePuesto;

import interfaces.Puntajes;
import model.ticket.DatosDeEmpleo;

public abstract class TipoDePuesto extends DatosDeEmpleo implements Puntajes {

	public abstract float calculaPuntaje(TipoDePuesto puesto);

	public TipoDePuesto(String valor, int peso) {
		super(valor, peso);
	}
	
	//Persistencia
	
	public TipoDePuesto() {}

}
