
public class test {

	public static void main(String[] args) {
		Couleur couleur = null;
		TailleCube taille = null;
		Cube cube1 = new Cube(couleur.getCouleur("rouge"),taille.getTaille("grand"));
		Cube cube2 = new Cube(couleur.getCouleur("rouge"),taille.getTaille("moyen"));
		Cube cube3 = new Cube(couleur.getCouleur("rouge"),taille.getTaille("petit"));
//		System.out.println(cube1.toString());
//		System.out.println(cube2.toString());
//		System.out.println(cube3.toString());
//		
//		System.out.println(cube1.premierLigne());
//		System.out.println(cube1.dexiemeLigne());
//		System.out.println(cube2.premierLigne());
//		System.out.println(cube2.dexiemeLigne());
//		System.out.println(cube3.premierLigne());
//		System.out.println(cube3.dexiemeLigne());

		cube1.créerLienDessous(cube2);
		cube2.créerLienDessous(cube3);
		System.out.println("****");
		System.out.println(cube1.toDessinAll()); 
 	   
//		Table table = new Table();
//		Robot robot = new Robot(table);
//		robot.poserSurTable();
		

	}

}
