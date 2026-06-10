package hechizos;

import personajes.Personaje;

public class AvadaKedavra implements Hechizo{
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		int danio = lanzador.potenciarAtaque(50);
		objetivo.recibirDanio(danio);
		
		System.out.println(lanzador.getNombre() + " lanzó Avada Kedavra sobre " + objetivo.getNombre());
	}

	@Override
	public String getNombre() {
		return "Avada Kedavra";
	}
}
