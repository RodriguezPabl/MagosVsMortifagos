package Hechizos;

import java.util.List;

import Unidades.Personaje;
import enums.TiposHechizos;

public class FactoryHechizos {
	public static HechizoBase crearHechizoAtaqueIndividual(TiposHechizos hechizo, Personaje lanzador,
			Personaje objetivo) {
		switch (hechizo) {
		case PROTEGO:
			return new Protego(lanzador, objetivo);
		case PETRIFICUS:
			return new Petrificus(lanzador, objetivo);
		case SEPTUSEMBRA:
			return new Septusembra(lanzador, objetivo);
		case AVADAKEDAVRA:
			return new AvadaKedavra(lanzador, objetivo);
		case INCENDIUM:
			return new Incendium(lanzador, objetivo);
		case VENEFICUS:
			return new Veneficus(lanzador, objetivo);
		default:
			throw new IllegalArgumentException("Tipo de hechizo invalido: " + hechizo);
		}

	}

	public static HechizoBase crearHechizoAtaqueEnArea(TiposHechizos hechizo, Personaje lanzador,
			List<Personaje> objetivos) {
		switch (hechizo) {
		case BOMBARDUM:
			return new Bombardum(lanzador, objetivos);
		default:
			throw new IllegalArgumentException("Tipo de hechizo invalido: " + hechizo);
		}
	}
}
