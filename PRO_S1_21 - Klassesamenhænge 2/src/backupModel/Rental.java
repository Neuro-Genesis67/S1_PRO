package backupModel;

import java.util.ArrayList;

public class Rental {
	private int number;
	private int days;
	private String date;
	private double price;
	private ArrayList<Car> cars = new ArrayList<>();
	
	// association: --> 0..* Person

	 public ArrayList<Car> getCars() {
	 return new ArrayList<>(cars);
	 }
	 
	 public void addCar(Car car) {
	 cars.add(car);
	 }
	 
	 public void removeCar(Car car) {
	 cars.remove(car);
	 }
	 
	
	public Rental (int number, String date, int days) {
		this.number = number;
		this.date = date;
		this.days = days;
	}
	
	public double getPrice() {
		for (Car c : cars) {
			price += c.getDayPrice() * days;
		}
		return price;
	}
	
	public void setDays(int days) {
		this.days = days;
	}
	
	public int getDays() {
		return days;
	}
	
	
}
