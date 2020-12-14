package stack;

import java.util.Scanner;

public class BalancedBrackets {

	void checkBracketIsBalancedOrNot(String[] element, StackOperations stack, int i) {
		while (element.length > i) {
			if (stack.top != null && element[i].equals("}") && stack.top.getInfixStr().equals("{") ) {
				stack.pop();
			}
			else if (stack.top != null   && element[i].equals(")") && stack.top.getInfixStr().equals("(")) {
				stack.pop();
			}
			else if (stack.top != null && element[i].equals("]") && stack.top.getInfixStr().equals("[") ) {
				stack.pop();
			} else {
				stack.push(stack.creataSpace(element[i]));
			}
			i++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StackOperations stack = new StackOperations();
		System.out.println("Enter The Total Element 1,2,3,4:-");
		String elem = sc.nextLine();
		BalancedBrackets blanceBrack = new BalancedBrackets();
		blanceBrack.checkBracketIsBalancedOrNot(elem.split(","), stack, 0);
		if (stack.top == null) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}
		sc.close();
	}

}
