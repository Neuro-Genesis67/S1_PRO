package opgave1dobbelarray;

public class DobbelArrayApp {

	public static void main(String[] args) {
		final int ROW = 8;
		final int COL = 8;
		int[][] values = new int[ROW][COL];
		Methods ass = new Methods();

		// 1. Udskriver indholdet af values p� tabel form
		// ass.displayArray(values);

		// 2. Indholdet i values skal v�re 5 p� alle pladser
		// ass.replaceWithFives(values);
		// ass.displayArray(values);

		// 3. Elementerne i values skal v�re skiftende med 0�er og 1�er som p� et
		// skakbr�t
		// ass.chessArray(values);
		// ass.displayArray(values);

		// 4. Alle elemeter i �verste og nederste r�kke skal v�re 5 alle elementer i
		// f�rste og sidste s�jle skal v�re 5 resten skal v�re 2.
		// ass.createFrame(values);
		// ass.displayArray(values);

		// 5. Beregner summen af alle tallene i values
		// System.out.println(ass.sumOfArrayElements(values));

	}

}
