package tomsApp;

import java.util.ArrayList;

public class mainApp {

	public static void main(String[] args) {
		String[] s = { "Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul",
				"Torkild" };

		Customer c1 = new Customer(22, "Xiaoyu");
		Customer c2 = new Customer(22, "Nina");
		Customer c3 = new Customer(22, "Alisa");
		Customer c4 = new Customer(22, "Asuka");
		Customer c5 = new Customer(22, "Josie");
		Customer c6 = new Customer(22, "Heihachi");
		Customer c7 = new Customer(22, "Yoshimitsu");
		Customer c8 = new Customer(22, "O'neil");

		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		customers.add(c4);
		customers.add(c5);
		customers.add(c6);
		customers.add(c7);
		customers.add(c8);

		SortMethods sortEm = new SortMethods();

		sortEm.bubbleSortStringArray(s);
		System.out.println();
		System.out.println("Sorted list: ");
		for (String string : s) {
			System.out.print(string + " ");
		}
		//
		// sortEm.bubbleSortStringArray(s);
		//
		// System.out.println("\nSorted list: ");
		// for (String string : s) {
		// System.out.print(string + " ");
		// }
		//
		//
		//
		// }
		// }

		// System.out.println("Original string-array: ");
		// for (String string : s) {
		// System.out.print(string + " ");
		// }
		// sortEm.selectionSortStringArray(s);
		//
		// System.out.println("\n\nSelection sorted string-array: ");
		// for (String string : s) {
		// System.out.print(string + " ");

		// System.out.println("\n\nSelection sorted ArrayList: ");
		// System.out.println(customers);
		// System.out.println("Sorted list: ");
		// System.out.println(sortEm.selectionSortArrayListCustomer(customers));

		// for (String string : s) {
		// System.out.print(string + " ");
		// }
		//
		// System.out.println("\n\nInsertion sorted version: \n");
		// sortEm.insertionSortStringArray(s);
		// for (String string : s) {
		// System.out.print(string + " ");
		// }
	}
}
