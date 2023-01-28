package model.ticket.estudios;

import model.ticket.DatosDeEmpleo;

public class Primario extends DatosDeEmpleo {

	public Primario() {
		
	}
	
	public Primario(int peso) {
		super("PRIMARIO", peso);
	}

	public float match1() {
		return 1F;
	}

	public float match2() {
		return 1.5F;
	}

	public float match3() {
		return 2F;
	}

	public float calculaPuntaje(DatosDeEmpleo estudios) {
		return estudios.match1() * this.getPeso();
	}

}
