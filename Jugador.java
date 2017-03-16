package juegoDeCartas;

/**
 * @author Alberto Perez Cano
 * @version 1.0
 */
public class Jugador implements Comparable<Jugador>{
	
	private String nombre;
	private int pJugadas, pGanadas, idJugador;
	private double puntuacion;
	private static int id = 1;
	
	public Jugador(String nombre) {
		setNombre(nombre);
		setpGanadas(0);
		setpJugadas(0);
		setPuntuacion(0);
		setIdJugador(Jugador.id++);
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getpJugadas() {
		return pJugadas;
	}

	public void setpJugadas(int pJugadas) {
		this.pJugadas = pJugadas;
	}

	public int getpGanadas() {
		return pGanadas;
	}

	public void setpGanadas(int pGanadas) {
		this.pGanadas = pGanadas;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	/**
	 * Incrementa las partidas jugadas
	 */
	public void incPJugadas() {
		setpJugadas(getpJugadas() + 1);
	}
	
	/**
	 * Incrementa las partidas ganadas
	 */
	public void incPGanadas() {
		setpGanadas(getpGanadas() + 1);
	}
	
	@Override
	public String toString() {
		return 	getIdJugador() 
				+ " - " + getNombre() 
				+ " / PJ: " + getpJugadas() 
				+ " / PG: " + getpGanadas();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Jugador jugador) {
		int comparepg = ((Jugador)jugador).getpGanadas();
		return comparepg-this.pGanadas;
	}
	
	
}
