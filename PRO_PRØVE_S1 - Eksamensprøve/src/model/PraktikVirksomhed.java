// Tom Steinmeier - DMU 18v

package model;

import java.util.ArrayList;

public class PraktikVirksomhed {

	private String navn;
	private String feedback;
	private String kontaktperson;

	private ArrayList<PraktikOpgave> praktikOpgaver = new ArrayList<>();
	private ArrayList<PraktikKontrakt> praktikKontrakter = new ArrayList<>();

	private PraktikOpgave praktikOpgave;
	private PraktikKontrakt praktikKontrakt;

	public PraktikVirksomhed(String navn, String feedback, String kontaktperson) {
		this.navn = navn;
		this.feedback = feedback;
		this.kontaktperson = kontaktperson;
	}

	public int antalPraktikOpgaverForSemesteret(int semester) {
		int antal = 0;
		for (PraktikOpgave p : praktikOpgaver) {
			if (p.getSemester() == semester) {
				antal++;
			}
		}

		return antal;
	}

	// Praktikopgaver
	public ArrayList<PraktikOpgave> getPraktikOpgaver() {
		return new ArrayList<>(praktikOpgaver);
	}

	public ArrayList<PraktikKontrakt> sorterKontrakterInsertionSort(ArrayList<PraktikKontrakt> arr) {

		PraktikKontrakt key = new PraktikKontrakt();
		PraktikKontrakt temp = new PraktikKontrakt();

		int i, j;
		for (i = 1; i < arr.size(); i++) {

			key = arr.get(i);
			j = i - 1;

			while (j >= 0 && key.compareTo(arr.get(j)) < 0) {

				temp = arr.get(j);
				key = arr.get(j + 1);
				arr.set(j, key);
				arr.set(j + 1, temp);
				j--;
			}

		}
		return arr;

	}

	public void createAnalyseOpgave(String navn, int semester, String analyseModel) {
		AnalyseOpgave analyseOpgave = new AnalyseOpgave(navn, semester, analyseModel);
		praktikOpgaver.add(analyseOpgave);
	}

	public void createTekniskOpgave(String navn, int semester, String programmeringsSprog) {
		TekniskOpgave tekniskOpgave = new TekniskOpgave(navn, semester, programmeringsSprog);
		praktikOpgaver.add(tekniskOpgave);

	}

	public void addPraktikOpgave(PraktikOpgave praktikOpgave) {
		praktikOpgaver.add(praktikOpgave);
	}

	public void removePraktikOpgave(PraktikOpgave praktikOpgave) {
		praktikOpgaver.remove(praktikOpgave);
	}

	public ArrayList<PraktikKontrakt> getPraktikKontrakter() {
		return new ArrayList<>(praktikKontrakter);
	}

	public void addPraktikKontrakt(PraktikKontrakt praktikKontrakt) {
		praktikKontrakter.add(praktikKontrakt);
	}

	public void removePraktikKontrakt(PraktikKontrakt praktikKontrakt) {
		praktikKontrakter.remove(praktikKontrakt);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getKontaktperson() {
		return kontaktperson;
	}

	public void setKontaktperson(String kontaktperson) {
		this.kontaktperson = kontaktperson;
	}

	public String toString() {
		return "Navn: " + this.getNavn() + " Feedback: " + this.getFeedback() + " Kontaktperson: "
				+ this.getKontaktperson();
	}

	// public void skrivTilFilKontrakter() {
	//
	// }

}
