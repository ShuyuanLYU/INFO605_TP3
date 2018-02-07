import in.keyboard.Keyboard;

public class Monde {

	// public static final int rouge = 31;
	// public static final int vert = 32;
	// public static final int jaune = 33;
	// public static final int bleu = 34;
	// public static final int violet = 35;
	// public static final int cyan = 36;
	// public static final int gris = 37;
	// public static final int noir = 38;

	public static void ecrire(Couleur coul, String s) {
		System.out.printf("\033[%d;1m%s\033[0m\n", coul.ordinal() + 31, s);
	}

	public static void main(String[] args) {
		// Couleur.testCouleur();
		Table tab = new Table();
		Robot D2R2 = new Robot(tab);
		char c = ' ';
		Couleur coul = null;
		TailleCube tc = null;
		do {
			System.out.println("\n--------------------------------");
			System.out.println("1 - creer un cube");
			System.out.println("2 - détruire un cube");
			System.out.println("3 - prendre un cube");
			System.out.println("4 - poser un cube sur la table");
			System.out.println("5 - poser un cube sur un cube");
			System.out.println("f - fin du monde");
			System.out.println("--------------------------------");
			System.out.print("Votre choix : ");
			c = Keyboard.getChar();
			switch (c) {
			case '1':
				if (D2R2.vériMainVide()) {
					System.out.print("Couleur du cube : ");
					coul = Couleur.getCouleur(Keyboard.getString());
					// ecrire (coul, "couleur saisie");
					System.out.print("Taille (grand/moyen/petit) : ");
					tc = TailleCube.getTaille(Keyboard.getString());
				}
				D2R2.creerCube(coul, tc);
				break;
			case '2':
				System.out.println("Le cube tenu par le robot va être détruit... ");
				// Keyboard.pause();
				D2R2.detruireCube();
				break;
			case '3':
				if (D2R2.vériMainVide()) {
					System.out.print("Couleur du cube : ");
					coul = Couleur.getCouleur(Keyboard.getString());
					// ecrire (coul, "couleur saisie");
					System.out.print("Taille (grand/moyen/petit) : ");
					tc = TailleCube.getTaille(Keyboard.getString());
				}
				D2R2.prendre(tc, coul);
				break;
			case '4':
				System.out.println("Le cube tenu  par le robot va être posé sur la table...");
				// Keyboard.pause();
				D2R2.poserSurTable();
				break;
			case '5':
				if (!D2R2.vériMainVide()) {
					System.out.print("Couleur du cube : ");
					coul = Couleur.getCouleur(Keyboard.getString());
					// ecrire (coul, "couleur saisie");
					System.out.print("Taille (grand/moyen/petit) : ");
					tc = TailleCube.getTaille(Keyboard.getString());
				}
				D2R2.poserSurCube(tc, coul);
				break;
			}
			afficherMonde(D2R2, tab);
		} while (c != 'f');
	}

	private static void afficherMonde(Robot R, Table T) {
		//ecrire(Couleur.noir, "Etat du monde : ");
		System.out.println("* * * * * * * * * * * * * * *");
		R.afficherRobot();
		T.afficherTable();
		System.out.println("* * * * * * * * * * * * * * *");
		// Keyboard.pause();

	}

}
