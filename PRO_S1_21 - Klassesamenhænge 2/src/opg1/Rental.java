package opg1;

import java.util.ArrayList;

public class Rental {
	// Association: --> 0..* Car
	// This class is responsible for updating Car and Rental's link attributes.

	private int ID;
	private int days;
	private String date;
	// --------------Link Attribute---------------
	private ArrayList<Car> cars = new ArrayList<>();
	private Car car;
	// --------------Link Attribute---------------

	public Rental(int ID, String date, int days) {
		this.ID = ID;
		this.date = date;
		this.days = days;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getPrice() {
		double price = 0.0;
		for (Car car : cars) {
			price += car.getPricePerDay() * this.getDays();
		}

		return price;
	}

	// --------------Link Attribute---------------
	// Har ansvar for at opdatere begge linkattributter (Car og Rental).
	public ArrayList<Car> getCars() {
		return new ArrayList<>(cars);
	}

	public void addCar(Car car) {
		cars.add(car);
		car.setRental(this);
	}

	public void removeCar(Car car) {
		cars.remove(car);
		car.setRental(null);
	}
	// --------------Link Attribute---------------

	public String toString() {
		return "Rental number: " + ID + "\nDate: " + date + "\nDays: " + days + "\n";

	}
}
