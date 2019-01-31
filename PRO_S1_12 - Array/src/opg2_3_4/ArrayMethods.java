package opg2_3_4;

public class ArrayMethods {
	private int[] array;

	public int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	public int[] createSum(int[] a, int[] b) {

		int[] mergedArray = new int[a.length];

		for (int i = 0; i < a.length; i++)
			mergedArray[i] = a[i] + b[i];

		return mergedArray;
	}

	public boolean hasUneven(int[] a) {
		boolean result = false;

		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 1) {
				result = true;
			}
		}
		return result;
	}

}
