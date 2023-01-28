package factory;

import exception.ConstructorInvalidoException;
import model.ticket.Locacion.HomeOfiice;
import model.ticket.Locacion.Indistinto;
import model.ticket.DatosDeEmpleo;
import model.ticket.Locacion.Presencial;

public class LocacionFactory {

	public static DatosDeEmpleo getLocacion(String tipo, int peso) throws ConstructorInvalidoException {

		if (tipo == null) {
			return null;
		}

		if (tipo.equalsIgnoreCase("HOMEOFFICE")) {
			return new HomeOfiice(peso);
		}

		if (tipo.equalsIgnoreCase("PRESENCIAL")) {
			return new Presencial(peso);
		}

		if (tipo.equalsIgnoreCase("INDISTINTO")) {
			return new Indistinto(peso);
		}

		throw new ConstructorInvalidoException(tipo);
	}
}
