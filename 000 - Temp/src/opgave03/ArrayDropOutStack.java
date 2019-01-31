package opgave03;

import java.util.EmptyStackException;

import opgave01.Stack;

public class ArrayDropOutStack<T> implements Stack<T> {

	T[] stack;
	int top;
	boolean wrapped;

	@SuppressWarnings("unchecked")
	public ArrayDropOutStack(int size) {
		stack = (T[]) new Object[size];
		top = 0;
		wrapped = false;
	}

	@Override
	public void push(T element) {
		if (top == stack.length) {
			top = 0;
			wrapped = true;
		}

		stack[top] = element;
		top++;
	}

	@Override
	public T pop() {
		if (top == 0 && wrapped) {
			top = stack.length;
			wrapped = false;
		}

		T removed = stack[--top];
		if (removed == null) {
			throw new EmptyStackException();
		}

		stack[top] = null;
		return removed;
	}

	@Override
	public T peek() {
		return stack[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public int size() {
		return wrapped ? stack.length : top; // Hvis wrapped = true; returner stack.length. Hvis ikke er true, returner
												// top
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("[\n");

		for (int i = stack.length - 1; i >= 0; i--) {
			if (stack[i] != null) {
				sb.append("\t" + stack[i] + ",\n");
			}
		}

		sb.append("]" + " n=" + size());

		return sb.toString();
	}

}
