package student;

public class Student {
	private String name;
	private int age;
	private int[] grades;
	private int arrayIndex;

	private static final int MAX_NUMBER_OF_GRADES = 10;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		arrayIndex = 0;
		grades = new int[MAX_NUMBER_OF_GRADES];
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void birthday() {
		age++;
	}

	/**
	 * Adds another grade to the list of grades. If the student already has 10
	 * grades, nothing happens.
	 * 
	 * @param grade
	 */
	public void addGrade(int grade) {
		if (arrayIndex < MAX_NUMBER_OF_GRADES) {
			grades[arrayIndex] = grade;
			arrayIndex++;
		}
	}

	/**
	 * Calculates and returns the average of all the grades.
	 * 
	 * @return
	 */
	public double averageGrade() {
		int sum = 0;
		double average = 0.0;
		for (int i = 0; i < arrayIndex; i++) {
			sum = sum + grades[i];
		}
		if (arrayIndex > 0) {
			average = (double) sum / arrayIndex;
		}
		return average;
	}

	public int maxGrade() {
		int bestGrade = 0;
		for (int i = 0; i < arrayIndex; i++) {
			if (grades[i] > bestGrade) {
				bestGrade = grades[i];
			}
		}
		return bestGrade;
	}

	public int minGrade() {
		int minGrade = 20;
		for (int i = 0; i < arrayIndex; i++) {
			if (grades[i] < minGrade) {
				minGrade = grades[i];
			}
		}
		return minGrade;
	}

	/**
	 * Returns all the grades the student has achieved.
	 * 
	 * @return
	 */
	public int[] getGrades() {
		return grades;
	}

	/**
	 * Get the number of grades the student has achieved
	 * 
	 * @return
	 */
	public int getNumberOfGrades() {
		return arrayIndex;
	}
}
