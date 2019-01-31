package tomsApp;

import java.util.ArrayList;

public class SortMethods {

	// public String[] bubbleSortStringArray(String[] array) {
	//
	// boolean sorted = false;
	// String temp = "";
	//
	// while (sorted == false) {
	// sorted = true;
	//
	// for (int i = 0; i < array.length - 1; i++) {
	//
	// if (array[i].compareTo(array[i + 1]) > 1) {
	// sorted = false;
	//
	// temp = array[i];
	// array[i] = array[i + 1];
	// array[i + 1] = temp;
	//
	// for (String s : array) {
	// System.out.print(s + " ");
	// }
	// System.out.println();
	// }
	//
	// }
	//
	// }
	// return array;
	// }

	public String[] bubbleSortStringArray(String[] array) {

		boolean sorted = false;
		String temp = "";

		while (sorted == false) {
			sorted = true;

			for (int i = 0; i < array.length - 1; i++) {
				for (int j = 0; j < array.length - i - 1; j++) {

					if (array[i + 1].compareTo(array[i]) < 0) {
						sorted = false;

						temp = array[i];
						array[i] = array[i + 1];
						array[i + 1] = temp;

						for (String s : array) {
							System.out.print(s + " ");
						}
						System.out.println();
					}
				}

			}

		}
		return array;
	}

	public String[] selectionSortStringArray(String[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int save = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j].compareTo(arr[save]) < 0)
					save = j;

			String smallest = arr[save];
			arr[save] = arr[i];
			arr[i] = smallest;
		}
		return arr;
	}

	public ArrayList<Customer> selectionSortArrayListCustomer(ArrayList<Customer> customers) { // does not work

		for (int i = 0; i < customers.size() - 1; i++) {
			int save = i;
			for (int j = i + 1; j < customers.size(); j++) {
				if (customers.get(j).compareTo(customers.get(save)) < 0) {
					save = j;
					Customer c = customers.get(save);
					customers.set(save, customers.get(i));
					customers.set(i, c);

				}
			}
		}

		return customers;
	}

	public String[] insertionSortStringArray(String[] arr) {

		String key = "";
		String temp = "";
		int i, j;
		for (i = 1; i < arr.length; i++) {

			key = arr[i];
			j = i - 1;

			while (j >= 0 && key.compareTo(arr[j]) < 0) {

				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
				j--;
			}

		}
		return arr;

	}

	// public ArrayList<Customer> insertionSortArrayList(ArrayList<Customer>
	// customers) {
	//
	// String key = "";
	// String temp = "";
	// int i, j;
	// for (i = 1; i < customers.size(); i++) {
	//
	// key = customers.get(i);
	// j = i - 1;
	//
	// while (j >= 0 && key.compareTo(customers.get(j)) < 0) {
	//
	// temp = customers.get(j);
	// customers.set(j, j+1);
	// customers.set(j+1, temp);
	// j--;
	// }
	//
	// }
	// return customers;
	// }
}
