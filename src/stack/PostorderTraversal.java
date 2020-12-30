package stack;

import java.util.Scanner;

public class PostorderTraversal {

	public static void main(String[] args) {
		PostorderTraversal pt = new PostorderTraversal();
		System.out.println("Enter The Tree Element :- ");
		Scanner sc = new Scanner(System.in);
		String[] value = sc.nextLine().split(",");
		pt.postOrderTraversal(value);
		sc.close();
	}

	
	private void postOrderTraversal(String[] value) {
		StackOperations stack1 = new StackOperations();
		StackOperations stack2 = new StackOperations();
		for (int i = 0; i < value.length; i++) {
			System.out.println(value[i]+"value of index"+i);
		}
		stack1.push(stack1.creataSpace("node1"));
		while (stack1.top != null ) {
			Node popElement = stack1.pop();
			stack2.push(popElement);
//			if (popElement.lefchild != null ) { 
//				stack1.push(popElement.left);
//			}
			
//			if (popElement.rightchild != null ) { 
//				stack1.push(popElement.right);
//			}
		}	
	}

}
