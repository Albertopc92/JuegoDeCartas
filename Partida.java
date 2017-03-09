package juegoDeCartas;

import java.util.ArrayList;
import juegoDeCartas.exceptions.BarajaVaciaException;
import utiles.Continuar;
import utiles.Teclado;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Partida {
	
	private Baraja baraja;
	private ArrayList<Jugador> participantes;
	
	public Partida() {
		baraja = new Baraja();
		participantes = new ArrayList<Jugador>();
	}
	
	/**
	 * Juega una partida de cartas
	 * @param listaJugadores
	 * 						lista de jugadores que pueden participar
	 * @throws BarajaVaciaException
	 */
	void jugar(ListaJugadores listaJugadores) throws BarajaVaciaException {
		int id;
		System.out.println(listaJugadores.toString());
		do {
			id = Teclado.leerEntero("Indica el ID del jugador a participar");
			participantes.add(listaJugadores.getJugador(id));
			participantes.get(id-1).incPJugadas();
		}while(Continuar.continuar("¿Desea añadir otro jugador?"));
		
		for (Jugador jugador : participantes) {
			turno(jugador);
			esGanador(jugador);
		}
	}
	
	/**
	 * Incrementa las partidas ganadas a un jugador si es ganador de una partida
	 * @param jugador
	 */
	private void esGanador(Jugador jugador) {
		if(jugador.getPuntuacion() == 7.5)
			jugador.incPGanadas();
	}

	/**
	 * Turno de juego de cada jugador de la partida
	 * @param jugador
	 * 					Jugador al que le toca el turno
	 * @throws BarajaVaciaException
	 */
	private void turno(Jugador jugador) throws BarajaVaciaException {
		double puntuacion = 0;
		Carta carta;
		
		System.out.println("Turno de " + jugador.getNombre());
		
		do {
			carta = baraja.sacarCarta();
			puntuacion += carta.getValor();
			System.out.println("Puntos acumulados: " + puntuacion);
			if(comprobarPuntuacion(puntuacion) == false) {
				break;
			}
		}while(Continuar.continuar("¿Quieres otra carta?"));
		
		System.out.println("Tu turno ha concluido con: " + puntuacion + " puntos");
		jugador.setPuntuacion(puntuacion);
	}
	
	/**
	 * Comprueba la puntuacion del jugador
	 * @param puntuacion
	 * 					Puntos del jugador
	 * @return
	 */
	private boolean comprobarPuntuacion(double puntuacion) {
		if(puntuacion > 7.5) {
			System.out.println("Te has pasado =(");
			return false;
		}else if(puntuacion == 7.5) {
			System.out.println("Has ganado =)");
			return true;
		}
			return true;
	}
}
