package stack;

import java.util.Scanner;

public class NextGreaterElement {
	
	void findNextGreaterElement(String[] element) {
		StackOperations stack = new StackOperations();
		Node node = stack.creataSpace(Integer.parseInt(element[0]));
		stack.push(node);
		for (int i = 1; i < element.length; i++) {
			System.out.println("Element is :-"+element[i]);
			while (stack.top != null && stack.top.getData() < Integer.parseInt(element[i]) ) {
				System.out.println("next greate element of "+stack.top.getData()+"----- is--"+Integer.parseInt(element[i]));
				stack.pop();
			}
			
			if (stack.top != null && stack.top.getData() > Integer.parseInt(element[i])) {
				System.out.println("Push the Next Small Element");
				stack.push(stack.creataSpace(Integer.parseInt(element[i])));
			} else{
				stack.push(stack.creataSpace(Integer.parseInt(element[i])));
			}
		}
		
		while(stack.top != null) {
			System.out.println("next greater element is -1 of -: "+stack.top.getData());
			stack.pop();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Total Element 1,2,3,4:-");
		String elem = sc.nextLine();
		NextGreaterElement nGE = new NextGreaterElement();
		nGE.findNextGreaterElement(elem.split(","));
	}

}
