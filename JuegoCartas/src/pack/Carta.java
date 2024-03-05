package pack;

public class Carta {

	//Como astributos ponemos que la figura sea un string para no tener que ir igualando luego valores numericos a strings y creamos un enum con las 4 opciones de palos disponibles.
	private String figura;
	private Palo palo;

	public enum Palo {
		oros, espadas, bastos, copas
	}

	public Carta(String figura, Palo palo) {
		this.figura = figura;
		this.palo = palo;
	}

	public String getFigura() {
		return figura;
	}

	public Palo getPalo() {
		return palo;
	}

	@Override
	public String toString() {
		return figura + " de " + palo;
	}
}
