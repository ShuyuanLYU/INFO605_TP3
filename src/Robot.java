
public class Robot {

	private Table table;
	private Cube cubeTenu;

	public Robot(Table table) {
		this.table = table;
	}

	private Cube getCubetenu() {
		return this.cubeTenu;
	}

	private void setCubetenu(Cube cubeTenu) {
		this.cubeTenu = cubeTenu;
	}

	public void creerCube(Couleur couleur, TailleCube taille) {
		if (vériMainVide()) {
			setCubetenu(new Cube(couleur, taille));
			System.out.println("(^_^)" + cubeTenu.toString() + " est bien crée.\n");
		} else
			System.out.println("(°_°) Malheureusement! Main occupé.\n");
	}

	public void tenirCube(Cube cubeTenu) {
		this.cubeTenu = cubeTenu;
	}

	public boolean vériMainVide() {
		return cubeTenu == null;
	}

	public void poserSurTable() {
		if (!vériMainVide()) {
			System.out.println("(^_^)" + cubeTenu.toString() + " est posé sur la table.\n");
			table.ajouterCube(cubeTenu);
			lacher();
		} else {
			System.out.println("(=_=) Robot ne tient rien, il ne peut pas poser.\n");
		}
	}

	public void lacher() {
		this.cubeTenu = null;
	}

	public void prendre(TailleCube taille, Couleur couleur) {
		if (vériMainVide()) {
			cubeTenu = table.enlèveCube(taille, couleur);
			System.out.println((cubeTenu == null ? "(`_°) Il y a pas de cube correspondant.\n"
					: "(^_^)" + "Bien trouvé " + cubeTenu.toString() + "\n"));
		} else
			System.out.println("(°o°) Malheureusement! Main occupé.\n");
	}

	public void poserSurCube(TailleCube taille, Couleur couleur) {
		if (!vériMainVide() && cubeTenu.poserPossible(taille) && table.mettreSurCube(taille, couleur, cubeTenu)) {
			System.out.println("(^_^)" + cubeTenu.toString() + " est bien posé.\n");
			lacher();
		} else if (vériMainVide())
			System.out.println("(>_<) Robot ne tient rien. Il ne peut pas poser.\n");
		else if (!cubeTenu.poserPossible(taille))
			System.out.println(
					"(@_@) " + cubeTenu.toString() + " ne peut pas poser sur un " + taille.name() + " cube.\n");
		else
			System.out.println("(?_?) Il y a pas ce type de cube sur la table.\n");

	}

	public void detruireCube() {
		if (!vériMainVide()) {
			System.out.println("(^_^)" + cubeTenu.toString() + " est bien détuit.\n");
			this.cubeTenu = null;
		} else {
			System.out.println("(O_o) Robot ne tient rien, échec de détuire.\n");
		}

	}

	public void afficherRobot() {
		System.out.print("Robot ");
		if (vériMainVide())
			System.out.println("ne tient rien.");
		else {
			System.out.print("tient un ");
			System.out.println(cubeTenu.getTaille().name() + " cube " + cubeTenu.getCouleur().name() + ".");

		}

		if (vériMainVide()) {
			System.out.println("   _____");
			System.out.println("+--|   |");
			System.out.println("|  |   |");
		} else {
			// premier ligne
			System.out.print("   _");
			for (int i = 0; i < cubeTenu.premierLigne().length(); i++) {
				System.out.print("_");
			}
			System.out.println("_");
			// dexieme ligne
			System.out.print("+--|");
			System.out.print(cubeTenu.premierLigne());
			System.out.println("|");
			// troisieme ligne
			System.out.print("|  |");
			System.out.print(cubeTenu.dexiemeLigne());
			System.out.println("|");
		}
		System.out.println("|");
		System.out.println("|");
		System.out.println("-----");

	}
	// void setCubeTenu(Cube value) {
	// this.cubeTenu = value;
	// }

}
