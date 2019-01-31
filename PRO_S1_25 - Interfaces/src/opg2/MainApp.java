package opg2;

public class MainApp {

	public static void main(String[] args) {

		Customer test = new Customer();
		Customer[] customers = new Customer[8];
		Customer c1 = new Customer("Mogens", "Røvguitar", 84);
		Customer c2 = new Customer("Ane", "Didriksen", 27);
		Customer c3 = new Customer("Abel", "Didriksen", 29);
		Customer c4 = new Customer("Ane", "Didriksen", 28);
		Customer c5 = new Customer("Tom", "Steinmeier", 27);
		Customer c6 = new Customer("Shane", "Niemeyer", 42);
		Customer c7 = new Customer("Peter", "Niemeyer", 27);
		Customer c8 = new Customer("Torso", "MqQueen", 26);

		customers[0] = c1;
		customers[1] = c2;
		customers[2] = c3;
		customers[3] = c4;
		customers[4] = c5;
		customers[5] = c6;
		customers[6] = c7;
		customers[7] = c8;

		System.out.println("All customers in the list: ");
		System.out.println();
		for (Customer c : customers) {
			System.out.println(c.toString());
		}
		System.out.println(test.lastCustomer(customers));
		System.out.println();
		System.out.println("\"Last\" costumer in line: " + test.lastCustomer(customers).toString());
		System.out.println();

		System.out.println("All customers that come after Peter Niemeyer: ");
		for (Customer c : test.afterCustomer(customers, c7)) {
			if (c == null) {
				System.out.print("");
			} else
				System.out.println(c.toString());
		} // Undgår nullPointerException

	}

}
