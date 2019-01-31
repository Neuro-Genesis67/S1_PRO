package opg1;

public class App {

	public static void main(String[] args) {

		Car car1 = new Car("8362", 20, 1991);
		Car car2 = new Car("6623", 45, 2002);
		Car car3 = new Car("1392", 35, 1998);
		Car car4 = new Car("3834", 15, 1994);
		Car car5 = new Car("2732", 20, 2004);

		Rental r1 = new Rental(1, "07/05/1991", 8);
		Rental r2 = new Rental(1, "07/05/1991", 3);

		car1.addRental(r1);
		car1.addRental(r2);
		// System.out.println(car1.getLongestRental());
		// System.out.println(r1.getCars());

		System.out.println(car1.getRentals());

	}
}
