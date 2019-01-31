// Tom Steinmeier - DMU 18v

package storage;

import java.util.ArrayList;

import model.PraktikKontrakt;
import model.PraktikOpgave;
import model.PraktikVirksomhed;

public class Storage {

	// private PraktikVirksomhed praktikVirksomhed;
	private static ArrayList<PraktikVirksomhed> praktikVirksomheder = new ArrayList<>();
	private static ArrayList<PraktikKontrakt> praktikKontrakter = new ArrayList<>();
	private static ArrayList<PraktikOpgave> praktikOpgaver = new ArrayList<>();

	public static ArrayList<PraktikVirksomhed> getPraktikVirksomheder() {
		return new ArrayList<PraktikVirksomhed>(praktikVirksomheder);
	}

	public static void addPraktikVirksomhed(PraktikVirksomhed praktikVirksomhed) {
		praktikVirksomheder.add(praktikVirksomhed);
	}

	public static ArrayList<PraktikKontrakt> getPraktikKontrakter() {
		return new ArrayList<PraktikKontrakt>(praktikKontrakter);
	}

	public static void addPraktikKontrakt(PraktikKontrakt PraktikKontrakt) {
		praktikKontrakter.add(PraktikKontrakt);
	}

	public ArrayList<PraktikOpgave> getPraktikOpgaver() {
		return new ArrayList<PraktikOpgave>(praktikOpgaver);
	}

	public static void addPraktikOpgave(PraktikOpgave praktikOpgave) {
		praktikOpgaver.add(praktikOpgave);
	}

}
