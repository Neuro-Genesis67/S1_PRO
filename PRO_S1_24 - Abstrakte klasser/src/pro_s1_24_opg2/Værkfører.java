package pro_s1_24_opg2;

public class Værkfører extends Mekaniker { // V�rkf�rer arver Person- og Mekaniker's instans variable og metoder.
	private int udnævnelse; // �r for udn�vnelse til v�rkf�rer
	private double tillæg; // bel�b oveni standard l�nnen

	// Constructor
	// ---------------------------------------------------------------------------------------------------
	public Værkfører(String navn, String addresse, int svendeprøve, double timeløn, int udnævnelse, double tillæg) {
		super(navn, addresse, svendeprøve, timeløn);
		this.udnævnelse = udnævnelse;
		this.tillæg = tillæg;
	}

	// Get & Set methods
	// ---------------------------------------------------------------------------------------------
	// Bruger denne metode, istedet for Mekaniker's getUgel�n metode. Kaldet er
	// sansynligvis det samme,
	// men n�r man kalder den p� V�rkf�rer, bruges denne metode istedet for den
	// nedarvede.
	@Override
	public double getUgeløn() {
		return super.getUgeløn() + tillæg;
	}

	public int getUdnævnelse() {
		return this.udnævnelse;
	}

	public void setUdnævnelse(int udnævnelse) {
		this.udnævnelse = udnævnelse;
	}

	public double getTillæg() {
		return this.tillæg;
	}

	public void setTillæg(double tillæg) {
		this.tillæg = tillæg;
	}
}
