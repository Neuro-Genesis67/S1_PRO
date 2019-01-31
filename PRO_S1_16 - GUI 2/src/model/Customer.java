package model;

public class Customer {

	private String name, address, license, password;
	private int phone;

	public Customer(String name, String address, String license, int phone, String password) {
		this.name = name;
		this.address = address;
		this.license = license;
		this.phone = phone;
		this.password = password;
	}
}
