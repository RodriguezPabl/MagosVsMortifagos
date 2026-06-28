package Hechizos;

import java.util.List;

import Efectos.Protegido;
import Unidades.Personaje;
import logger.Logger;

public class Protego extends HechizoBase {
	public static final int costo = 40;
	public static final String NOMBRE = "Protego";
	private int turnos;
	private Personaje objetivo;

	public Protego(Personaje lanzador, Personaje objetivos) {
		this.nombre = "Protego";
		this.lanzador = lanzador;
		this.objetivo = objetivos;
		this.dañoBase = 0;
		this.costeMana = 40;
		this.turnos = 4;
		this.descripcion = "Hechizo de proteccion basico.";
	}

	Protego(Personaje lanzador, List<Personaje> objetivos, int dañoBase, int costeMana, int turnos) {
		this.nombre = "Protego";
		this.lanzador = lanzador;
		// this.objetivos = objetivos;
		this.dañoBase = dañoBase;
		this.costeMana = costeMana;
		this.turnos = turnos;
		this.descripcion = "Hechizo de proteccion basico.";
	}
 
	@Override
	public void ejecutar() {
		Logger.agregarMensaje(lanzador + " ha realizado el hechizo " + nombre + " a " + objetivo);
		lanzador.gastarMana(costeMana);
		objetivo.agregarEfecto(new Protegido(objetivo));
	}
}
