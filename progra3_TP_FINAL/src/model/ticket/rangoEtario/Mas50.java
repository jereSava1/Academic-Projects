package model.ticket.rangoEtario;

import model.ticket.DatosDeEmpleo;

public class Mas50 extends DatosDeEmpleo {
	public Mas50(int peso) {
		super("MAS_50", peso);
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

	public float calculaPuntaje(DatosDeEmpleo rango) {
		return rango.match3() * this.getPeso();
	}
	//Persistencia
	public Mas50() {
	}
}
