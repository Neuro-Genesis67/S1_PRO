// Tom Steinmeier
package model;

import java.util.ArrayList;

public class ProfSpiller extends Spiller {
	private double kampHonorar;
	private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

	public ProfSpiller(String navn, int årgang, double kampHonorar) {
		super(navn, årgang);
		this.kampHonorar = kampHonorar;
	}

	// Get & Set methods -----
	public double getKampHonorar() {
		return kampHonorar;
	}

	public void setKampHonorar(double kampHonorar) {
		this.kampHonorar = kampHonorar;
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

	// public double KampHonorar() {
	// double honorar = 0.0;
	// double afbud = 0;
	// double procent = 0;
	// double kampe = 0;
	// int i = 0;
	// while (i < deltagelser.size()) {
	// if (deltagelser.get(i).isAfbud()) {
	// afbud++;
	// kampe++;
	// i++;
	// } else {
	// kampe++;
	// i++;
	// }
	//
	// }
	// System.out.println("afbud: " + afbud);
	// System.out.println("kampe: " + kampe);
	// procent = afbud / kampe;
	// System.out.println("procent: " + procent * 100);
	//
	// honorar = (this.kampHonorar * kampe) / 100 * procent;
	//
	// honorar = this.kampHonorar * kampe * (afbud / kampe);
	//
	//
	// return honorar; UNFINISHED - NEEDS A BIT MORE MATH BRO
	// }

}
