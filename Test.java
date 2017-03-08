package juegoDeCartas;

import juegoDeCartas.exceptions.BarajaVaciaException;
import utiles.Continuar;

public class Test {

	public static void main(String[] args) {
		
		Baraja baraja = new Baraja();
		ListaJugadores lista = new ListaJugadores();
		/*baraja.show();*/
		/*
		do {
			try {
				System.out.println(baraja.sacarCarta() + "\n Quedan " + baraja.getCartasRestantes() + " cartas");
			} catch (BarajaVaciaException e) {
				System.out.println(e.getMessage());
			}
		}while(Continuar.continuar("continuar?"));
		*/
		
		lista.addJugador("pepe");
		lista.addJugador("otro");
		lista.show();
	}

}
