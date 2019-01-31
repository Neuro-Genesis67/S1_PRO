package model;

public class Person {
	private String name;
	private String address;
	private double monthlySalary;
	private String company;
	private int numberOfCompanies;




	public Person(String inputName, String inputAddress, double inputMonthlySalary, int inputNumberOfCompanies, String inputCurrentCompany) {
		name = inputName;
		address = inputAddress;
		monthlySalary = inputMonthlySalary;
		company = inputCurrentCompany;
		numberOfCompanies = inputNumberOfCompanies;
		
	}

	//Set methods:
	public void setName(String inputName) {
		name = inputName;
	}

	public void setAddress(String inputAddress) {
		address = inputAddress;
	}

	public void setMonthlySalary(double inputMonthlySalary) {
		monthlySalary = inputMonthlySalary;
	}
	
	public void setCompany(String inputCurrentCompany) {
		company = inputCurrentCompany;
	}
	public void setNumberOfCompanies(int inputNumberOfCompanies) {
	numberOfCompanies = inputNumberOfCompanies;	
	}
	

	//Get methods:
	public String getName () {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}
	
	public int getCurrentCompanies() {
		return numberOfCompanies;
	}
	
	public String getCompany() {
		return company;
	}
	//Printperson
	public void printPerson() {
		System.out.println("**************************************");
		System.out.println("Name: " + getName());
		System.out.println("Address: " + getAddress());
		System.out.println("MonthlySalary: " + getMonthlySalary());
		System.out.println("Yearly Salary: " + yearly());
		System.out.println("Number of companies: " + getCurrentCompanies());
		System.out.println("Current Company: " + getCompany());
		System.out.println("**************************************");
	}
	//Månedslån + 2.5% i feriepenge
	public double yearly() {
		double yearlySalary = (this.monthlySalary * 12);
		return yearlySalary;
	}
	
	public void changeCompanyTo(String inputCompany) {
		company = inputCompany;
		
	}
}


