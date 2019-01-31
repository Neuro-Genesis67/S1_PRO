package opgave03;

public class Application {

	public static void main(String[] args) {
		ArrayDropOutStack<Integer> stack = new ArrayDropOutStack<>(4);
		
		System.out.println(stack);
		
		for (int i = 0; i < 10; i++) {
			stack.push(i);
			System.out.println(stack);
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println(stack.pop());
		}
	}

}
