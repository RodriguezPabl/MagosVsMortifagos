package consumible;

import Unidades.Personaje;
import logger.Logger;

public class PocionVida extends Consumible {

	public PocionVida(Personaje p) {
		this.personaje = p;
	}

	@Override
	public void activarConsumible() {
		int vidaArecargar = 100;
		Logger.agregarMensaje(personaje + " +100HP");
		personaje.ganarVida(vidaArecargar);
	}

	@Override
	public String getNombre() {
		return "pocionVida";
	}

}
