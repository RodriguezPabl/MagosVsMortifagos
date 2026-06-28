package Unidades;

import Acciones.LanzarHechizo;
import Acciones.Meditar;
import Acciones.TomarConsumible;
import Hechizos.FactoryHechizos;
import Hechizos.HechizoBase;
import Hechizos.Petrificus;
import Hechizos.Protego;
import Hechizos.Septusembra;
import consumible.Consumible;
import consumible.FactoryConsumible;
import enums.TiposHechizos;

public class Profesor extends Mago {

	public Profesor(String nombre) {
		super(nombre, 130, 130, "Profesor");
		consumibles.add(Consumible.POCION_VIDA);
		consumibles.add(Consumible.POCION_VIDA);
		consumibles.add(Consumible.POCION_VIGORIZANTE);
	}

	@Override
	public int getPrioridad() { return 2; }

	@Override
	public void pensarAccion(Batallon aliados, Batallon oponentes) {

		String consumible = this.obtenerPrimerNombreObjetoUtil();

		if (consumible != null) {
			Consumible c = FactoryConsumible.crearConsumible(this, consumible);
			accion = new TomarConsumible(c);
			return;
		}

		Personaje p;

		if (this.tieneSuficenteMana(Petrificus.NOMBRE) && oponentes.hayAlgunAurorOComandanteSinPetrificado()) {
			p = oponentes.obtenerElPrimerAurorOComandanteSinPetrificar();
			HechizoBase h = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.PETRIFICUS, this, p);
			accion = new LanzarHechizo(h);
			return;
		}

		if (this.tieneSuficenteMana(Protego.NOMBRE)) {
			p = aliados.obtenerPrimerPersonajeMasAltoRangoPosibleSinProtego();
			if (p != null) {
				HechizoBase h = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.PROTEGO, this, p);
				accion = new LanzarHechizo(new Protego(this, p));
				return;
			}
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
