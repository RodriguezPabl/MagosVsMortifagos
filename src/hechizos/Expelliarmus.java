package hechizos;

import personajes.Personaje;

public class Expelliarmus implements Hechizo{
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		int danio = lanzador.potenciarAtaque(20);
		objetivo.recibirDanio(danio);
		
		System.out.println(lanzador.getNombre() + " lanzó Expelliarmus sobre " + objetivo.getNombre());
	}

	@Override
	public String getNombre() {
		return "Expelliarmus";
	}
}
