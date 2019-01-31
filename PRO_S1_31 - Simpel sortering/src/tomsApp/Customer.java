package tomsApp;

public class Customer implements Comparable<Customer> {

	private int age;
	private String name;

	public Customer(int age, String name) {
		this.age = age;
		this.name = name;
	}

	public Customer() {

	}

	@Override
	public int compareTo(Customer customer) {
		int result = 0;
		if (this.age > customer.getAge()) {
			result = 1;
		} else if (this.age < customer.getAge()) {
			result = -1;
		} else if (this.age == customer.getAge()) {
			if (this.name.compareTo(customer.getName()) == 1) {
				result = 1;
			} else if (this.name.compareTo(customer.getName()) == -1) {
				result = -1;
			} else {
				result = 0;
			}
		}
		return result;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nName: " + this.name + "\nAge: " + this.age + "\n";
	}

}
