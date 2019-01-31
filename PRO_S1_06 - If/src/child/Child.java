package child;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		this.age = age;
		String team = "";
		if (age == 0) {
			team = "Home";
		} else if (age > 0 && age < 3) {
			team = "Nursery";
		} else if (age > 2 && age < 7) {
			team = "Kindergarten";
		} else if (age > 5 && age < 17) {
			team = "School";
		} else if (age > 16) {
			team = "Out of school";
		}
		
		return team;
	}
	
	public String gender() {
		String result = "";
		if (this.boy == true) {
			result = "I's a Boy";
		}
		if (this.boy == false) {
			result = "I's a Girl";
		}
		return result;
	}
	
	public String team() {
		String result = "";
		if (boy == false && age < 8) {
			result = "Tumbling girls";
		} else if (boy == false && age >= 8) {
			result = "Springy girls";
		} else if (boy == true && age < 8) {
			result = "Young Cubs";
		} else if (boy == true && age >= 8) {
			result = "Cool Boys";
		}
		return result;
	}

}
