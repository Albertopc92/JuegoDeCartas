package juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;
import juegoDeCartas.exceptions.BarajaVaciaException;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Baraja {
	
	ArrayList<Carta> baraja = null;
	private static final int NUMCARTAS = 40;
	private int cartasRestantes;
	
	public Baraja(){
		baraja = new ArrayList<Carta>();
		for (Palo palo : Palo.values()) {
			for (Figura figura : Figura.values()) {
				baraja.add(new Carta(palo, figura));
			}
		}
		setCartasRestantes(getCartas());
		Collections.shuffle(baraja);
	}

	public int getCartasRestantes() {
		return cartasRestantes;
	}


	public void setCartasRestantes(int cartasRestantes) {
		this.cartasRestantes = cartasRestantes;
	}


	public static int getCartas() {
		return NUMCARTAS;
	}
	
	/**
	 * Saca las cartas
	 * @return carta
	 * @throws BarajaVaciaException
	 */
	Carta sacarCarta() throws BarajaVaciaException {
		if(getCartasRestantes() == 0)
			throw new BarajaVaciaException("La baraja esta vacia");

		Carta carta;
		int i = 0;
		do {
			carta = baraja.get(i);
			i++;
		}while(i < getCartasRestantes());
		
		setCartasRestantes(getCartasRestantes() - 1);
		
		return carta;
	}
	/**
	 * Muestra la baraja al completo
	 */
	public void show() {
		for (Carta carta: baraja) {
			System.out.println(carta);
		}
	}

}
