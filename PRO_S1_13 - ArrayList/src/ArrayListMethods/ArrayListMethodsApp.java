package ArrayListMethods;

import java.util.ArrayList;

public class ArrayListMethodsApp {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(19);
		list.add(35);
		list.add(44);
		list.add(56);
		list.add(35);
		list.add(14);
		list.add(7);
		list.add(0);

		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(44);
		list2.add(0);
		list2.add(19);
		list2.add(35);
		list2.add(14);
		list2.add(56);
		list2.add(7);
		list2.add(35);

		ArrayListMethods methods = new ArrayListMethods();

		// System.out.println(list);
		// System.out.println("Summen af tallene i listen (med for loop): " +
		// methods.sumListeFor(list));
		// System.out.println("Summen af tallene i listen (med for-each loop): " +
		// methods.sumListeForEach(list));
		// System.out.println("Indeks for det første lige tal: " +
		// methods.hasEvenAtIndex(list));
		// System.out.println("Mindste værdi i listen: " + methods.min(list));
		// System.out.println("Average of values in list: " + methods.average(list));
		// System.out.println("Number of zeroes in the list: " + methods.zeroes(list));
		// // methods.replaceEvenNumbers(list);
		// // System.out.println("Even numbers haven been replaced with zeroes: " +
		// list);
		// System.out.println("A new list containing all even numbers from the previous
		// list: " + methods.evenList(list));
		//
		// System.out.print("List with EVEN elements moved first, keeping the previous
		// order: ");
		// methods.moveEvenElementsFirstInList(list);
		// System.out.println(list);
		//
		// System.out.println("Next biggest int, in list: " +
		// methods.nextBiggestInList(list));
		// System.out.println("Is the list sorted?: " + methods.isListSorted(list));
		// System.out.println("Are there any duplicates in the list?: " +
		// System.out.println(methods.duplicatesInList(list));
		// System.out.println(methods.sameInLists(list, list2));

	}

}
