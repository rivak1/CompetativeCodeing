package stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStackURecursion {

	public static void main(String[] args) {
		ReverseStackURecursion rsur = new ReverseStackURecursion();
		String a = "Rivak";
		String b = "Arpit Panchal";
		rsur.mergerString(a,b);
		

	}

	private void mergerString(String a, String b) {
		long countA = a.length();
		long countB = b.length();
		String merge = "";
		int i = 0;
		while (countA > i|| countB > i) {
			
			if (i < countA) {
				merge = merge + a.charAt(i);
			} 
			
			if (i < countB) {
				merge = merge + b.charAt(i);
			}

			i++;
		}
		System.out.println("Merger String is :- "+merge);
		
	}

//	private void revereStackUsingN(String elem) {
//		StackOperations stack = new StackOperations();
//		for (int i = 0; i < elem.length(); i++) {
//			stack.push(stack.creataSpace(elem.charAt(i)));
//		}
//		
//	
//		Node prev = null;
//		Node curr = stack.top;
		Node next = null;
//		while (curr.getNext() != null ) {
//			
//			next = curr.getNext();
//			curr.setNext(prev);
//			prev = curr;
//			curr = next;
//		}
//		stack.top = prev;
//		
//		while(stack.top != null) {
//			System.out.println(stack.pop().getData()+"Value Of Temps");
//		}
//		
//	}

	private void reverseStackUsingR(String elem) {
		StackOperations stack = new StackOperations();
		StackOperations stack1 = new StackOperations();
		for (int i = 0; i < elem.length(); i++) {
			stack.push(stack.creataSpace(elem.charAt(i)));
		}
		stack.print();	
		System.out.println("------------------------------------------------");
		stack= this.reverseStack(stack,stack1);
		stack.print();
	}

	private StackOperations reverseStack(StackOperations stack, StackOperations stack1) {
		if (stack.top != null ) {
			char val = stack.pop().getInfixChar();
			stack1.push(stack.creataSpace(val));
			reverseStack(stack,stack1);
		}
		return stack1;
	}

}
