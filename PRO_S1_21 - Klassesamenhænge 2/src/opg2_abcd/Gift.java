package opg2_abcd;

public class Gift {

	private String description;
	private double price;
	private Person person;

	public Gift(String description, double price, Person fromPerson) {
		this.description = description;
		this.price = price;
		this.setPerson(fromPerson);
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

	public void setPerson(Person person) {
		this.person = person;
	}
}
