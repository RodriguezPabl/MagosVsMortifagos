package Hechizos;


import Efectos.Envenenado;
import Unidades.Personaje;
import logger.Logger;

public class Veneficus extends HechizoBase {
	public static final int costo = 40;
	public static final String NOMBRE = "Veneficus";
	private Personaje objetivo;

	public Veneficus(Personaje lanzador, Personaje objetivo) {
		this.nombre = "Veneficus";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 10;
		this.costeMana = 40;
		this.descripcion = "Hechizo de area venenoso, solo lo pueden utilizar los seguidores.";
	}


	@Override
	public void ejecutar() {
		
		if(objetivo.equals(lanzador)) {
			Logger.agregarMensaje("No puede lanzarse ese hechizo a si mismo");
			return;
		}
		Logger.agregarMensaje(lanzador + " ha realizado el hechizo " + nombre + " a " + objetivo);
		lanzador.gastarMana(costeMana);
		objetivo.recibirDaño(dañoBase);
		Logger.agregarMensaje(objetivo + " ha recibido " + dañoBase + " de daño y efecto Enveneado");
		objetivo.agregarEfecto(new Envenenado(objetivo));
	}
}
