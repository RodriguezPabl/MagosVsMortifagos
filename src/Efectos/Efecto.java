package Efectos;

import Unidades.Personaje;

public abstract class Efecto {
	protected int turnosFaltantes;
	protected Personaje personaje;

	public void bajarTurno() {
		this.turnosFaltantes -= 1;
	}

	public boolean hayTurno() {
		return turnosFaltantes > 0;
	}

	abstract public void activar();
}
