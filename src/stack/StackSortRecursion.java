package stack;

import java.util.Scanner;

public class StackSortRecursion {
	
	public static void main(String[] args) {
		StackSortRecursion ssr = new StackSortRecursion();
		System.out.println("Enter The Values :-");
		Scanner sc = new Scanner(System.in);
		String values = sc.nextLine();
		ssr.sortRecursion(values.split(","));
		sc.close();
	}

	private void sortRecursion(String[] values) {
		StackOperations stack = new StackOperations();
		for (int i = 0; i < values.length; i++) {
			stack.push(stack.creataSpace(Integer.parseInt(values[i])));
		}
		this.sortRecurs(stack);
		while(stack.top != null) {
			System.out.println(stack.top.getData()+"top values of data");
			stack.pop();
		}
	}
	
	private void sortRecurs(StackOperations stack) {
		if( stack.top != null ) {
			int temp = stack.pop().getData();
			sortRecurs(stack);
			this.sort(stack, temp);
		}
	}

	private void sort(StackOperations stack, int temp) {
		if (stack.top == null || stack.top.getData() < temp) {
			stack.push(stack.creataSpace(temp));
		} else {
			int elm = stack.pop().getData();
			sort(stack,temp);
			stack.push(stack.creataSpace(elm));
		}
	}
}
