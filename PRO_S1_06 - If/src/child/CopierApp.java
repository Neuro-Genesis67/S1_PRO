package child;

import java.util.Scanner;

public class CopierApp extends Copier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Copier cpy = new Copier();
		cpy.startup();

		// Inserting paper into printer
		// cpy.insertPaper(200);
		// cpy.getPaper();
		// Print 5 copies, using 5 pieces of paper.
		// cpy.makeCopy(15);

	}

}
