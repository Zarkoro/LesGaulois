package objets;

public class Chaudron {
	int quantitePotion;
	int forcePotion;

	public void remplirChaudron(int quantite, int forcePotion) {
		this.quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		return quantitePotion > 0;
	}

	public int prendreLouche() {
		quantitePotion--;
		if (!resterPotion()) {
			forcePotion = 0;
		}

		return forcePotion;
	}
}
