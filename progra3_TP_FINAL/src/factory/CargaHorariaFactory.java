package factory;

import exception.ConstructorInvalidoException;
import model.ticket.DatosDeEmpleo;
import model.ticket.cargaHoraria.Completa;
import model.ticket.cargaHoraria.Extendida;
import model.ticket.cargaHoraria.Media;

public class CargaHorariaFactory {

	/**
	 * Metodo Factory para generar un objeto del tipo DatoDeEmpleo para calcular el
	 * puntaje, recibira dos parametros, un String "tipo" que especifique el
	 * requerimiento, y otro de tipo int "peso" que le da el valor que le presta el
	 * usuario a este requerimento.
	 *
	 * pre: peso >= 0 pos: Se genera una nueva instancia tipo DatosDeEmpleo segun el
	 * tipo ingresado
	 *
	 * @param tipo Identificador para poder instanciar el requerimiento del usuario
	 * @param peso Valor/importancia que le da el usuario al tipo de dato
	 * @return Objetos de tipo clases extendidas de DatoDeEmpleo (especifica la
	 *         cargaHoraria)
	 * @throws ConstructorInvalidoException Lanza excepcion si no existe ese "tipo"
	 *                                      de requerimiento
	 */

	public static DatosDeEmpleo getCargaHoraria(String tipo, int peso) throws ConstructorInvalidoException {
		if (tipo == null) {
			return null;
		}

		if (tipo.equalsIgnoreCase("COMPLETA")) {
			return new Completa(peso);
		}

		if (tipo.equalsIgnoreCase("EXTENDIDA")) {
			return new Extendida(peso);
		}

		if (tipo.equalsIgnoreCase("MEDIA")) {
			return new Media(peso);
		}

		throw new ConstructorInvalidoException(tipo);
	}
}
