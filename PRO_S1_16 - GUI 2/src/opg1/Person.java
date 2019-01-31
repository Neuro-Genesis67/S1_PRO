package opg1;

import java.util.ArrayList;

public class Person {

	private String name, title;
	private boolean status = false;
	private ArrayList<Person> persons;

	public Person(String string, String string2, boolean b) {
		// TODO Auto-generated constructor stub
	}

	public void Persons(String name, String title, boolean status) {
		this.name = name;
		this.title = title;
		this.status = status;

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTitle(String title) {
		this.name = title;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void Persons() {

	}

	public String getName() {
		return this.name;
	}

	public String getTitle() {
		return this.title;
	}

	public boolean getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		String s = name + " " + title;
		if (status)
			s = s + " (senior)";
		return s;
	}

}
