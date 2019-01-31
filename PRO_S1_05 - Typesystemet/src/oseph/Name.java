package oseph;

public class Name {
	private String firstName;
	private String middleName;
	private String lastName;

	public Name(String f, String m, String l) {
		this.firstName = f;
		this.middleName = m;
		this.lastName = l;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		lastName = lastName;
	}

	public String getInit() {
		String result;
		result = this.firstName.substring(0, 1) + this.middleName.substring(0, 1) + this.lastName.substring(0, 1);
		return result;
	}

	public String getUserName() {
		String result = firstName.substring(0, 2).toUpperCase() + middleName.length()
				+ lastName.substring(lastName.length() - 2);
		return result;
	}

}
