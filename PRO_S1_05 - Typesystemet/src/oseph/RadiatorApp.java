package oseph;

public class RadiatorApp {

	public static void main(String[] args) {
		Radiator r1 = new Radiator();
		Radiator r2 = new Radiator(20);

		System.out.println("Radiator 1's temperatur: " + r1.getTemperature());
		System.out.println("Radiator 2's temperatur: " + r2.getTemperature());

		r1.skruOp(40);
		r2.skruNed(35);

		System.out.println();
		System.out.println("Varme justeres for begge radiatorer...\n");
		System.out.println("Radiator 1's temperatur: " + r1.getTemperature());
		System.out.println("Radiator 2's temperatur: " + r2.getTemperature());

	}

}
