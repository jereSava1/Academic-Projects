package model.ticket.pretensionSalarial;

import interfaces.Puntajes;
import model.ticket.DatosDeEmpleo;

public abstract class PretensionSalarial extends DatosDeEmpleo{

	public PretensionSalarial() {
		// TODO Auto-generated constructor stub
	}
	
	public PretensionSalarial(String valor, int peso) {
		super(valor, peso);
	}


}