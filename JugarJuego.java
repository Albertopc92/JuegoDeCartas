package juegoDeCartas;

import utiles.Menu;
import utiles.Teclado;
import juegoDeCartas.exceptions.*;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class JugarJuego {
	
	private static Menu menuPrincipal, menuJugadores;
	private static ListaJugadores listaJugadores = new ListaJugadores();
	private static Partida partida;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		menuPrincipal = new Menu("Menu Principal", new String[] {"Gestionar Jugadores", "Jugar", "Ranking"});
		
				
		do {
			switch (menuPrincipal.gestionar()) {
			case 1:
				menujugadores();
				break;
			case 2:
				jugar();
				break;
			case 3:
				ranking();
				break;
			default:
				System.out.println("Has salido del programa");
				return;
			}
		}while(true);
		
	}
	
	/**
	 * Muestra un ranking
	 */
	private static void ranking() {
		listaJugadores.ranking();
	}
	
	/**
	 * Inicia la partida
	 */
	private static void jugar() {
		partida = new Partida();
		try {
			partida.jugar(listaJugadores, Teclado.leerEntero("Â¿Cuantos jugadores van a participar?"));
		} catch (BarajaVaciaException e) {
			System.out.println(e.getMessage());
		} catch (PosicionNoValidaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Gestiona el menu de opciones de los jugadores
	 */
	private static void menujugadores() {
		menuJugadores = new Menu("GestiÃ³n de jugadores", new String[] {"Crear Jugador", "Mostrar lista de jugadores"});
		
		do {
			switch (menuJugadores.gestionar()) {
			case 1:
				addJugador();
				break;
			case 2:
				showJugadores();
				break;
			default:
				return;
			}
		} while (true);
		
	}
	
	/**
	 * Muestra la lista de jugadores
	 */
	private static void showJugadores() {
		try {
			listaJugadores.show();
		} catch (ListaVaciaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 *Añade jugador
	 */
	private static void addJugador() {
		int numJugadores = Teclado.leerEntero("¿Cuantos jugadores quieres crear?");
		for(int i = 0; i < numJugadores; i++)
			listaJugadores.addJugador(Teclado.leerCadena("Introduzca el nombre del jugador: "));
	}

}
