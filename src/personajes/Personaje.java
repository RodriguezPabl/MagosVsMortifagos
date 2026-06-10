package personajes;

import java.util.ArrayList;
import java.util.List;
import hechizos.Hechizo;

public abstract class Personaje {
	protected String nombre;
	protected int nivelDeMagia;
	protected int puntosDeVida;
	protected List<Hechizo> hechizos;
	protected boolean protegido;
	
	public Personaje(String nombre, int nivelDeMagia, int puntosDeVida) {
		this.nombre = nombre;
		this.nivelDeMagia = nivelDeMagia;
		this.puntosDeVida = puntosDeVida;
		this.hechizos = new ArrayList<Hechizo>();
		this.protegido = false;
	}
	
	public void aprenderHechizo(Hechizo hechizo) {
		hechizos.add(hechizo);
	}
	
	public void lanzarHechizo(int indice, Personaje objetivo) {
		if(indice >= 0 && indice < hechizos.size())
			hechizos.get(indice).ejecutar(this, objetivo);
	}
	
	public void recibirDanio(int danio) {
		if(protegido) {
			System.out.println(nombre + " bloqueó el ataque con Protego.");
			protegido = false;
			return;
		}
		
		puntosDeVida -= danio;
		if(puntosDeVida < 0) {
			puntosDeVida = 0;
		}
	}
	
	public void curar(int vida) {
		puntosDeVida += vida;
	}
	
	public boolean estaVivo() {
		return puntosDeVida > 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNivelDeMagia() {
		return nivelDeMagia;
	}
	
	public int getPuntosDeVida() {
		return puntosDeVida;
	}
	
	public void activarProteccion() {
		protegido = true;
	}
	
	public boolean estaProtegido() {
		return protegido;
	}
	
	public abstract int potenciarAtaque(int danioBase);
	
	public abstract int potenciarCuracion(int curacionBase);
}
