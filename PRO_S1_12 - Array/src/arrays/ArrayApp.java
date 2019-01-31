package arrays;

public class ArrayApp {

	public static void main(String[] args) {
		String[] stringArray = new String[10];
		
		for (int i = 0; i < stringArray.length; i++) {
			stringArray[i] = "String " + i;
		}
		
		ArrayMethods methods = new ArrayMethods();
		methods.printStringArray(stringArray);
		
		String[] stringArray2 = 
			{"Hej", "Dav", "Halløj"};
		
		methods.printStringArray(stringArray2);
	}
}
