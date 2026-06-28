package Unidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Efectos.Petrificado;
import Efectos.Protegido;
import logger.Logger;

public class Batallon implements Combatiente {
	private List<Combatiente> combatientes;
	private List<Personaje> personajesVivos;
	private int indice = 0;

	public Batallon() {
		this.combatientes = new ArrayList<Combatiente>();
		this.personajesVivos = new ArrayList<Personaje>();
	}

	public Batallon(List<Combatiente> combatientes) {
		this.combatientes = combatientes;
		this.personajesVivos = new ArrayList<Personaje>();
	}

	public void agregarCombatiente(Combatiente combatiente) {
		combatientes.add(combatiente);
	}

	public void eliminarCombatiente(Combatiente combatiente) {
		combatientes.remove(combatiente);
	}

	public void cargarPersonajesVivos() {
		personajesVivos = obtenerPersonajes();
	}

	public List<Personaje> obtenerListaPersonajesVivos() {
		return personajesVivos;
	}

	private List<Personaje> obtenerPersonajes() {
		List<Personaje> personajes = new ArrayList<>();
		for (Combatiente combatiente : combatientes) {
			personajes.addAll(combatiente.obtenerPersonajesInternos());
		}
		return personajes;
	}

	@Override
	public List<Personaje> obtenerPersonajesInternos() {
		return obtenerPersonajes();
	}

//	Metodos de la interfaz Combatiente
	public void luchar(Combatiente enemigo) {
		for (Combatiente c : combatientes) {
			if (!c.estaMuerto()) {
				c.luchar(enemigo);
			}
		}
	}

	public boolean estaMuerto() {
		for (Combatiente c : combatientes) {
			if (!c.estaMuerto())
				return false;
		}
		return true;
	}

	public void imprimirInfo() { /// esto es para ver como esta internamete da la info
		Logger.agregarMensaje("------BATALLON------");
		for (Combatiente c : combatientes)
			c.imprimirInfo();
		Logger.agregarMensaje("-----------------");
	}

	public List<Personaje> getTodosLosPersonaje() {
		return this.personajesVivos;
	}

	//////////////////// aca van las funciones que ayudan para

	public Personaje obtenerPersonajeMenorVida() {
		Personaje personajeMenorVida = null;
		int vidaMenor = 1000000;
		for (Personaje p : personajesVivos)
			if (p.getVida() < vidaMenor) {
				personajeMenorVida = p;
				vidaMenor = p.getVida();
			}

		return personajeMenorVida;
	}

	public boolean hayObjetivoPrioritario() {
		for (Personaje p : personajesVivos)
			if (p.esObjetivoPrioritario())
				return true;
		return false;
	}

	public Personaje obtenerPrimerObjetivoPrioritario() {
		for (Personaje p : personajesVivos)
			if (p.esObjetivoPrioritario())
				return p;
		return null;
	}

	public boolean hayAlgunAurorOComandanteSinPetrificado() {
		for (Personaje p : personajesVivos)
			if (p.esObjetivoPrioritario())
				if (!p.tieneEfecto(Petrificado.class))
					return true;
		return false;
	}

	public Personaje obtenerElPrimerAurorOComandanteSinPetrificar() {
		for (Personaje p : personajesVivos)
			if (p.esObjetivoPrioritario())
				if (!p.tieneEfecto(Petrificado.class))
					return p;
		return null;
	}

	public boolean hayPersonajeSinProtego(int prioridadMinima) {
		for (Personaje p : personajesVivos)
			if (p.getPrioridad() >= prioridadMinima)
				if (!p.tieneEfecto(Protegido.class))
					return true;
		return false;
	}

	public Personaje obtenerPrimerPersonajeSinProtego(int prioridadMinima) {
		for (Personaje p : personajesVivos)
			if (p.getPrioridad() >= prioridadMinima)
				if (!p.tieneEfecto(Protegido.class))
					return p;
		return null;
	}

	public Personaje obtenerPersonajeAleatorio() {
		Random random = new Random(12345);
		int indiceAleatorio = random.nextInt(personajesVivos.size());
		return personajesVivos.get(indiceAleatorio);
	}

	public Personaje obtenerPersonajeMayorVida() {
		Personaje personajeMenorVida = null;
		int vidaMayor = 0;
		for (Personaje p : personajesVivos)
			if (p.getVida() > vidaMayor) {
				personajeMenorVida = p;
				vidaMayor = p.getVida();
			}

		return personajeMenorVida;
	}

	public Personaje obtenerPrimerPersonajeMasAltoRangoPosible() {
		Personaje mejor = null;
		for (Personaje p : personajesVivos)
			if (mejor == null || p.getPrioridad() > mejor.getPrioridad())
				mejor = p;
		return mejor;
	}

	public Personaje obtenerPrimerPersonajeMasAltoRangoPosibleSinProtego() {
		Personaje mejor = null;
		for (Personaje p : personajesVivos)
			if (!p.tieneEfecto(Protegido.class))
				if (mejor == null || p.getPrioridad() > mejor.getPrioridad())
					mejor = p;
		return mejor;
	}

	public Personaje obtenerSiguientePersonaje() {
		if (indice >= this.personajesVivos.size())
			indice = indice % this.personajesVivos.size();
		Personaje personajeActual = this.personajesVivos.get(indice);
		indice++;
		return personajeActual;
	}

	public void removerPersonajesMuertos() {
		if (personajesVivos.size() > 0) {
			int i = 0;
			while (i < personajesVivos.size()) {
				Personaje p = personajesVivos.get(i);
				if (p.estaMuerto()) {
					///probar si funciona
					if(indice>i)
						indice--;
					
					Logger.agregarMensaje( p + " se fue de sabático!!!!!");
					personajesVivos.remove(i);
					i--;
				}
				i++;
			}
		}
		
		
		
		/*
		personajesVivos.removeIf(personaje -> {
			if (personaje.estaMuerto()) {
				///aca hay que pensar en el indice
				Logger.agregarMensaje(personaje + " se fue de sabático!!!!!");
				return true;
			}
			return false;
		});*/
	}

	public boolean batallonDerrotado() {
		return this.personajesVivos.size() == 0;
	}

	public int cantidadPersonajesVivos() {
		return this.personajesVivos.size();
	}

}
