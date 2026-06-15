package Unidades;

import java.util.List;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Hechizos.*;
import consumible.Consumible;
import consumible.FactoryConsumible;
import enums.TiposHechizos;

public class Auror extends Mago {
	public Auror(String nombre) {
		super(nombre, 200, 200, "Auror");
		consumibles.add(Consumible.POCION_VIDA);
		consumibles.add(Consumible.POCION_POTENCIADORA);
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

		if (this.tieneSuficenteMana(Bombardum.NOMBRE)) {
			List<Personaje> ps = oponentes.getTodosLosPersonaje();
			HechizoBase h = FactoryHechizos.crearHechizoAtaqueEnArea(TiposHechizos.BOMBARDUM, this, ps);
			accion = new LanzarHechizo(h);
			return;
		}

		Personaje p = oponentes.obtenerPersonajeMenorVida();
		if (this.tieneSuficenteMana(Septusembra.NOMBRE) && p.getVida() <= Septusembra.DAÑO) {
			HechizoBase h = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.SEPTUSEMBRA, this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		accion = new Meditar(this);
	}

}
