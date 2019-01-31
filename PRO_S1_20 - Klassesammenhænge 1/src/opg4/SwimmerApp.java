package opg4;

import java.util.ArrayList;

public class SwimmerApp {

	public static void main(String[] args) {

		TrainingPlan tpA = new TrainingPlan('A', 16, 10);
		TrainingPlan tpB = new TrainingPlan('A', 10, 6);

		ArrayList<Double> lapTimes = new ArrayList<>();
		lapTimes.add(1.02);
		lapTimes.add(1.01);
		lapTimes.add(0.99);
		lapTimes.add(0.98);
		lapTimes.add(1.02);
		lapTimes.add(1.04);
		lapTimes.add(0.99);
		Swimmer s1 = tpA.createSwimmer("Tom steinmeier", 1991, lapTimes, "Flyderen");

		lapTimes = new ArrayList<>();
		lapTimes.add(1.05);
		lapTimes.add(1.01);
		lapTimes.add(1.04);
		lapTimes.add(1.06);
		lapTimes.add(1.08);
		lapTimes.add(1.04);
		lapTimes.add(1.02);
		Swimmer s2 = tpA.createSwimmer("Morten Sørensen", 1995, lapTimes, "Flyderino");

		lapTimes = new ArrayList<>();
		lapTimes.add(1.03);
		lapTimes.add(1.01);
		lapTimes.add(1.02);
		lapTimes.add(1.05);
		lapTimes.add(1.03);
		lapTimes.add(1.06);
		lapTimes.add(1.03);
		Swimmer s3 = tpA.createSwimmer("Lene Steinmeier", 1982, lapTimes, "Flyderina");

		System.out.println("Swimmers on training plan A: \n" + tpA.getSwimmers());
		System.out.println("\nRemoving Morten Sørensen from the training plan...\n");
		tpA.removeSwimmer(s2);
		System.out.println("Swimmers on training plan A: \n" + tpA.getSwimmers());

	}

}
