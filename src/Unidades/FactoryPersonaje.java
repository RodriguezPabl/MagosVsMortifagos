package Unidades;

import enums.TiposPersonaje;

public class FactoryPersonaje {
    public static Personaje crearPersonaje(String nombre, TiposPersonaje rango) {
        switch (rango) {
            case AUROR:
                return new Auror(nombre);
            case PROFESOR:
                return new Profesor(nombre);
            case ESTUDIANTE:
                return new Estudiante(nombre);
            case COMANDANTE:
            	return new Comandante(nombre);
            case MAGOOSCURO:
            	return new MagoOscuro(nombre);
            case SEGUIDOR:
            	return new Seguidor(nombre);
            default:
                throw new IllegalArgumentException("Tipo de personaje no reconocido: " + rango);
        }
    }
}
