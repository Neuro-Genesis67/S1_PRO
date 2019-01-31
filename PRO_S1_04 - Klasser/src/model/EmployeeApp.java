package model;

/*
 * Anvendelses program der opretter Employee objekter og anvender metoder på disse
 */
public class EmployeeApp {

	public static void main(String[] args) {
		Employee e1 = new Employee("Hans", "Jensen", 25);
		Employee e2 = new Employee("Tom", "Steinmeier", 26);
		e2.printEmployee();
		e1.printEmployee();
		e1.setName("Viggo");
		e1.setAge(22);
		e1.birthday();
		e1.printEmployee();

	}

}
