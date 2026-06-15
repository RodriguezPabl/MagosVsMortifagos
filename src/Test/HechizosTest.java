package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Acciones.LanzarHechizo;
import Efectos.Agilizado;
import Efectos.Envenenado;
import Efectos.Petrificado;
import Efectos.Protegido;
import Efectos.Quemado;
import Hechizos.AvadaKedavra;
import Hechizos.Bombardum;
import Hechizos.Incendium;
import Hechizos.Petrificus;
import Hechizos.Protego;
import Hechizos.Veneficus;
import Unidades.Auror;
import Unidades.Comandante;
import Unidades.Estudiante;
import Unidades.Personaje;
import Unidades.Seguidor;

class HechizosTest {

	@Test
	void testPetrificusAplicaEfecto() {
		Comandante c = new Comandante("V");
		Auror a = new Auror("H");

		c.setAccion(new LanzarHechizo(new Petrificus(c, a)));
		c.ejecutarAccion();

		assertTrue(a.tieneEfecto(Petrificado.class));

	}

	@Test
	void testAvadaKedavraEsEvitadoPorAgilidad() {
		Comandante c = new Comandante("V");
		Auror a = new Auror("H");

		a.agregarEfecto(new Agilizado(a));
		a.activarEfectos();

		c.setAccion(new LanzarHechizo(new AvadaKedavra(c, a)));
		c.ejecutarAccion();

		// tiene la vida entera, ya que el ataque no se pudo ejecutar, por el efecto que
		// tiene auror de agilizado
		assertEquals(200, a.getVida());
	}

	@Test
	void testAvadaKedavraInstakill() {
		Comandante c = new Comandante("V");
		Auror a = new Auror("H");

		c.setAccion(new LanzarHechizo(new AvadaKedavra(c, a)));
		c.ejecutarAccion();

		assertTrue(a.estaMuerto());
	}

	@Test
	void testBombardumDañaCorrectamenteAGrupoEnemigos() {
		Comandante c = new Comandante("V");
		Seguidor s = new Seguidor("S");
		Comandante c2 = new Comandante("V2");
		Auror a = new Auror("H");
		ArrayList<Personaje> enemigos = new ArrayList<Personaje>();
		enemigos.add(c2);
		enemigos.add(c);
		enemigos.add(s);

		c.agregarEfecto(new Agilizado(c));
		c.activarEfectos();
		c2.agregarEfecto(new Protegido(c2));
		c2.activarEfectos();

		a.setAccion(new LanzarHechizo(new Bombardum(a, enemigos)));
		a.ejecutarAccion();

		Bombardum b = new Bombardum(a, enemigos);
		int danioBase = b.getDañoBase() / enemigos.size(); // son 3 enemigos, el daño base del hechizo se divide por la
															// cantidad de enemgos apuntados
		assertEquals(s.getVidaMax() - danioBase, s.getVida(), "Deberia morir");
		assertEquals(c2.getVidaMax() - danioBase / 3, c2.getVida());
		assertEquals(c.getVidaMax(), c.getVida(), "Deberia esquivar el ataque");

	}
	
	@Test
	void testIncendiumAplicaEfectoQuemar() {
		Comandante c = new Comandante("V");
		Estudiante e = new Estudiante("H");

		e.setAccion(new LanzarHechizo(new Incendium(e, c)));
		e.ejecutarAccion();

		assertTrue(c.tieneEfecto(Quemado.class));
	}
	
	@Test
	void testProtegoAplicaProtegido() {
		Estudiante e = new Estudiante("H");

		e.setAccion(new LanzarHechizo(new Protego(e, e)));
		e.ejecutarAccion();

		assertTrue(e.tieneEfecto(Protegido.class));
	}
	
	@Test
	void testVeneficusAplicaEnvenenado() {
		Seguidor s = new Seguidor("S");
		Estudiante e = new Estudiante("H");
		s.setAccion(new LanzarHechizo(new Veneficus(s, e)));
		s.ejecutarAccion();
		assertTrue(e.tieneEfecto(Envenenado.class));
	}
	
}
