package model.ticket;

import model.usuario.Empleado;
import model.usuario.Usuario;
import types.Resultado;

/**
 * Ticket que deberan tener todos los empleados que deseen realizar busquedas de
 * empleo.
 */
public class TicketBusquedaDeEmpleo extends Ticket {

	public TicketBusquedaDeEmpleo() {
		
	}
	
	public TicketBusquedaDeEmpleo(FormularioBusqueda formularioBusqueda, Empleado empleado) {
		super(formularioBusqueda, empleado);
	}

	// TODO: completar to string con todos los atributos del form
	@Override
	public String toString() {
		return super.toString() + "Remuneracion pretendida: "
				+ this.getFormularioDeBusqueda().getPretensionSalarial() + "\n";
	}
	
}
