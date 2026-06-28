package Unidades;

import java.util.List;

public interface Combatiente {
	public void luchar(Combatiente enemigo);

	public boolean estaMuerto();

	public void imprimirInfo();

	// Metodo para el patron Composite: cada combatiente sabe devolver sus personajes
	public List<Personaje> obtenerPersonajesInternos();
}
