package factory;

import exception.ConstructorInvalidoException;
import model.ticket.DatosDeEmpleo;
import model.ticket.estudios.Primario;
import model.ticket.estudios.Secundario;
import model.ticket.estudios.Terciario;

public class EstudiosFactory {

	public static DatosDeEmpleo getEstudios(String tipo, int peso) throws ConstructorInvalidoException {
		if (tipo == null) {
			return null;
		}

		if (tipo.equalsIgnoreCase("PRIMARIO")) {
			return new Primario(peso);
		}

		if (tipo.equalsIgnoreCase("SECUNDARIO")) {
			return new Secundario(peso);
		}

		if (tipo.equalsIgnoreCase("TERCIARIO")) {
			return new Terciario(peso);
		}

		throw new ConstructorInvalidoException(tipo);
	}
}
