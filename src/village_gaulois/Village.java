package village_gaulois;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois chef;
	private Gaulois[] villageois;

	public Village(String nom, Gaulois chef, int NB_VILLAGEOIS_MAX) {
		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
		this.villageois = new Gaulois[NB_VILLAGEOIS_MAX];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			gaulois.setVillage(this);

			nbVillageois++;
		}
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois < 1 || nbVillageois < numVillageois) {
			System.out.println("Il n’y a pas autant d’habitants dans notre village !");
			return null;
		}

		return villageois[numVillageois - 1];
	}

	public void afficherVillageois() {
		System.out.println(
				"Dans le village \"" + getNom() + "\" du chef " + chef.getNom() + " vivent les légendaires gaulois :");

		for (int i = 1; i <= nbVillageois; i++) {
			Gaulois gaulois = trouverVillageois(i);
			System.out.println("  - " + gaulois.getNom());
		}
	}

	public static void main() {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		// village.trouverVillageois(30);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);

		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		System.out.println();

		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);

		village.afficherVillageois();
		System.out.println();

		Gaulois doublePolemix = new Gaulois("Doublepolémix", 4);

		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}

}
