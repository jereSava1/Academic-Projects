package model.ticket.cargaHoraria;

import model.ticket.DatosDeEmpleo;

public class Extendida extends DatosDeEmpleo {
	
	public Extendida() {
		
	}
	
	public Extendida(int peso) {
		super("EXTENDIDA", peso);
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

	public float calculaPuntaje(DatosDeEmpleo cargaHoraria) {
		return cargaHoraria.match3() * this.getPeso();
	}
}
