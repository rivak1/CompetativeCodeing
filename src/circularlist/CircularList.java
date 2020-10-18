package circularlist;
import java.util.Scanner;

public class CircularList {
	CNode head = null;
	CNode head1 = null;
	CNode loop = null;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CircularList list = new CircularList();
		System.out.print("ENTER NUM OF NODES :-");
		int no = sc.nextInt();
		while (no > 0) {
			System.out.print("ENTER VALUE :-");
			int val = sc.nextInt();
			CNode node = list.create(val);
			list.connect(node);
			no--;
		}
		list.split();
		list.print();
		sc.close();
	}


	private void split() {
		CNode temp = this.head;
		CNode tempDouble = this.head;
		
		while (tempDouble.getNext() != this.head && tempDouble.getNext().getNext() != this.head) { 
			temp = temp.getNext();
			tempDouble = tempDouble.getNext().getNext();
		}
		System.out.println(temp.getId()+"--1212--"+tempDouble.getId());
		CNode next = temp.getNext();
		temp.setNext(this.head);
		if (tempDouble.getNext() != this.head) {
			tempDouble.getNext().setNext(next);
			this.head1 = next;
		} else {
			tempDouble.setNext(next);
			this.head1 = next;
		}
		
	}


	private void print() {
		CNode temp = this.head;
		while (true) {
			System.out.println("GIVEN VALUE temp :- "+temp.getId());
			temp = temp.getNext();
			if (temp == this.head)
				break;			
		}
		
		CNode temp1 = this.head1;
		while (true) {
			System.out.println("GIVEN VALUE temp1:- "+temp1.getId());
			temp1 = temp1.getNext();
			if (temp1 == this.head1)
				break;			
		}
	}


	private void connect(CNode node) {
		if ( this.head == null ) {
			this.head = node;
			this.loop = node;
		} else {
			this.loop.setNext(node);
			this.loop = node;
			node.setNext(this.head);
		}
	}


	private CNode create(int value) {
		CNode node = new CNode(value, null);
		return node;
	}

}
