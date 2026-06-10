package fabricas;

import personajes.*;

public class FabricaPersonajes {
	public static Personaje crearPersonaje(String tipo, String nombre) {
		switch(tipo.toUpperCase()) {
			case "AUROR":
			return new Auror(nombre);
			
			case "PROFESOR":
			return new Profesor(nombre);
			
			case "ESTUDIANTE":
			return new Estudiante(nombre);
			
			case "SEGUIDOR":
			return new Seguidor(nombre);
			
			case "COMANDANTE":
			return new Comandante(nombre);
			
			default:
			throw new IllegalArgumentException("Personaje inexistente");
		}
	}
}
