// Tom Steinmeier - DMU 18v

package model;

import java.time.LocalDate;

public class PraktikKontrakt implements Comparable<PraktikKontrakt> {

	private String opgavebeskrivelse;
	private int timerPerUge;
	private LocalDate periodeStart;
	private LocalDate periodeSlut;

	private PraktikVirksomhed praktikVirksomhed;

	public PraktikKontrakt(String opgavebeskrivelse, int timerPerUge, LocalDate start, LocalDate slut) {
		this.opgavebeskrivelse = opgavebeskrivelse;
		this.timerPerUge = timerPerUge;
		this.periodeStart = start;
		this.periodeSlut = slut;
	}

	public PraktikKontrakt() {

	}

	public PraktikVirksomhed getPraktikVirksomhed() {
		return praktikVirksomhed;
	}

	public void setPraktikVirksomhed(PraktikVirksomhed praktikVirksomhed) {
		this.praktikVirksomhed = praktikVirksomhed;
	}

	public String getOpgavebeskrivelse() {
		return opgavebeskrivelse;
	}

	public void setOpgavebeskrivelse(String opgavebeskrivelse) {
		this.opgavebeskrivelse = opgavebeskrivelse;
	}

	public int getTimerPerUge() {
		return timerPerUge;
	}

	public void setTimerPerUge(int timerPerUge) {
		this.timerPerUge = timerPerUge;
	}

	public LocalDate getPeriodeStart() {
		return periodeStart;
	}

	public void setPeriodeStart(LocalDate periodeStart) {
		this.periodeStart = periodeStart;
	}

	public LocalDate getPeriodeSlut() {
		return periodeSlut;
	}

	public void setPeriodeSlut(LocalDate periodeSlut) {
		this.periodeSlut = periodeSlut;
	}

	public String toString() {
		return "Opgavebeskrivelse: " + this.getOpgavebeskrivelse() + " Timer per uge: " + this.getTimerPerUge()
				+ " Starttidspunkt: " + this.getPeriodeStart() + " Sluttidspunkt: " + this.getPeriodeSlut();
	}

	@Override
	public int compareTo(PraktikKontrakt o) {
		int result = 0;
		if (this.getPeriodeStart().compareTo(o.getPeriodeStart()) < 0) {
			result = 1;
		}
		if (this.getPeriodeStart().compareTo(o.getPeriodeStart()) > 0) {
			result = -1;
		}
		if (this.getPeriodeStart().compareTo(o.getPeriodeStart()) == 0) {
			if (this.getOpgavebeskrivelse().compareTo(o.getOpgavebeskrivelse()) > 0) {
				result = 1;
			} else if (this.getOpgavebeskrivelse().compareTo(o.getOpgavebeskrivelse()) < 0) {
				result = -1;
			} else
				result = 0;
		}
		return result;

	}

}
