package simulacionThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class BolsaDeTrabajoServiceSimulacion extends Observable{
	
	private static BolsaDeTrabajoServiceSimulacion bolsaDeTrabajoService;
	private boolean finalizado = false;
	private List<TicketSimplificado> bolsa = new ArrayList<>();
	
	private BolsaDeTrabajoServiceSimulacion() {}

	public static BolsaDeTrabajoServiceSimulacion getBolsaDeTrabajoService() {
		if (bolsaDeTrabajoService == null) {
			bolsaDeTrabajoService = new BolsaDeTrabajoServiceSimulacion();
		}
		return bolsaDeTrabajoService;
	}
	public synchronized void agregarTicketSimplificado(TicketSimplificado ticket) {
		 bolsa.add(ticket);
		 System.out.println("El empleador "+ ticket.getDueno().getNombre()+ " GENERO un nuevo ticket ");
		 notifyAll();
	}
	
	public synchronized void sacaTicketSimplificado(EmpleadoSimulacion empleado) {
		
		int i = 0;
		
		
		while( i < bolsa.size() && !empleado.isTengoTicket() && !finalizado ) {
			if( verificaTicket(bolsa.get(i), empleado) ) {
				empleado.setTengoTicket(true);
				empleado.setTicketSimplificado(bolsa.get(i));
				bolsa.remove(i);
				System.out.println("El empleado   "+ empleado.getNombre()+ " SACO el ticket ");
			}else {
				if( i == bolsa.size()-1  ) { //Si estoy parado en el ultimo elemento y no coincide, espero
					try{
						wait();
					}catch( Exception e ) {
						e.printStackTrace();
					}
					i = 0;
				}else 
					i++;		
			}
		}
	}
	
	public boolean verificaTicket(TicketSimplificado ticket, EmpleadoSimulacion empleado) {
		
		return ticket.getLocacion().getValor().equalsIgnoreCase(empleado.getLocacion().getValor()) && ticket.getTipoDeEmpleo().equals(empleado.getRubro());
		
	}
	
	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}
	
}
