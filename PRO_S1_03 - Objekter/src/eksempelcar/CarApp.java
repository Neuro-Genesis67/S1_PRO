package eksempelcar;

public class CarApp {

	public static void main(String[] args) {
		Car myCar = new Car("VW UP", "White");
		System.out.println(myCar.getBrand());
		myCar.setRegistrationNumber("AB 11 123");
		System.out.println(myCar.getRegistrationNumber());
		Car myCar2 = new Car("Skoda", "Pisgul");
		myCar2.setRegistrationNumber("AP 52 512");
		System.out.println(myCar2.getColor());
		System.out.println(myCar2.getBrand());
		myCar2.setKm(19922);
		myCar2.printCar(myCar2);
	}

}
