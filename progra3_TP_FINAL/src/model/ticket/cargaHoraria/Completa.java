package model.ticket.cargaHoraria;

import model.ticket.DatosDeEmpleo;

public class Completa extends DatosDeEmpleo {
	
	public Completa() {
		
	}
	
	public Completa(int peso) {
		super("COMPLETA", peso);
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

	public float calculaPuntaje(DatosDeEmpleo cargaHoraria) {
		return cargaHoraria.match2() * this.getPeso();
	}
}
