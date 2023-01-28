package negocio;

import dto.PersistenciaContrataciones;
import model.Agencia;
import model.ticket.Ticket;
import model.ticket.TicketBusquedaDeEmpleado;
import model.ticket.TicketBusquedaDeEmpleo;
import model.usuario.UsuarioPuntuado;
import persistencia.Ipersistencia;
import persistencia.PersistenciaXML;
import state.FinalizadoState;
import types.EstadoTicket;
import types.Resultado;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class RondaDeContrataciones {
	
	private static boolean activada = false; 
	
	/**
	 * PRECONDICION: se debe ejecutar luego de la ronda de encuentro y de la ronda
	 * de elecciones
	 * 
	 * @param agencia
	 */
	
	
	public static void ejecutarRondaDeContrataciones(Agencia agencia) {
		Ipersistencia persistencia = new PersistenciaXML();
		List<PersistenciaContrataciones> output = new LinkedList<>();

		activada = false;

		float comisiones = 0;
		agencia.empleadorNoElegido();// actualiza los puntajes en caso de que el empleador no haya sido elegido por
										// ningun empleado
		for (TicketBusquedaDeEmpleado solicitud : agencia.getSolicitudes()) { // TICKETS DE EMPLEADORES

			List<UsuarioPuntuado> candidatosSeleccionados = solicitud.getListaDeAsignaciones().stream()
					.filter(UsuarioPuntuado::isSeleccionado).collect(Collectors.toList()); // filtro los candidatos
																							// seleccionados por los
																							// empleadores de la lista
																							// de asignaciones

			for (TicketBusquedaDeEmpleo busqueda : agencia.getBusquedas()) { // TICKETS DE EMPLEADOS
				if (solicitud.getEstadoTicket().getNombre() == EstadoTicket.FINALIZADO) { // Si el ticket se cerró
																							// durante la ejecucion, la
																							// corto
					break;
				}

				if (busqueda.getEstadoTicket().getNombre() == EstadoTicket.ACTIVO
						&& candidatosSeleccionados.stream().anyMatch(c -> c.getUsuario().getNombreUsuario().equalsIgnoreCase(busqueda.getDueno().getNombreUsuario()))) { // validamos
																															// que
																															// el
																															// ticket
																															// este
																															// activo
																															// y
																															// que
																															// el
																															// dueño
																															// de
																															// la
																															// solicitud

					List<UsuarioPuntuado> empleadoresSeleccionados = busqueda.getListaDeAsignaciones().stream()
							.filter(UsuarioPuntuado::isSeleccionado).collect(Collectors.toList());

					if (empleadoresSeleccionados.stream().anyMatch(c -> c.getUsuario().getNombreUsuario().equalsIgnoreCase(solicitud.getDueno().getNombreUsuario()))) { // si
																														// el
																														// empleado
																														// tambien
																														// seleccionó
																														// al
																														// empleador
																														// HAY
																														// MATCH
						/* Agrego comisiones a la agencia */
						comisiones = agencia.calculaComisionesEmpleado(busqueda) + agencia.calculaComisionesEmpleador(solicitud);
						agencia.setComisiones(agencia.getComisiones() + comisiones);
						busqueda.setComisionAPagar(busqueda.getComisionAPagar()+agencia.calculaComisionesEmpleado(busqueda));
						solicitud.setComisionAPagar(solicitud.getComisionAPagar()+agencia.calculaComisionesEmpleador(solicitud));
						/* Actualizamos los atributos del ticket de empleado */
						busqueda.setEstadoTicket(new FinalizadoState(busqueda)); // Si se contrata, finalizamos el
																					// ticket
						busqueda.getDueno().aumentarPuntaje(10); // aumentamos el puntaje del usuario
						
						

						/* actualizamos los atributos del ticket de empleador */
						solicitud.aumentarEmpleadosObtenidos();
						
						
						
						if (solicitud.getEmpleadosObtenidos() == solicitud.getEmpleadosNecesitados()) { // si alcanza el
																										// tope, cierro
																										// el ticket
							solicitud.setEstadoTicket(new FinalizadoState(solicitud));
							solicitud.getDueno().aumentarPuntaje(50);
						}
						PersistenciaContrataciones item = new PersistenciaContrataciones();
						item.setComisionEmpleador(agencia.calculaComisionesEmpleador(solicitud));
						item.setComisionEmpleado(agencia.calculaComisionesEmpleado(busqueda));
						item.setIdTicket(busqueda.getId());
						item.setNombreEmpleado(busqueda.getDueno().getNombre());
						item.setNombreEmpleador(solicitud.getDueno().getNombre());
						output.add(item);
					}
				}
			}
		}
		activada = true;

		try {
			persistencia.abrirOutput("ronda-de-contrataciones.xml");
			persistencia.escribir(output);
			persistencia.cerrarOutput();
		} catch (IOException e) {
			//Cumple contrato
		}
		RondaDeEncuentro.setActivada(false);
	}

	public static boolean isActivada() {
		return activada;
	}
}
