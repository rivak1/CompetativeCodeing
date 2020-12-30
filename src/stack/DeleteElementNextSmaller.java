package stack;

import java.util.Scanner;

public class DeleteElementNextSmaller {
	
	public static void main(String[] args) {
		DeleteElementNextSmaller dens = new DeleteElementNextSmaller();
		System.out.println("Enter The Element :-");
		Scanner sc = new Scanner(System.in);
		String elem = sc.nextLine();
		dens.deleteNextSmallerElement(elem.split(","));
		sc.close();
	}

	private void deleteNextSmallerElement(String[] elem) {
		StackOperations stack = new StackOperations();
		stack.push(stack.creataSpace(0));
		int k = 1;
		for (int i = 1; i < elem.length; i++) {
			
			if (k <= 0) {
				break;
			}
			
			while (stack.top != null && 
			Integer.parseInt(elem[i]) > Integer.parseInt(elem[stack.top.getData()])) {
				elem[stack.top.getData()] = Integer.toString(-1);
				k--;
				stack.pop();
			}
			
			if (stack.top != null && Integer.parseInt(elem[i]) > Integer.parseInt(elem[stack.top.getData()])) {
				stack.push(stack.creataSpace(i));
			}else {
				stack.push(stack.creataSpace(i));
			}
  		}
		
		for (int i = 0; i < elem.length; i++) {
			System.out.println("element are"+elem[i]);
		}
	}

}
