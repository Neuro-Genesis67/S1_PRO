// Tom Steinmeier
package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Kamp {
	
	private String sted;
	private LocalDate dato;
	private LocalTime tid;
	private ArrayList<Deltagelse> deltagelser = new ArrayList<>();
	private Deltagelse deltagelse;
	private Spiller spiller;
//	Aggregering 1 -> 0..* Deltagelse
	
	public Kamp (String sted, LocalDate dato, LocalTime tid) {
		this.sted = sted;
		this.dato = dato;
		this.tid = tid;
	}
	

	
	// Get & Set methods -----
	public String getSted() {
		return sted;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public LocalTime getTid() {
		return tid;
	}

	public void setTid(LocalTime tid) {
		this.tid = tid;
	}
	//------------------------

		public ArrayList<Deltagelse> getDeltagelse(){
		return new ArrayList<Deltagelse>(deltagelser);
	}
	public void addDeltagelse(Deltagelse deltagelse) {
		deltagelser.add(deltagelse);
	}
	public void removeDeltagelse(Deltagelse deltagelse) {
		deltagelser.remove(deltagelse);
	}
	//------------------------
	
//	public ArrayList<String> afbud(){
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
