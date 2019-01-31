package opgave1dobbelarray;

public class Methods {

	// 1. Udskriver indholdet af values p� tabel form
	public void displayArray(int[][] array) {

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col]);
			}
			System.out.println();
		}
	}

	// 2. Indholdet i values skal v�re 5 p� alle pladser
	public void replaceWithFives(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				array[row][col] = 5;
			}
		}

	}

	// 3. Elementerne i values skal v�re skiftende med 0�er og 1�er som p� et
	// skakbr�t
	public void chessArray(int[][] array) {
		boolean flip = false;
		for (int row = 0; row < array.length; row++) {
			if (row % 2 == 0) {
				flip = false;
			} else {
				flip = true;
			}
			for (int col = 0; col < array[row].length; col++) {
				if (flip) {
					array[row][col] = 1;
					flip = false;
				} else {
					array[row][col] = 0;
					flip = true;
				}
			}
		}
	}

	// 4. Alle elemeter i �verste og nederste r�kke skal v�re 5. alle elementer i
	// f�rste og sidste s�jle skal v�re 5 resten skal v�re 2. array.length

	public void createFrame(int[][] array) {
		int col = 0;
		for (int row = 0; row < array.length; row++) {

			for (col = 0; col < array[row].length; col++) {
				if (row == 0 || row == array.length - 1) {
					array[row][col] = 5;
				} else if (col < 1 || col == array[row].length - 1) {
					array[row][col] = 5;
				}

			}

		}
	}

	// 5. Beregner summen af alle tallene i values

	public int sumOfArrayElements(int[][] array) {
		int sum = 0;
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				sum += array[row][col];
			}
		}
		return sum;

	}
}