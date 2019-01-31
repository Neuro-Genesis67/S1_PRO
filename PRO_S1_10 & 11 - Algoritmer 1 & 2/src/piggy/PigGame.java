package piggy;

import java.util.Scanner;

public class PigGame {
	private Scanner scint = new Scanner(System.in);
	private Scanner scring = new Scanner(System.in);
	private String p1; // Player one
	private String p2; // Player two
	private int p1Bracket;
	private int p2Bracket;
	private int p1Points;
	private int p2Points;
	private int input;
	private boolean playerOne;
	private boolean playerWon;
	private int roll;
	Die dice = new Die(6);
	private boolean gameOn;
	private int playPoints;

	public void newGame() {
		System.out.println("Welcome to Pig");
		System.out.println(
				"\nRules: \nHver spiller skiftes til at kaste med en terning indtil han enten kaster 1, eller beslutter sig for at\r\n"
						+ "stoppe. Hvis han slår en 1’er, får han ingen point i denne omgang. Hvis han beslutter sig for at\r\n"
						+ "stoppe inden har slår en 1’er, lægges summen af alle hans kast i denne tur sammen med hans\r\n"
						+ "samlede antal point, og turen går videre til næste spiller. Den første spiller der samlet når 100\r\n"
						+ "point har vundet.\n");

		System.out.println("1: New game\n2: Close game");
		input = scint.nextInt();
		if (input == 1) {
			createPlayers();
			startingPlayer();
			setPlayPoints();
			startGame();
			roll();

		} else if (input == 2) {
			closeGame();
		}

	}

	public void setPlayPoints() {
		System.out.println("type in how many points you wish to play to:");
		input = scint.nextInt();
		playPoints = input;
	}

	public void startGame() {
		System.out.println("It's " + p1 + " vs. " + p2 + "\nLet the games begin. Bitch.\n\n\n");

	}

	public void createPlayers() {
		System.out.println("Enter your name player 1: ");
		p1 = scring.nextLine();
		System.out.println("Enter your name player 2: ");
		p2 = scring.nextLine();

	}

	public void startingPlayer() {
		int decision = 1 + (int) (Math.random() * 2);
		if (decision == 1) {
			playerOne = true;
		} else {
			playerOne = false;
		}

	}

	public void roll() {
		while (p1Points < playPoints || p2Points < playPoints) {

			if (playerOne) {
				dice.roll();
				roll = dice.getFaceValue();
				System.out.println("-" + p1 + "'s turn-\n");
				System.out.println(p1 + "'s total score: " + p1Points);
				System.out.println(p1 + " rolls " + roll);
				if (roll == 1) {
					System.out.print("and loses his turn.\n\n\n\n");
					p1Bracket = 0;
					playerOne = false;
				} else {
					p1Bracket += roll;
					System.out.println(p1 + " now has " + p1Bracket + " temporary points ");
					rollAgain();
				}
			}
			if (!playerOne) {
				dice.roll();
				roll = dice.getFaceValue();
				System.out.println("-" + p2 + "'s turn-\n");
				System.out.println(p2 + "'s total score: " + p2Points);
				System.out.println(p2 + " rolls " + roll);
				if (roll == 1) {
					System.out.print("and loses his turn.\n\n\n\n");
					p2Bracket = 0;
					playerOne = true;
					roll(); // be careful
				} else {
					p2Bracket += roll;
					System.out.println(p2 + " now has " + p2Bracket + " temporary points ");
					rollAgain();
				}
			}
		}
		gameWon();

	}

	public void rollAgain() {
		System.out.println("\n1: Roll again.\n2: Save points.");
		input = scint.nextInt();

		if (input == 1) {
			roll();
		} else {
			if (playerOne) {
				p1Points += p1Bracket;
				System.out.println(p1 + " saved " + p1Bracket + " points.");
				p1Bracket = 0;
				System.out.println(p2 + " now has a total of " + p1Points + " points.\n\n\n");
				playerOne = false;
				roll();
			} else {
				p2Points += p2Bracket;
				System.out.println(p2 + " saved " + p2Bracket + " points.");
				p2Bracket = 0;
				System.out.println(p2 + " now has a total of " + p2Points + " points.\n\n\n");
				playerOne = true;
				roll();
			}
		}
	}

	public void closeGame() {
		// Close scanner(s)
		System.out.println("Closing game...");
		System.out.println("\n\nGame has successfully closed.");
	}

	public void playAgain() {
		System.out.println("Do you wish to start a new game?\n1: Yes\n2: No");
		input = scint.nextInt();
		if (input == 1) {
			// clear();
			newGame();
		}
	}

	public void gameWon() {
		if (playerWon) {
			System.out.println(p1 + " has won the game! hahah, eat dicks " + p2 + "!");
			playAgain();
		} else {
			System.out.println(p2 + " has won the game! hahah, eat dicks " + p1 + "!");
			playAgain();
		}
	}

}
