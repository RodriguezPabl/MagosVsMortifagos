package consumible;

import Unidades.Personaje;
import logger.Logger;

public class Orocrux extends Consumible {

	public Orocrux(Personaje p) {
		this.personaje = p;
	}

	@Override
	public void activarConsumible() {
		int vidaARestaurar = personaje.getVidaMax();
		Logger.agregarMensaje(personaje + " ha usado un Orocrux, restaurando toda su vida!");
		personaje.ganarVida(vidaARestaurar);
	}

	@Override
	public String getNombre() {
		return Consumible.OROCRUX;
	}
}
