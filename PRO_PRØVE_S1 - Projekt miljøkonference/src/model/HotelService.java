package model;

public class HotelService {
	private String navn;
	private double tillægsPris;

	public HotelService(String navn, double tillægsPris) {
		this.navn = navn;
		this.tillægsPris = tillægsPris;
	}

	public double getTillægsPris() {
		return tillægsPris;
	}

	@Override
	public String toString() {
		return navn + " (" + tillægsPris + " DKK)";
	}
}
