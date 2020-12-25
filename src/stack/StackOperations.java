package stack;

import java.util.Scanner;

public class StackOperations {

	Node top = null;
	
	public Node creataSpace(int data) {
		return new Node(data, null);
	}
	
	public Node creataSpace(char infixChar) {
		return new Node(null, infixChar);
	}

	public Node creataSpace(String infixChar) {
		return new Node(null, infixChar);
	}
	
	public void push(Node node) {
		if (this.top == null) {
			this.top = node;
		} else {
			node.setNext(this.top);
			this.top = node;
		}
	}
	
	public Node pop() {
		Node node = this.top;
		this.top = this.top.getNext();
		return node;
	}
	
	public Node peak() {
		return this.top;
	}
	
	public Node findMin() {
		Node maxNode = new Node(9999999, null);
		Node node = this.top.getNext();
		while (node != null) {
			if (node.getData() < maxNode.getData() ) {
				maxNode = node;
			} 
			node = node.getNext();
		}
		return maxNode;
	}
	
	public void print() {
		Node node = this.top;
		while (node != null) {
			System.out.println(node.getInfixChar()+"value of stack");
			node = node.getNext();
		}
	}
	
	public static void main(String args[]) {
		StackOperations stack = new StackOperations();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Total Node :-");
		int totalNode = sc.nextInt();
		for (int i = 0; i < totalNode; i++) {
			System.out.print("Enter Node value :-");
			int data = sc.nextInt();
			Node node = stack.creataSpace(data);
			stack.push(node);
		}
		stack.print();
		Node node = stack.findMin();
		System.out.println(node.getData()+"the min data in list");
		System.out.println(stack.peak().getData());
		System.out.println(stack.pop().getData());
		System.out.println(stack.peak().getData());
		sc.close();
	}

}
