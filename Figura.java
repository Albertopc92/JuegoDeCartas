package juegoDeCartas;

/**
 * Figuras de las cartas
 * 
 * @author Alberto Perez Cano
 * @version 1.0
 */
public enum Figura {
	AS(1),
	DOS(2),
	TRES(3),
	CUATRO(4),
	CINCO(5),
	SEIS(6),
	SIETE(7),
	SOTA(0.5),
	CABALLO(0.5),
	REY(0.5);
	
	private final double valor;
	
	private Figura(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the valor
	 */
	double getValor() {
		return valor;
	}	
	
}
