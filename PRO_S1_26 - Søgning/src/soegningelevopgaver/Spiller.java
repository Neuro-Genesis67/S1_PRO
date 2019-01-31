package soegningelevopgaver;

public class Spiller {
	private String navn;
	private int hojde;
	private int vaegt;
	private int antalMaal;

	// Opretter et Spiller objekt med navn, højde, vægt og
	// antal mål
	public Spiller(String navn, int hoejde, int vaegt, int antalmaal) {
		this.hojde = hoejde;
		this.navn = navn;
		this.vaegt = vaegt;
		this.antalMaal = antalmaal;
	}

	// returnerer spillerens navn
	public String getNavn() {
		return navn;
	}

	// returnerer spillerens højde i cm
	public int getHoejde() {
		return hojde;
	}

	// returnerer spillerens vægt i kg
	public int getVaegt() {
		return vaegt;
	}

	// returnerer antal mål spilleren har scoret i
	// indeværende sæson
	public int getMaal() {
		return antalMaal;
	}

	public String toString() {
		return "Navn: " + navn + "\nH�jde: " + hojde + "\nV�gt: " + vaegt + "\nM�l: " + antalMaal;
	}

}
