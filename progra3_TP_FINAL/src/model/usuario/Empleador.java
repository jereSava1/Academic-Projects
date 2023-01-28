package model.usuario;

import exception.NoDuenoDeTicketException;
import model.ticket.FormularioBusqueda;
import model.ticket.TicketBusquedaDeEmpleado;
import types.*;

import java.io.Serializable;

public class Empleador extends Usuario implements Serializable {

	/**
	 * - TipoPersona - Fisica - Juridica
	 */
	private TipoPersona tipoPersona;
	/**
	 * - Tipo De Rubro - Comercio Internacional - Comercio Local - Salud
	 */
	private Rubro rubro;
	private int ticketsSimplificadosSinAsignar;

	public Empleador() {

	}

	public Empleador(String nombreUsuario, String contrasena) {
		super(nombreUsuario, contrasena);
		this.ticketsSimplificadosSinAsignar = 0;
	}

	/**
	 * Se crea un nuevo ticket de busqueda de empleador
	 * 
	 * @param formulario contiene las preferencias del empleador para la busqueda de
	 *                   empleados
	 * @return TicketBusquedaDeEmpleo
	 */
	public TicketBusquedaDeEmpleado altaTicket(FormularioBusqueda formulario, int cantEmpleados) {
		return new TicketBusquedaDeEmpleado(formulario, cantEmpleados, this);
	}

	public void modificaTicket(TicketBusquedaDeEmpleado ticket, int cantEmpleados) throws NoDuenoDeTicketException {
		if (ticket.getDueno().equals(this)) {
			ticket.setEmpleadosNecesitados(cantEmpleados);
		} else {
			throw new NoDuenoDeTicketException(ticket, "ticket " + ticket.getDueno() + " no es dueno de este ticket");
		}
	}

	// GETTERS Y SETTERS
	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public int getTicketsSimplificadosSinAsignar() {
		return ticketsSimplificadosSinAsignar;
	}

	public void setTicketsSimplificadosSinAsignar(int ticketsSimplificadosSinAsignar) {
		this.ticketsSimplificadosSinAsignar = ticketsSimplificadosSinAsignar;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
}
