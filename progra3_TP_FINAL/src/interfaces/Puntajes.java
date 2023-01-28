package interfaces;

/**
 * Define los metodos encargados de retornar el "valor" de coincidencia o de
 * matcheo, entre 2 datos de empleo del mismo tipo. Un dato se correspondera al
 * empleado y el otro restante al empleador. Al compararse se obtiene un cierto
 * nivel de coincidencia.
 */
public interface Puntajes {

	float match1();

	float match2();

	float match3();
}
