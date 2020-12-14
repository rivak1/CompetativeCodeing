package stack;

import java.util.Scanner;

public class NextGreaterNumberQueries {

	public static void main(String[] args) {
		NextGreaterNumberQueries ngno = new NextGreaterNumberQueries();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter elements :-");
		String elem = sc.nextLine();
		ngno.findGreaterElementOfQuries(elem.split(","));
	}

	private void findGreaterElementOfQuries(String[] elem) {
		StackOperations stack = new StackOperations();
		int nGreater[] = new int[elem.length];
		stack.push(stack.creataSpace(0));
		for (int i = 1; i < elem.length; i++) {
			
			while (stack.top != null && Integer.parseInt(elem[i]) > 
			Integer.parseInt(elem[stack.top.getData()])) {
				nGreater[stack.top.getData()] = i;
				stack.pop();
			}
			
			if (stack.top != null && Integer.parseInt(elem[i]) <
			Integer.parseInt(elem[stack.top.getData()])) {
				stack.push(stack.creataSpace(i));
			} else {
				stack.push(stack.creataSpace(i));
			}
		}
		while (stack.top != null) {
			nGreater[stack.top.getData()] = -1;
			stack.pop();
		}
		
		int[] qQueries = new int[4];
		qQueries[0] = 0;
		qQueries[1] = 1;
		qQueries[2] = 2;
		qQueries[3] = 3;
		for (int i = 0; i < qQueries.length; i++) {
			if (nGreater[qQueries[i]] == -1) {
				System.out.println("Greater Element At Index ["+qQueries[i]+"] Of elem is[-1]");
			} else {
				String val = elem[nGreater[qQueries[i]]];
				System.out.println("Greater Element At Index ["+qQueries[i]+"] Of elem is["+val+"]");
			}
		}
	}

}
