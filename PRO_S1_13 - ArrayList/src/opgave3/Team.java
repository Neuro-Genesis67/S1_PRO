package opgave3;

import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> players = new ArrayList<>();

	public Team(String name) {
		players = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addPlayer(Player player) {
		players.add(player);
	}

	public void printPlayers() {
		for (Player p : players) {
			System.out.println("Player: " + p.getName() + " - Age: " + p.getAge() + " - Score: " + p.getScore());
		}
	}

	public double totalScore() {
		double scores = 0.0;
		for (Player p : players) {
			scores += p.getScore();
		}
		return scores;
	}

	public double averageAge() {
		double ages = 0.0;
		int playerCount = 0;
		for (Player p : players) {
			ages += p.getAge();
			playerCount++;
		}
		return ages / playerCount;
	}

	public int calcOldPlayersScore(int ageLimit) {
		int totalScore = 0;
		for (Player p : players) {
			if (p.getAge() > ageLimit) {
				totalScore += p.getScore();
			}
		}
		return totalScore;
	}

	public int biggestScore() {
		int bestScore = 0;
		for (Player p : players) {
			if (p.getScore() > bestScore) {
				bestScore = p.getScore();
			}
		}
		return bestScore;
	}

	public String bestPlayer() {
		String bestPlayer = "";
		int bestScore = 0;
		for (Player p : players) {
			if (p.getScore() > bestScore) {
				bestScore = p.getScore();
			}
		}
		for (Player p : players) {
			if (p.getScore() == bestScore) {
				bestPlayer = p.getName();
			}
		}
		return bestPlayer;
	}
}
