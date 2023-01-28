package simulacionThreads;

import model.ticket.DatosDeEmpleo;
import types.Rubro;

public class TicketSimplificado {
	
	private EmpleadorSimulacion dueno;
	private Rubro tipoDeEmpleo;
	private DatosDeEmpleo locacion;

	public TicketSimplificado() {

	}

	public TicketSimplificado(EmpleadorSimulacion dueno, Rubro tipoDeEmpleo, DatosDeEmpleo locacion) {
		this.dueno = dueno;
		this.tipoDeEmpleo = tipoDeEmpleo;
		this.locacion = locacion;
	}
	

	public EmpleadorSimulacion getDueno() {
		return dueno;
	}

	public void setDueno(EmpleadorSimulacion dueno) {
		this.dueno = dueno;
	}

	public EmpleadoSimulacion getEmpleadoAsignado() {
		return empleadoAsignado;
	}

	public void setEmpleadoAsignado(EmpleadoSimulacion empleadoAsignado) {
		this.empleadoAsignado = empleadoAsignado;
	}

	public Rubro getTipoDeEmpleo() {
		return tipoDeEmpleo;
	}

	public void setTipoDeEmpleo(Rubro tipoDeEmpleo) {
		this.tipoDeEmpleo = tipoDeEmpleo;
	}

	public DatosDeEmpleo getLocacion() {
		return locacion;
	}

	public void setLocacion(DatosDeEmpleo locacion) {
		this.locacion = locacion;
	}

	@Override
	public String toString() {
		return "TicketSimplificado de " + dueno.getNombre() + " del rubro " + tipoDeEmpleo + " con la locacion "
				+ locacion.getValor() + ".";
	}

}
