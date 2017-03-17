package juegoDeCartas;

import java.util.ArrayList;
import juegoDeCartas.exceptions.*;
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
	 * @throws PosicionNoValidaException 
	 */
	void jugar(ListaJugadores listaJugadores, int numJugadores) throws BarajaVaciaException, PosicionNoValidaException {
		int id;
		System.out.println(listaJugadores.toString());
		
		for(int i = 0; i < numJugadores; i++) {
			id = Teclado.leerEntero("Indica la posicion del jugador a participar");
			if(id > listaJugadores.size() || id < 1)
				throw new PosicionNoValidaException("Posicion no valida");
			participantes.add(listaJugadores.getJugador(id)); // añade un jugador a la lista de jugadores participantes
			participantes.get(participantes.indexOf(listaJugadores.getJugador(id))).incPJugadas(); // Obtiene el jugador de la lista de participantes al que se le van a incrementar las partidas
		}
		
		for (Jugador jugador : participantes) {
			turno(jugador);
		}
		
		ganador();
	}
	
	/**
	 * Incrementa las partidas ganadas a un jugador si es ganador de una partida
	 * @param jugador
	 */
	private void ganador() {
		int puntuacion = 0;
		int posicion = 0;
		Jugador ganador = null;
		for (Jugador jug : participantes) {
			if(jug.getPuntuacion() == 7.5){
				ganador = participantes.get(posicion);
				break;
			}
			
			if(jug.getPuntuacion() > puntuacion && jug.getPuntuacion() < 7.5){
				puntuacion = (int)jug.getPuntuacion();
				ganador = participantes.get(posicion);
			}
	
			posicion++;	
		}
		
		ganador.incPGanadas();
		
		System.out.println("El ganador es " + ganador.getNombre());
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
			System.out.println(carta + "\nPuntos acumulados: " + puntuacion);
			
			if(puntuacion > 7.5) {
				System.out.println("Has perdido =(");
				break;
			}else if(puntuacion == 7.5) {
				System.out.println("Has ganado =)");
				break;
			}
			
		}while(Continuar.continuar("¿Quieres otra carta?"));
		
		System.out.println("Tu turno ha concluido con: " + puntuacion + " puntos");
		jugador.setPuntuacion(puntuacion);
	}

}
