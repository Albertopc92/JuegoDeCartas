package juegoDeCartas;

import utiles.Menu;
import utiles.Teclado;
import juegoDeCartas.exceptions.ListaVaciaException;
import utiles.Continuar;
/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class JugarJuego {
	
	private static Menu menuPrincipal, menuJugadores;
	private static ListaJugadores listaJugadores = new ListaJugadores();
	
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
				//ranking();
				break;
			default:
				System.out.println("Has salido del programa");
				return;
			}
		}while(true);
		
	}

	private static void jugar() {
		Partida partida = new Partida(Teclado.leerEntero("¿Cuantos jugadores van a participar?"));
		try {
			partida.seleccionarJugadores();
		} catch (ListaVaciaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void menujugadores() {
		menuJugadores = new Menu("Gestión de jugadores", new String[] {"Crear Jugador", "Borrar Jugador", "Mostrar lista de jugadores"});
		
		do {
			switch (menuJugadores.gestionar()) {
			case 1:
				addJugador();
				break;
			case 2:
				delJugador();
				break;
			case 3:
				showJugadores();
				break;
			default:
				return;
			}
		} while (true);
		
	}

	private static void showJugadores() {
		try {
			listaJugadores.show();
		} catch (ListaVaciaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void delJugador() {
		try {
			listaJugadores.delJugador(Teclado.leerEntero("Introduzca el ID del jugador que quiere borrar: "));
		} catch (ListaVaciaException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void addJugador() {
		listaJugadores.addJugador(Teclado.leerCadena("Introduzca el nombre del jugador: "));
	}

}
