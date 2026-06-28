package Acciones;

import consumible.Consumible;

public class TomarConsumible implements Accion {
	private Consumible consumible;

	public TomarConsumible(Consumible consumible) {
		this.consumible = consumible;
	}

	@Override
	public void ejecutar() {
		consumible.usar();
	}

}
