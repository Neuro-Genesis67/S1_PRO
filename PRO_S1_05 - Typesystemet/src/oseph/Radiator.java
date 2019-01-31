package oseph;

public class Radiator {
	private int temperature;

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public Radiator() {

	}

	public Radiator(int t) {
		this.temperature = t;
	}

	public int skruOp(int grader) {
		this.temperature += grader;
		return this.temperature;
	}

	public int skruNed(int grader) {
		this.temperature -= grader;
		return this.temperature;
	}
}
