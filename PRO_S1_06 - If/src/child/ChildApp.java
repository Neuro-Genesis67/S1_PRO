package child;

public class ChildApp {

	public static void main(String[] args) {
		Child c1 = new Child(4, true);// boy 4 years old
		Child c2 = new Child(2, false);// girl 2 years old
		System.out.println(c1.institution());
		System.out.println(c2.institution());
		System.out.println(c1.gender());
		System.out.println(c2.gender());
		System.out.println("Et barn på " + c1.getAge());
		System.out.println(c1.team());
		System.out.println(c2.team());

	}

}
