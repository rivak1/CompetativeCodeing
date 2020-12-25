package stack;

import java.util.Scanner;

public class DeleteMiddleStack {

	public static void main(String[] args) {
		DeleteMiddleStack dms = new DeleteMiddleStack();
		System.out.println("Enter the Values :-");
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		dms.deleteMiddleElementFromStack(value.split(","));

	}

	private void deleteMiddleElementFromStack(String[] values) {
		StackOperations stack = new StackOperations();
		Node middle = null;
		Node first = null;
		for (int i = 0; i < values.length; i++) {
			stack.push(stack.creataSpace(Integer.parseInt(values[i])));
		}
		first = stack.top;
		middle = stack.top;
		
		while (first != null && middle != null && middle.getNext() != null) {
			first = first.getNext();
			middle = middle.getNext().getNext();
		}
		
		System.out.println(first.getData()+"value of middle");
	}

}
