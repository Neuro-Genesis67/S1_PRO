// Tom Steinmeier
package model;

import java.util.ArrayList;

public class Spiller {

	private String navn;
	private int årgang;
	// private double KampHonorar;
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

	public ArrayList<Deltagelse> getDeltagelser() {
		return new ArrayList<Deltagelse>(deltagelser);
	}

	public void addDeltagelse(Deltagelse deltagelse) {
		deltagelser.add(deltagelse);
	}

	public void removeDeltagelse(Deltagelse deltagelse) {
		deltagelser.remove(deltagelse);
	}
	// ------------------------

	public double getKampHonorar() {
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
