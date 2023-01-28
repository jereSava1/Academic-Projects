package model.ticket.estudios;

import model.ticket.DatosDeEmpleo;

public class Secundario extends DatosDeEmpleo {
	
	public Secundario() {
		
	}
	
	public Secundario(int peso) {
		super("SECUNDARIO", peso);
	}

	public float match1() {
		return -0.5F;
	}

	public float match2() {
		return 1F;
	}

	public float match3() {
		return 1.5F;
	}

	public float calculaPuntaje(DatosDeEmpleo estudios) {
		return estudios.match2() * this.getPeso();
	}
}
