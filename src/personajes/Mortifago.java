package personajes;

public abstract class Mortifago extends Personaje{
	public Mortifago(String nombre, int nivelDeMagia, int puntosDeVida) {
		super(nombre, nivelDeMagia, puntosDeVida);
	}
	
	@Override
	public int potenciarAtaque(int danioBase) {
		return danioBase + nivelDeMagia;
	}
	
	@Override
	public int potenciarCuracion(int curacionBase) {
		return curacionBase;
	}
}
