package copier;

public class PrinterApp {

	public static void main(String[] args) {
		Copier cp = new Copier(450);
		cp.status();
		cp.insertPaper(51);
		cp.makeCopy(22);
		cp.fixJam();
		cp.insertPaper(20);
		cp.insertPaper(20);

	}
}
