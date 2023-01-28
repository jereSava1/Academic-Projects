package simulacionThreads;

import exception.ConstructorInvalidoException;
import factory.LocacionFactory;
import model.ticket.DatosDeEmpleo;
import types.Rubro;

public class EmpleadorSimulacion extends Thread {
	
	private String nombre;
	private DatosDeEmpleo locacion;
	private Rubro rubro;
	private BolsaDeTrabajoServiceSimulacion bolsaDeTrabajo;

	public EmpleadorSimulacion(String nombre, DatosDeEmpleo locacion, Rubro rubro, BolsaDeTrabajoServiceSimulacion bolsaDeTrabajo) {
		this.nombre = nombre;
		this.locacion = locacion;
		this.rubro = rubro;
		this.bolsaDeTrabajo = bolsaDeTrabajo;
	}

	@Override
	public void run() {
		TicketSimplificado ticketSimplificado = null;
		
		int opcion;
		int i = 0;
		
		DatosDeEmpleo locacion = null;
		Rubro rubro = null;
		 
		while( i < 3 && !BolsaDeTrabajoServiceSimulacion.getBolsaDeTrabajoService().isFinalizado() ) {
						
			Util.espera();
			System.out.println("El empleador "+ this.getNombre()+" esta yendo a poner un ticket");
			
			ticketSimplificado = getTicket();

		    i++;
		    this.bolsaDeTrabajo.getBolsaDeTrabajoService().agregarTicketSimplificado(ticketSimplificado);
		}
	
	 }
	
	public TicketSimplificado getTicket() {
	
	int opcion = (int)(Math.random()*3+1);
		
	switch (opcion) {
	case 1:
		try {
			locacion = LocacionFactory.getLocacion("HOMEOFFICE", 1);
		} catch (ConstructorInvalidoException e) {
			e.printStackTrace();
		}
		break;
	case 2:
		try {
			locacion = LocacionFactory.getLocacion("PRESENCIAL", 1);
		} catch (ConstructorInvalidoException e) {
			e.printStackTrace();
		}
		break;
	case 3:
		try {
			locacion = LocacionFactory.getLocacion("INDISTINTO", 1);
		} catch (ConstructorInvalidoException e) {
			e.printStackTrace();
		}
		break;
	default:
		break;
	}
	
	
	opcion = (int)(Math.random()*3+1);
	
	switch (opcion) {
	case 1:
		rubro = Rubro.SALUD;
		break;
	case 2:
		rubro = Rubro.COMERCIO_INTERNACIONAL;		
		break;
	case 3:
		rubro = Rubro.COMERCIO_LOCAL;	
		break;
	default:
		break;
	}
	
	return new TicketSimplificado(this, rubro, locacion);
}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DatosDeEmpleo getLocacion() {
		return locacion;
	}

	public void setLocacion(DatosDeEmpleo locacion) {
		this.locacion = locacion;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	
	
	
}
