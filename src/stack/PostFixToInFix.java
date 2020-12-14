package stack;

import java.util.Scanner;

public class PostFixToInFix {

	public static void main(String[] args) {
		PostFixToInFix postfix = new PostFixToInFix();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter infix String :-");
		String prefix = sc.nextLine();
		System.out.println(postfix.convertPostToInfix(prefix));
		sc.close();
	}

	private String convertPostToInfix(String prefix) {
		StackOperations stack = new StackOperations();
		for (int i = 0; i < prefix.length(); i++) {
			char prefiChar = prefix.charAt(i);
			boolean number = this.checkAlphbate(prefiChar);
			boolean alphabate = Character.isDigit(prefiChar);
			if (number || alphabate) {
				System.out.println(prefiChar+" :- char is");
				stack.push(stack.creataSpace(Character.toString(prefiChar)));
			} else {
				Node node1 = stack.pop();
				Node node2 = stack.pop();
				boolean reponse = bracketRequired(prefiChar);
				System.out.println(prefiChar+" :- operator is");
				Node node3 = null;
				node3 = stack.creataSpace("("+node2.getInfixStr()+""+prefiChar+""+node1.getInfixStr()+")");
				System.out.println(node3.getInfixStr());
				stack.push(node3);
			}
			
		}
		
		while (stack.top != null) {
			System.out.println(stack.peak().getInfixStr());
			stack.top  = stack.top.getNext();
		}
		return null;
	}

	private boolean bracketRequired(char prefiChar) {
		if (prefiChar == '*') {
			return true;
		} else if (prefiChar == '/') {
			return true;
		}else {
			return false;
		}
	}

	private boolean checkAlphbate(char prefixChar) {
		if( ( prefixChar >= 'a' && prefixChar <= 'z') || (prefixChar >= 'A' && prefixChar <= 'Z')) {
			return true;
		}
		return false;
	}
}
