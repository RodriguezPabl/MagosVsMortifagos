package hechizos;

import personajes.Personaje;

public class ExpectoPatronum implements Hechizo{

	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		int curacion = lanzador.potenciarCuracion(25);
		
		objetivo.curar(curacion);
	}

	@Override
	public String getNombre() {
		return "Expecto Patronum";
	}
	
}
