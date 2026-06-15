package Unidades;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Hechizos.AvadaKedavra;
import Hechizos.FactoryHechizos;
import Hechizos.HechizoBase;
import Hechizos.Septusembra;
import consumible.Consumible;
import consumible.FactoryConsumible;
import enums.TiposHechizos;

public class Comandante extends Mortifago {
	public Comandante(String nombre) {
		super(nombre, 200, 200, "Comandante");
		consumibles.add(Consumible.OROCRUX);
	}

	@Override
	public int getPrioridad() { return 3; }

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {

		String consumible = this.obtenerPrimerNombreObjetoUtil();
		if (consumible != null) {
			Consumible c = FactoryConsumible.crearConsumible(this, consumible);
			accion = new TomarConsumible(c);
			return;
		}

		Personaje p;
		if (this.tieneSuficenteMana(AvadaKedavra.NOMBRE)) {
			p = oponentes.obtenerPersonajeMayorVida();
			HechizoBase h = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.AVADAKEDAVRA, this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		p = oponentes.obtenerPersonajeMenorVida();
		if (this.tieneSuficenteMana(Septusembra.NOMBRE) && p.getVida() <= Septusembra.DAÑO) {
			HechizoBase h = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.SEPTUSEMBRA, this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		accion = new Meditar(this);
	}

}
