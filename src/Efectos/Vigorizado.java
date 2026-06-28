package Efectos;

import Unidades.Personaje;
import logger.Logger;

public class Vigorizado extends Efecto {

	public Vigorizado(Personaje personaje) {
		this.personaje = personaje;
		this.turnosFaltantes = 10;
	}

	@Override
	public void activar() {
		Logger.agregarMensaje(personaje + " esta vigorizado +10HP +10MP");
		personaje.ganarMana(10);
		personaje.ganarVida(10);
	}

}
