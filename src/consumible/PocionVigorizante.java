package consumible;

import Efectos.Vigorizado;
import Unidades.Personaje;
import logger.Logger;

public class PocionVigorizante extends Consumible {

	public PocionVigorizante(Personaje p) {
		this.personaje = p;
	}

	@Override
	public void activarConsumible() {
		Logger.agregarMensaje(personaje + " ha consumido la pocion vigorizante, añadiendo efecto...");
		personaje.agregarEfecto(new Vigorizado(personaje));
	}

	@Override
	public String getNombre() {
		return Consumible.POCION_VIGORIZANTE;
	}

}
