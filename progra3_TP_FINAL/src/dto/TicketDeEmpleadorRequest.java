package dto;

import exception.ConstructorInvalidoException;

public class TicketDeEmpleadorRequest extends TicketDeEmpleadoRequest {

	private int cantEmpleados;
	
	public TicketDeEmpleadorRequest(String locacion, int pesoLocacion, String estudio, int pesoEstudio,
			String experiencia, int pesoExperiencia, String horario, int pesoHorario, String rangoEtario,
			int pesoRangoEtario, String remuneracion, int pesoRemuneracion, String tipoDePuesto,
			int pesoTipoDePuesto,int cantEmpleados) throws ConstructorInvalidoException {
		super(locacion, pesoLocacion, estudio, pesoEstudio, experiencia, pesoExperiencia, horario, pesoHorario, rangoEtario,
				pesoRangoEtario, remuneracion, pesoRemuneracion, tipoDePuesto, pesoTipoDePuesto);
		// TODO Auto-generated constructor stub
		this.cantEmpleados=cantEmpleados;
	}

	public int getCantEmpleados() {
		return cantEmpleados;
	}

	public void setCantEmpleados(int cantEmpleados) {
		this.cantEmpleados = cantEmpleados;
	}
	
	

}
