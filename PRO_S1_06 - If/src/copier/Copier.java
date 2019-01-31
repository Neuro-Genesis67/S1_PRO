package copier;

public class Copier {
	// private Scanner sc = new Scanner(System.in);
	private int paper;
	private boolean jammed = false;
	// private int choice;

	public Copier() {
		// Gør det muligt at oprette printer objekt uden papir i
	}

	public Copier(int paper) {
		this.paper = paper;
	}

	public void insertPaper(int paper) {
		int amount = this.paper + paper;
		if (amount > 500) {
			System.out.println("Paper tray already full, printer has been jammed");
			jammed = true;
			status();
		} else {
			this.paper += paper;
			System.out.println("Inserting " + paper + " pieces of paper...");
			status();
		}

	}

	// // __________________PRINTER________________________
	// // ___________________MENU__________________________
	// public void welcome() {
	// System.out.println("Welcome to Ocelot-8 PrintPro XH8220-PZag v. 2.1 beta." +
	// "\n" + "\n");
	// menu();
	// }
	//
	// public void menu() {
	// System.out.println("1: Insert paper");
	// System.out.println("2: Make copy");
	//
	// this.choice = sc.nextInt();
	// if (choice == 1) {
	//
	// }
	//
	// }
	// // __________________PRINTER________________________
	// // ___________________MENU__________________________

	public void makeCopy(int copies) {
		int i = 0;
		int pagesPrinted;
		int failsafe = this.paper - copies;
		while (!jammed) {
			if (failsafe < 0) {
				System.out.println("Not enough paper in printer, task aborted.");
			} else {
				System.out.println("\n" + "Printing..." + "\n");
				while (copies > 0 && i != copies) {
					this.paper--;

					i++;
					System.out.println(i + "/" + copies);
				}
				System.out.println("\n" + i + " copies printed");
				status();

			}
		}
		if (jammed) {
			System.out.println("Can't print copies; printer is jammed!" + "\n");
		}

	}

	public void fixJam() {
		this.jammed = false;
		System.out.println("Jam has been fixed.");
		status();

	}

	public void status() {

		String jam = "";
		if (this.jammed) {
			jam = "Jammed";
		} else {
			jam = "100% mah nigger";
		}

		System.out.println("\n" + "********STATUS****************" + "\n" + "Paper in tray: " + this.paper + "\n"
				+ "Functionality: " + jam + "\n" + "*******************************" + "\n");

	}

}
