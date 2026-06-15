package Unidades;

public abstract class Mago extends Personaje {
	protected Mago(String nombre, int vida, int mana, String rango) {
		super(nombre, vida, mana, "Mago", rango);
	}
}
