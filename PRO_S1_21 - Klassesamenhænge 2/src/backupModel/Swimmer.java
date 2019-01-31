package backupModel;

import java.util.*;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
	// association --> 0..1 TrainingPlan
    private String name;
    private String club;
    private int yearGroup;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;
    
    /**
     * Initialize a new swimmer with name, club, yearGroup, and lap times.
     */ 

   public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
       this.name = name;
       this.yearGroup = yearGroup;
       this.lapTimes = lapTimes;
       this.club = club;
   }
    /**
     * Return the name of the swimmer
     */
    public String getName() {
        return this.name;
    }
    // -e-
    public TrainingPlan getTrainingPlan() {
    	return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
    	this.trainingPlan = trainingPlan;
    }
    //-end-e-
    /**
     * Return the yearGroup of the swimmer
     */
    public int getYearGroup() {
        return this.yearGroup;
    }

    /**
     * Return the club of the swimmer
     */
    public String getClub() {
        return this.club;
    }

    /**
     * Register the club of the swimmer
     * @param club
     */
    public void setClub(String club) {
        this.club = club;
    }
    
    public int allTrainingHours() {
    	int total = trainingPlan.getWeeklyStrengthHours() + trainingPlan.getWeeklyWaterHours();
    	return total;
    }
    /**
     * Return the fastest lap time
     */
    public double bestLapTime() {
    	double time = 0;
        for (int i = 0; i < lapTimes.size(); i++) {
        	if (time < lapTimes.get(i)) {
        		time = lapTimes.get(i);
        	}
        }
        return time;
    }
}
