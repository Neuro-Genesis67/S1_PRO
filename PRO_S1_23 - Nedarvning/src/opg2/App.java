package opg2;

import java.util.ArrayList;

import opg1.Værkfører;

public class App { // Anvendelsesklassen

	public static double beregnSamletLøn(ArrayList<Mekaniker> list) {
		double sum = 0.0;
		for (Mekaniker m : list) {
			sum += m.getUgeløn();
		}
		return sum;
	}

	public static void main(String[] args) {

		// ---------------------------------------------------------------------------------------------------
		// String navn, String addresse, int svendepr�ve, double timel�n
		Mekaniker m1 = new Mekaniker("Michael olufsen", "Moltkes allé 90, 2tv", 2005, 200);

		// String navn, String addresse, int svendepr�ve, double timel�n, int
		// udn�vnelse, double till�g
		// String navn, String addresse, int svendeprøve, double timeløn, int
		// udnævnelse, double tillæg
		Værkfører v1 = new Værkfører("Vilhelm", "Jakob jakobsens vej 22, st. th", 2004, 200, 2010, 600);

		// String navn, String addresse, int svendepr�ve, double timel�n, double
		// synTill�g, int ugentligeSyn
		Synsmand s1 = new Synsmand("Oluf syneri", "Synbald all�", 2005, 120, 20, 5);

		// ---------------------------------------------------------------------------------------------------

		// getUgeløn er defineret både i Mekaniker og Værkfører klasserne
		// System.out.println("Mekanikerens ugeløn: " + m1.getUgeløn());
		System.out.println("Værkførerens ugeløn: " + v1.getUgeløn());
		// System.out.println("Synsmandens ugeløn: " + s1.getUgeløn());

		// ---------------------------------------------------------------------------------------------------

		// Der oprettes en ny liste af Mekaniker klassen.
		// Da v�rkf�rer nedarver Mekaniker egenskaberne,
		// indg�r denne ogs� i lisen. V�rkf�rer er en specialisering af Mekaniker
		ArrayList<Mekaniker> mekanikere = new ArrayList<>();
		// Der tilf�jes Mekanikere/Specialiseringer af "Mekaniker klassen", til listen.
		mekanikere.add(m1);
		// mekanikere.add(v1);
		mekanikere.add(s1);
		// ..Double.. | Output = Double
		double samletLøn = beregnSamletLøn(mekanikere);
		System.out.println("Samlet ugeløn for dem alle: " + samletLøn);

	}

}
