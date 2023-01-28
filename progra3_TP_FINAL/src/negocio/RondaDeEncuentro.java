package negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import dto.PersistenciaListaDeAsignaciones;
import exception.ListaVaciaException;
import model.Agencia;
import model.ticket.FormularioBusqueda;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.UsuarioPuntuado;
import persistencia.Ipersistencia;
import persistencia.PersistenciaXML;

/**
 * Se analizan los tickets y se determinan las coincidencias para elaborar las
 * Listas de asignaciones para cada Usuario.
 */
public class RondaDeEncuentro {

	private static boolean activada = false;
	/**
	 * PRECOND: busquedas != null solicitud != null
	 *
	 * Al ticket unico (solicitud) se le asignara una lista de asignacion(ranking)
	 * dependiendo de las coincidencias entre los formularios de este ticket y la
	 * lista de tickets (busquedas).
	 *
	 * Esta lista de asignacion tendra a los posibles candidatos del ticker
	 * "solicitud" ordenados en un ranking de mayor a menor.
	 *
	 * @param busquedas sera una lista de tickets
	 * @param solicitud sera un ticket unico (saldra del metodo con la lista de
	 *                  asignacion seteada)
	 */
	private static void ejecutarRondaDeEncuentrosParaTicket(List<? extends Ticket> busquedas, Ticket solicitud) {
		List<UsuarioPuntuado> ranking = new ArrayList<>();
		FormularioBusqueda solicitudForm = solicitud.getFormularioDeBusqueda();
		
		for (Ticket busqueda : busquedas) {
			FormularioBusqueda formulario = busqueda.getFormularioDeBusqueda();
			float puntaje = 0F;

			puntaje += formulario.getPretensionSalarial().calculaPuntaje(solicitudForm.getPretensionSalarial());
			puntaje += formulario.getEstudios().calculaPuntaje(solicitudForm.getEstudios());
			puntaje += formulario.getRangoEtario().calculaPuntaje(solicitudForm.getRangoEtario());
			puntaje += formulario.getTipoDePuesto().calculaPuntaje(solicitudForm.getTipoDePuesto());
			puntaje += formulario.getCargaHoraria().calculaPuntaje(solicitudForm.getCargaHoraria());
			puntaje += formulario.getLocacion().calculaPuntaje(solicitudForm.getLocacion());
			puntaje += formulario.getExperienciaPrevia().calculaPuntaje(solicitudForm.getExperienciaPrevia());
			
			ranking.add(new UsuarioPuntuado(busqueda.getDueno(), puntaje));
		}
		Collections.sort(ranking);

		solicitud.setListaDeAsignaciones(ranking);
	}
	
	

	public static void setActivada(boolean activada) {
		RondaDeEncuentro.activada = activada;
	}

	/**
	 * Ejecucion de la ronda de encuentro: Ticket de empleado: - A ticket de
	 * empleado se le asignara una lista de asignacion de empleadores (Lista del
	 * empleado pretenso) - A ticket de empleadores se le asignara una lista de
	 * asignacion de empleados (Lista del empleador)
	 * 
	 * @param agencia
	 */
	public static void ejecutarRondaDeEncuentros(Agencia agencia) {
				
		for (Ticket busqueda : agencia.getBusquedas()) { // TICKETS DE EMPLEADOS
			RondaDeEncuentro.ejecutarRondaDeEncuentrosParaTicket(agencia.getSolicitudes(), busqueda);
		}
		Ipersistencia persistencia = new PersistenciaXML();
		try {
			persistencia.abrirOutput("lista-de-asignaciones-empleados.xml");
			persistencia.escribir(agencia.getBusquedas().stream().map(PersistenciaListaDeAsignaciones::of).collect(Collectors.toList()));
			persistencia.cerrarOutput();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Ticket solicitud : agencia.getSolicitudes()) { // TICKETS DE EMPLEADORES
			RondaDeEncuentro.ejecutarRondaDeEncuentrosParaTicket(agencia.getBusquedas(), solicitud);
		}
		try {
			persistencia.abrirOutput("lista-de-asignaciones-empleador.xml");
			persistencia.escribir(agencia.getBusquedas().stream().map(PersistenciaListaDeAsignaciones::of).collect(Collectors.toList()));
			persistencia.cerrarOutput();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ronda ejecutada");
		
		RondaDeEncuentro.activada = true;
	}

	/**
	 * PRECOND solicitudes != null
	 *
	 * - Se actualizaran el puntajes para un empleado luego de finalizada la ronda
	 * de encuentro en caso que: - Por cada lista de empleados pretensos dónde
	 * quede ultimo, resta 5 puntos - Por cada lista de empleados pretensos, sumará
	 * 5 puntos
	 * 
	 * @param solicitudes
	 */
	public static void actualizarPuntajesParaEmpleado(List<TicketBusquedaDeEmpleado> solicitudes) {
		for (TicketBusquedaDeEmpleado solicitud : solicitudes) {
			List<UsuarioPuntuado> listaDeAsignaciones = solicitud.getListaDeAsignaciones();
			listaDeAsignaciones.get(0).getUsuario().aumentarPuntaje(5);
			listaDeAsignaciones.get(listaDeAsignaciones.size() - 1).getUsuario().bajarPuntaje(5);
		}
	}

	/**
	 * PRECOND: busquedas != null
	 *
	 * - Se actualizaran el puntajes para un empleador luego de finalizada la ronda
	 * de encuentro en caso que: - Por ser primero en la lista de empleadores suma
	 * 10 por c/u
	 * 
	 * @param busquedas
	 */
	public static void actualizarPuntajesParaEmpleador(List<TicketBusquedaDeEmpleo> busquedas) {
		for (TicketBusquedaDeEmpleo busqueda : busquedas) {
			List<UsuarioPuntuado> listaDeAsignaciones = busqueda.getListaDeAsignaciones();
			listaDeAsignaciones.get(0).getUsuario().aumentarPuntaje(10);
		}
	}

	/**
	 * muestra la lista de asignaciones generada, con los usuarios de mayor
	 * coincidencia de busqueda a menor coincidencia, para que el usuario que genero
	 * el ticket puede ver cuales son los candidatos a elegir( para ejecutar la
	 * ronda de elecciones)
	 * 
	 * @param ticket recibe un ticket generico de la clase abstracta.
	 */
	public static void muestraListaDeAsignaciones(Ticket ticket) throws ListaVaciaException {
		List<UsuarioPuntuado> lista = ticket.getListaDeAsignaciones();
		if (lista.size() > 0) {
			for (UsuarioPuntuado usuarioP : lista) {
				System.out.println(usuarioP.toString());
			}
		} else
			throw new ListaVaciaException("lista de asignaciones vacia");
	}

	public static boolean isActivada() {
		return activada;
	}
	
	
}
