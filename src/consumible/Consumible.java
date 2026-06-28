package consumible;

import Unidades.Personaje;

public abstract class Consumible {
	final static public String POCION_VIGORIZANTE = "pocionVigorizante";
	final static public String POCION_VIDA = "pocionVida";
	final static public String POCION_MANA = "pocionMana";
	final static public String POCION_ESPECTRO = "pocionEspectro";
	final static public String POCION_POTENCIADORA = "pocionPotenciadora";
	final static public String OROCRUX = "orocrux";

	protected Personaje personaje;

	public void usar() {
		activarConsumible();
		personaje.quitarDeListaDeObjetos(getNombre());
	}

	abstract public void activarConsumible();

	abstract public String getNombre();

}
