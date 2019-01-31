// Tom Steinmeier - DMU 18v

package model;

public abstract class PraktikOpgave {

	private String navn;
	private int semester;
	private PraktikVirksomhed praktikVirksomhed;

	public PraktikOpgave(String navn, int semester) {
		this.navn = navn;
		this.semester = semester;
		this.setPraktikVirksomhed(praktikVirksomhed);
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public PraktikVirksomhed getPraktikVirksomhed() {
		return praktikVirksomhed;
	}

	public void setPraktikVirksomhed(PraktikVirksomhed praktikVirksomhed) {
		this.praktikVirksomhed = praktikVirksomhed;
	}

}
