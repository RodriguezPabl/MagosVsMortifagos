package Hechizos;

import java.util.List;

import Efectos.Agilizado;
import Efectos.Potenciado;
import Efectos.Protegido;
import Unidades.Auror;
import Unidades.Personaje;
import logger.Logger;

public class Bombardum extends HechizoBase {
	public static final int costo = 90;
	public static final String NOMBRE = "Bombardum";
	private List<Personaje> objetivos;

	public Bombardum(Personaje lanzador, List<Personaje> objetivos) {
		this.nombre = "Bombardum";
		this.lanzador = lanzador;
		this.objetivos = objetivos;
		this.dañoBase = 240;
		this.costeMana = 90;
		this.descripcion = "Hechizo potente y costoso de area, solo lo pueden usar aurores.";
	}

	@Override
	public void ejecutar() {

		if (objetivos.contains(lanzador)) {
			Logger.agregarMensaje("No puede lanzarse ese hechizo, el impacto le afectara a si mismo");
			return;
		}

		lanzador.gastarMana(costeMana);

		int dañoRepartido = dañoBase / objetivos.size();

		if (lanzador.tieneEfecto(Potenciado.class))
			dañoRepartido *= 2;

		int dañoBasePorUnidad;
		for (Personaje objetivo : objetivos) {
			Logger.agregarMensaje(lanzador + " ha realizado el hechizo " + nombre + " a " + objetivo);

			dañoBasePorUnidad = dañoRepartido;
			
			if (objetivo.tieneEfecto(Agilizado.class)) {
				Logger.agregarMensaje(objetivo + " estaba Agilizado y con su suerte evito el ataque");
				continue;
			}

			if (objetivo.tieneEfecto(Protegido.class)) {
				Logger.agregarMensaje(objetivo + " estaba Protegido se reduce el daño a un tercio");
				dañoBasePorUnidad /= 3;
			}

			objetivo.recibirDaño(dañoBasePorUnidad);
			Logger.agregarMensaje(objetivo + " ha recibido " + dañoBasePorUnidad + " de daño");
		}

	}

}
