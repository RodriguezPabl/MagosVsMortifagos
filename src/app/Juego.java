package app;

import enums.TiposPersonaje;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Unidades.*;
import logger.Logger;

public class Juego {
	private Batallon batallon_1, batallon_2;
	List<Personaje> personajes_vivos_1, personajes_vivos_2;
	// Map: registra los hechizos lanzados por cada personaje durante toda la batalla
	private Map<String, List<String>> registroHechizos;

	public Juego() {
		batallon_1 = new Batallon();
		batallon_2 = new Batallon();
		registroHechizos = new HashMap<>();
	}

	public void cargarDatos() { /// aca se da todos los datos que necesitamos
		batallon_1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Harry Potter", TiposPersonaje.ESTUDIANTE));
		batallon_1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Faul Loger", TiposPersonaje.AUROR));
		batallon_1.agregarCombatiente(FactoryPersonaje.crearPersonaje("Snape", TiposPersonaje.PROFESOR));
		
		Batallon batallon_3= new Batallon();
		batallon_3.agregarCombatiente(FactoryPersonaje.crearPersonaje("GLORO!!!", TiposPersonaje.PROFESOR));
		batallon_1.agregarCombatiente(batallon_3);
		
		
		batallon_2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Seguidor 1", TiposPersonaje.SEGUIDOR));
		batallon_2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Seguidor 2", TiposPersonaje.SEGUIDOR));
		batallon_2.agregarCombatiente(FactoryPersonaje.crearPersonaje("Voldemort", TiposPersonaje.COMANDANTE));
		batallon_2.agregarCombatiente(FactoryPersonaje.crearPersonaje("El Inmobrable", TiposPersonaje.MAGOOSCURO));
		/////////////////// para arriba se carga los enemigos

		batallon_1.imprimirInfo();
		batallon_2.imprimirInfo();

		batallon_1.cargarPersonajesVivos();
		personajes_vivos_1 = batallon_1.obtenerListaPersonajesVivos();

		batallon_2.cargarPersonajesVivos();
		personajes_vivos_2 = batallon_2.obtenerListaPersonajesVivos();
	}


	
	public void jugar() {
		Personaje personajeActual;
		while (!this.estaTerminado()) {
			if (batallon_1.cantidadPersonajesVivos() > 0) {
				Logger.agregarMensaje("\n*****turno del batallon 1*****");
				personajeActual = batallon_1.obtenerSiguientePersonaje();
				personajeActual.imprimirInfo();
				personajeActual.accionar(batallon_1, batallon_2);
				registrarHechizosDelPersonaje(personajeActual);
			}

			batallon_1.removerPersonajesMuertos();
			batallon_2.removerPersonajesMuertos();

			if (!this.estaTerminado()) {
				if (batallon_2.cantidadPersonajesVivos() > 0) {
					Logger.agregarMensaje("\n*****turno del batallon 2*****");
					personajeActual = batallon_2.obtenerSiguientePersonaje();
					personajeActual.imprimirInfo();
					personajeActual.accionar(batallon_2, batallon_1);
					registrarHechizosDelPersonaje(personajeActual);
				}

				batallon_1.removerPersonajesMuertos();
				batallon_2.removerPersonajesMuertos();
			}
		}

		if (batallon_1.batallonDerrotado()) {
			Logger.agregarMensaje("-----Gano el batallon 2-----");
		} else {
			Logger.agregarMensaje("-----Gano el batallon 1-----");
		}

		mostrarRegistroHechizos();
	}

	// Transfiere los hechizos del Set del personaje al Map general
	private void registrarHechizosDelPersonaje(Personaje p) {
		for (String hechizo : p.getHechizosUsadosEnRonda()) {
			registroHechizos.computeIfAbsent(p.getNombre(), k -> new ArrayList<>()).add(hechizo);
		}
		p.limpiarHechizosRonda();
	}

	private void mostrarRegistroHechizos() {
		Logger.agregarMensaje("\n-----Registro de hechizos lanzados (Map)-----");
		for (Map.Entry<String, List<String>> entry : registroHechizos.entrySet()) {
			Logger.agregarMensaje(entry.getKey() + " -> " + entry.getValue());
		}
	}

	private boolean estaTerminado() {
		return batallon_1.batallonDerrotado() || batallon_2.batallonDerrotado();
	}
}
