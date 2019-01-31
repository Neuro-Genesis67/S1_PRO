package opg5;

import java.util.ArrayList;

public class Episode {

	private int episode;
	private ArrayList<String> guestActors;
	private int lengthInMinutes;
	private Series series;

	Episode(int number, ArrayList<String> guestActors, int lengthInMinutes) {
		this.episode = number;
		this.guestActors = guestActors;
		this.lengthInMinutes = lengthInMinutes;
	}

	public int getNumber() {
		return episode;
	}

	public ArrayList<String> getGuestActors() {
		return guestActors;
	}

	public int getLengthInMinutes() {
		return lengthInMinutes;
	}

	@Override
	public String toString() {
		return "Episode " + episode + ". \nEpisode length " + lengthInMinutes + " minutes.";
	}
}
