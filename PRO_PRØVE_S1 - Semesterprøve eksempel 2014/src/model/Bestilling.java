package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {

	private LocalDate dato;
	private boolean betalt;
	private ArrayList<BestillingsLinje> bestillingsLinjer = new ArrayList<>();
	
	public Bestilling (LocalDate dato, boolean betalt, ArrayList bestillingsLinjer) {
		this.dato = dato;
		this.betalt = betalt;
		this.bestillingsLinjer = bestillingsLinjer;
		
	}
	
	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public boolean isBetalt() {
		return betalt;
	}

	public void setBetalt(boolean betalt) {
		this.betalt = betalt;
	}
	
	public ArrayList<BestillingsLinje> getBestillingsLinje(){
		return new ArrayList<>(bestillingsLinjer);
	}
	
    public BestillingsLinje createBestillingsLinje(int antal) {
    	BestillingsLinje bestillingsLinje = new BestillingsLinje(antal);
    	bestillingsLinjer.add(bestillingsLinje);
    	return bestillingsLinje;
    }
    
    public void addBestillingsLinje (BestillingsLinje bestillingsLinje) {
    	bestillingsLinjer.add(bestillingsLinje);
    }
    
    public void removeBestillingsLinje(BestillingsLinje bestillingsLinje) {
    	bestillingsLinjer.remove(bestillingsLinje);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
