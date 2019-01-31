package opgave3;

public class MainApp {

	public static void main(String[] args) {

		// Opretter nyt hold
		Team team = new Team("Bollebaskerne");

		// Opretter fem spillere
		Player p1 = new Player("Xiaoyu", 25);
		Player p2 = new Player("Eliza", 22);
		Player p3 = new Player("Asuika", 20);
		Player p4 = new Player("Nina", 27);
		Player p5 = new Player("Josie", 18);

		// Tilføjer spillerene til holdet
		team.addPlayer(p1);
		team.addPlayer(p2);
		team.addPlayer(p3);
		team.addPlayer(p4);
		team.addPlayer(p5);

		// Udskriver information om alle holdets spillere
		team.printPlayers();
		System.out.println();

		// Finder gennemsnitsalderen for spillerene på holdet
		System.out.println("Average age of players on the team: " + team.averageAge());
		System.out.println();

		// Udskriver den samlede score for spillerene på holdet
		System.out.println("Total score for everyone on the team: " + team.totalScore());
		System.out.println();

		// Udskriver score for alle over 20
		System.out.println("Score for everyone older than 20: " + team.calcOldPlayersScore(20));
		System.out.println();

		// Udskriver den højeste score en spiller på holdet har
		System.out.println("Biggest score on the team: " + team.biggestScore());
		System.out.println();

		// Udskriver den bedste spiller på holdet, baseret på højeste score
		System.out.println("Best player on the team: " + team.bestPlayer());
	}

}
