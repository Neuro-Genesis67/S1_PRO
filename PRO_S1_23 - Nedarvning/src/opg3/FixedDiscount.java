package opg3;

public class FixedDiscount extends Discount {
	private double fixedDiscount;

	public FixedDiscount(double fixedDiscount) {
		this.fixedDiscount = fixedDiscount;

	}

	public double getFixedDiscount() {
		return fixedDiscount;
	}

	public void setFixedDiscount(double fixedDiscount) {
		this.fixedDiscount = fixedDiscount;
	}

}
