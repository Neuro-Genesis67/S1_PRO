package opg2_efg;

public class App {

	public static void main(String[] args) {
		Gift g1 = new Gift("Coconut oil", 25.49);
		Gift g2 = new Gift("Tekken 7", 199.98);
		Gift g3 = new Gift("Mirrors edge 3", 40.00);
		Gift g4 = new Gift("Græsslåmaskine", 49.95);

		Person p1 = new Person("Tom", 27);

		p1.addGift(g1);
		p1.addGift(g2);
		p1.addGift(g3);
		p1.addGift(g4);

		System.out.println(p1.getName() + "'s gifts: " + p1.getGifts());

		System.out.println("The total value of all thos gifts: " + p1.getValueOfGifts());

	}

}
