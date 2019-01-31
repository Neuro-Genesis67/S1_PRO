package opg2_3_4;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		ArrayMethods am = new ArrayMethods();
		int[] a = { 2, 8, 7, 3, 4, 6 };
		int[] b = { 8, 2, 3, 7, 6, 5 };
		int[] c = { 2, 4, 6, 2, 10 };
		System.out.println("Sum of array a: " + am.sum(a));
		System.out.println("Parallel index's of array a & b have been merged: " + Arrays.toString(am.createSum(a, b)));
		System.out.println(am.hasUneven(c));

	}

}
