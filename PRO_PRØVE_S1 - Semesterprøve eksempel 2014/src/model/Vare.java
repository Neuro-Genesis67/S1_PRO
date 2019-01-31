package model;

import java.util.ArrayList;

public class Vare {
	// LinkAttribut done
	private String navn;
	private String mærke;
	private double mængde;
	private double pris;
	private ArrayList<BestillingsLinje> bestillingsLinjer;

	public Vare(String navn, String mærke, double mængde, double pris) {
		this.navn = navn;
		this.mærke = mærke;
		this.mængde = mængde;
		this.pris = pris;

	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getMærke() {
		return mærke;
	}

	public void setMærke(String mærke) {
		this.mærke = mærke;
	}

	public double getMængde() {
		return mængde;
	}

	public void setMængde(double mængde) {
		this.mængde = mængde;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public ArrayList<BestillingsLinje> getBestillingsLinje() {
		return new ArrayList<>(bestillingsLinjer);
	}

	void addBestillingsLinje(BestillingsLinje bestillingsLinje) {
		bestillingsLinjer.add(bestillingsLinje);
	}

	void removeBestillingsLinje(BestillingsLinje bestillingsLinje) {
		bestillingsLinjer.remove(bestillingsLinje);
	}

}
