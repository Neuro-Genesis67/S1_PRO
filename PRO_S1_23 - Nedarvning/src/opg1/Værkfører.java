package opg1;

public class Værkfører extends Mekaniker {
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

	public String getUgeløn() {
		String result = "";
		result += (this.getTimeløn() * 37) + tillæg;
		return result;
	}
}
