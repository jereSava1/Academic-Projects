package model.ticket.experiencia;

import model.ticket.DatosDeEmpleo;

public class Media extends DatosDeEmpleo {
	
	public Media() {
		// TODO Auto-generated constructor stub
	}
	
	public Media(int peso) {
		super("MEDIA", peso);
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

	public float calculaPuntaje(DatosDeEmpleo experienciaPrevia) {
		return experienciaPrevia.match2() * this.getPeso();
	}
}
