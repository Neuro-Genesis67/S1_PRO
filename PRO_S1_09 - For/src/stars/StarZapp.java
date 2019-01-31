package stars;

public class StarZapp {

	public void starPicture() {
		int x = 1;
		for (int i = -10; i <= 10; i++) {
			System.out.println(x);
			x++;
		}
	}

	public void starPictureA() {
		for (int row = 10; row >= 0; row--) {
			for (int col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println("YaBitch!");
		}
	}

	public void starPictureB() {
		String word = "YaBitch!";

		for (int row = 10; row >= 0; row--) {
			for (int col = 0; col < row; col++) {
				System.out.print(" ");
			}
			for (int i = 10; i > row - 1; i--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

	public void starPictureC() {
		for (int row = 10; row >= 0; row--) {
			for (int col = 10; col > row; col--) {
				System.out.print(" ");
			}
			for (int i = 0; i <= row; i++) {
				System.out.print("*");
			}
			System.out.println();

		}
		System.out.println("... YaBitch!");
	}

	public void starPictureD() {
		int row;
		int spaces;
		int stars;

		int exit = 12;
		// rows
		for (row = 1; row < 6; row++) {
			// spaces
			for (spaces = 5; spaces > row; spaces--) {
				System.out.print(" ");
			}
			// stars
			for (stars = 1; stars < (row * 2); stars++) {
				System.out.print("*");
			}
			System.out.println();
		}
		// rows
		for (row = 1; row < 8; row++) {
			// spaces
			for (spaces = 1; spaces < row; spaces++) {
				System.out.print(" ");
			}
			for (stars = 1; stars < (exit - 2); stars++) {
				System.out.print("*");

			}
			exit = exit - 2;
			System.out.println();

		}
		System.out.println("...........");
		System.out.println("\n\n\n\n");
		System.out.println("YaYEET!");
	}

}
