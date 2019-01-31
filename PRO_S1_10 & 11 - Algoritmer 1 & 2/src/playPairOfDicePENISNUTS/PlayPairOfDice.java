package playPairOfDicePENISNUTS;

import java.util.Scanner;

public class PlayPairOfDice {

	private Scanner sc;
	private boolean finished;
	private PairOfDices dices;

	public void play() {
		dices = new PairOfDices(6);
		boolean finished = false;
		dices.rollBothDices();
		while (!finished) {
			System.out.println("\nRoll again?: y/n");
			String input = sc.nextLine();
			if (input.equalsIgnoreCase("y")) {
				dices.rollBothDices();
			} else {
				dices.printOccurrences();
				dices.resetDice();
				endGame();
				finished = true;

			}

		}

	}

	public void takeTurn() {

	}

	public void endGame() {
		System.out.println(
				"Game has come to an end. Thank you for playing\n********************************\n\n\n\n\n\n\n\n\n Ya dickhead");
		sc.close();

	}
	// game is conducted here.

	public void startGame() {
		sc = new Scanner(System.in);
		System.out.println("Welcome to the game \"Pair of dice\".\n\n"
				+ "The game lets you roll two dices continuously, until you decide to stop. \nWhen the game stops, it'll display the statistics of your rolls\n"
				+ "You can't win, so have fun achieving nothing.\n\n" + "Start new game? y/n: ");
		String answer = sc.nextLine();
		if (answer.equalsIgnoreCase("y")) {
			play();
		} else {
			System.out.println("PENISNUTS!!");
		}

	}

}
