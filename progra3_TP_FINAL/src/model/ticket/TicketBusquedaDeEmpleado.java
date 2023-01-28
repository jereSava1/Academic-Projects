package model.ticket;

import model.usuario.Empleador;

/**
 * Ticket que deberan tener todos los empleadores que deseen realizar busquedas
 * de empleado.
 */
public class TicketBusquedaDeEmpleado extends Ticket {

	/**
	 * Total de empleados que requiere la empresa para satisfacer su busqueda de
	 * empleados.
	 */
	private int empleadosNecesitados;
	/**
	 * Empleados que se obtienen luego de las rondas de contrataciones.
	 */
	private int empleadosObtenidos = 0;
	
	
	

	public TicketBusquedaDeEmpleado(FormularioBusqueda formularioDeBusqueda, int empleadosNecesitados,
			Empleador empleador) {
		super(formularioDeBusqueda, empleador);
		this.empleadosNecesitados = empleadosNecesitados;
	}



	@Override
	public String toString() {
		return super.toString() + " \nCantidad de empleados: " + this.empleadosNecesitados + "\n"
				+ "Empleados obtenidos: " + this.empleadosObtenidos + "\n";
	}

	public void setEmpleadosObtenidos(int empleadosObtenidos) {
		this.empleadosObtenidos = empleadosObtenidos;
	}
	
	public TicketBusquedaDeEmpleado() {
		
	}
	
	
	/**
	 * Al producirse una contratacion, se incrementa en 1 la cantidad de empleados
	 * obtenidos
	 *
	 * pos: se incrementa en 1 los empleados obtenidos, siempre y cuando obtenidos <
	 * necesitados
	 */
	public void aumentarEmpleadosObtenidos() {
		if (empleadosObtenidos < empleadosNecesitados) {
			this.empleadosObtenidos++;
		}
	}

	// GETTERS Y SETTERS
	public int getEmpleadosNecesitados() {
		return empleadosNecesitados;
	}

	public void setEmpleadosNecesitados(int empleadosNecesitados) {
		this.empleadosNecesitados = empleadosNecesitados;
	}

	public int getEmpleadosObtenidos() {
		return empleadosObtenidos;
	}

}
