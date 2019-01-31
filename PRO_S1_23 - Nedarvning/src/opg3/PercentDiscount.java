package opg3;

public class PercentDiscount extends Discount {

	private double percent = 20.0;

	public PercentDiscount(double percent) {
		this.percent = percent;

	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

}
