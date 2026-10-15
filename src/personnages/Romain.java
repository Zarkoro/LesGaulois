package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;

		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		if (forceCoup < 0) {
			throw new IllegalArgumentException("Invalid forceCoup: " + forceCoup);
		}
		int forceOrigine = force;

		force -= forceCoup;

		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}

		assert isInvariantVerified();
		assert force < forceOrigine;
	}

	private boolean isInvariantVerified() {
		return 0 <= force;
	}

	private void sEquiper(Equipement equipement) {
		String texte;

		switch (nbEquipement) {
		case 2 -> texte = "Le soldat " + nom + " est déjà bien protégé !";

		case 0, 1 -> {
			if (equipement == equipements[0]) {
				texte = "Le soldat " + nom + " possède déjà un.e " + equipement + " !";
			} else {
				texte = "Le soldat " + nom + " s'équipe avec un.e " + equipement + ".";
				equipements[nbEquipement] = equipement;
				nbEquipement++;
			}
		}

		default -> throw new IllegalArgumentException("Unexpected value: " + nbEquipement);
		}

		System.out.println(texte);
	}

	public static void main() {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
