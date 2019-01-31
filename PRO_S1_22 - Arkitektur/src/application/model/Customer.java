package application.model;

import java.util.ArrayList;

public class Customer {

	private Company company;
	private String name;
	// ---------- Link attribute ----------
	private ArrayList<Company> companies = new ArrayList<>();
	// ---------- Link attribute ----------

	public Customer(String name) {
		this.name = name;
	}

	public Customer(String name, Company company) {
		this.name = name;
		this.company = company;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//
	// public Company getCompany() {
	// return
	// }

	public void removeCompany(Company company) {
		companies.remove(company);

	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Company getCompany() {
		return this.company;
	}

	public ArrayList<Company> getCompanies() {
		return companies;
	}

	public void addCompany(Company company) {
		companies.add(company);
	}

	@Override
	public String toString() {
		return name;
	}

}
