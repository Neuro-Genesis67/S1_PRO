package prøve_Model;

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

	public double KampHonorar() {
		double honorar = 0.0;
		double procent = 0.0;
		int afbud = 0;
		int counter = 0;
		while (counter < deltagelser.size()) {
			if (deltagelser.get(counter).isAfbud()) {
				afbud++;
				counter++;
			} else {
				counter++;
			}
		}

		procent = (afbud - counter) - 1;
		System.out.println(procent);
		honorar = kampHonorar * counter;
		System.out.println(honorar);
		honorar *= procent;
		System.out.println("Reduceret honorar: " + honorar);

		return honorar;
	}

}

// beregn kamphonoraret som attributten kampHonorar, dog reduceret
// med en procentdel svarende til hvor mange procent af kampene spilleren har
// meldt afbud til.
// Tilf�j den n�dvendige kode for at honoraret for en ProfSpiller beregnes
// korrekt.