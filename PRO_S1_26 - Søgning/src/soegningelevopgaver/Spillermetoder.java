package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {

	// Opgave 4.1:
	public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
		boolean found = false;
		int i = 0;
		while (!found && i < spillere.size()) {
			if (spillere.get(i).getMaal() == score) {
				found = true;
				return spillere.get(i);
			} else {
				i++;
			}
		}
		return null;
	}

	// Opgave 4.2
	public Spiller findScoreBinary(ArrayList<Spiller> spillere, int score) {
		boolean found = false;
		int left = 0;
		int middle = -1;
		int right = spillere.size() - 1;
		Spiller spiller = null;
		while (!found && left <= right) {
			middle = (left + right) / 2;
			spiller = spillere.get(middle);
			if (spiller.getMaal() == score) {
				found = true;
			} else if (spiller.getMaal() < score) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}

		}
		if (found) {
			return spiller;
		} else {
			return null;
		}

	}

	// Opgave 4.3 - Egentligt ikke sådan opgaven skal besvares
	public String findGodSpiller(ArrayList<Spiller> spillere) {

		String result = "";

		for (int i = 0; i < spillere.size(); i++) {
			if (spillere.get(i).getHoejde() < 170 && spillere.get(i).getMaal() > 50) {
				result = spillere.get(i).getNavn();
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Spillermetoder metoder = new Spillermetoder();

		// Her afprÃ¸ves opgave 4.1
		ArrayList<Spiller> spillerListe = new ArrayList<>();
		spillerListe.add(new Spiller("Hans", 196, 99, 45));
		spillerListe.add(new Spiller("Bo", 203, 89, 60));
		spillerListe.add(new Spiller("Jens", 188, 109, 32));
		spillerListe.add(new Spiller("Finn", 194, 102, 12));
		spillerListe.add(new Spiller("Lars", 192, 86, 35));
		spillerListe.add(new Spiller("Mads", 200, 103, 37));

		ArrayList<Spiller> spillerListeSorteret = new ArrayList<>();
		spillerListeSorteret.add(new Spiller("Finn", 194, 102, 12));
		spillerListeSorteret.add(new Spiller("Jens", 188, 109, 32));
		spillerListeSorteret.add(new Spiller("Lars", 192, 86, 35));
		spillerListeSorteret.add(new Spiller("Mads", 200, 103, 37));
		spillerListeSorteret.add(new Spiller("Hans", 196, 99, 45));
		spillerListeSorteret.add(new Spiller("Bo", 203, 89, 60));

		System.out.println("Opg 4.1: Spiller der har scoret 35 mål: \n" + metoder.findScoreLinear(spillerListe, 35));
		System.out.println("\nopg 4.1: Spiller der har scoret 30 mål: \n" + metoder.findScoreLinear(spillerListe, 30));

		System.out.println("\nOpg 4.2: Find a player with the input score (input: x) (Answer: x): \n"
				+ metoder.findScoreBinary(spillerListeSorteret, 32));
		// Metoden virker ikke som forventet.

		System.out.println(
				"\nOpg 4.3: Find navnet på en \"god\" spiller med en højde på under 170cm og med over 50 mål: (testet og virker) \n"
						+ metoder.findGodSpiller(spillerListe));
	}

}
