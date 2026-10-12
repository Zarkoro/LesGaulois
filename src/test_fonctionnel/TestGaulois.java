package test_fonctionnel;

import personnages.Druide;
import personnages.Gaulois;
import personnages.Romain;

public class TestGaulois {
	public static void main() {
		// test 1.2
		System.out.println("---test 1.2---");
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 16);

		asterix.parler("Bonjour Obélix.");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des sangliers ?");
		asterix.parler("Oui très bonne idée.");

		// test 3.3
		System.out.println("");
		System.out.println("---test 3.3---");
		Romain minus = new Romain("Minus", 6);

		System.out.println(
				"Dans la forêt " + asterix + " et " + obelix + " tombent nez à nez sur le romain " + minus.getNom());
		for (int i = 0; i < 3; i++) {
			asterix.frapper(minus);
		}

		// test 4.5
		System.out.println("");
		System.out.println("---test 4.5---");
		Romain brutus = new Romain("Brutus", 14);
		Druide panoramix = new Druide("Panoramix", 2);

		panoramix.fabriquerPotion(4, 3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);

		for (int i = 0; i < 3; i++) {
			asterix.frapper(brutus);
		}
	}
}
