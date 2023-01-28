package model;

import dto.*;
import exception.ContrasenaIncorrectaException;
import exception.NoDuenoDeTicketException;
import exception.UsuarioIncorrectoException;
import model.ticket.*;
import model.usuario.*;
import persistencia.Ipersistencia;
import persistencia.PersistenciaXML;
import state.CanceladoState;
import types.Rubro;
import types.TipoPersona;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 */
public class Agencia extends Observable {

	/**
	 * coleccion que contiene a los empleados (sin repeticiones) que consumen la
	 * aplicacion
	 */
	private Set<Empleado> empleados;
	/**
	 * coleccion que contiene a los empleadores (sin repeticiones) que consumen la
	 * aplicacion
	 */
	private Set<Empleador> empleadores;

	private Administrador administrador;
	/**
	 * Lista con los tickets de busqueda de empleo
	 */
	private List<TicketBusquedaDeEmpleo> busquedas;
	/**
	 * Lista con los tickets de solicitud de empleado
	 */
	private List<TicketBusquedaDeEmpleado> solicitudes;
	/**
	 * Permite definir que categoria tendra la Pretension salarial junto con V2
	 */
	private Float remuneracionV1;
	/**
	 * Permite definir que categoria tendra la Pretension salarial junto con V1
	 */
	private Float remuneracionV2;
	/**
	 * Suma total de comisiones adquirida por la Agencia
	 */
	private Float comisiones;
	
	private List<TicketSimplificado> bolsaDeTrabajo;
	
	private Set<TicketSimplificado> ticketSimplificadosAsignados;

	static private Agencia singleton = null;
	
	public Administrador getAdministrador() {
		return administrador;
	}
	
	private Agencia(String usuario, String contrasena) {
		Ipersistencia persistencia = new PersistenciaXML();

		try { // cargar los datos de la agencia desde el archivo XML
			persistencia.abrirInput("empleadores.xml");
			this.empleadores = (HashSet<Empleador>) persistencia.lee();
			if (empleadores == null) {
				empleadores = new HashSet<>();
			}
			persistencia.cerrarInput();
		} catch (Exception err) {
			this.empleadores = new HashSet<>();
		}

		try {
			persistencia.abrirInput("empleados.xml");
			this.empleados = (HashSet<Empleado>) persistencia.lee();
			if (empleados == null) {
				empleados = new HashSet<>();
			}
			persistencia.cerrarInput();
		} catch (Exception err) {
			this.empleados = new HashSet<>();
		}

		try {
			persistencia.abrirInput("administrador.xml");
			this.administrador = (Administrador) persistencia.lee();
			persistencia.cerrarInput();
		} catch (Exception err) {
			this.administrador = null;
		}
		
		try { // cargar los datos de la agencia desde el archivo XML
			persistencia.abrirInput("ticketBusquedaDeEmpleo.xml");
			this.busquedas = (List<TicketBusquedaDeEmpleo>) persistencia.lee();
			if (busquedas == null) {
				busquedas = new ArrayList<>();
			}
			persistencia.cerrarInput();
		} catch (Exception err) {
			this.busquedas = new ArrayList<>();
		}
		
		try { // cargar los datos de la agencia desde el archivo XML
			persistencia.abrirInput("ticketBusquedaDeEmpleados.xml");
			this.solicitudes = (List<TicketBusquedaDeEmpleado>) persistencia.lee();
			if (solicitudes == null) {
				solicitudes = new ArrayList<>();
			}
			persistencia.cerrarInput();
		} catch (Exception err) {
			this.solicitudes = new ArrayList<>();
		}
		
		try {
			persistencia.abrirInput("ticketSimplificadosAsignados.xml");
			this.ticketSimplificadosAsignados = (HashSet<TicketSimplificado>) persistencia.lee();
			if (ticketSimplificadosAsignados == null) {
				ticketSimplificadosAsignados = new HashSet<>();
			}
			persistencia.cerrarInput();
		} catch (Exception err) {
			this.ticketSimplificadosAsignados = new HashSet<>();
		}
		
		try {
			persistencia.abrirInput("bolsaDeTrabajo.xml");
			this.bolsaDeTrabajo = (List<TicketSimplificado>) persistencia.lee();
			persistencia.cerrarInput();
		} catch (Exception err) {
			this.bolsaDeTrabajo = new ArrayList<>();
		}
		
		this.comisiones = 0f;
	}
	public static Agencia getAgencia() {

		if (singleton == null) {
			singleton = new Agencia("admin", "admin");
		}
		return singleton;
	}

