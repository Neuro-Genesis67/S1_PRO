package oseph;

public class Program {

	public static void main(String[] args) {
		String ord1 = "Datamatiker";
		String ord2 = "Uddannelsen";
		String ord3 = ord1 + ord2.toLowerCase();
		System.out.println(ord3.length());
		System.out.println(ord1.length());
		System.out.println("***********************");
		for (int i = 0; i < 7; i++) {
			if (i > 1 && i < 7) {
				System.out.println(ord2.substring(0 + i, i + 1));
			}

		}

	}

}
