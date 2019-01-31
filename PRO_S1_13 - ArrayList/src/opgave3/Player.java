package opgave3;

public class Player {
	private String name;
	private int age;
	private int score = 0;

	public Player(String name, int age) {
		this.name = name;
		this.age = age;
		this.score = 0;

	}

	public void addScore(int score) {
		this.score += score;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

}
