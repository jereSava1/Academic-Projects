package dto;

import factory.LocacionFactory;
import factory.TipoDePuestoFactory;
import model.ticket.DatosDeEmpleo;
import model.ticket.Locacion.Locacion;
import model.ticket.tipoDePuesto.TipoDePuesto;
import types.Rubro;

public class TicketSimplificadoRequest {

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	private String nombreUsuario;
	private DatosDeEmpleo locacion;
	private Rubro tipoDeEmpleo;

	public TicketSimplificadoRequest(String locacion, String tipoDeTrabajo) {
		try {
			this.locacion = LocacionFactory.getLocacion(locacion, 1);
			this.tipoDeEmpleo = Rubro.valueOf(tipoDeTrabajo.toUpperCase());
		} catch (Exception e){}
	}

	public DatosDeEmpleo getLocacion() {
		return locacion;
	}

	public void setLocacion(DatosDeEmpleo locacion) {
		this.locacion = locacion;
	}

	public Rubro getTipoDeEmpleo() {
		return tipoDeEmpleo;
	}

	public void setTipoDeEmpleo(Rubro tipoDeEmpleo) {
		this.tipoDeEmpleo = tipoDeEmpleo;
	}
}
