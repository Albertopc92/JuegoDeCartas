package juegoDeCartas;

import java.util.ArrayList;

import juegoDeCartas.exceptions.ListaVaciaException;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Partida {
	
	private Baraja baraja;
	private ListaJugadores listaJugadores;
	private int numJugadores;
	
	public Partida(int numJugadores) {
		setBaraja(new Baraja());
		setNumJugadores(numJugadores);
	}

	public Baraja getBaraja() {
		return baraja;
	}

	private void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}

	public ListaJugadores getListaJugadores() {
		return listaJugadores;
	}

	private void setListaJugadores(ListaJugadores listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	private void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}
	
	public void seleccionarJugadores() throws ListaVaciaException{
		listaJugadores.show();
	}
	
}
