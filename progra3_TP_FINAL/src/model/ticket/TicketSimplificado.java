package model.ticket;

import model.ticket.Locacion.Locacion;
import model.usuario.Empleado;
import model.usuario.Empleador;
import types.Rubro;

public class TicketSimplificado {
	private Empleador dueno;
	private Empleado asignacion = null;
	private Rubro tipoDeEmpleo;
	private DatosDeEmpleo locacion;
	private boolean esPermanente;

	public TicketSimplificado() {
		// TODO Auto-generated constructor stub
	}

	public TicketSimplificado(Empleador dueno, Rubro tipoDeEmpleo, DatosDeEmpleo locacion) {
		this.dueno = dueno;
		this.tipoDeEmpleo = tipoDeEmpleo;
		this.locacion = locacion;
		this.esPermanente = false; // No esta tomado
	}
	
	

	public void setDueno(Empleador dueno) {
		this.dueno = dueno;
	}

	public void setTipoDeEmpleo(Rubro tipoDeEmpleo) {
		this.tipoDeEmpleo = tipoDeEmpleo;
	}

	public void setLocacion(DatosDeEmpleo locacion) {
		this.locacion = locacion;
	}

	public Empleado getAsignacion() {
		return asignacion;
	}

	public void setAsignacion(Empleado asignacion) {
		this.asignacion = asignacion;
	}

	public Empleador getDueno() {
		return dueno;
	}

	public Rubro getTipoDeEmpleo() {
		return tipoDeEmpleo;
	}

	public DatosDeEmpleo getLocacion() {
		return locacion;
	}

	public boolean isEsPermanente() {
		return esPermanente;
	}

	public void setEsPermanente(boolean esPermanente) {
		this.esPermanente = esPermanente;
	}

	@Override
	public String toString() {
		return "TicketSimplificado de " + dueno.getNombre() + " del rubro " + tipoDeEmpleo + " con la locacion "
				+ locacion.getValor() + ".";
	}

}
