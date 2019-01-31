package opg1;

public class Data {

	public static double max(Measurable[] objects) {
		double max = 0.0;
		for (Measurable mes : objects) {
			if (mes.getMeasure() > max) {
				max = mes.getMeasure();
			}
		}
		return max;
	}

	public static double avg(Measurable[] objects) {
		double avg = 0.0;
		int count = 0;
		for (Measurable mes : objects) {
			avg += mes.getMeasure();
			count++;
		}
		return avg / count;
	}

}
