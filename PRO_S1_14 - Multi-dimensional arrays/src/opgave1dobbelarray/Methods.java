package opgave1dobbelarray;

public class Methods {

	// 1. Udskriver indholdet af values på tabel form
	public void displayArray(int[][] array) {

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col]);
			}
			System.out.println();
		}
	}

	// 2. Indholdet i values skal være 5 på alle pladser
	public void replaceWithFives(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				array[row][col] = 5;
			}
		}

	}

	// 3. Elementerne i values skal være skiftende med 0’er og 1’er som på et
	// skakbræt
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

	// 4. Alle elemeter i øverste og nederste række skal være 5. alle elementer i
	// første og sidste søjle skal være 5 resten skal være 2. array.length

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