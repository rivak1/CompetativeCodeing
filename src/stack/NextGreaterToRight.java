package stack;

import java.util.Scanner;

public class NextGreaterToRight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Elements :-");
		String elements = sc.nextLine();
		NextGreaterToRight nGR = new NextGreaterToRight();
//		nGR.findTotalNextElement(elements.split(" "));
		nGR.findTotalNextElement1(elements.split(" "));
		
	}

	private void findTotalNextElement1(String[] elem) {
		int [] next = new int[elem.length];
		int [] dp = new int[elem.length];
		StackOperations stack = new StackOperations();
		next = findPositonOfElement(stack, next, elem);
		for (int i =next.length-2; i >= 0; i--) {
			if (next[i] != 0 && next[i] != -1) {
				dp[i] = dp[next[i]] + 1;
			}
		}
		
		for (int i = 0; i < dp.length; i++) {
			System.out.println(dp[i]+"dp element on index"+i);
		}
 	}

	private int[] findPositonOfElement(StackOperations stack, int[] next, String[] elem) {
		// insert the index of element;
		stack.push(stack.creataSpace(0));
		
		for (int i = 1; i < elem.length; i++) {
			
			while (stack.top != null && Integer.parseInt(elem[i]) > Integer.parseInt(elem[stack.top.getData()])) {
				next[stack.top.getData()] = i;
				stack.pop();
			}
			
			if (stack.top != null && Integer.parseInt(elem[i]) < Integer.parseInt(elem[stack.top.getData()])){
				stack.push(stack.creataSpace(i));
			} else {
				stack.push(stack.creataSpace(i));
			}
			
		}
		
		while (stack.top != null) {
			next[stack.top.getData()] = -1;
			stack.pop();
		}
		
		return next;
	}

	private void findTotalNextElement(String[] elem) {
		int[] next = new int[elem.length];
		StackOperations stack = new StackOperations();
		for (int i=0; i<next.length; i++) {
			next[i] =  -1;
		}
		Node node  = new Node(null, elem[0]);
		stack.push(node);
		for (int i=1; i<elem.length; i++) {
			int count = -1;
//			System.out.println(Integer.parseInt(stack.top.getInfixStr())+"Integer.parseInt(stack.top.getInfixStr()");
//			System.out.println(Integer.parseInt(elem[i])+"Integer.parseInt(elem[i])");
//			System.out.println(stack.top+"------------------TOPMELEME");
			while (stack.top != null && Integer.parseInt(stack.top.getInfixStr()) < Integer.parseInt(elem[i])) {
				stack.pop();
//				System.out.println(stack.top+"-------------------------------------");
				++count;
				++count;
			}
//			System.out.println("count"+count);
			next[i-1] = count;
			if (stack.top != null && Integer.parseInt(stack.top.getInfixStr()) > Integer.parseInt(elem[i])) {
				System.out.println("Push the Next Small Element");
				stack.push(stack.creataSpace(elem[i]));
			} else{
				stack.push(stack.creataSpace(elem[i]));
			}
		}
		while(stack.top != null) {
			System.out.println("next greater element is -1 of -: "+stack.top.getData());
			stack.pop();
		}
		int index = 2;
		int sum = 0;
		for (int i = index; i < next.length-1; i++) {
			if (next[i] == -1){
				break;
			}
			sum = sum + next[i];
		}
		System.out.println("Sum Of Elements"+sum+"At Index"+index);
		
	}

}
