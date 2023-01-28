package model.ticket.experiencia;

import model.ticket.DatosDeEmpleo;

public class Mucha extends DatosDeEmpleo {
	
	public Mucha() {
		// TODO Auto-generated constructor stub
	}
	
	public Mucha(int peso) {
		super("MUCHA", peso);
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

	public float calculaPuntaje(DatosDeEmpleo experienciaPrevia) {
		return experienciaPrevia.match3() * this.getPeso();
	}
}
