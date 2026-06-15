package Efectos;

import Unidades.Personaje;
import logger.Logger;

public class Protegido extends Efecto {

	public Protegido(Personaje personaje) {
		this.personaje = personaje;
		this.turnosFaltantes = 3;
	}

	Protegido(Personaje persona, int cantTurnos) {
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}

	@Override
	public void activar() {
		Logger.agregarMensaje(personaje + " esta protegido, reduccion de daño");
	}
}
