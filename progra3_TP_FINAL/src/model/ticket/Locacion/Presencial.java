package model.ticket.Locacion;

import model.ticket.DatosDeEmpleo;

public class Presencial extends DatosDeEmpleo {
	
	public Presencial() {
		// TODO Auto-generated constructor stub
	}
	
	public Presencial(int peso) {
		super("PRESENCIAL", peso);
	}

	@Override
	public float match1() {
		return -1F;
	}

	@Override
	public float match2() {
		return 1F;
	}

	@Override
	public float match3() {
		return -1F;
	}

	@Override
	public float calculaPuntaje(DatosDeEmpleo locacion) {
		return locacion.match2() * this.getPeso();
	}
}
