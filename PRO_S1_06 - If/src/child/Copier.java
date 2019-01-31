package child;

import java.util.Scanner;

public class Copier {

	private int paper = 0;
	private int totalCopies = 0;
	private boolean jam = false;

	public Copier() {

	}

	public Copier(int paper) {
		if (this.paper >= 500) {
			System.out.println("Copier is full");
		}
		if (this.paper <= 0) {
			System.out.println("Copier is empty!");
		}
	}

	public void makeCopy(int nrCopies) {
		if (jam != true) {
			if ((this.paper - nrCopies) < 0) {
				System.out.println("Not enough paper in tray" + "\n" + "Tray currently has: " + this.paper
						+ " pieces of paper" + "\n" + "Operation aborted." + "\n");
			} else if ((this.paper - nrCopies) >= 0) {
				for (int i = 0; i < nrCopies; i++) {
					System.out.println("Copying... " + (i + 1) + "/" + nrCopies);
				}
				this.paper -= nrCopies;
				System.out.println("Copying successful!" + "\n" + this.paper + " paper remaining." + "\n");
			}
			this.totalCopies += nrCopies;
		} else {
			System.out.println("Can't make copies: Printer is jammed!");
		}
	}

	public void insertPaper(int paper) {
		if (this.paper + paper > 500) {
			System.out.println("No more room in printer, printer has become jammed!" + "\n");
			jam = true;
			startup();
		} else {
			this.paper += paper;
			System.out.println("The printer now has " + this.paper + " pcs. of paper remaining" + "\n");

		}
		startup();

	}

	public int getPaper() {
		return paper;
	}

	public void printerStatus() {
		System.out.println("Paper in tray: " + this.paper);
		System.out.println("Copies made: " + this.totalCopies + "\n");
		System.out.println("Printer jammed?: " + jam);
		startup();
	}

	public void startup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("************************");
		System.out.println("Welcome to We-Print-2000");
		System.out.println("************************");
		System.out.println("1: Insert paper");
		System.out.println("2: Make a copy");
		System.out.println("3: Show printer status");
		System.out.println("4: Fix printer jam");
		System.out.println("************************");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("How many pieces of paper do you wish to insert: ");
			int insert = sc.nextInt();
			insertPaper(insert);

		} else if (choice == 2) {
			System.out.println("How many copies do you wish to make: ");
			makeCopy(sc.nextInt());
			startup();

		} else if (choice == 3) {
			printerStatus();
			startup();

		} else if (choice == 4) {
			System.out.println("Fixing printer jam...");
			jam = false;
			System.out.println("Printer jam fixed");
		}

	}
}
