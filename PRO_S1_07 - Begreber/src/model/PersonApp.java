package model;

public class PersonApp {

	public static void main(String[] args) {
		Person p = new Person("Bent", "Janus", "Christensen", 27, 12, 1990);
		Person Tom = new Person("Tom", "Steinmeier", 07, 05, 1991);
		Person p1 = new Person("Jacobs", "Webb", 5, 2, 1982);
		System.out.println(Tom.getUserName());
	}
}
