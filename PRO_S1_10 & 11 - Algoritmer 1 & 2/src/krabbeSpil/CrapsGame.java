package krabbeSpil;

import java.util.Scanner;

public class CrapsGame {
	private Die d1;
	private Die d2;
	private Scanner sc = new Scanner(System.in);
	private boolean gameWon = false;
	private boolean gameLost = false;
	private int point;
	private boolean firstRoll = true;
	private int roll1;
	private int roll2;
	private boolean playAgain = false;
	private String input;
	private int roll;
	private boolean gameOn = true;

	public CrapsGame() {
		d1 = new Die(6);
		d2 = new Die(6);
	}

	public void welcome() {
		// sc = new Scanner(System.in);
		input = null;
		System.out.println("Welcome to Craps\n\n" + "Rules: \n-First roll is 7 or 11 = you win\n"
				+ "-First roll is 2, 3 or 12 = You lose\n"
				+ "-First roll is not 2, 3, 7, 11 or 12 = Your roll is your \"point\"\n"
				+ "-Roll 7 after point has been established = Lose the game\n\n\n" + "" + "-Start new game? y/n: ");
		input = sc.nextLine();
		if (input.equalsIgnoreCase("y")) {
			firstRoll();
		} else {
			gameEnd();
		}
	}

	public void firstRoll() {
		d1.roll();
		d2.roll();
		roll = d1.getFaceValue() + d2.getFaceValue();
		System.out.println("You rolled: " + roll + "\n");
		if (roll == 7 || roll == 11) {
			gameWon();
		} else if (roll == 2 || roll == 3 || roll == 12) {
			gameLost();
		} else {
			point = roll;
			while (gameOn) {
				roll();
			}

		}

	}

	public void roll() {
		System.out.println("Roll " + point + " to win.");
		System.out.println("Roll dice? y/n: ");
		input = sc.nextLine();
		if (input.equalsIgnoreCase("y")) {
			d1.roll();
			d2.roll();
			roll = d1.getFaceValue() + d2.getFaceValue();
			if (roll == point) {
				System.out.println("You rolled " + roll);
				gameWon();
			} else if (roll == 7) {
				System.out.println("You rolled 7");
				gameLost();
			} else {
				System.out.println("You rolled " + roll);
			}

		} else {
			gameEnd();
		}

	}

	public void gameWon() {
		sc = new Scanner(System.in);
		System.out.println("Congratulations, you won the game. \n\nPlay again? y/n: ");
		input = sc.nextLine();
		if (input.equalsIgnoreCase("y")) {
			// sc.close();
			// input = "";
			firstRoll();
		} else {
			gameEnd();
		}

	}

	public void gameLost() {
		System.out.println("You lost the game.\n\nPlay again? y/n: ");
		input = sc.nextLine();
		if (input.equalsIgnoreCase("y")) {
			// sc.close();
			// input = "";
			firstRoll();
		} else {
			gameEnd();
		}
	}

	public void gameEnd() {
		System.out.println("Closing game...\n\nGame successfully closed.");
		gameOn = false;
		// input = "";
		// sc.close();
	}
}
