package playPairOfDicePENISNUTS;

import playRollDieBitch.Die;

public class PairOfDices {

	private Die d1;
	private Die d2;
	private int totalRolls;
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int pairs;
	private int highestRoll;

	public PairOfDices() {
		d1 = new Die();
		d2 = new Die();
	}

	public PairOfDices(int sides) {
		d1 = new Die(sides);
		d2 = new Die(sides);
	}

	public void rollBothDices() {
		d1.roll();
		d2.roll();
		totalRolls++;

		int roll = d1.getFaceValue() + d2.getFaceValue();

		if (roll > this.highestRoll) {
			this.highestRoll = roll;
		}

		if (d1.getFaceValue() == 1 && d2.getFaceValue() == 1) {
			ones = ones + 2;
			pairs++;
		} else if (d1.getFaceValue() == 1 || d2.getFaceValue() == 1) {
			ones++;
		}

		if (d1.getFaceValue() == 2 && d2.getFaceValue() == 2) {
			twos = twos + 2;
			pairs++;
		} else if (d1.getFaceValue() == 2 || d2.getFaceValue() == 2) {
			twos++;
		}

		if (d1.getFaceValue() == 3 && d2.getFaceValue() == 3) {
			threes = threes + 2;
			pairs++;
		} else if (d1.getFaceValue() == 3 || d2.getFaceValue() == 3) {
			threes++;
		}

		if (d1.getFaceValue() == 4 && d2.getFaceValue() == 4) {
			fours = fours + 2;
			pairs++;
		} else if (d1.getFaceValue() == 4 || d2.getFaceValue() == 4) {
			fours++;
		}

		if (d1.getFaceValue() == 5 && d2.getFaceValue() == 5) {
			fives = fives + 2;
			pairs++;
		} else if (d1.getFaceValue() == 5 || d2.getFaceValue() == 5) {
			fives++;
		}

		if (d1.getFaceValue() == 6 && d2.getFaceValue() == 6) {
			sixes = sixes + 2;
			pairs++;
		} else if (d1.getFaceValue() == 6 || d2.getFaceValue() == 6) {
			sixes++;
		}
		System.out.println("You rolled: " + d1.getFaceValue() + " & " + d2.getFaceValue());

	}

	public int sumOfDices() {
		int total = d1.getFaceValue() + d2.getFaceValue();
		return total;
	}

	public void printOccurrences() {
		System.out.println("********************************");
		System.out.println("During the game you rolled:  ");
		System.out.println("Ones:   " + ones);
		System.out.println("Twos:   " + twos);
		System.out.println("Threes: " + threes);
		System.out.println("Fours:  " + fours);
		System.out.println("Fives:  " + fives);
		System.out.println("Sixes:  " + sixes);
		System.out.println("--------------------------------");
		System.out.println("Pairs:        " + pairs);
		System.out.println("Highest roll: " + highestRoll);
		System.out.println("Total rolls:  " + totalRolls);
		System.out.println("********************************");
	}

	public void resetDice() {
		ones = 0;
		twos = 0;
		threes = 0;
		fours = 0;
		fives = 0;
		sixes = 0;
		highestRoll = 0;
		pairs = 0;

	}

}
