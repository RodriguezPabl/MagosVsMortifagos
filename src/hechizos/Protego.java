package hechizos;

import personajes.Personaje;

public class Protego implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		lanzador.activarProteccion();
	
		System.out.println(lanzador.getNombre() + " lanzó Protego y quedó protegido");
	}

	@Override
	public String getNombre() {
		return "Protego";
	}
	
}
