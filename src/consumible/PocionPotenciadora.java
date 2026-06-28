package consumible;

import Efectos.Potenciado;
import Unidades.Personaje;
import logger.Logger;

public class PocionPotenciadora extends Consumible {

	public PocionPotenciadora(Personaje p) {
		this.personaje = p;
	}

	@Override
	public void activarConsumible() {
		Logger.agregarMensaje(personaje + " ha consumido la pocion potenciadora, añadiendo efecto...");
		personaje.agregarEfecto(new Potenciado(personaje));
	}

	@Override
	public String getNombre() {
		return "pocionPotenciadora";
	}

}
