package fabricas;

import hechizos.*;

public class FabricaHechizos {
	public static Hechizo crearHechizo(String tipo) {
		switch(tipo.toUpperCase()) {
			case "EXPELLIARMUS":
				return new Expelliarmus();
				
			case "AVADA KEDAVRA":
				return new AvadaKedavra();
				
			case "PROTEGO":
				return new Protego();
				
			case "EXPECTO PATRONUM":
				return new ExpectoPatronum();
				
			default:
				throw new IllegalArgumentException("Hechizo inexistente");
		}
	}
}