	/**
	 * Agrega un nuevo empleado a la coleccion de empleados
	 * 
	 * @param nuevoEmpleado
	 */
	public void registraEmpleado(Empleado nuevoEmpleado) {
		this.empleados.add(nuevoEmpleado);
	}

	/**
	 * Agrega un nuevo empleador a la coleccion de empleadores
	 * 
	 * @param nuevoEmpleador
	 */
	public void registraEmpleador(Empleador nuevoEmpleador) {
		this.empleadores.add(nuevoEmpleador);
	}

	public Usuario login(String nombreUsuario, String contrasena)throws UsuarioIncorrectoException, ContrasenaIncorrectaException {
		
		Optional<Empleador> candidatoEmpleador = empleadores.stream()
				.filter(e -> e.getNombreUsuario().equalsIgnoreCase(nombreUsuario)).findAny();
		
		if (candidatoEmpleador.isPresent()) {
			candidatoEmpleador.get().validaContrasena(contrasena);
			return candidatoEmpleador.get();
		}

		Optional<Empleado> candidatoEmpleado = empleados.stream()
				.filter(e -> e.getNombreUsuario().equalsIgnoreCase(nombreUsuario)).findAny();

		if (candidatoEmpleado.isPresent()) {
			candidatoEmpleado.get().validaContrasena(contrasena);
			return candidatoEmpleado.get();
		}
		
		if(this.administrador!=null) {
		  if (this.administrador.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
			 this.administrador.validaContrasena(contrasena);
			 return administrador;
		 }
		} 

		throw new UsuarioIncorrectoException("Usuario no encontrado", nombreUsuario);
	}

	public void mostrarEmpleados() {
		for (Empleado empleado : this.empleados) {
			System.out.println(empleado);
		}
	}

	public void mostrarEmpleador() {
		for (Empleador empleador : this.empleadores) {
			System.out.println(empleador.toString());
		}
	}

	public void mostrarTicketBusqueda() {
		for (TicketBusquedaDeEmpleo ticket : busquedas) {
			System.out.println(ticket.toString());
		}
	}

	public void mostrarTicketSolicitud() {
		for (TicketBusquedaDeEmpleado ticket : solicitudes) {
			System.out.println(ticket.toString());
		}
	}

	/**
	 * PRECOND: - El empleador debe haber conseguido un empleado
	 *
	 * Calcula las comisiones que obtendra del empleador segun el sueldo con el que
	 * el empleador remunerará al empleado El porcentaje de comision varia segun el
	 * tipo de persona que sea la empresa y segun el rubro que esta misma desarrolle
	 *
	 * Por cada punto que tenga el empleador se restara un 1% a la comision final
	 *
	 * Si el puntaje del empleador supera el porcentaje de comision, la comision
	 * final quedara en cero.
	 *
	 * @param ticket
	 * @return comision final para el empleador
	 */
	public float calculaComisionesEmpleador(TicketBusquedaDeEmpleado ticket) {// si el puntaje supera a la comision--> // devuelvo 
				
				float comision = 0;
				
				String pretensionSalarial = ticket.getFormularioDeBusqueda().getPretensionSalarial().getValor();
				Empleador empleador = (Empleador)ticket.getDueno();
				
				float sueldo = 0;
				
				switch (pretensionSalarial) {
				case "MENOS_V1":
					sueldo = this.remuneracionV1;
					break;
				case "ENTRE_V1_Y_V2":
					sueldo = (float)(this.remuneracionV1 + this.remuneracionV2 ) / 2;
					break;
				case "MAS_DE_V2":
					sueldo = this.remuneracionV2;
					break;
				}

				if (empleador.getTipoPersona().equals(TipoPersona.FISICA)) {
					if (empleador.getRubro().equals(Rubro.COMERCIO_INTERNACIONAL)) {
						if (0.8 > empleador.getPuntaje() / 100)
							comision = (float) (sueldo * (0.8 - empleador.getPuntaje() / 100));
					} else if (empleador.getRubro().equals(Rubro.COMERCIO_LOCAL)) {
						if (0.7 > empleador.getPuntaje() / 100)
							comision = (float) (sueldo * (0.7 - empleador.getPuntaje() / 100));
					} else if (0.6 > empleador.getPuntaje() / 100)
						comision = (float) (sueldo * (0.6 - empleador.getPuntaje() / 100));
				} else {
					if (empleador.getRubro().equals(Rubro.COMERCIO_INTERNACIONAL)) {
						if (1 > empleador.getPuntaje() / 100)
							comision = sueldo * (1 - empleador.getPuntaje() / 100);
					} else if (empleador.getRubro().equals(Rubro.COMERCIO_LOCAL)) {
						if (0.9 > empleador.getPuntaje() / 100)
							comision = (float) (sueldo * (0.9 - empleador.getPuntaje() / 100));
					} else if (0.8 > empleador.getPuntaje() / 100)
						comision = (float) (sueldo * (0.8 - empleador.getPuntaje() / 100));
				}
		
		return comision;
	}

