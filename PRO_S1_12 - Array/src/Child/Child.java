package Child;

/**
 * A child with a gender and an age.
 */
public class Child {
	private int age;
	private boolean boy;
	private double[] weightOneToTen = new double[10];

	public Child(int age, boolean boy, double[] weightOneToTen) {
		this.age = age;
		this.boy = boy;
		this.weightOneToTen = weightOneToTen;
	}

	public double getWeight(int age) {
		double weight = 0.0;

		weight = weightOneToTen[age - 1];

		return weight;
		// returnere barnets vægt hørende til en bestemt alder:
	}

	public double getBiggestWeightGain(double[] array) {
		double result = 0.0;
		double first = 0.0;
		double second = 0.0;

		for (int i = 0; i < array.length - 1; i++) {
			first = array[i];
			second = array[i + 1];
			if (second - first > result) {
				result = second - first;
			}
		}
		return result;
		// returnere den største vægtforøgelse barnet har haft på et år:
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return this.boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		String institution = "";
		if (this.age < 3) {
			institution = "Nursery";
		} else if (this.age < 6) {
			institution = "Kindergarten";
		} else if (this.age < 17) {
			institution = "School";
		} else if (this.age > 16) {
			institution = "Out of school";
		}
		return institution;
	}

	public String gender() {
		if (this.boy) {
			return "Boy";
		} else {
			return "Girl";
		}
	}

	public String team() {
		if (this.age < 8) {
			if (this.boy) {
				return "Young cubs";
			} else {
				return "Tumbling girls";
			}
		} else {
			if (this.boy) {
				return "Cool boys";
			} else {
				return "Springy girls";
			}
		}
	}
}
