package model.ticket.pretensionSalarial;

import model.ticket.DatosDeEmpleo;

public class MasDeV2 extends PretensionSalarial {
	
	public MasDeV2() {
		// TODO Auto-generated constructor stub
	}
	
	public MasDeV2(int peso) {
		super("MAS_DE_V2", peso);

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
		return -0.5F;
	}

	@Override
	public float calculaPuntaje(DatosDeEmpleo datoDeEmpleo) {
		return datoDeEmpleo.match3() * this.getPeso();
	}

}
