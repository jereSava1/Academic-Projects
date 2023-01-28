package model.ticket.Locacion;

import model.ticket.DatosDeEmpleo;

public class HomeOfiice extends DatosDeEmpleo {
	
	public HomeOfiice() {
		// TODO Auto-generated constructor stub
	}
	
	public HomeOfiice(int peso) {
		super("HOME_OFFICE", peso);
	}

	public float match1() {
		return 1F;
	}

	public float match2() {
		return -1F;
	}

	public float match3() {
		return 1F;
	}

	public float calculaPuntaje(DatosDeEmpleo locacion) {
		return locacion.match1() * this.getPeso();
	}
}
