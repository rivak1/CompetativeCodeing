package stack;

public class IterativeTowerOfHanoi {
	
	public static void main(String args[]) {
		IterativeTowerOfHanoi itoh = new IterativeTowerOfHanoi();
		System.out.println("Values For Insetions");
		StackOperations stackS = new StackOperations();
		stackS.push(stackS.creataSpace(3));
		stackS.push(stackS.creataSpace(2));
		stackS.push(stackS.creataSpace(1));
		stackS.push(stackS.creataSpace(0));
		while (stackS.top != null) {
			System.out.println("values"+stackS.top.getData()/3);
			stackS.pop();
		}
		StackOperations stackA = new StackOperations();
		StackOperations stackD = new StackOperations();
//		itoh.towerOfHanoi(stackS, stackA, stackD);
	}

	private void towerOfHanoi(StackOperations stackS, StackOperations stackA, StackOperations stackD) {
		
		
	}

}
