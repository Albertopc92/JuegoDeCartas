package juegoDeCartas.exceptions;

public class PosicionNoValidaException extends Exception {
	private static final long serialVersionUID = 1L;
	public PosicionNoValidaException() {}
	public PosicionNoValidaException(String msg) {
		super(msg);
	}
}