	/**
	 * PRECOND: - El empleado debe haber conseguido trabajo
	 *
	 * Calcula las comisiones que obtendra del empleado segun el sueldo pretendido
	 * El porcentaje de comision varia segun el tipo de puesto
	 *
	 * Por cada punto que tenga el empleado se restara un 1% a la comision final
	 *
	 * Si el puntaje del empleado supera el porcentaje de comision, la comision
	 * final quedara en cero.
	 *
	 * @param ticket
	 * @return comision final para el empleado
	 */
	public float calculaComisionesEmpleado(TicketBusquedaDeEmpleo ticket) {
		float comision = 0;
		Empleado empleado = (Empleado) ticket.getDueno();
		String pretensionSalarial = ticket.getFormularioDeBusqueda().getPretensionSalarial().getValor();
		float sueldo = 0;
		switch (pretensionSalarial) {
		case "MENOS_V1":
			sueldo = this.remuneracionV1;
			break;
		case "ENTRE_V1_Y_V2":
			sueldo = (float)(this.remuneracionV1 + this.remuneracionV2 ) / 2;
			break;
		case "MAS_DE_V2":
			sueldo = this.remuneracionV2;
			break;
		}
		String tipoDePuesto = ticket.getFormularioDeBusqueda().getTipoDePuesto().getValor();

		if (tipoDePuesto.equalsIgnoreCase("JR")) {
			if (0.8 > empleado.getPuntaje() / 100)
				comision = (float) (sueldo * (0.8 - empleado.getPuntaje() / 100));
		} else if (tipoDePuesto.equalsIgnoreCase("SR")) {
			if (0.9 > empleado.getPuntaje() / 100)
				comision = (float) (sueldo * (0.9 - empleado.getPuntaje() / 100));
		} else if (tipoDePuesto.equalsIgnoreCase("MANAGMENT")) {
			if (1.0 > empleado.getPuntaje() / 100)
				comision = (float) (sueldo * (1.0 - empleado.getPuntaje() / 100));
		}
		return comision;
	}

	// GETTERS Y SETTERS
	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public List<EmpleadoDTO> listarEmpleados() {
		return empleados.stream().map(EmpleadoDTO::of).collect(Collectors.toList());
	}

	public Set<Empleador> getEmpleadores() {
		return empleadores;
	}

	public List<EmpleadorDTO> listarEmpleadores() {
		return empleadores.stream().map(EmpleadorDTO::of).collect(Collectors.toList());
	}

	public void setRemuneracionV1(Float remuneracionV1) {
		this.remuneracionV1 = remuneracionV1;
	}

	public void setRemuneracionV2(Float remuneracionV2) {
		this.remuneracionV2 = remuneracionV2;
	}

	public List<TicketBusquedaDeEmpleo> getBusquedas() {
		return busquedas;
	}

	public List<TicketBusquedaDeEmpleado> getSolicitudes() {
		return solicitudes;
	}

	public List<TicketEmpleadorDTO> getListaSolicitudes(String nombreUsuario) {
		return solicitudes.stream().filter(s -> s.getDueno().getNombreUsuario().equalsIgnoreCase(nombreUsuario)).map(TicketEmpleadorDTO::new).collect(Collectors.toList());
	}
	public Float getRemuneracionV1() {
		return remuneracionV1;
	}

	public Float getRemuneracionV2() {
		return remuneracionV2;
	}

	public Float getComisiones() {
		return comisiones;
	}

	/**
	 * Por cada empleador se verifica si este fue por lo menos elegido alguna vez
	 * por algun empleado en la ronda de eleccion.
	 *
	 * En cada ticket de busqueda de empleo encontraremos una lista de empleadores
	 * puntuados segun nuestro nivel de coincidencias con ellos.
	 *
	 * Recorro cada empleador de la lista del empleado para ver si este fue
	 * seleccionado.
	 *
	 * Si verifico que el empleador jamas fue seleccionado en la ronda de eleccion,
	 * se le restara 20 puntos a su puntaje final.
	 *
	 */
	public void empleadorNoElegido() {
		for (Empleador empleador : this.empleadores) {
			boolean elegido = false;
			for (TicketBusquedaDeEmpleo ticket : this.busquedas) {
				List<UsuarioPuntuado> lista = ticket.getListaDeAsignaciones();
				for (UsuarioPuntuado usuarioP : lista) {
					if (usuarioP.isSeleccionado() && usuarioP.getUsuario().equals(empleador)) {
						elegido = true;
						break;
					}
				}
				if (elegido)
					break;
			}
			if (!elegido) {
				empleador.bajarPuntaje(20);
			}
		}
	}

