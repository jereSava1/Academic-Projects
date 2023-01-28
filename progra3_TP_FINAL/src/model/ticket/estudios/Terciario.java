package model.ticket.estudios;

import model.ticket.DatosDeEmpleo;

public class Terciario extends DatosDeEmpleo {
	
	public Terciario() {
		
	}
	
	public Terciario(int peso) {
		super("TERCIARIO", peso);
	}

	public float match1() {
		return -2F;
	}

	public float match2() {
		return -1.5F;
	}

	public float match3() {
		return 1F;
	}

	public float calculaPuntaje(DatosDeEmpleo estudios) {
		return estudios.match3() * this.getPeso();
	}
}
