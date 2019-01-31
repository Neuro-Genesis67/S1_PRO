package model;

public class PersonApp {

	public static void main(String[] args) {
		//Name, address, monthlySalary.
		Person p1 = new Person("Tom", "Rosenhøj", 8000, 8, "Danfos");
		p1.printPerson();
		p1.setNumberOfCompanies(11);
		p1.setCompany("Vestas");
		p1.printPerson();
		System.out.println((int)11.0/4.0);

	}

}
