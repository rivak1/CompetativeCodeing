package stack;

import java.util.Scanner;

public class SortRecursion {

	public static void main(String[] args) {
		SortRecursion sr = new SortRecursion();
		System.out.println("Please Insert The value :-");
		Scanner sc = new Scanner(System.in);
		String val = sc.nextLine();
		sr.sortStackUsingRecursion(val.split(","));
	}

	private void sortStackUsingRecursion(String[] value) {
		StackOperations stack = new StackOperations();
		StackOperations temp = new StackOperations();
		for (int i = 0; i < value.length; i++) {
			stack.push(stack.creataSpace(Integer.parseInt(value[i])));
		}
		
		while (stack.top != null) {
			
				int x = stack.pop().getData();
				while (temp.top != null && temp.top.getData() > x) {
					stack.push(stack.creataSpace(temp.top.getData()));
					temp.pop();
				}
				temp.push(temp.creataSpace(x));
		}
			
		while(temp.top != null) {
			System.out.println(temp.pop().getData()+"Value Of Temps");
		}
		
	}

}
