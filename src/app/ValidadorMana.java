package app;

import java.util.Map;

public class ValidadorMana {

	private static final Map<String, Integer> costos = Map.of(
		"septusembra", 30,
		"bombardum", 90,
		"avadakedavra", 80,
		"incendium", 40,
		"petrificus", 50,
		"protego", 40,
		"veneficus", 40
	);

	public static boolean puedeLanzarHechizo(String hechizo, int manaPersonaje) {
		Integer costo = costos.get(hechizo.toLowerCase());
		return costo != null && manaPersonaje >= costo;
	}
}
