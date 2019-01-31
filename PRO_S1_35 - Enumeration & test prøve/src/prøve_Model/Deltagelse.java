package prøve_Model;

import java.util.ArrayList;

public class Deltagelse {
	private boolean afbud = false;
	private String begrundelse;
	private Spiller spiller;
	private Kamp kamp;
	private ArrayList<Spiller> spillere = new ArrayList<>();

	public Deltagelse(boolean afbud, String begrundelse, Kamp kamp, Spiller spiller) {
		this.afbud = afbud;
		this.begrundelse = begrundelse;
		this.kamp = kamp;
		this.spiller = spiller;
	}

	// Get & Set methods -----
	public boolean isAfbud() {
		return afbud;
	}

	public void setAfbud(boolean afbud) {
		this.afbud = afbud;
	}

	public String getBegrundelse() {
		return begrundelse;
	}

	public void setBegrundelse(String begrundelse) {
		this.begrundelse = begrundelse;
	}
	// ------------------------

	// public Spiller createSpiller() {
	//
	// }

	public Spiller getSpiller() {
		return spiller;
	}

	public void setSpiller(Spiller spiller) {
		if (spiller != null) {
			spiller.addDeltagelse(this);
			;
		} else {
			this.spiller.removeDeltagelse(this);
			;
		}
		this.spiller = spiller;

	}

	public void removeSpiller(Spiller spiller) {
		spillere.remove(spiller);
	}
	// ------------------------

}
