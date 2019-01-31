package opg2_abcd;

import java.util.ArrayList;

public class Person {

	private String name;
	private int age;

	// ----------Link attribute-----------
	private ArrayList<Gift> gifts = new ArrayList<>();
	// ----------Link attribute-----------

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return "Name: " + name + "\nAge: " + age;
	}

	public double getValueOfGifts() {
		double totalValue = 0.0;
		for (Gift g : gifts) {
			totalValue += g.getPrice();
		}

		return totalValue;
	}

	// ----------Link attribute-----------
	public ArrayList<Gift> getGifts() {
		return new ArrayList<>(gifts);
	}

	public void addGift(Gift gift) {
		gifts.add(gift);
	}

	public void removeGift(Gift gift) {
		gifts.remove(gift);
	}
	// ----------Link attribute-----------
}
