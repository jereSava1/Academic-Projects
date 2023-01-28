package factory;

import exception.ConstructorInvalidoException;
import model.ticket.DatosDeEmpleo;
import model.ticket.experiencia.Media;
import model.ticket.experiencia.Mucha;
import model.ticket.experiencia.Nada;

public class ExperienciaFactory {

	public static DatosDeEmpleo getExperiencia(String tipo, int peso) throws ConstructorInvalidoException {
		if (tipo == null) {
			return null;
		}

		if (tipo.equalsIgnoreCase("NADA")) {
			return new Nada(peso);
		}

		if (tipo.equalsIgnoreCase("MEDIA")) {
			return new Media(peso);
		}

		if (tipo.equalsIgnoreCase("MUCHA")) {
			return new Mucha(peso);
		}

		throw new ConstructorInvalidoException(tipo);
	}
}
