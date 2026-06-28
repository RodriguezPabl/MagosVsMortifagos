package consumible;

import Unidades.Personaje;
import logger.Logger;

public class PocionMana extends Consumible {

	public PocionMana(Personaje personaje) {
		this.personaje = personaje;
	}

	@Override
	public void activarConsumible() {
		int manaArecargar = 100;
		Logger.agregarMensaje(personaje + " +100MP");
		personaje.ganarMana(manaArecargar);
	}

	@Override
	public String getNombre() {
		return Consumible.POCION_MANA;
	}

}
