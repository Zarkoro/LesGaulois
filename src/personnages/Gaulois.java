package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village = null;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}

	@Override
	public String toString() {
		return nom;
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		int forceCoup = force * effetPotion / 3;
		romain.recevoirCoup(forceCoup);

		if (effetPotion > 1) {
			effetPotion--;
		}
	}

	public void boirePotion(int forcePotion) {
		this.effetPotion = forcePotion;
	}

	public void sePresenter() {
		String textePresentation = "Bonjour, je m'appelle " + getNom() + ". ";

		if (village == null) {
			parler(textePresentation + "Je voyage de villages en villages.");

		} else {
			String nomVillage = village.getNom();
			if (this == village.getChef()) {
				parler(textePresentation + "Je suis le chef le village : " + nomVillage + ".");

			} else {
				parler(textePresentation + "J'habite le village : " + nomVillage + ".");

			}

		}
	}

}
