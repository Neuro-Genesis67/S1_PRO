package Child;

public class Institution {

	private String name;
	private String address;
	private Child[] kidsList = new Child[100];
	private static int KIDS_LIST_INDEX = 0;

	public Institution(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void addChild(Child child) {
		kidsList[KIDS_LIST_INDEX] = child;
		KIDS_LIST_INDEX++;
	}

	public double KidsAverageAge() {
		double kidsAges = 0;
		for (int i = 0; i < KIDS_LIST_INDEX; i++) {
			kidsAges += kidsList[i].getAge();
		}
		return kidsAges / KIDS_LIST_INDEX;
	}

	public int girlsCount() {
		int numberOfGirls = 0;

		for (int i = 0; i < KIDS_LIST_INDEX; i++) {
			if (!kidsList[i].isBoy()) {
				numberOfGirls++;
			}
		}
		return numberOfGirls;
	}

	public int boysCount() {
		int numberOfBoys = 0;

		for (int i = 0; i < KIDS_LIST_INDEX; i++) {
			if (kidsList[i].isBoy()) {
				numberOfBoys++;
			}
		}
		return numberOfBoys;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
