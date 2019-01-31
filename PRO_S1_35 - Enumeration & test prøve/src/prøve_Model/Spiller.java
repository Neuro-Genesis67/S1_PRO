package prøve_Model;

import java.util.ArrayList;

public class Spiller {
	// association: --> 0..* Deltagelse
	private String navn;
	private int årgang;
	private Deltagelse deltagelse;
	private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

	public Spiller(String navn, int årgang) {
		this.navn = navn;
		this.årgang = årgang;

	}

	// Get & Set methods -----
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getårgang() {
		return årgang;
	}

	public void setårgang(int årgang) {
		this.årgang = årgang;
	}
	// ------------------------

	// Ved en dobbeltrettet forbindelse skal to linkattributter opdateres, n�r
	// forbindelsen oprettes eller slettes. Ansvaret
	// for at opdatere begge linkattributter p�l�gges metoderne i �n af klasserne.
	// Hermed skal Service-klassen
	// (hvor objekterne oprettes og s�ttes sammen) kun kalde �n metode, som
	// opdaterer begge linkattributter.
	//
	// Derfor skal metoderne i �n af klasserne �ndres, s� de opdaterer begge
	// linkattributter.
	// sine metoder, som kun opdaterer dens egen linkattribut. Da disse metoder i
	// den anden klasse ikke m�
	// bruges af Service klassen, �ndres synligheden af metoderne fra public til
	// package synlighed.

	public ArrayList<Deltagelse> getDeltagelser() {
		return new ArrayList<>(deltagelser);
	}

	void addDeltagelse(Deltagelse deltagelse) {
		deltagelser.add(deltagelse);
	}

	void removeDeltagelse(Deltagelse deltagelse) {
		deltagelser.remove(deltagelse);
	}

	// public class Group {
	// // association: --> 0..* Deltagelse
	// private ArrayList<Person> persons = new ArrayList<>();
	// public ArrayList<Person> getPersons() {
	// return new ArrayList<>(persons);
	// }
	// void addPerson(Person person) { // Bem�rk: package synlighed
	// persons.add(person);
	// }
	// void removePerson(Person person) { // Bem�rk: package synlighed
	// persons.remove(person);
	// }

	// ------------------------

	public double kampHonorar() {
		int afbud = 0; // <- Deltagelser uden afbud
		double honorar = 0.0;
		int i = 0;
		int kampe = 0;
		while (i < deltagelser.size()) {
			if (deltagelser.get(i).isAfbud()) {
				afbud++;
				kampe++;
				i++;
			} else {
				kampe++;
				i++;
			}
			honorar = (kampe - afbud) * 10;

		}
		return honorar;

	}

}
