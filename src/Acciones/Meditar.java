package Acciones;

import Unidades.Personaje;
import logger.Logger;

public class Meditar implements Accion {
	Personaje personaje;

	public Meditar(Personaje personaje) {
		this.personaje = personaje;
	}

	@Override
	public void ejecutar() {
		Logger.agregarMensaje(personaje + " ha meditado + 10HP  + 20MP");
		personaje.ganarMana(20);
		personaje.ganarVida(10);

	}
}
