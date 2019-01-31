package model;

import java.util.ArrayList;

public class Gæst {

	private String navn;
	private int værelsesNummer;
	private ArrayList<Bestilling> bestillinger;

	public Gæst(String navn, int værelsesNummer) {
		this.navn = navn;
		this.værelsesNummer = værelsesNummer;

	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getVærelsesNummer() {
		return værelsesNummer;
	}

	public void setVærelsesNummer(int værelsesNummer) {
		this.værelsesNummer = værelsesNummer;
	}

	public ArrayList<Bestilling> getBestilling() {
		return new ArrayList<>(bestillinger);
	}

	void addBestilling(Bestilling bestilling) {
		bestillinger.add(bestilling);
	}

	void removeBestilling(Bestilling bestilling) {
		bestillinger.remove(bestilling);
	}

}
