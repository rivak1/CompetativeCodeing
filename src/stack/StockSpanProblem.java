package stack;

import java.util.Scanner;

public class StockSpanProblem {

	public static void main(String[] args) {
		StockSpanProblem stockProblem = new StockSpanProblem();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the stocks :-");
		String stocks = sc.nextLine();
		stockProblem.solveStockProblem(stocks.split(", "));
		sc.close();
	}

	private void solveStockProblem(String[] split) {
		StackOperations stack = new StackOperations();
		for (int i = 0; i < split.length; i++) {
			int span = 1;
			if (stack.top == null) {
				Node node = stack.creataSpace(Integer.parseInt(split[i]));
				stack.push(node);
				System.out.println("Given Span "+split[i]+" Of Stock Is -:"+span);
			} else {
				Node temp = stack.top;
				Node node = stack.creataSpace(Integer.parseInt(split[i]));
				while (temp != null && temp.getData() < Integer.parseInt(split[i])) {
					System.out.println("Data Of Temp :-"+temp.getData());
					span++;
					temp = temp.getNext();
				}
				stack.push(node);
				System.out.println("Given Span "+split[i]+" Of Stock Is -:"+span);
			}
		}
	}

}
