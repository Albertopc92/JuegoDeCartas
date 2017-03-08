package juegoDeCartas;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Carta {
	
	private final Palo palo;
	private final Figura figura;
	
	Carta(Palo palo, Figura figura){
		this.palo = palo;
		this.figura = figura;
	}
	
	double getValor(){
		return figura.getValor();
	}
	
	@Override
	public String toString() {
		return figura + " de " + palo;
	}
}
