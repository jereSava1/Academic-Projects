package model.ticket.experiencia;

import model.ticket.DatosDeEmpleo;

public class Nada extends DatosDeEmpleo {
	
	public Nada() {
		// TODO Auto-generated constructor stub
	}
	
	public Nada(int peso) {
		super("NADA", peso);
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

	public float calculaPuntaje(DatosDeEmpleo experienciaPrevia) {
		return experienciaPrevia.match1() * this.getPeso();
	}
}
