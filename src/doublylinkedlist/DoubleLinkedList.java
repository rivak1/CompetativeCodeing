package doublylinkedlist;

import java.util.Scanner;

public class DoubleLinkedList {
	
	private DNode head;
	
	DNode create(int value, DNode next, DNode prev) {
		
		DNode node = new DNode( value, next, prev );
		node.setId(value);
		node.setNext(next);
		node.setPrev(prev);
		return node;
	}
	
	public void connectNodes( DNode node ) {
		
		if (this.head == null) {
			this.head = node;
		} else {
			DNode temp = this.head;
			while (temp.getNext() != null) {		
				temp = temp.getNext();
			}
		node.setPrev(temp);
		temp.setNext(node);
		}
	}
	
	public void deleteNode (DoubleLinkedList list) {
		DNode node = list.head;	
		DNode prev = null;
		while ( node != null ) {
			if ( node.getId() == 3 ) {
			
				if (node.getPrev() == null ) {
					list.head = node.getNext();
					this.head.setPrev(null);
				} else {
					prev = node.getPrev();
					prev.setNext(node.getNext());
				}
			}
			node = node.getNext();
		}
		
	}
	
	
	private void print() {
		
		DNode temp = this.head;
		
		while ( temp != null ) {
			System.out.println("NEXT-VALUE-------->"+temp.getId());
			temp = temp.getNext();
		}
		
	}
	
	public static void main(String[] args) {
		
		DoubleLinkedList list = new DoubleLinkedList();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER TOTAL NODE -: ");
		int count = sc.nextInt();
		while (count != 0) {
			System.out.println("ENTER TOTAL NODE VALUE -: ");
			int id = sc.nextInt();
			list.connectNodes(new DNode(id, null, null));
			count--;
		}
		list.print();
		//list.deleteNode(list);
		list.reverse(list);
		System.out.println("AFTER REVERSE");
		list.print();
		sc.close();
	}

	private void reverse(DoubleLinkedList list) {
		DNode node = list.head;
		DNode next = null;
		DNode prev = null;
		while (node != null) {
			next = node.getNext();
			node.setNext(prev);
			node.setPrev(next);
			prev = node;
			node = next;
		}
		list.head = prev;
	}
	

}
