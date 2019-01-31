package pro_s1_24_opg2;

public class Synsmand extends Mekaniker {
	private double synTillæg = 250;
	private static int ugentligeSyn = 0;

	public Synsmand(String navn, String addresse, int svendeprøve, double timeløn, double synTillæg, int ugentligeSyn) {
		super(navn, addresse, svendeprøve, timeløn);
		this.synTillæg = synTillæg;
		this.ugentligeSyn = ugentligeSyn;
	}

	@Override // SUCCESSS!!!!!!!!!!!!!
	public double getUgeløn() {
		return super.getUgeløn() + (synTillæg * ugentligeSyn);
	}

	public double getSynTillæg() {
		return this.synTillæg;
	}

	public void setSynTillæg(double synTillæg) {
		this.synTillæg = synTillæg;
	}

	public int getUgentligeSyn() {
		return this.ugentligeSyn;
	}

	public void setUgentligeSyn(int ugentligeSyn) {
		this.ugentligeSyn = ugentligeSyn;
	}
}
