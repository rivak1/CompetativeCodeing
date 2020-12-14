package stack;

import java.util.Scanner;

public class MaximumProductLeftRight {

	
	
	
	public static void main(String[] args) {
		MaximumProductLeftRight mplr = new MaximumProductLeftRight();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Elements");
		String [] elements = sc.nextLine().split(" ");
		int[] nextL = mplr.getLeftGreaterElement(elements);
		int[] nextR = mplr.getRightGreaterElement(elements);
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nextR.length; i++) {
			System.out.println(nextL[i]+"L<---->R"+nextR[i]);
			if (max < (nextL[i] * nextR[i])) {
				System.out.println((nextL[i] * nextR[i])+"sum of product");
				System.out.println("Max value"+max);
				max = (nextL[i] * nextR[i]);
			}
		}
		System.out.println(max+"Maximum Product From Left To Right Is");
		sc.close();
		
	}
	private int[] getRightGreaterElement(String[] elements) {
		
		StackOperations stack = new StackOperations();
		int [] nextL =  new int [elements.length];
		stack.push(stack.creataSpace(elements.length-1));
		for (int i = elements.length-2; i>=0; i--) {
			
			while (stack.top != null && Integer.parseInt(elements[i]) > Integer.parseInt(elements[stack.top.getData()])){
				nextL[stack.top.getData()] = i+1;
				stack.pop();
			}
			
			if (stack.top != null && Integer.parseInt(elements[i]) < Integer.parseInt(elements[stack.top.getData()])) {
				stack.push(stack.creataSpace(i));
			} else {
				stack.push(stack.creataSpace(i));
			} 
		}
		
		while (stack.top != null) {
			nextL[stack.top.getData()] = -1+1;
			stack.pop();
		}
		return nextL;
	}

	private int[] getLeftGreaterElement(String[] elements) {

		StackOperations stack = new StackOperations();
		int [] nextR =  new int [elements.length];
		stack.push(stack.creataSpace(0));
		for (int i = 1; i < elements.length; i++) {
			while (stack.top != null && Integer.parseInt(elements[i]) > Integer.parseInt(elements[stack.top.getData()])){
				nextR[stack.top.getData()] = i+1;
				stack.pop();
			}
			
			if (stack.top != null && Integer.parseInt(elements[i]) < Integer.parseInt(elements[stack.top.getData()])) {
				stack.push(stack.creataSpace(i));
			} else {
				stack.push(stack.creataSpace(i));
			}
		}
		
		while (stack.top != null) {
			nextR[stack.top.getData()] = -1+1;
			stack.pop();
		}
		return nextR;
	}

}
