package juegoDeCartas;

import java.util.ArrayList;
import java.util.Collections;

import juegoDeCartas.exceptions.ListaVaciaException;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class ListaJugadores{
	
	ArrayList<Jugador> listaJugadores;
	
	public ListaJugadores() {
		listaJugadores = new ArrayList<Jugador>();
	}
	
	Jugador getJugador(int id) {
		return listaJugadores.get(id-1);
	}
	
	@Override
	public String toString() {
		for (Jugador jugador : listaJugadores) {
			System.out.println(jugador);
		}
		return "";
	}

	/**
	 * Añade un jugador a la lista
	 * @param nombre
	 * @return
	 */
	boolean addJugador(String nombre){
		Jugador jugador = new Jugador(nombre);
		if(listaJugadores.contains(jugador)){
			return false;
		}
		listaJugadores.add(jugador);
		return true;
	}
	
	/**
	 * Borra un jugador de la lista
	 * @param nombre
	 * @return
	 * @throws ListaVaciaException 
	 */
	boolean delJugador(int id) throws ListaVaciaException{
		if(listaJugadores.isEmpty() || posicionValida(id))
			throw new ListaVaciaException("La lista esta vacia");
		if(listaJugadores.remove(listaJugadores.get(id-1)))
				return true;
		return false;
	}
	
	/**
	 * Muestra la lista de jugadores
	 * @return 
	 * @throws ListaVaciaException 
	 */
	void show() throws ListaVaciaException{
		if(listaJugadores.isEmpty())
			throw new ListaVaciaException("La lista esta vacia");
		for (Jugador jugador : listaJugadores) {
			System.out.println(jugador);
		}
	}
	
	/**
	 * Comprueba si la posicion introducida por el usuario es correcta
	 * @param index
	 * @return
	 */
	boolean posicionValida(int index) {
		if (index - 1 < 0 || index - 1 > listaJugadores.size())
			return false;
		return true;
	}
	
	/**
	 * Tamaño de la lista
	 * @return int
	 */
	int size() {
		return listaJugadores.size();
	}
	/**
	 * Muestra el ranking segun partidas ganadas
	 */
	public void ranking() {
		Collections.sort(listaJugadores);
		
		for (Jugador jugador : listaJugadores) {
			System.out.println(jugador);
		}
	}

}
