package negocio;

import exception.LimiteExcedidoException;
import model.ticket.Ticket;
import model.usuario.Empleado;
import model.usuario.Empleador;
import model.usuario.UsuarioPuntuado;
import model.usuario.Usuario;
import java.util.List;
import java.util.stream.Collectors;

/**
 * En esta ronda un empleado seleccionara un empleador y un empleador
 * seleccionara multiples empleados. Las elecciones quedaran almacenadas para
 * ser usadas posteriormente en la ultima etapa,la ronda de contrataciones.
 */
public class RondaDeElecciones {
	
	/**
	 * PRECONTRATO
	 *
	 * Busco el usuario a seleccionar
	 * 
	 * @param ticket
	 * @param usuario No null, el usuario existe en el ranking
	 */
	public static void seleccionaCandidato(Ticket ticket, Usuario usuario) {
		UsuarioPuntuado seleccionado = ticket.getListaDeAsignaciones().stream()
				.filter(r -> r.getUsuario().getNombreUsuario().equalsIgnoreCase(usuario.getNombreUsuario())).findFirst().orElse(null); // Busco el usuario a seleccionar

		if (seleccionado != null) {
			seleccionado.setSeleccionado(true);
		}

	}

	/**
	 * Selecciona multiples usuarios
	 * 
	 * @param ticket           ticket de busqueda
	 * @param usuariosElegidos lista de usuarios a seleccionar, no null
	 */

	public static void seleccionaMultiplesCandidatos(Ticket ticket, List<Usuario> usuariosElegidos) {
		for (Usuario usuario : usuariosElegidos) {
			RondaDeElecciones.seleccionaCandidato(ticket, usuario);
		}
	}

	public static void muestraCandidatosSeleccionados(Ticket ticket) {
		List<UsuarioPuntuado> seleccionados = ticket.getListaDeAsignaciones().stream().filter(r -> r.isSeleccionado())
				.collect(Collectors.toList()); // guarda los usuarios seleccionados por el creador del ticket
		for (UsuarioPuntuado usuarioP : seleccionados) {
			System.out.println(usuarioP.toString());
		}
	}

}
