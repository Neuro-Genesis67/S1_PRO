package opg2_efg;

public class Gift {

	private String description;
	private double price;

	public Gift(String description, double price) {
		this.description = description;
		this.price = price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return this.price;
	}

	public String toString() {
		return this.description;
	}

}
