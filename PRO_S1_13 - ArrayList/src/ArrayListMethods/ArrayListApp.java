package ArrayListMethods;

import java.util.ArrayList;

public class ArrayListApp {
	private static int antal;

	public static void main(String[] args) {
		// 1 lav arrayList af strenge
		ArrayList<String> stringList = new ArrayList<>();

		// 2 tilf�j f�lgende navne til listen.
		stringList.add("Hans");
		stringList.add("Viggo");
		stringList.add("Jens");
		stringList.add("B�rge");
		stringList.add("Bent");

		// 3 Udskriver antal elementer i listen
		antal = 0;
		for (String e : stringList) {
			antal++;
		}
		System.out.println("antal elementer i listen: " + antal);
		System.out.println();

		// 4 Tilf�jer tekststrengen �Jane� p� indeks plads 2 i listen
		stringList.add(1, "Jane");

		// 5 Udskriver indholdet af listen
		System.out.println(stringList);
		System.out.println();

		// 6 Sletter elementet p� indeks plads 1 i listen
		stringList.remove(1);

		// 7 & 8 Tilf�jer teksten �Pia� forrest i listen og (8) Tilf�jer teksten �Ib�
		// bagerst i listen.
		stringList.add(0, "Pia");
		stringList.add("Ib");
		System.out.println(stringList);

		// 9 Udskriver antal elementer i listen
		antal = 0;
		for (String e : stringList) {
			antal++;
		}
		System.out.println();
		System.out.println("antal elementer i listen: " + antal);

		// 10 P� indeks plads 2 skal elementet �ndres til at v�re �Hansi�
		stringList.set(2, "Hansi");

		// 11 Udskriver antal elementer i listen
		antal = 0;
		for (String e : stringList) {
			antal++;
		}
		System.out.println();
		System.out.println("antal elementer i listen: " + antal);
		System.out.println();

		// 12 Udskriver indholdet af listen
		System.out.println(stringList);

		// 13 Genneml�ber listen med en for�l�kke og udskiver l�ngden p� hver af
		// tekststrengene i listen
		String size = "";
		System.out.println();
		for (int i = 0; i < stringList.size(); i++) {
			System.out.println(stringList.get(i).length());
		}
		System.out.println();

		// 14 Genneml�ber listen med en for-each � l�kke og udskiver l�ngden p� hver af
		// tekststrengene i listen
		for (String e : stringList) {
			System.out.println(e.length());
		}

	}

}
