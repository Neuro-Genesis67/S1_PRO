package backupModel;

public class Car {

	private String license;
	private double pricePerDay;
	private int purchaseYear;
	private int year;
	
	
	public Car (String license, int year) {
		this.license = license;
		this.year = year;
	}
	
	public void setDayPrice(double price) {
		this.pricePerDay = price;
	}
	
	public double getDayPrice() {
		return pricePerDay;
	}
	
	public String getLicense() {
		return license;
	}
	
	public int getPurchaseYear() {
		return purchaseYear;
	}
}
