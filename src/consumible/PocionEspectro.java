package consumible;

import Efectos.Agilizado;
import Unidades.Personaje;
import logger.Logger;

public class PocionEspectro extends Consumible {

	public PocionEspectro(Personaje p) {
		this.personaje = p;
	}

	@Override
	public void activarConsumible() {
		Logger.agregarMensaje(personaje + " ha consumido la pocion espectro, añadiendo efecto agilizado...");
		personaje.agregarEfecto(new Agilizado(personaje));
	}

	@Override
	public String getNombre() {
		return "pocionEspectro";
	}

}
