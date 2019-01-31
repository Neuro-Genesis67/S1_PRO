// Tom Steinmeier - DMU 18v

package service;

import java.time.LocalDate;

import model.AnalyseOpgave;
import model.PraktikKontrakt;
import model.PraktikOpgave;
import model.PraktikVirksomhed;
import model.TekniskOpgave;
import storage.Storage;

public class Service {

	public static String getEftertragtetSemesterVirksomhed(int semester) {
		String navn = "";
		int antal = 0;

		for (PraktikVirksomhed pv : Storage.getPraktikVirksomheder()) {
			if (antal < pv.antalPraktikOpgaverForSemesteret(semester)) {
				antal = pv.antalPraktikOpgaverForSemesteret(semester);
				navn = pv.getNavn();
			}
			;
		}
		return navn;
	}

	public static void initStorage() {

		PraktikVirksomhed pv1 = createPraktikVirksomhed("Vestas", "Godt miljø", "Peter Justesen");
		PraktikVirksomhed pv2 = createPraktikVirksomhed("Nilfisk", "Udfordrende", "Peter Justesen");
		PraktikVirksomhed pv3 = createPraktikVirksomhed("POWER", "Energisk", "Magrethe Dybdahl");

		PraktikKontrakt pk1 = createPraktikKontrakt("Tester", 37, LocalDate.parse("2018-7-1"),
				LocalDate.parse("2018-9-16"));
		addVirksomhedToKontrakt(pv1, pk1);

		PraktikKontrakt pk2 = createPraktikKontrakt("Udvikler", 27, LocalDate.parse("2018-3-14"),
				LocalDate.parse("2018-5-6"));
		addVirksomhedToKontrakt(pv2, pk2);

		PraktikKontrakt pk3 = createPraktikKontrakt("Programmør", 15, LocalDate.parse("2018-2-14"),
				LocalDate.parse("2018-4-6"));
		addVirksomhedToKontrakt(pv1, pk3);

		PraktikKontrakt pk4 = createPraktikKontrakt("Analytiker", 12, LocalDate.parse("2018-2-14"),
				LocalDate.parse("2018-4-6"));
		addVirksomhedToKontrakt(pv1, pk4);

		PraktikOpgave po1 = createTekniskOpgave("Flowoptimering", 5, "Java");
		addOpgaveToVirksomhed(po1, pv1);

		PraktikOpgave po2 = createTekniskOpgave("Test i felten", 5, "C#");
		addOpgaveToVirksomhed(po2, pv1);

		PraktikOpgave po3 = createTekniskOpgave("Risikoanalyse", 3, "MUST");
		addOpgaveToVirksomhed(po3, pv2);

		PraktikOpgave po4 = createTekniskOpgave("Simulering", 5, "Python");
		addOpgaveToVirksomhed(po4, pv1);

	}

	public static PraktikVirksomhed createPraktikVirksomhed(String navn, String feedback, String kontaktperson) {
		PraktikVirksomhed praktikVirksomhed = new PraktikVirksomhed(navn, feedback, kontaktperson);
		Storage.addPraktikVirksomhed(praktikVirksomhed);
		return praktikVirksomhed;
	}

	public static void updatePraktikVirksomhed(PraktikVirksomhed praktikVirksomhed, String navn, String feedback,
			String kontaktperson) {
		praktikVirksomhed.setNavn(navn);
		praktikVirksomhed.setFeedback(feedback);
		praktikVirksomhed.setKontaktperson(kontaktperson);
	}

	public static PraktikKontrakt createPraktikKontrakt(String opgavebeskrivelse, int timerPerUge, LocalDate start,
			LocalDate slut) {
		PraktikKontrakt praktikKontrakt = new PraktikKontrakt(opgavebeskrivelse, timerPerUge, start, slut);
		Storage.addPraktikKontrakt(praktikKontrakt);
		return praktikKontrakt;
	}

	public static PraktikOpgave createAnalyseOpgave(String navn, int semester, String analyseModel) {
		PraktikOpgave analyseOpgave = new AnalyseOpgave(navn, semester, analyseModel);
		Storage.addPraktikOpgave(analyseOpgave);
		return analyseOpgave;
	}

	public static PraktikOpgave createTekniskOpgave(String navn, int semester, String programmeringsSprog) {
		PraktikOpgave tekniskOpgave = new TekniskOpgave(navn, semester, programmeringsSprog);
		Storage.addPraktikOpgave(tekniskOpgave);
		return tekniskOpgave;
	}

	public static void addVirksomhedToKontrakt(PraktikVirksomhed virksomhed, PraktikKontrakt kontrakt) {
		virksomhed.addPraktikKontrakt(kontrakt);
		kontrakt.setPraktikVirksomhed(virksomhed);
	}

	public static void removeVirksomhedFraKontrakt(PraktikVirksomhed virksomhed, PraktikKontrakt kontrakt) {
		virksomhed.removePraktikKontrakt(kontrakt);
		kontrakt.setPraktikVirksomhed(null);
	}

	public static void addOpgaveToVirksomhed(PraktikOpgave praktikOpgave, PraktikVirksomhed praktikVirksomhed) {
		praktikVirksomhed.addPraktikOpgave(praktikOpgave);
	}

	public static void removeOpgaveFraVirksomhed(PraktikOpgave praktikOpgave, PraktikVirksomhed praktikVirksomhed) {
		praktikVirksomhed.removePraktikOpgave(praktikOpgave);
	}

}
