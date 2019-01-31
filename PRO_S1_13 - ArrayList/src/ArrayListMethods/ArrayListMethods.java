package ArrayListMethods;

import java.util.ArrayList;

public class ArrayListMethods {

	public void moveEvenElementsFirstInList(ArrayList<Integer> list) {
		int element = 0;
		int moveIndexUp = 0;
		for (int i = 0; i != list.size() - 1; i++) {
			if (list.get(i) % 2 == 0) {
				element = list.get(i);
				list.remove(i);
				list.add(moveIndexUp, element);
				moveIndexUp++;

			}
		}
	}

	public boolean sameInLists(ArrayList<Integer> list1, ArrayList<Integer> list2) {

		boolean noneFound = false;
		boolean foundOne = false;
		int x = 0;
		int i = 0;
		// i = amount of items in list
		for (i = 0; i < list1.size(); i++) {
			foundOne = false;
			x = 0;
			// Tjekker om der findes en lignende i liste 2
			while (x < list1.size()) {
				if (list1.get(i) == list2.get(x)) {
					foundOne = true;
					x++;
				} else {
					x++;
				}
			}
			if (!foundOne) {
				return noneFound;
			}
		}
		return foundOne;
	}

	public boolean duplicatesInList(ArrayList<Integer> list) {
		boolean found = false;
		int main = 0;
		int oneUp = 0;

		for (int i = 0; i < list.size(); i++) { // i = 1 now
			main = list.get(i); // 19
			oneUp += i + 1;
			for (int x = oneUp; x < list.size(); x++) {

				if (main == list.get(x)) {
					found = true;
				}
			}

		}

		return found;
	}

	public boolean isListSorted(ArrayList<Integer> list) {
		boolean sorted = true;
		int index = -500000;
		for (Integer i : list) {

			if (i < index) {
				sorted = false;
			}
			index = i;
		}
		return sorted;
	}

	public int nextBiggestInList(ArrayList<Integer> list) {
		int biggest = 0;
		int previous = 0;
		int temp = 0;
		int index = 0;
		for (Integer i : list) {

			if (i > biggest) {
				if (index == 0) {
					index++;
					temp = list.get(0);
				} else {
					temp = biggest;
				}
				biggest = i;
			}
			if (i > temp && i < biggest) {
				temp = i;
			}

		}
		return temp;

	}

	public int min(ArrayList<Integer> list) {
		int min = 500000;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
			}

		}
		return min;
	}

	public void replaceEvenNumbers(ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				list.set(i, 0);
			}
		}
	}

	public ArrayList<Integer> evenList(ArrayList<Integer> list) {
		ArrayList<Integer> evenList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				evenList.add(list.get(i));
			}

		}
		return evenList;
	}

	public double average(ArrayList<Integer> list) {
		int i;
		double average = 0.0;
		double sum = 0;
		for (i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		average = sum / i;
		return average;
	}

	public int zeroes(ArrayList<Integer> list) {
		int zeroes = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 0) {
				zeroes++;
			}
		}
		return zeroes;
	}

	/**
	 * Sums the numbers in the list using a for loop each
	 */
	public int sumListeForEach(ArrayList<Integer> list) {
		int resultat = 0;
		for (int tal : list) {
			resultat = resultat + tal;
		}
		return resultat;
	}

	/**
	 * Sums the numbers in the list using a for loop
	 */
	public int sumListeFor(ArrayList<Integer> list) {
		int resultat = 0;
		for (int i = 0; i < list.size(); i++) {
			resultat = resultat + list.get(i);
		}
		return resultat;
	}

	/**
	 * Returns the index of the first even number
	 */
	public int hasEvenAtIndex(ArrayList<Integer> list) {
		int index = -1;
		int i = 0;
		while (index == -1 && i < list.size()) {
			if (list.get(i) % 2 == 0) {
				index = i;
			}
			i++;
		}
		return index;
	}

}
