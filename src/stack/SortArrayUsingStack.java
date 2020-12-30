package stack;

import java.util.Scanner;

public class SortArrayUsingStack {

	public static void main(String[] args) {
		SortArrayUsingStack saus = new SortArrayUsingStack();
		System.out.println("Enter The String :-");
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		saus.sortArrayUsingStack(value.split(","));
		sc.close();
	}

	private void sortArrayUsingStack(String[] values) {
		StackOperations stack = new StackOperations();
		
		for (int i = 0; i < values.length; i++) {
			stack.push(stack.creataSpace(Integer.parseInt(values[i])));
		}
		
		StackOperations temp = new StackOperations();
		
		while (stack.top  != null ) {
			int value = stack.pop().getData();
			while (temp.top != null && temp.top.getData() > value) {
				stack.push(stack.creataSpace(temp.top.getData()));
				temp.pop();
			}
			temp.push(temp.creataSpace(value));
		}
		
		while (temp.top  != null) {
			System.out.println(temp.top.getData()+"value at top");
			temp.pop();
		}
 	}

}
