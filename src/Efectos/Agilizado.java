package Efectos;

import Unidades.Personaje;
import logger.Logger;

public class Agilizado extends Efecto {

	public Agilizado(Personaje personaje) {
		this.personaje = personaje;
		this.turnosFaltantes = 1;
	}

	@Override
	public void activar() {
		Logger.agregarMensaje(personaje + " esta Agilizado al 100%, si tiene turnos");
	}

}
