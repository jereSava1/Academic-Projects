package model.ticket;

import model.ticket.DatosDeEmpleo;
import model.ticket.pretensionSalarial.PretensionSalarial;

/**
 * Define el formulario de busqueda que contendra los datos necesarios para
 * generar tickets de busquedas para el usuario
 */
public class FormularioBusqueda {

	/**
	 * - Pretension Salarial - R < V1 - V1 < R < V2 - R > V2 -> V1, V2 Seran valores
	 * para establecer un rango, son establecidos arbitrariamente por la Agencia
	 */
	private DatosDeEmpleo pretensionSalarial;
	/**
	 * - Rango etario - E < 40 - 40 < E < 50 - E > 50
	 */
	private DatosDeEmpleo rangoEtario;
	/**
	 * - Locacion - Remoto - Presencial - Cualquiera
	 */
	private DatosDeEmpleo locacion;
	/**
	 * - Experiencia previa - Nada - Media - Mucha
	 */
	private DatosDeEmpleo experienciaPrevia;
	/**
	 * - Carga horaria - Media - Completa - Extendida
	 */
	private DatosDeEmpleo cargaHoraria;
	/**
	 * - Tipo de puesto - Junior - Senior - etc.
	 */
	private DatosDeEmpleo tipoDePuesto;
	/**
	 * - Estudios - Primario - Secundario - Terciario
	 */
	private DatosDeEmpleo estudios;
	
	private int cantEmpleadosSolicitados;
	
	public FormularioBusqueda() {
		
	}

	public FormularioBusqueda(DatosDeEmpleo rangoEtario, DatosDeEmpleo locacion, DatosDeEmpleo experienciaPrevia,
			DatosDeEmpleo cargaHoraria, DatosDeEmpleo tipoDePuesto, DatosDeEmpleo estudios,
			DatosDeEmpleo remuneracion) {
		this.rangoEtario = rangoEtario;
		this.locacion = locacion;
		this.experienciaPrevia = experienciaPrevia;
		this.cargaHoraria = cargaHoraria;
		this.tipoDePuesto = tipoDePuesto;
		this.estudios = estudios;
		this.pretensionSalarial = remuneracion;
	}
	
	public FormularioBusqueda(DatosDeEmpleo rangoEtario, DatosDeEmpleo locacion, DatosDeEmpleo experienciaPrevia,
			DatosDeEmpleo cargaHoraria, DatosDeEmpleo tipoDePuesto, DatosDeEmpleo estudios,
			DatosDeEmpleo remuneracion, int cantEmpleadosSolicitados) {
		this.rangoEtario = rangoEtario;
		this.locacion = locacion;
		this.experienciaPrevia = experienciaPrevia;
		this.cargaHoraria = cargaHoraria;
		this.tipoDePuesto = tipoDePuesto;
		this.estudios = estudios;
		this.pretensionSalarial = remuneracion;
		this.cantEmpleadosSolicitados = cantEmpleadosSolicitados;
	}

	@Override
	public String toString() {
		return "FormularioBusqueda " + " remuneracionPretendida=" + pretensionSalarial + ", rangoEtario="
				+ rangoEtario.getValor() + ", locacion=" + locacion.getValor() + ", experienciaPrevia="
				+ experienciaPrevia.getValor() + ", cargaHoraria=" + cargaHoraria.getValor() + ", tipoDePuesto="
				+ tipoDePuesto.getValor() + ", estudios=" + estudios.getValor() + "]";
	}

	// GETTERS
	public DatosDeEmpleo getPretensionSalarial() {
		return pretensionSalarial;
	}

	public void setPretensionSalarial(DatosDeEmpleo pretensionSalarial) {
		this.pretensionSalarial = pretensionSalarial;
	}

	public void setRangoEtario(DatosDeEmpleo rangoEtario) {
		this.rangoEtario = rangoEtario;
	}

	public void setLocacion(DatosDeEmpleo locacion) {
		this.locacion = locacion;
	}

	public void setExperienciaPrevia(DatosDeEmpleo experienciaPrevia) {
		this.experienciaPrevia = experienciaPrevia;
	}

	public void setCargaHoraria(DatosDeEmpleo cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setTipoDePuesto(DatosDeEmpleo tipoDePuesto) {
		this.tipoDePuesto = tipoDePuesto;
	}

	public void setEstudios(DatosDeEmpleo estudios) {
		this.estudios = estudios;
	}

	public DatosDeEmpleo getRangoEtario() {
		return rangoEtario;
	}

	public DatosDeEmpleo getLocacion() {
		return locacion;
	}

	public DatosDeEmpleo getExperienciaPrevia() {
		return experienciaPrevia;
	}

	public DatosDeEmpleo getCargaHoraria() {
		return cargaHoraria;
	}

	public DatosDeEmpleo getTipoDePuesto() {
		return tipoDePuesto;
	}

	public DatosDeEmpleo getEstudios() {
		return estudios;
	}

	public int getCantEmpleadosSolicitados() {
		return cantEmpleadosSolicitados;
	}

	public void setCantEmpleadosSolicitados(int cantEmpleadosSolicitados) {
		this.cantEmpleadosSolicitados = cantEmpleadosSolicitados;
	}
	
	

}
