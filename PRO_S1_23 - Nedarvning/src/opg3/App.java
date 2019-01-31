package opg3;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {

		Product p1 = new Product(1, "Shaving cream", 22.49);
		Product p2 = new Product(2, "Huge dildo", 49.45);
		Product p3 = new Product(3, "Magic box", 88.21);
		Product p4 = new Product(4, "Bagic Mox", 62);
		Product p5 = new Product(5, "Xiaoyu", 48.42);

		Customer c1 = new Customer("Thomas", LocalDate.parse("2017-04-12"));
		Customer c2 = new Customer("Tom", LocalDate.parse("1991-07-05"));

		Order o1 = new Order(1);
		o1.createOrderLine(5, p1);
		o1.createOrderLine(8, p2);

		Order o2 = new Order(2);
		o2.createOrderLine(3, p3);
		o2.createOrderLine(1, p4);
		o2.createOrderLine(7, p5);

		Order o3 = new Order(2);
		o3.createOrderLine(3, p3);
		o3.createOrderLine(4, p2);
		o3.createOrderLine(7, p5);

		Order o4 = new Order(2);
		o4.createOrderLine(3, p3);
		o4.createOrderLine(1, p4);
		o4.createOrderLine(2, p1);

		Order o5 = new Order(2);
		o5.createOrderLine(3, p1);
		o5.createOrderLine(1, p2);
		o5.createOrderLine(7, p3);

		Order o6 = new Order(2);
		o6.createOrderLine(3, p3);
		o6.createOrderLine(1, p2);
		o6.createOrderLine(7, p4);

		Order o7 = new Order(2);
		o7.createOrderLine(3, p3);
		o7.createOrderLine(12, p1);

		c1.addOrder(o1);
		c1.addOrder(o2);

		c2.addOrder(o3);
		c2.addOrder(o4);
		c2.addOrder(o5);
		c2.addOrder(o6);

		System.out.println("Price of customer 1's orders: " + c1.getPriceOfOrders() + " shekels.");
		System.out.println("Price of customer 2's orders: " + c2.getPriceOfOrders() + " shekels.");
	}

}
