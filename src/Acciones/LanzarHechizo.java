package Acciones;

import Hechizos.HechizoBase;
import Unidades.*;

public class LanzarHechizo implements Accion {
	private HechizoBase hechizo;

	public LanzarHechizo(HechizoBase hechizo) {
		this.hechizo = hechizo;
	}

	@Override
	public void ejecutar() {
		hechizo.ejecutar();
		// Registra el hechizo usado en la ronda (Set)
		hechizo.getLanzador().registrarHechizoUsado(hechizo.getNombre());
	}
}
