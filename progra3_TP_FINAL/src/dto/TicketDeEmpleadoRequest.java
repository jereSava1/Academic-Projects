package dto;

import exception.ConstructorInvalidoException;
import factory.CargaHorariaFactory;
import factory.EstudiosFactory;
import factory.ExperienciaFactory;
import factory.LocacionFactory;
import factory.PretensionSalarialFactory;
import factory.RangoEtarioFactory;
import factory.TipoDePuestoFactory;
import model.ticket.DatosDeEmpleo;
import model.ticket.pretensionSalarial.PretensionSalarial;

public class TicketDeEmpleadoRequest {

	private DatosDeEmpleo locacion;
	private PretensionSalarial remuneracion;
	private DatosDeEmpleo puesto;
	private DatosDeEmpleo rEtario;
	private DatosDeEmpleo experiencia;
	private DatosDeEmpleo estudios;
	private DatosDeEmpleo horario;
	
	public TicketDeEmpleadoRequest(String locacion, int pesoLocacion, String estudio, int pesoEstudio, String experiencia,
								int pesoExperiencia, String horario, int pesoHorario, String rangoEtario, int pesoRangoEtario,
								String remuneracion, int pesoRemuneracion ,	String tipoDePuesto, int pesoTipoDePuesto) throws ConstructorInvalidoException {
		
			this.locacion = LocacionFactory.getLocacion(locacion, pesoLocacion);
			this.remuneracion = PretensionSalarialFactory.getPretensionSalarial(pesoRemuneracion, remuneracion);
			this.experiencia = ExperienciaFactory.getExperiencia(experiencia, pesoExperiencia);
			this.estudios = EstudiosFactory.getEstudios(estudio, pesoEstudio);
			this.horario = CargaHorariaFactory.getCargaHoraria(horario,pesoHorario);
			this.rEtario = RangoEtarioFactory.getRangoEtario(rangoEtario, pesoRangoEtario);
			this.puesto = TipoDePuestoFactory.getTipoDePuesto(tipoDePuesto, pesoTipoDePuesto);

	}

	public DatosDeEmpleo getLocacion() {
		return locacion;
	}

	public PretensionSalarial getRemuneracion() {
		return remuneracion;
	}

	public DatosDeEmpleo getPuesto() {
		return puesto;
	}

	public DatosDeEmpleo getrEtario() {
		return rEtario;
	}

	public DatosDeEmpleo getExperiencia() {
		return experiencia;
	}

	public DatosDeEmpleo getEstudios() {
		return estudios;
	}

	public DatosDeEmpleo getHorario() {
		return horario;
	}
	
	

}
