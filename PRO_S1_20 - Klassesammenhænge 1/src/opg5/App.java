package opg5;

import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		ArrayList<String> cast = new ArrayList<>();
		cast.add("Jonno boyt");
		cast.add("Janeo kiks");
		cast.add("Xiaoyu fuseling");

		Series wlkd = new Series("The walking dead", cast);

		ArrayList<String> guestActors1 = new ArrayList<>();
		guestActors1.add("Jane Keymeyer");
		guestActors1.add("Rocco Sigfreud");
		guestActors1.add("Solo Gansoso");
		guestActors1.add("Kan Jack");

		ArrayList<String> guestActors2 = new ArrayList<>();
		guestActors1.add("bryan fury");
		guestActors1.add("Nina Williams");
		guestActors1.add("Lei Wulong");
		guestActors1.add("Jack-7");

		Episode e1 = wlkd.createEpisode(1, guestActors1, 45);
		Episode e2 = wlkd.createEpisode(1, guestActors2, 49);
		System.out.println("Total lengt of " + wlkd.getTitle() + " in minutes: " + wlkd.totalLength()
				+ "\nAll guest actors during the entire series: " + wlkd.getAllGuestActors()
				+ "\nMain cast of the series: " + wlkd.getCast());

	}
}
