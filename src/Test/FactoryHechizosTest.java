package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;
import Hechizos.*;
import Unidades.Auror;
import Unidades.Comandante;
import Unidades.Estudiante;
import Unidades.Personaje;
import enums.TiposHechizos;

class FactoryHechizosTest {

    @Test
    void testCrearHechizoAtaqueIndividual() {

        Personaje lanzador = new Comandante("Voldemort");  
        Personaje objetivo = new Auror("Harry");

        HechizoBase hechizo = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.PROTEGO, lanzador, objetivo);
        assertTrue(hechizo instanceof Protego, "Debería crear un hechizo de tipo Protego");

        hechizo = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.PETRIFICUS, lanzador, objetivo);
        assertTrue(hechizo instanceof Petrificus, "Debería crear un hechizo de tipo Petrificus");

        hechizo = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.AVADAKEDAVRA, lanzador, objetivo);
        assertTrue(hechizo instanceof AvadaKedavra, "Debería crear un hechizo de tipo AvadaKedavra");
        
        hechizo = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.INCENDIUM, lanzador, objetivo);
        assertTrue(hechizo instanceof Incendium, "Debería crear un hechizo de tipo Incendium");
        

        hechizo = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.SEPTUSEMBRA, lanzador, objetivo);
        assertTrue(hechizo instanceof Septusembra, "Debería crear un hechizo de tipo Septusembra");
        

        hechizo = FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.VENEFICUS, lanzador, objetivo);
        assertTrue(hechizo instanceof Veneficus, "Debería crear un hechizo de tipo Veneficus");
    }

    @Test
    void testCrearHechizoAtaqueEnArea() {
        Personaje lanzador = new Comandante("Lanzador");  
        Personaje objetivo1 = new Auror("Objetivo1"); 
        Personaje objetivo2 = new Estudiante("Objetivo2");
        List<Personaje> objetivos = Arrays.asList(objetivo1, objetivo2);

        HechizoBase hechizo = FactoryHechizos.crearHechizoAtaqueEnArea(TiposHechizos.BOMBARDUM, lanzador, objetivos);
        assertTrue(hechizo instanceof Bombardum, "Debería crear un hechizo de tipo Bombardum");
    }

    @Test
    void testCrearHechizoInvalido() {
        Personaje lanzador = new Comandante("Voldemort");  
        Personaje objetivo = new Auror("Harry");

        assertThrows(IllegalArgumentException.class, () -> {
            FactoryHechizos.crearHechizoAtaqueIndividual(TiposHechizos.valueOf("HECHIZO_INVALIDO"), lanzador, objetivo);
        }, "Debería lanzar IllegalArgumentException si el hechizo es inválido");
    }
}
