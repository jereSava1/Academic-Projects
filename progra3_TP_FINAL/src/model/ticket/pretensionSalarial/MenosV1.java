package model.ticket.pretensionSalarial;

import model.ticket.DatosDeEmpleo;

public class MenosV1 extends PretensionSalarial {
	
	public MenosV1() {
		// TODO Auto-generated constructor stub
	}
	
	public MenosV1(int peso) {
		super("MENOS_V1", peso);

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
		return datoDeEmpleo.match1() * this.getPeso();
	}

}
