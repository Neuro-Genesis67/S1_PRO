package opgave2multiplechoice;

import java.util.Arrays;

public class MultipleChoice {
	private char[] correctAnswer = { 'B', 'C', 'A', 'A', 'B', 'A', 'C', 'D', 'A', 'C' };

	private char[][] studentAnswers;

	public MultipleChoice(int numberOfStudents) {
		studentAnswers = new char[numberOfStudents][10];
		for (int i = 0; i < studentAnswers.length; i++) {
			for (int j = 0; j < studentAnswers[i].length; j++) {
				int tal = (int) (Math.random() * 4); // tal mellem 0-3
				char c = (char) (tal + 'A');
				studentAnswers[i][j] = c;
			}
		}
	}

	public void printStudentAnswers() {
		for (int i = 0; i < studentAnswers.length; i++) {
			System.out.print("Student " + (i + 1) + " resultat: ");
			for (int j = 0; j < studentAnswers[i].length; j++) {
				if (j != 0) {
					System.out.print(", ");
				}
				System.out.print(studentAnswers[i][j]);
			}
			System.out.println();
		}
	}

	public void printCorrectAnswers() {
		System.out.println("Question solutions:  " + Arrays.toString(correctAnswer));

	}

	/**
	 * Udskriver for hver studerende antallet af rigtige svar
	 */
	public void printCorrectAnswersForStudents(char[][] answers) {
		int student1 = 0;
		int student2 = 0;
		int student3 = 0;

		for (int row = 0; row < answers.length; row++) {
			for (int col = 0; col < answers[row].length; col++) {
				if (row == 0) {

				}
			}
		}
	}

	/**
	 * Udskriver for hverTTTTTTTTTTTTTTTTTT spørgsmål, antallet af rigtige svar
	 */
	public void printCorrectAnswerPrQuestion() {
		// TODO
	}

}
