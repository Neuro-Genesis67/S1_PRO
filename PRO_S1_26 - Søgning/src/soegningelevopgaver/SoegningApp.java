package soegningelevopgaver;

public class SoegningApp {

	public static void main(String[] args) {
		Soegning s = new Soegning();

		// Opgave 1 - Er der ulige tal i arrayet?:
		int[] array1 = { 2, 4, 8, 2 };
		System.out.println("opg1: " + "(2, 4, 8, 2) Er der et ulige tal i talArray ? " + s.metode1(array1));
		array1[2] = 15;
		System.out.println("opg1: " + "(2, 4, 15, 2) Er der et ulige tal i talArray ? " + s.metode1(array1));

		// Opgave 2 - Find og returner første tal mellem 10 og 15 i listen:
		int[] array2 = { 2, 27, 7, 14, 17, 11, 4 };
		System.out.println(
				"\nopg2: " + "(2, 27, 7, 10, 14, 17, 11, 4) Første tal i listen mellem 10 og 15: " + s.metode2(array2));
		array2[3] = 67;
		array2[5] = 67;
		System.out.println("opg2: " + "(" + s.printArray(array2) + ")" + " Første tal i listen mellem 10 og 15: "
				+ s.metode2(array2));

		// Opgave 3:

		int[] array3 = { 7, 9, 13, 7, 9, 13 };
		System.out.println("\nopg3: " + "(7, 9, 13, 7, 9, 13)" + " Står der to ens ved siden af hinanden i listen?: "
				+ s.metode3(array3));
		array3[3] = 13;
		System.out.println("opg3: " + "(" + s.printArray(array3) + ")"
				+ " Står der to ens ved siden af hinanden i listen?: " + s.metode3(array3));

		// Opgave 5:

		// Opgave 6:
		// OPgave 7:
	}

}
