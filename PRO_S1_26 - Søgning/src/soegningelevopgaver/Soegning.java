package soegningelevopgaver;

public class Soegning {

	public String printArray(int[] array) {
		String result = "";
		for (int i = 0; i < array.length; i++) {
			result += array[i] + " ";
		}
		return result;
	}

	public boolean metode1(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {

			if (array[i] % 2 != 0) {
				return true;
			}
		}
		return false;
	}

	public int metode2(int[] array) {
		int result = 0;

		for (int i = 0; i < array.length; i++) {
			result = array[i];
			if (result > 10 && result < 15) {
				return result;
			}
		}

		return -1;
	}

	public boolean metode3(int[] array) {
		boolean found = false;
		int current;
		int previous = -9999999;

		for (int i = 0; i < array.length; i++) {
			current = array[i];
			if (current == previous) {
				found = true;
				return found;
			}
			previous = array[i];

		}
		return false;
	}

}
