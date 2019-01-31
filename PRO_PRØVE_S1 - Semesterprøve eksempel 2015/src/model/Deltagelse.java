// Tom Steinmeier
package model;

import java.util.ArrayList;

public class Deltagelse {
	private boolean afbud = false;
	private String begrundelse;
	private Spiller spiller;
	private ArrayList<Spiller> spillere;
	
	public Deltagelse (boolean afbud, String begrundelse) {
		this.afbud = afbud;
		this.begrundelse = begrundelse;
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
	//------------------------
	
	public ArrayList<Spiller> getSpiller(){
		return new ArrayList<Spiller>(spillere);
	}
	
	public void addSpiller(Spiller spiller) {
		spillere.add(spiller);
	}
	
	public void removeSpiller(Spiller spiller) {
		spillere.remove(spiller);
	}
	//------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
