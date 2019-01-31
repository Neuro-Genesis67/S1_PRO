package opg4;

import java.util.ArrayList;

public class Swimmer {
	private String name;
	private String club;
	private int yearGroup;
	private ArrayList<Double> lapTimes;
	private TrainingPlan trainingPlan;

	Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
		this.name = name;
		this.yearGroup = yearGroup;
		this.lapTimes = lapTimes;
		this.club = club;

	}

	public int getWeeklyTrainingHours() {
		return this.trainingPlan.getWeeklyStrengthHours() + this.trainingPlan.getWeeklyWaterHours();
	}

	public String getName() {
		return this.name;
	}

	public int getYearGroup() {
		return this.yearGroup;
	}

	public String getClub() {
		return this.club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public void setTrainingPlan(TrainingPlan trainingPlan) {
		this.trainingPlan = trainingPlan;
	}

	public TrainingPlan getTrainingPlan() {
		return this.trainingPlan;
	}

	public double bestLapTime() {
		double fastestLap = Double.MAX_VALUE;
		for (double lap : lapTimes) {
			if (lap < fastestLap) {
				fastestLap = lap;
			}
		}
		return fastestLap;
	}

	@Override
	public String toString() {
		return "\nName: " + name + "\nYearGroup: " + yearGroup + "\nClub: " + club + "\n";
	}
}
