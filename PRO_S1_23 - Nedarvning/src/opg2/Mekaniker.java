package opg2;

public class Mekaniker extends Person { // Mekaniker arver Person's instans variable og metoder.
	private int svendeprøve; // �rstal
	private double timeløn;
	private double ugeløn;

	// Constructor
	// ---------------------------------------------------------------------------------------------------
	public Mekaniker(String navn, String addresse, int svendeprøve, double timeløn) {
		super(navn, addresse);
		this.svendeprøve = svendeprøve;
		this.timeløn = timeløn;
	}

	// Get & Set methods
	// ---------------------------------------------------------------------------------------------
	public double getUgeløn() {
		return this.timeløn * 37;
	}

	public int getSvendeprøve() {
		return this.svendeprøve;
	}

	public void setSvendeprøve(int svendeprøve) {
		this.svendeprøve = svendeprøve;
	}

	public double getTimeløn() {
		return this.timeløn;
	}

	public void setTimeløn(double timeløn) {
		this.timeløn = timeløn;
	}
}
