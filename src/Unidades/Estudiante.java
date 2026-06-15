package Unidades;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Hechizos.FactoryHechizos;
import Hechizos.HechizoBase;
import Hechizos.Incendium;
import Hechizos.Septusembra;
import consumible.Consumible;
import consumible.FactoryConsumible;
import enums.TiposHechizos;

public class Estudiante extends Mago {
	public Estudiante(String nombre) {
		super(nombre, 80, 80, "Estudiante");
		consumibles.add(Consumible.POCION_VIDA);
		consumibles.add(Consumible.POCION_VIDA);
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

		if (this.tieneSuficenteMana(Incendium.NOMBRE)) {
			p = oponentes.obtenerPrimerPersonajeMasAltoRangoPosible();
			HechizoBase h = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.INCENDIUM, this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		accion = new Meditar(this);
	}

}
