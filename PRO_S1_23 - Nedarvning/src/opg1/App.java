package opg1;

public class App {

	public static void main(String[] args) {

		// String navn, String addresse, int svendepr�ve, double timel�n
		Mekaniker m1 = new Mekaniker("Michael olufsen", "Moltkes allé 90, 2tv", 2005, 205);

		// String navn, String addresse, int svendepr�ve, double timel�n, int
		// udn�vnelse, double till�g
		Værkfører v1 = new Værkfører("Vilhelm", "Jakob jakobsens vej 22, st. th", 2004, 250, 2010, 25);

		// String navn, String addresse
		Person p1 = new Person("Per naturelli", "Pr�dgers prok, 9th.");

		System.out.println(m1.getAddresse());
		System.out.println(v1.getSvendeprøve());
		System.out.println(p1.getNavn());

	}

}
