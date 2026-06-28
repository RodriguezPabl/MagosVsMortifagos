package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Unidades.*;
import enums.TiposPersonaje;

class FactoryPersonajeTest {

    @Test
    void testCrearPersonajeAuror() {
        Personaje auror = FactoryPersonaje.crearPersonaje("Harry", TiposPersonaje.AUROR);
        assertTrue(auror instanceof Auror, "Debería crear un personaje de tipo Auror");
    }

    @Test
    void testCrearPersonajeProfesor() {
        Personaje profesor = FactoryPersonaje.crearPersonaje("Dumbledore", TiposPersonaje.PROFESOR);
        assertTrue(profesor instanceof Profesor, "Debería crear un personaje de tipo Profesor");
    }

    @Test
    void testCrearPersonajeEstudiante() {
        Personaje estudiante = FactoryPersonaje.crearPersonaje("Hermione", TiposPersonaje.ESTUDIANTE);
        assertTrue(estudiante instanceof Estudiante, "Debería crear un personaje de tipo Estudiante");
    }

    @Test
    void testCrearPersonajeComandante() {
        Personaje comandante = FactoryPersonaje.crearPersonaje("Voldemort", TiposPersonaje.COMANDANTE);
        assertTrue(comandante instanceof Comandante, "Debería crear un personaje de tipo Comandante");
    }

    @Test
    void testCrearPersonajeMagoOscuro() {
        Personaje magoOscuro = FactoryPersonaje.crearPersonaje("Bellatrix", TiposPersonaje.MAGOOSCURO);
        assertTrue(magoOscuro instanceof MagoOscuro, "Debería crear un personaje de tipo MagoOscuro");
    }

    @Test
    void testCrearPersonajeSeguidor() {
        Personaje seguidor = FactoryPersonaje.crearPersonaje("Lucius", TiposPersonaje.SEGUIDOR);
        assertTrue(seguidor instanceof Seguidor, "Debería crear un personaje de tipo Seguidor");
    }

    @Test
    void testCrearPersonajeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactoryPersonaje.crearPersonaje("Error", TiposPersonaje.valueOf("PERSONAJE_INVALIDO"));
        }, "Debería lanzar IllegalArgumentException si el tipo de personaje es inválido");
    }
}
