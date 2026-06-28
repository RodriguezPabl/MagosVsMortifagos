package Unidades;

import Acciones.*;
import Hechizos.*;
import consumible.*;
import enums.TiposHechizos;

public class Seguidor extends Mortifago {

	public Seguidor(String nombre) {
		super(nombre, 80, 80, "Seguidor");
		consumibles.add(Consumible.POCION_MANA);
	}

	@Override
	public int getPrioridad() { return 1; }

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {

		String consumible = this.obtenerPrimerNombreObjetoUtil();
		if (consumible != null) {
			Consumible c = FactoryConsumible.crearConsumible(this, consumible);
			accion = new TomarConsumible(c);
			return;
		}

		Personaje p = oponentes.obtenerPersonajeMenorVida();
		if (this.tieneSuficenteMana(Septusembra.NOMBRE) && p.getVida() <= Septusembra.DAÑO) {
			HechizoBase h = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.SEPTUSEMBRA, this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		if (this.tieneSuficenteMana(Veneficus.NOMBRE)) {
			p = oponentes.obtenerPrimerPersonajeMasAltoRangoPosible();
			HechizoBase h = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.VENEFICUS, this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		accion = new Meditar(this);
	}

}
