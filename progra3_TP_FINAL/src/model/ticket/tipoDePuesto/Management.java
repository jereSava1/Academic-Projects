package model.ticket.tipoDePuesto;

import model.ticket.DatosDeEmpleo;

public class Management extends DatosDeEmpleo {
	public Management(int peso) {
		super("MANAGEMENT", peso);
	}

	public float match1() {
		return -1F;
	}

	public float match2() {
		return -0.5F;
	}

	public float match3() {
		return 1F;
	}

	@Override
	public float calculaPuntaje(DatosDeEmpleo puesto) {
		return puesto.match3() * this.getPeso();
	}
	
	//Persistencia 
	
	public Management() {}
}
