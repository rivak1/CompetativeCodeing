package stack;

import java.util.Scanner;

public class InfixToPostFix {

	public static void main(String[] args) {
		InfixToPostFix infixToPostFix = new InfixToPostFix();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter infix String :-");
		String infix = sc.nextLine();
		//infix = infixToPostFix.reverSE(infix);
		System.out.println(infixToPostFix.convertInfixToPostFix(infix));
		sc.close();
	}

	private String reverSE(String infix) {
		String reverseString = "";
		for (int i = infix.length()-1; i > -1; i--) {
			char infixChar = infix.charAt(i);
			System.out.println(infixChar+"infixChar-----");
			if (infixChar == ')') {
				reverseString = reverseString + "(";
			}
			else if (infixChar == '(') {
				reverseString = reverseString + ")";
			}else {
			reverseString = reverseString + infixChar;
			}
		}
		System.out.println(reverseString+"--------------------");
		return reverseString;
	}

	private String convertInfixToPostFix(String infix) {
		// TODO Auto-generated method stub
		String prefix = "";
		StackOperations stack = new StackOperations();
		for (int i = 0; i < infix.length(); i++) {
			char infixChar = infix.charAt(i);
			boolean number = this.checkAlphbate(infixChar);
			boolean alphabate = Character.isDigit(infixChar);
			
			if ( number || alphabate ) {
				prefix = prefix + infixChar;
				//System.out.println("INSIDE alpha or number");
			} else {
				//System.out.println("Inside operator"+infixChar);
				Node node = stack.creataSpace(infixChar);
				switch (infixChar) {
				case '(':
					stack.push(node);
					break;
				case ')':
					while (stack.peak() != null) {
						if ('('  != stack.peak().getOperator()) {
							prefix = prefix + stack.peak().getOperator();
							stack.pop();
						} 
						else {
							stack.pop();
							break;
						}
					}
					System.out.println("Code For Pop All Element From Stack");
					break;
				default:
					if (stack.peak() != null) {
						//System.out.println("Node another operator"+node.getOperator());
						while (stack.peak() != null) {
							int priorityInfix = InfixToPostFix.checkPriority(node.getOperator());
							int popPriority = InfixToPostFix.checkPriority(stack.peak().getOperator());	
							//System.out.println(priorityInfix+"priorityInfix value");
							//System.out.println(popPriority+"popPriority value");
							if (priorityInfix <= popPriority) {
								prefix = prefix + stack.peak().getOperator();
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
		while (stack.peak() != null) {
			prefix = prefix + stack.peak().getOperator();
			stack.pop();
		}
		return prefix;
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
