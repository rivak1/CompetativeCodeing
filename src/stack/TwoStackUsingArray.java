package stack;

public class TwoStackUsingArray {
	
	int stack[];
	int top1;
	int top2;
	
	
	public void initStack(int size) {
		stack = new int[size];
		top1  = stack.length / 2;
		top2  = stack.length - 1;
	}
	
	public void insertIntoStackOne(int elem) {
		if (this.top1 != -1) {
			stack[this.top1] = elem;
			this.top1--;
		} else {
			System.out.println("Overflow");
		}
	}

	public void insertIntoStackTwo(int elem) {
		int middle = (stack.length)/2;
		//System.out.println(stack[last]+"last elemet brfore 2");
		if (top2 != middle) {
			stack[top2] = elem;
			top2--;
		} else {
			System.out.println("Overflow");
		}
		//System.out.println(stack[last]+"last elemet after 2");
	}
	
	public void printStackTwo() {
		int middle = (stack.length)/2 + 1;
		while (middle < stack.length) {
			System.out.println(stack[middle]+"stack two");
			middle++;
		}
	}
	
	public void printArray() {
		for (int i = 0; i < stack.length; i++) {
			System.out.println(stack[i]+"value of stack");
		}
	}
	
	public void printStackOne() {
		int middle = (stack.length)/2 + 1;
		int i = 0;
		while (middle != i) {
			System.out.println(stack[i]+"stack one");
			i++;
		}
	}
	
	public int popFromStackTwo() {
		int last = stack.length - 1;
		if (this.top2 != last) {
			int elem = stack[this.top2];
			stack[this.top2] = 0;
			this.top2++;
			return elem;
		} else {
			System.out.println("Stack overDown");
			return -1;
		}
	}
	
	public int popFromStackOne() {
		int middle = (stack.length)/2 + 1;
		if (this.top1 != middle) {
			this.top1++;
			int elem = stack[this.top1];
			stack[middle] = 0;	
			return elem;
		} else {
			System.out.println("Stack OverBownd");
		}
		return -1;
	}
	
	public static void main(String args[]) {
		TwoStackUsingArray two = new TwoStackUsingArray();
		two.initStack(7);
		two.insertIntoStackOne(1);
		two.insertIntoStackOne(2);
		two.insertIntoStackOne(3);
		two.insertIntoStackOne(4);
		two.insertIntoStackTwo(5);
		two.insertIntoStackTwo(6);
		two.insertIntoStackTwo(7);
		two.printStackOne();
		two.setDivider();
		two.setDivider();
		two.printStackTwo();
		System.out.println(two.popFromStackOne());
		System.out.println(two.popFromStackOne());
		System.out.println(two.popFromStackTwo());
		System.out.println(two.popFromStackTwo());
		two.printStackOne();
		two.setDivider();
		two.setDivider();
		two.printStackTwo();
//		two.printArray();
	}

	private void setDivider() {
		System.out.println("--------------------------------------------------");
	}

}
