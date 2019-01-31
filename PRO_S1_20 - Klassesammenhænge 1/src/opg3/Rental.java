package opg3;

import java.util.ArrayList;

public class Rental {

	private int ID;
	private int days;
	private String date;
	// --------------Link Attribute---------------
	private ArrayList<Car> cars = new ArrayList<>();
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
	public ArrayList<Car> getCarList() {
		return new ArrayList<>(cars);
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void removeCar(Car car) {
		cars.remove(car);
	}
	// --------------Link Attribute---------------
}
