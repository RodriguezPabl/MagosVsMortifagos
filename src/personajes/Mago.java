package personajes;

public abstract class Mago extends Personaje{
	public Mago(String nombre, int nivelDeMagia, int puntosDeVida) {
		super(nombre, nivelDeMagia, puntosDeVida);
	}
	
	@Override
	public int potenciarAtaque(int danioBase) {
		return danioBase;
	}
	
	@Override
	public int potenciarCuracion(int curacionBase) {
		return curacionBase + nivelDeMagia;
	}
}
