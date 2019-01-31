package arrays;

public class ArrayMethods {

	public void printStringArray(String[] input) {
		
		input[2] = "En anden string";
		
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
		
	}
}
