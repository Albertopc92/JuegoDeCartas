package juegoDeCartas.exceptions;

public class ListaVaciaException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListaVaciaException() {}
	
	public ListaVaciaException(String msg){
		super(msg);
	}
}
