package model.ticket.Locacion;

import model.ticket.DatosDeEmpleo;

public class Indistinto extends DatosDeEmpleo {
	
	public Indistinto() {
		// TODO Auto-generated constructor stub
	}
	
	public Indistinto(int peso) {
		super("INDISTINTO", peso);
	}

	@Override
	public float match1() {
		return 1F;
	}

	@Override
	public float match2() {
		return 1F;
	}

	@Override
	public float match3() {
		return 1F;
	}

	@Override
	public float calculaPuntaje(DatosDeEmpleo locacion) {
		return locacion.match3() * this.getPeso();
	}
}
