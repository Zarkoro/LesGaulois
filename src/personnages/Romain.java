package personnages;

public class Romain {
	private String nom;
	private int force;

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

	public static void main() {
		new Romain("Minus", 6);
	}
}
