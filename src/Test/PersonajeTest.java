package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Acciones.LanzarHechizo;
import Efectos.Petrificado;
import Efectos.Protegido;
import Hechizos.Protego;
import Hechizos.Septusembra;
import Unidades.Auror;
import Unidades.Personaje;

class PersonajeTest {

	/*
	 * Para testear una clase abstracta, que no se puede inicializar,
	 * usaremos una instancia de auror elegida arbitrariamente
	 * auror tiene 200 puntos de vida y mana*/
	
	@Test
	void testGetVida() {
		Personaje personaje = new Auror("Harry");
		assertEquals(200, personaje.getVida());		

	}
	
	
	@Test
	void testRecibirDaño() {

		Personaje personaje = new Auror("Harry");
		personaje.recibirDaño(150);
		assertEquals(50, personaje.getVida());		

	}
	
	@Test
	void testGanarVidaNoPasaVidaMaxima() {
		Personaje personaje = new Auror("Harry");
		personaje.ganarVida(1500);
		assertEquals(200, personaje.getVida());		

	}
	
	@Test
	void testGanarManaaNoPasaManaMaximo() {
		Personaje personaje = new Auror("Harry");
		personaje.ganarMana(1500);
		assertEquals(200, personaje.getVida());		

	}
	
	@Test
	void testPuedePelear() {
		Personaje personaje = new Auror("Harry");
		assertTrue(personaje.puedePelear());
	}
	
	@Test
	void testNoPuedePelear() {
		Personaje personaje = new Auror("Harry");
		Personaje personaje2 = new Auror("Harry 2");
		personaje.agregarEfecto(new Petrificado(personaje));
		personaje2.recibirDaño(500);
		assertFalse(personaje.puedePelear());
		assertFalse(personaje2.puedePelear());
	}
	
	@Test
	void testTienePocoMana() {
		Personaje personaje = new Auror("Harry");
		personaje.gastarMana(170); //se queda con 30 mana
		assertTrue(personaje.tienePocoMana());
		
	}
	
	@Test
	void testTienePocaVida() {
		Personaje personaje = new Auror("Harry");
		personaje.recibirDaño(160);
		assertTrue(personaje.tienePocaVida());
	}
	
	@Test
	void testEstaMuerto() {
		Personaje personaje = new Auror("Harry");
		personaje.recibirDaño(210);
		assertTrue(personaje.estaMuerto());
	}
	
	@Test
	void testNoDeberiaPoderMatarseASiMismo() {
		Personaje personaje = new Auror("Harry");
		personaje.setVida(1);
		personaje.setAccion(new LanzarHechizo(new Septusembra(personaje, personaje)));
		personaje.ejecutarAccion();
		assertFalse(personaje.estaMuerto());
		assertEquals(1, personaje.getVida());
	}
	
	@Test 
	void testProtegerseASiMismo() {
		Personaje personaje = new Auror("Harry");
		personaje.setAccion(new LanzarHechizo(new Protego(personaje, personaje)));
		personaje.ejecutarAccion();
		assertTrue(personaje.tieneEfecto(Protegido.class));
	}
	

}
