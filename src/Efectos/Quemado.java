package Efectos;

import Unidades.Personaje;
import logger.Logger;

public class Quemado extends Efecto {

	public Quemado(Personaje personaje) {
		this.personaje = personaje;
		this.turnosFaltantes = 5;
	}

	Quemado(Personaje persona, int cantTurnos) {
		this.personaje = persona;
		this.turnosFaltantes = cantTurnos;
	}

	@Override
	public void activar() {
		int dañoBaseFuego = 15;
		Logger.agregarMensaje(personaje + " esta quemado -" + dañoBaseFuego + "HP");
		personaje.recibirDaño(dañoBaseFuego);
	}
}
