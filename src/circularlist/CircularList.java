package circularlist;

import java.util.Scanner;

public class CircularList {
	CNode head = null;
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
		list.print();
		list.split();
		sc.close();
	}


	private void split() {
		
	}


	private void print() {
		CNode temp = this.head;
		while (true) {
			System.out.println("GIVEN VALUE :- "+temp.getId());
			temp = temp.getNext();
			if (temp == this.head)
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
