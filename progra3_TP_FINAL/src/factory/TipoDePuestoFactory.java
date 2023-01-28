package factory;

import exception.ConstructorInvalidoException;
import model.ticket.tipoDePuesto.Jr;
import model.ticket.tipoDePuesto.Management;
import model.ticket.tipoDePuesto.Sr;
import model.ticket.DatosDeEmpleo;

public class TipoDePuestoFactory {

	public static DatosDeEmpleo getTipoDePuesto(String tipo, int peso) throws ConstructorInvalidoException {
		if (tipo == null) {
			return null;
		}

		if (tipo.equalsIgnoreCase("JR")) {
			return new Jr(peso);
		}

		if (tipo.equalsIgnoreCase("Management")) {
			return new Management(peso);
		}

		if (tipo.equalsIgnoreCase("SR")) {
			return new Sr(peso);
		}

		throw new ConstructorInvalidoException(tipo);
	}

}
