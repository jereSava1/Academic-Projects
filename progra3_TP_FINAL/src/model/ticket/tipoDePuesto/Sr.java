package model.ticket.tipoDePuesto;

import model.ticket.DatosDeEmpleo;

public class Sr extends DatosDeEmpleo {
	public Sr(int peso) {
		super("SR", peso);
	}

	public float match1() {
		return -0.5F;
	}

	public float match2() {
		return 1F;
	}

	public float match3() {
		return -0.5F;
	}

	@Override
	public float calculaPuntaje(DatosDeEmpleo puesto) {
		return puesto.match2() * this.getPeso();
	}
	//Persistencia
	public Sr() {}
	
}
