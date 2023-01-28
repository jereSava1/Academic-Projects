package model.usuario;

import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import persistencia.Ipersistencia;
import persistencia.PersistenciaXML;
import state.CanceladoState;
import state.IState;
import types.*;

import java.util.Objects;

import exception.ContrasenaIncorrectaException;
import exception.NoDuenoDeTicketException;
import exception.UsuarioIncorrectoException;

public abstract class Usuario  {
	private String nombre;
	private String nombreUsuario;
	private String contrasena;
	protected int puntaje;

	public Usuario() {

	}

	public Usuario(String nombreUsuario, String contrasena) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.puntaje = 0;
	}

	public boolean validaContrasena(String contrasena) throws ContrasenaIncorrectaException {
		boolean ingreso = false;
		if (contrasena.equals(this.contrasena))
			ingreso = true;
		else {
			throw new ContrasenaIncorrectaException(contrasena, "contrasena incorrecta");
		}
		return ingreso;
	}

	public void bajaTicket(Ticket ticket) throws NoDuenoDeTicketException {
		if (ticket.getDueno().equals(this)) {
			ticket.setEstadoTicket(new CanceladoState(ticket));
		} else {
			throw new NoDuenoDeTicketException(ticket, "ticket " + ticket.getDueno() + " no es dueno de este ticket");// try
		}
	}

	
	public void modificaTicket(Ticket ticket, FormularioBusqueda formularioBusqueda) throws NoDuenoDeTicketException {
		if (ticket.getDueno().equals(this)) {
			ticket.setFormularioDeBusqueda(formularioBusqueda);
			if( ticket instanceof TicketBusquedaDeEmpleado ) {
				((TicketBusquedaDeEmpleado) ticket).setEmpleadosNecesitados(formularioBusqueda.getCantEmpleadosSolicitados());			
			}	
		} else { 
			throw new NoDuenoDeTicketException(ticket, "ticket " + ticket.getDueno() + " no es dueno de este ticket");
		}
	}

	public void cambiaEstadoTicket(Ticket ticket, IState estado) throws NoDuenoDeTicketException {
		if (ticket.getDueno().equals(this)) {
			ticket.setEstadoTicket(estado);
		} else {
			throw new NoDuenoDeTicketException(ticket, "ticket " + ticket.getDueno() + " no es dueno de este ticket");
		}
	}

	public void aumentarPuntaje(int puntaje) {
		this.puntaje += puntaje;
	}

	/**
	 * Baja un determinado puntaje al puntaje final del usuario. El puntaje final no
	 * puede ser menor a 0
	 * 
	 * @param puntaje se le resta al puntaje final
	 */
	public void bajarPuntaje(int puntaje) {
		if (this.puntaje - puntaje >= 0)
			this.puntaje -= puntaje;
		else
			this.puntaje = 0;
	}

	public void consultaTicket(Ticket ticket) {
		System.out.println(ticket.toString());
	}

	// GETTERS Y SETTERS

	public String getNombre() {
		return nombre;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
