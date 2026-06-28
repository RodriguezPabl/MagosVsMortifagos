package Hechizos;


import Unidades.Personaje;

public abstract class HechizoBase implements Hechizo {

	protected Personaje lanzador;
	protected int dañoBase, costeMana;
	protected String nombre;
	protected String descripcion;

	public String getNombre() {
		return this.nombre;
	}

	public Personaje getLanzador() {
		return this.lanzador;
	}

	public int getCostoMana() {
		return this.costeMana;
	}

	public int getDañoBase() {
		return this.dañoBase;
	}

	public abstract void ejecutar();

}
