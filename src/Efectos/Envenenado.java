package Efectos;

import Unidades.Personaje;
import logger.Logger;

public class Envenenado extends Efecto {

	public Envenenado(Personaje personaje) {
		this.personaje = personaje;
		this.turnosFaltantes = 5;
	}

	Envenenado(Personaje personaje, int cantTurnos) {
		this.personaje = personaje;
		this.turnosFaltantes = cantTurnos;
	}

	@Override
	public void activar() {
		int dañoBaseVeneno = 10;
		Logger.agregarMensaje(personaje + " esta envenado -" + dañoBaseVeneno + "HP");
		personaje.recibirDaño(dañoBaseVeneno);
	}
}
