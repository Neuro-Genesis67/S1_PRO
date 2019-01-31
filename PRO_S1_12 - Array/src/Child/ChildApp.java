package Child;

public class ChildApp {

	public static void main(String[] args) {
		double[] weightOneToTen = { 2.1, 4.2, 5.2, 7.6, 8.1, 10.2, 15.5, 15.6, 17.4, 18.6, };
		Child child1 = new Child(2, false, weightOneToTen);
		Child child2 = new Child(8, true, weightOneToTen);
		Child child3 = new Child(4, false, weightOneToTen);
		Child child4 = new Child(6, false, weightOneToTen);// alder = 2, false = pige & true = dreng;
		System.out.println(String.format("Alder: %s", child1.getAge()));
		String institution = child1.institution();
		System.out.println(String.format("Institution: %s", institution));

		System.out.println("Child's weight in the third year (5.2): " + child1.getWeight(3));
		System.out.println("Child's biggest weight gain (5.3). Does he even lift?: "
				+ child1.getBiggestWeightGain(weightOneToTen));

		Institution dagplejen = new Institution("De dårlige børnepassere", "Torturvej 13");
		dagplejen.addChild(child1);
		dagplejen.addChild(child2);
		dagplejen.addChild(child3);
		dagplejen.addChild(child4);
		System.out.println("\n\n\n\nAverage age of the four kids (5.0) in dagplejen: " + dagplejen.KidsAverageAge());
		System.out.println("Number of girls in dagplejen (3): " + dagplejen.girlsCount());
		System.out.println("Number of boys in dagplejen (1): " + dagplejen.boysCount());

	}

}
