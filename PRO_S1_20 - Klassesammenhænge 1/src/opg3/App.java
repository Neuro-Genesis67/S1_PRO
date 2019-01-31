package opg3;

public class App {

	public static void main(String[] args) {
		Car c1 = new Car("07 AXP 802", 49.98, 1991);
		Car c2 = new Car("92 YXO 711", 69.45, 1995);
		Car c3 = new Car("78 GKF 726", 25.50, 2002);
		Car c4 = new Car("41 OGJ 591", 15.25, 1982);
		Car c5 = new Car("25 RDK 284", 105.2, 2010);

		Rental r1 = new Rental(1, "07/05/1991", 8);
		Rental r2 = new Rental(2, "02/12/1991", 2);

		r1.addCar(c1);
		r1.addCar(c2);
		r1.addCar(c3);
		r1.addCar(c4);

		r2.addCar(c5);

		System.out.println("Total price of rental 1: " + r1.getPrice());
		System.out.println("Total price of rental 2: " + r2.getPrice());

	}

}