	public List<TicketSimplificado> getBolsaDeTrabajo() {
		return bolsaDeTrabajo;
	}

	public void registrarAdmin(RegistroRequestAdmin req) {
		Administrador newAdmin = new Administrador(req.getNombreUsuario(), req.getContrasena(), req.getID(), req.getEmail());
		this.administrador = newAdmin;
		System.out.println("Se registro el admin: " + newAdmin.getNombreUsuario());
		
		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("administrador.xml");
			persistencia.escribir(this.administrador);
			persistencia.cerrarOutput();
		} catch (Exception e) {
		}
	}

	public void registrarEmpleador(RegistroRequestEmpleador req) {
		Empleador newEmpleador = new Empleador(req.getNombreUsuario(), req.getContrasena());
		newEmpleador.setNombre(req.getNombre());
		newEmpleador.setRubro(Rubro.valueOf(req.getRubro()));
		newEmpleador.setTipoPersona(TipoPersona.valueOf(req.getTipoPersona()));
		this.empleadores.add(newEmpleador);

		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("empleadores.xml");
			persistencia.escribir(this.empleadores);
			persistencia.cerrarOutput();
		} catch (Exception e) {
		}

		System.out.println("Se registro el empleador: " + newEmpleador.getNombre());
	}

	public void registrarEmpleado(RegistroRequestEmpleado req){
		Empleado newEmpleado = new Empleado(req.getNombreUsuario(),req.getContrasena(),req.getNombre(),req.getEdad(),req.getEmail(),req.getTelefono());
		this.empleados.add(newEmpleado);
		
		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("empleados.xml");
			persistencia.escribir(this.empleados);
			persistencia.cerrarOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Se registro el empleado: " + newEmpleado.getNombre());

	}
	
	public void addTicketBusquedaDeEmpleo(TicketBusquedaDeEmpleo ticket) {
		this.busquedas.add(ticket);
		
		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("ticketBusquedaDeEmpleo.xml");
			persistencia.escribir(this.busquedas);
			persistencia.cerrarOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public void crearTicketBusquedaDeEmpleo(TicketDeEmpleadoRequest request, String username) {
		Set<Empleado> empleados = this.empleados;

		int i = 0;
		Empleado dueno = empleados.stream().filter(e -> e.getNombreUsuario().equalsIgnoreCase(username)).findFirst().get();

		FormularioBusqueda formulario = new FormularioBusqueda(request.getrEtario(), request.getLocacion(),
						request.getExperiencia(), request.getHorario(),
						request.getPuesto(), request.getEstudios(),
						request.getRemuneracion());

		//Dimos de alta el ticket del empleado en la agencia
	 	TicketBusquedaDeEmpleo ticket =	dueno.altaTicket(formulario);

		this.addTicketBusquedaDeEmpleo(ticket);
	 	
	}

	public void addTicketBusquedaDeEmpleado(TicketBusquedaDeEmpleado ticket) {
		this.solicitudes.add(ticket);
		
		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("ticketBusquedaDeEmpleados.xml");
			persistencia.escribir(this.solicitudes);
			persistencia.cerrarOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public TicketBusquedaDeEmpleado crearTicketBusquedaDeEmpleado(TicketDeEmpleadorRequest request, String username) {
		Set <Empleador> empleadores = this.empleadores;

		Empleador dueno = empleadores.stream().filter(e -> e.getNombreUsuario().equalsIgnoreCase(username)).findFirst().get();

		FormularioBusqueda formulario = new FormularioBusqueda(request.getrEtario(), request.getLocacion(),
						request.getExperiencia(), request.getHorario(),
						request.getPuesto(), request.getEstudios(),
						request.getRemuneracion());

		return dueno.altaTicket(formulario,request.getCantEmpleados());
	}
	
	public void removeTicketBusquedaDeEmpleo(TicketBusquedaDeEmpleo ticket) {
		this.busquedas.remove(ticket);
		
		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("ticketBusquedaDeEmpleo.xml");
			persistencia.escribir(this.busquedas);
			persistencia.cerrarOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeTicketBusquedaDeEmpleado(TicketBusquedaDeEmpleado ticket) {
		this.solicitudes.remove(ticket);
		
		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("ticketBusquedaDeEmpleados.xml");
			persistencia.escribir(this.solicitudes);
			persistencia.cerrarOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Modifica el ticket de un usurio, permite cambiar el formulario contenido en el.
	 * 
	 * @param ticket        ticket al que se le desea aplicar la modificacion
	 * @param formulario    nuevo formulario, reemplaza al anterior
	 */
	public void modificaTicket(Ticket ticketSel,FormularioBusqueda formulario) {
		ticketSel.setFormularioDeBusqueda(formulario);
		if( ticketSel instanceof TicketBusquedaDeEmpleado ) {
			((TicketBusquedaDeEmpleado) ticketSel).setEmpleadosNecesitados(formulario.getCantEmpleadosSolicitados());	
			
			try {
				Ipersistencia persistencia = new PersistenciaXML();
				persistencia.abrirOutput("ticketBusquedaDeEmpleados.xml");
				persistencia.escribir(this.solicitudes);
				persistencia.cerrarOutput();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			
			try {
				Ipersistencia persistencia = new PersistenciaXML();
				persistencia.abrirOutput("ticketBusquedaDeEmpleo.xml");
				persistencia.escribir(this.busquedas);
				persistencia.cerrarOutput();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public TicketBusquedaDeEmpleo encuentraTicketDeEmpleo(Usuario usuario) {
		
		List <TicketBusquedaDeEmpleo> busquedas = this.busquedas;
		
		return busquedas.stream().filter( b -> b.getDueno().getNombreUsuario().equalsIgnoreCase(usuario.getNombreUsuario()) ).findFirst().orElse(null);

	}

	public TicketBusquedaDeEmpleado encuentraTicketsDeEmpleador(String ticketId) {

		List <TicketBusquedaDeEmpleado> solicitudes = this.solicitudes;

		return solicitudes.stream().filter( b -> b.getId().equals(ticketId) ).findFirst().orElse(null);

	}

	public void cancelaTicket (TicketDTO request) {
		Optional<TicketBusquedaDeEmpleo> ticket = this.busquedas.stream().filter(t -> t.getId().equals(request.getId())).findFirst();
		if (ticket.isPresent()) {
			ticket.get().setEstadoTicket(new CanceladoState(ticket.get()));
			this.removeTicketBusquedaDeEmpleo(ticket.get());
		}
	}

	public Ticket encuentraTicket(String ticketId) {
		Optional<? extends Ticket> result = this.busquedas.stream().filter(t -> t.getId().equals(ticketId)).findFirst();
		if (result.isPresent()) {
			return result.get();
		} else {
			result = this.solicitudes.stream().filter(t -> t.getId().equals(ticketId)).findFirst();
			return result.orElse(null);
		}
	}
	
	public Set<TicketSimplificado> getTicketSimplificadosAsignadosAEmpleados() {
		return getTicketSimplificadosAsignadosAEmpleados();
	}

	public void setTicketSimplificadosAsignadosAEmpleados(Set<TicketSimplificado> ticketSimplificadosAsignadosAEmpleados) {
		this.ticketSimplificadosAsignados = ticketSimplificadosAsignadosAEmpleados;
	}

	public void setComisiones(Float comisiones) {
		this.comisiones = comisiones;
	}

	public void addTicketSimplificadoAsignado(TicketSimplificado ticket) {
		this.ticketSimplificadosAsignados.add(ticket);
		
		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("ticketSimplificadosAsignados.xml");
			persistencia.escribir(this.ticketSimplificadosAsignados);
			persistencia.cerrarOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addTicketSimplificado(TicketSimplificado ticket) {
		this.bolsaDeTrabajo.add(ticket);
		
		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("bolsaDeTrabajo.xml");
			persistencia.escribir(this.bolsaDeTrabajo);
			persistencia.cerrarOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void removeTicketSimplificado(TicketSimplificado ticket) {
		this.bolsaDeTrabajo.remove(ticket);
		
		try {
			Ipersistencia persistencia = new PersistenciaXML();
			persistencia.abrirOutput("bolsaDeTrabajo.xml");
			persistencia.escribir(this.bolsaDeTrabajo);
			persistencia.cerrarOutput();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean estaAsignado(String username) {
		
		TicketSimplificado ticket = this.ticketSimplificadosAsignados.stream().filter(t -> t.getAsignacion().getNombreUsuario().equalsIgnoreCase(username)).findAny().orElse(null);
			
		if( ticket == null )
			return false;
		else
			return true;
		
		
	}

}
