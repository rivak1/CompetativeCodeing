package stack;

import java.util.Scanner;

public class InfixToPrefix {

	public static void main(String[] args) {
		InfixToPrefix prefix = new InfixToPrefix();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter infix String :-");
		String infix = sc.nextLine();
		System.out.println(prefix.convertPostToInfix(infix));
		sc.close();
	}

	private String convertPostToInfix(String infix) {
		StackOperations stack = new StackOperations();
		String prefix = "";
		for (int i = 0; i < infix.length(); i++) {
			char prefixChar = infix.charAt(i);
			boolean number = this.checkAlphbate(prefixChar);
			boolean alphabate = Character.isDigit(prefixChar);		
			if (number || alphabate) {
				prefix = prefix + prefixChar;
			} else {
				Node node = stack.creataSpace(prefixChar);
				switch (prefixChar) {
				case '(':
					stack.push(node);
					break;
				case ')':
					while ( stack.peak() != null ) {
						if (stack.peak().getOperator() != ')') {
							prefix = stack.peak().getOperator()+prefix;
							stack.pop();
						} else  {
							stack.pop();
							break;
						}
					}
				default:
					if (stack.peak() != null) {
						//System.out.println("Node another operator"+node.getOperator());
						while (stack.peak() != null) {
							int priorityInfix = checkPriority(node.getOperator());
							int popPriority = checkPriority(stack.peak().getOperator());	
							//System.out.println(priorityInfix+"priorityInfix value");
							//System.out.println(popPriority+"popPriority value");
							if (priorityInfix <= popPriority) {
								prefix = stack.peak().getOperator()+prefix;
								stack.pop();
							} 
							else {
								break;
							}
						}
						stack.push(node);
					} else {
						//System.out.println("Firsy operator"+node.getOperator());
						stack.push(node);
					}
					break;
				}
			}
		}
		return infix;
		
	}

	private static int checkPriority(char c) {
		if (c == '+' || c == '-') {
			return 1;
		} else if (c == '*' || c == '/') {
			return 2;
		} else if (c == '^') {
			return 3;
		}
		return 0;
	}

	private boolean checkAlphbate(char prefixChar) {
		if( ( prefixChar >= 'a' && prefixChar <= 'z') || (prefixChar >= 'A' && prefixChar <= 'Z')) {
			return true;
		}
		return false;
	}
}
