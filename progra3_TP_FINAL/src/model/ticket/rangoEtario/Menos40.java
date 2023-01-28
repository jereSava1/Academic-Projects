package model.ticket.rangoEtario;

import model.ticket.DatosDeEmpleo;

public class Menos40 extends DatosDeEmpleo {
	public Menos40(int peso) {
		super("MENOS_40", peso);
	}

	public float match1() {
		return 1F;
	}

	public float match2() {
		return -0.5F;
	}

	public float match3() {
		return -1F;
	}

	public float calculaPuntaje(DatosDeEmpleo rango) {
		return rango.match1() * this.getPeso();
	}
	//Persistencia
	public Menos40() {}
}
