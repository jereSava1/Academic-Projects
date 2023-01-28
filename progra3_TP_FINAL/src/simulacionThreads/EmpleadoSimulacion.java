package simulacionThreads;

import model.ticket.DatosDeEmpleo;
import types.Rubro;

public class EmpleadoSimulacion extends Thread {
	
	private String nombre;
	private TicketSimplificado ticketSimplificado;
	private DatosDeEmpleo locacion;
	private Rubro rubro;
	private BolsaDeTrabajoServiceSimulacion bolsa;
	private boolean tengoTicket=false;

	public BolsaDeTrabajoServiceSimulacion getBolsa() {
		return bolsa;
	}


	public void setBolsa(BolsaDeTrabajoServiceSimulacion bolsa) {
		this.bolsa = bolsa;
	}


	public boolean isTengoTicket() {
		return tengoTicket;
	}


	public void setTengoTicket(boolean tengoTicket) {
		this.tengoTicket = tengoTicket;
	}


	public EmpleadoSimulacion(String nombre, DatosDeEmpleo locacion, Rubro rubro,BolsaDeTrabajoServiceSimulacion bolsa) {
		this.nombre = nombre;
		this.ticketSimplificado = null;
		this.locacion = locacion;
		this.rubro = rubro;
		this.bolsa=bolsa;
	}


	@Override
	public void run() {
		int i=0;
		while(i<10 && !this.bolsa.getBolsaDeTrabajoService().isFinalizado() && !tengoTicket) {
			Util.espera();
			System.out.println("El empleado "+ this.getNombre()+" esta yendo a buscar un ticket");
			bolsa.sacaTicketSimplificado(this);
			i++;
		}
		
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TicketSimplificado getTicketSimplificado() {
		return ticketSimplificado;
	}


	public void setTicketSimplificado(TicketSimplificado ticketSimplificado) {
		this.ticketSimplificado = ticketSimplificado;
	}
	
	
	
	

}
