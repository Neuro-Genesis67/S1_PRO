package opg1;

public class App {

	public static void main(String[] args) {

		// Laver en liste af chilier
		Chili[] chilies = new Chili[6];

		// Opretter chili objekter
		// String Navn, double styrke
		Chili c1 = new Chili("Carolina Reaper", 2200000);
		Chili c2 = new Chili("Habanero", 3000000);
		Chili c3 = new Chili("Jalapeno", 8000);
		Chili c4 = new Chili("Cute chili", 2);
		Chili c5 = new Chili("X-Bomb", 5000000);
		Chili c6 = new Chili("Bhut Jolokia", 1500000);

		// Sætter de nyoprettede chilier på listen "chilies"
		chilies[0] = c1;
		chilies[1] = c2;
		chilies[2] = c3;
		chilies[3] = c4;
		chilies[4] = c5;
		chilies[5] = c6;

		System.out.println("Hottest chili in the list: " + Data.max(chilies) + " scoville units.");
		System.out.println("Average of chilies in the list: " + Data.avg(chilies) + " scoville units.");

	}

}
