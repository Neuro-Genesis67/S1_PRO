package model;

public class Algorithm {
	private static int workDays = 5;
	private int workKm = 60;
	private int totesKimotes = 700;
	private int personalKm;

	public String calc() {
		int totalWorkKm;
		int totalPersKm;
		totalWorkKm = workDays * workKm;
		totalPersKm = totesKimotes - totalWorkKm;
		String work = "Work km: " + totalWorkKm;
		String pers = "Personal km: " + totalPersKm;
		String total = "Total Km: " + totesKimotes;

		return work + "\n" + pers + "\n" + total;
	}

}
