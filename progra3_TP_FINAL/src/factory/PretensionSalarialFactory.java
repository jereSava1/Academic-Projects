package factory;

import exception.ConstructorInvalidoException;
import model.Agencia;
import model.ticket.experiencia.Media;
import model.ticket.pretensionSalarial.EntreV1YV2;
import model.ticket.pretensionSalarial.MasDeV2;
import model.ticket.pretensionSalarial.MenosV1;
import model.ticket.pretensionSalarial.PretensionSalarial;

public class PretensionSalarialFactory {

	public static PretensionSalarial getPretensionSalarial(int peso, String remuneracionPretendida)
			throws ConstructorInvalidoException {
		
		float v1 = Agencia.getAgencia().getRemuneracionV1();
		float v2 = Agencia.getAgencia().getRemuneracionV2();

		if (remuneracionPretendida.equalsIgnoreCase("MENOS_V1")) {
				return new MenosV1(peso);
		}

		if (remuneracionPretendida.equalsIgnoreCase("ENTRE_V1_Y_V2")) {
			return new EntreV1YV2(peso);
		}
		if (remuneracionPretendida.equalsIgnoreCase("MAS_DE_V2")) {
			return new MasDeV2(peso);
		}
		
		throw new ConstructorInvalidoException("Sueldo Pretendido menor a 0");
	}
}
