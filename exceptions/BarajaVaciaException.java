package juegoDeCartas.exceptions;

public class BarajaVaciaException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public BarajaVaciaException() {}
	
	public BarajaVaciaException(String msg) {
		super(msg);
	}

}
