package opg2;

import java.util.ArrayList;

public class SwimmerApp {

	public static void main(String[] args) {

		ArrayList<Double> lapTimes = new ArrayList<>();
		lapTimes.add(1.02);
		lapTimes.add(1.01);
		lapTimes.add(0.99);
		lapTimes.add(0.98);
		lapTimes.add(1.02);
		lapTimes.add(1.04);
		lapTimes.add(0.99);
		Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");

		lapTimes = new ArrayList<>();
		lapTimes.add(1.05);
		lapTimes.add(1.01);
		lapTimes.add(1.04);
		lapTimes.add(1.06);
		lapTimes.add(1.08);
		lapTimes.add(1.04);
		lapTimes.add(1.02);
		Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");

		TrainingPlan tpA = new TrainingPlan('A', 16, 10);

		tpA.addSwimmer(s1);
		tpA.addSwimmer(s2);

		for (Swimmer s : tpA.getSwimmers()) {
			System.out
					.println("Name: " + s.getName() + " - Club: " + s.getClub() + " - yeargroup: " + s.getYearGroup());
		}
	}

}

// På level A er svømmeren i vandet 16 timer og styrketræner 10 timer om ugen.
// På
// level B er svømmeren i vandet 10 timer om ugen og styrketræner 6 timer om
// ugen.