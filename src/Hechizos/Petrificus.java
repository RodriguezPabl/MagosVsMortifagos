package Hechizos;



import Efectos.Petrificado;
import Unidades.Personaje;
import logger.Logger;

public class Petrificus extends HechizoBase {
	public static final int costo = 50;
	public static final String NOMBRE = "Petrificus";
	private Personaje objetivo;

	public Petrificus(Personaje lanzador, Personaje objetivo) {
		this.nombre = "Petrificus";
		this.lanzador = lanzador;
		this.objetivo = objetivo;
		this.dañoBase = 0;
		this.costeMana = 50;
		this.descripcion = "Hechizo de petrificacion basico.";
	}

	@Override
	public void ejecutar() {
		
		if(objetivo.equals(lanzador)) {
			Logger.agregarMensaje("No puede lanzarse ese hechizo a si mismo");
			return;
		}
		Logger.agregarMensaje(lanzador + " ha realizado el hechizo " + nombre + " a " + objetivo);
		lanzador.gastarMana(costeMana);

		objetivo.agregarEfecto(new Petrificado(objetivo));
	}
}
