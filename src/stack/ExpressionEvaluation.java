package stack;

import java.util.Scanner;

public class ExpressionEvaluation {

	public static void main(String[] args) {
		ExpressionEvaluation ee = new ExpressionEvaluation();
		Scanner sc = new Scanner(System.in);
		String[] expression = sc.nextLine().split(" ");
		ee.evaluteExpression(expression);
	}

	private void evaluteExpression(String[] expression) {
		StackOperations operator = new StackOperations();
		StackOperations operand = new StackOperations();
		for (int i = 0; i < expression.length; i++) {
			try {
				operand.push(operand.creataSpace(Integer.parseInt(expression[i])));
			} catch (NumberFormatException e) {
				if (operator.top != null && checkPriority(expression[i]) < checkPriority(operator.top.getInfixStr())) {
					operand.push(operand.creataSpace(applyOperation(operand.pop().getData(),operand.pop().getData(), expression[i])));
				} else {
					operator.push(operator.creataSpace(expression[i]));
				}
			}
		}
		
		while (operator.top != null) {
			int a = operand.pop().getData();
			int b = operand.pop().getData();
			operand.push(operand.creataSpace(applyOperation(a,b, operator.pop().getInfixStr())));			
		}
		System.out.println(operand.top.getData());
	}
	
	private int applyOperation(int i, int j, String op) {
		switch (op) {
		case "*":
			return i * j;
		case "-":
			return i - j;
		case "+":
			return i + j;
		case "/":
			return i / j;
		default:
			return 0;
		}
	}

	private static int checkPriority(String c) {
		if (c == "+" || c == "-") {
			return 1;
		} else if (c == "*" || c == "/") {
			return 2;
		} else if (c == "^") {
			return 3;
		}
		return 0;
	}

}
