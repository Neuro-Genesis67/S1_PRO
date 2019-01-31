package opg3;

public class Car {

	private String license;
	private double pricePerDay;
	private int purchaseYear;

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

}
