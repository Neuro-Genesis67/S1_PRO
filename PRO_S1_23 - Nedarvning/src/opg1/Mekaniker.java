package opg1;

public class Mekaniker extends Person {
	private int svendeprøve; // �rstal
	private double timeløn;

	// Constructor
	// ---------------------------------------------------------------------------------------------------
	public Mekaniker(String navn, String addresse, int svendeprøve, double timeløn) {
		super(navn, addresse);
		this.svendeprøve = svendeprøve;
		this.timeløn = timeløn;
	}

	// Get & Set methods
	// ---------------------------------------------------------------------------------------------
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
