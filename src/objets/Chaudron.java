package objets;

public class Chaudron {
	int quantitePotion = 0;
	int forcePotion = 0;

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
