package opg2;

public class Customer implements Comparable<Customer> {

	private String name;
	private String lastName;
	private int age;

	public Customer(String name, String lastName, int age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	public Customer() {

	}

	public int compareTo(Customer customer) {
		int result;
		if (this.getLastName().compareTo(customer.getLastName()) > 0) {
			result = 1;
		} else if (this.getLastName().compareTo(customer.getLastName()) < 0) {
			result = -1;
		} else
			result = 0;

		if (result == 0) {
			if (this.getName().compareTo(customer.getName()) > 0) {
				result = 1;
			} else if (this.getName().compareTo(customer.getName()) < 0) {
				result = -1;
			} else
				result = 0;

			if (result == 0) {
				if (this.getAge() > customer.getAge()) {
					result = 1;
				}
				if (this.getAge() < customer.getAge()) {
					result = -1;
				} else
					result = 0;
			}
		}
		return result;

	}

	public static Customer lastCustomer(Customer[] customers) {
		Customer current = null;
		Customer previous = null;
		Customer lastCustomer = null;
		int compare = 0;
		for (Customer c : customers) {
			if (previous != null) {
				current = c;
				compare = current.compareTo(previous);
			}
			if (compare == 1) {
				lastCustomer = current;
			}
			if (compare == -1) {
				lastCustomer = previous;
			}

			previous = c;
		}
		return lastCustomer;
	}

	public static Customer[] afterCustomer(Customer[] customers, Customer customer) {
		int comparison;
		int i = 0;
		Customer[] afterCustomerList = new Customer[customers.length];
		for (Customer c : customers) {
			comparison = c.compareTo(customer);
			if (comparison == 1) {
				afterCustomerList[i] = c;
				i++;
			}
		}
		return afterCustomerList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.getName() + " " + this.getLastName() + ", " + this.getAge() + " år gammel.";
	}

}
