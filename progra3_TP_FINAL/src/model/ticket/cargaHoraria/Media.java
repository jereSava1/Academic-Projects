package model.ticket.cargaHoraria;

import model.ticket.DatosDeEmpleo;

public class Media extends DatosDeEmpleo {
	
	public Media() {
		
	}
	
	public Media(int peso) {
		super("MEDIA", peso);
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

	public float calculaPuntaje(DatosDeEmpleo cargaHoraria) {
		return cargaHoraria.match1() * this.getPeso();
	}
}
