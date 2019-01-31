package model;

import java.util.ArrayList;

public class FletningsMetoder {

	public ArrayList<Integer> flet(ArrayList<Integer> a1, ArrayList<Integer> a2) {

		// Index 1
		int i1 = 0;

		// Index 2
		int i2 = 0;

		// Den flettede ArrayList som returneres
		ArrayList<Integer> result = new ArrayList<Integer>();

		while (i1 < a1.size() && i2 < a2.size()) {
			if (a1.get(i1) < a2.get(i2)) {
				result.add(a1.get(i1));
				i1++;
			} else {
				result.add(a2.get(i2));
				i2++;
			}
		}
		while (i1 < a1.size()) {
			result.add(a1.get(i1));
			i1++;
		}
		while (i2 < a2.size()) {
			result.add(a2.get(i2));
			i2++;
		}

		return result;
	}
}
