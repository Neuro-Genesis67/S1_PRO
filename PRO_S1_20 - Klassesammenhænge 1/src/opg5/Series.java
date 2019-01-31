package opg5;

import java.util.ArrayList;

public class Series {

	private String title;
	private ArrayList<String> cast;
	// --------------Link Attribute---------------
	private ArrayList<Episode> episodes = new ArrayList<>();

	// --------------Link Attribute---------------
	public Series(String title, ArrayList<String> cast) {
		this.title = title;
		this.cast = cast;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<String> getCast() {
		return cast;
	}

	public int totalLength() {
		int length = 0;
		for (Episode e : episodes) {
			length += e.getLengthInMinutes();
		}
		return length;
	}

	public ArrayList<String> getAllGuestActors() {
		ArrayList<String> allActors = new ArrayList<>();
		for (Episode e : episodes) {
			for (String actor : e.getGuestActors()) {
				allActors.add(actor);
			}
		}
		return allActors;
	}

	// --------------Link Attribute---------------
	public Episode createEpisode(int number, ArrayList<String> guestActors, int lengthInMinutes) {
		Episode episode = new Episode(number, guestActors, lengthInMinutes);
		episodes.add(episode);
		return episode;
	}

	public ArrayList<Episode> getEpisodes() {
		return new ArrayList<>(episodes);
	}

	public void removeEpisode(Episode episode) {
		episodes.remove(episode);
	}
	// --------------Link Attribute---------------
}
