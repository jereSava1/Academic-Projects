package simulacionThreads;

import exception.ConstructorInvalidoException;
import factory.LocacionFactory;
import model.ticket.DatosDeEmpleo;
import types.Rubro;

public class Test {

	public Test() {
	
	}
	
	public static void main(String[] args) {
		
		BolsaDeTrabajoServiceSimulacion bolsa = BolsaDeTrabajoServiceSimulacion.getBolsaDeTrabajoService();
		
		DatosDeEmpleo locacion1=null; 
		DatosDeEmpleo locacion2=null;
		try {
			locacion2 = LocacionFactory.getLocacion("PRESENCIAL", 1);
			locacion1 = LocacionFactory.getLocacion("HOMEOFFICE", 1);
		} catch (ConstructorInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		EmpleadorSimulacion empleador1 = new EmpleadorSimulacion("Jere", locacion2, Rubro.SALUD, bolsa);
		EmpleadorSimulacion empleador2 = new EmpleadorSimulacion("Tibau", locacion1, Rubro.SALUD, bolsa);
		
		EmpleadoSimulacion e1 = new EmpleadoSimulacion("Saimon", locacion1 , Rubro.SALUD,bolsa);
		EmpleadoSimulacion e2 = new EmpleadoSimulacion("Fachita", locacion2 , Rubro.COMERCIO_INTERNACIONAL,bolsa);
		EmpleadoSimulacion e3 = new EmpleadoSimulacion("Welo", locacion1 , Rubro.COMERCIO_INTERNACIONAL,bolsa);
		
	 empleador1.start();
	 empleador2.start();
	 
	 e1.start();
	 e2.start();
	 e3.start();
		
	}

}
