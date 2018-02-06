
public class Robot {
	// private String nom;
	private Table table;
	private Cube cubeTenu;

	public Robot(Table table) {
		this.table = table;
	}

	// private String getNom() {
	// return this.nom;
	// }

	// private void setNom(String nom) {
	// this.nom = nom;
	// }

	private Cube getCubetenu() {
		return this.cubeTenu;
	}

	private void setCubetenu(Cube cubeTenu) {
		this.cubeTenu = cubeTenu;
	}

	public void creerCube(Couleur couleur, TailleCube taille) {
		if (vériMainVide()) {
			Cube cubeCréé = new Cube(couleur, taille);
			setCubetenu(cubeCréé);
		}
	}

	public void tenirCube(Cube cubeTenu) {
		this.cubeTenu = cubeTenu;
	}

	public boolean vériMainVide() {
		return cubeTenu == null;
	}

	public void poserSurTable() {
		if (!vériMainVide()) {
			System.out.println(cubeTenu.toString() + "est posé sur la table.");
			table.ajouterCube(cubeTenu);
			lacher();
		} else {
			System.out.println("(=_=)\nRobot ne tient rien, il ne peut pas poser.");
		}
	}

	public void lacher() {
		this.cubeTenu = null;
	}

	public void prendre(TailleCube taille, Couleur couleur) {
		if (vériMainVide()) {
			cubeTenu = table.enlèveCube(taille, couleur);
		}
	}

	public void poserSurCube(TailleCube taille, Couleur couleur) {
		if (!vériMainVide() && cubeTenu.poserPossible(taille) && table.mettreSurCube(taille, couleur, cubeTenu)) {
			lacher();
		}
	}

	public void detruireCube() {
		if (!vériMainVide()) {
			System.out.println(cubeTenu.toString() + "est bien détuit.");
			this.cubeTenu = null;
		} else {
			System.out.println("(O_o)\nRobot ne tient rien, échec de détuire.");
		}

	}

	public void afficherRobot() {
		System.out.print("Robot ");
		if (vériMainVide())
			System.out.println("ne tient rien.");
		else {
			System.out
					.println("tient un " + cubeTenu.getTaille().name() + " cube " + cubeTenu.getCouleur().name() + ".");
		}
	}
	// void setCubeTenu(Cube value) {
	// this.cubeTenu = value;
	// }

}
