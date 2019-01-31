package model;

/**
 * Write a description of class Person here.
 *
 * @author (Margrethe Dybdahl)
 * @version (12/09/2014)
 */
public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private int dayOfBirth; // 1..31
	private int monthOfBirth; // 1..12
	private int yearOfBirth; // 1900..2010

	/**
	 * Constructor for objects of class Person
	 */

	public Person(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.yearOfBirth = yearOfBirth;

	}

	public Person(String firstName, String middleName, String lastName, int dayOfBirth, int monthOfBirth,
			int yearOfBirth) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth;
		this.yearOfBirth = yearOfBirth;

	}

	// ************get & set methods*************

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// *********************************************

	public void printPerson() {
		if (middleName == null) {
			System.out.println(firstName + " " + lastName + " " + dayOfBirth + "." + monthOfBirth + "." + yearOfBirth);
		} else {
			System.out.println(firstName + " " + middleName + " " + lastName + " " + dayOfBirth + "." + monthOfBirth
					+ "." + yearOfBirth);
		}

	}

	public String getInit() {
		if (middleName == null) {
			return "" + firstName.substring(0, 2) + lastName.charAt(0);

		} else {
			return "" + firstName.charAt(0) + middleName.charAt(0) + lastName.charAt(0);
		}

	}

	public String getUserName() {
		if (middleName == null) {
			int id = firstName.length() - lastName.length();
			return "" + firstName.substring(0, 2).toUpperCase() + id + lastName.substring(lastName.length() - 2);
		} else {
			String tekst1 = firstName.substring(0, 2).toUpperCase();
			String tekst2 = middleName.length() + "";
			String tekst3 = lastName.substring(lastName.length() - 2);
			return tekst1 + tekst2 + tekst3;
		}

	}

	public void weekday() {

	}

	public int age(int dayToDay, int monthToDay, int yearToDay) {
		int years = 0;
		years = (yearToDay - yearOfBirth);
		if (monthToDay < monthOfBirth || dayToDay < dayOfBirth) {
			years--;
		}
		return years;

	}

	/**
	 * Returns whether year is a leapyear
	 *
	 * @param year
	 * @return
	 */
	public boolean leapYear(int year) {
		boolean leapyear = false;
		if (year % 4 == 0 && year % 100 != 0) {
			leapyear = true;
		} else if (year % 400 == 0) {
			leapyear = true;
		}
		return leapyear;
	}
}
