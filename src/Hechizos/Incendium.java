package Hechizos;


import Efectos.Quemado;
import Unidades.Personaje;
import logger.Logger;

public class Incendium extends HechizoBase {
	public static final int costo = 40;
	public static final String NOMBRE = "Incendium";
	private Personaje objetivo;
	int turnos;

	public Incendium(Personaje lanzador, Personaje objetivo) {
		this.nombre = "Incendium";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 5;
		this.costeMana = 40;
		this.turnos = 5;
		this.descripcion = "Hechizo de area fuego, solo lo pueden utilizar los estudiantes.";
	}
	/*
	 * Incendium(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int
	 * costeMana, int turnos){ this.nombre = "Incendium"; this.lanzador = lanzador;
	 * this.objetivo = objetivos; this.dañoBase = dañoBase; this.costeMana =
	 * costeMana; this.turnos = turnos; this.descripcion =
	 * "Hechizo de area fuego, solo lo pueden utilizar los estudiantes."; }
	 */

	@Override
	public void ejecutar() {
		if(objetivo.equals(lanzador)) {
			Logger.agregarMensaje("No puede lanzarse ese hechizo a si mismo");
			return;
		}
		
		Logger.agregarMensaje(lanzador + " ha realizado el hechizo " + nombre + " a " + objetivo);
		lanzador.gastarMana(costeMana);

		objetivo.recibirDaño(dañoBase);
		Logger.agregarMensaje(objetivo + " ha recibido " + dañoBase + " de daño y efecto quemado");
		objetivo.agregarEfecto(new Quemado(objetivo));
	}
}
