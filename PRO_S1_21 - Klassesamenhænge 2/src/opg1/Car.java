package opg1;

import java.util.ArrayList;

public class Car {
	// Association: --> 0..* Rental

	private String license;
	private double pricePerDay;
	private int purchaseYear;

	// --------------Link Attribute---------------
	private ArrayList<Rental> rentals = new ArrayList<>();
	private Rental rental;
	// --------------Link Attribute---------------

	public Car(String license, double pricePerDay, int purchaseYear) {
		this.license = license;
		this.pricePerDay = pricePerDay;
		this.purchaseYear = purchaseYear;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getPurchaseYear() {
		return purchaseYear;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	void setRental(Rental rental) {
		this.rental = rental;
	}

	public int getLongestRental() {
		int longestRental = 0;
		for (Rental r : rentals) {
			if (r.getDays() > longestRental) {
				longestRental = r.getDays();
			}
		}
		return longestRental;
	}

	// --------------Link Attribute---------------
	// Har package synlighed
	ArrayList<Rental> getRentals() {
		return new ArrayList<>(rentals);
	}

	void addRental(Rental rental) {
		rentals.add(rental);
	}

	void removeRental(Rental rental) {
		rentals.remove(rental);
	}
	// --------------Link Attribute---------------

	public String toString() {
		return "License: " + license;
	}
}
