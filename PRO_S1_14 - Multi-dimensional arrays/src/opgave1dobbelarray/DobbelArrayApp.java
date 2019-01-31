package opgave1dobbelarray;

public class DobbelArrayApp {

	public static void main(String[] args) {
		final int ROW = 8;
		final int COL = 8;
		int[][] values = new int[ROW][COL];
		Methods ass = new Methods();

		// 1. Udskriver indholdet af values på tabel form
		// ass.displayArray(values);

		// 2. Indholdet i values skal være 5 på alle pladser
		// ass.replaceWithFives(values);
		// ass.displayArray(values);

		// 3. Elementerne i values skal være skiftende med 0’er og 1’er som på et
		// skakbræt
		// ass.chessArray(values);
		// ass.displayArray(values);

		// 4. Alle elemeter i øverste og nederste række skal være 5 alle elementer i
		// første og sidste søjle skal være 5 resten skal være 2.
		// ass.createFrame(values);
		// ass.displayArray(values);

		// 5. Beregner summen af alle tallene i values
		// System.out.println(ass.sumOfArrayElements(values));

	}

}
