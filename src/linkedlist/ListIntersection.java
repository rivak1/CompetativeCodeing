package linkedlist;

import java.util.Scanner;


public class ListIntersection {
	private Node head;
	
	public Node create(int id) {
		Node node = new Node(id, null);
		return node;
	}
	
	public void conect(Node node) {
		Node headCopy;
		if ( this.head == null ) {
			this.head = node;
		} else {
			headCopy = this.head;
			while( headCopy.getNext() != null ) {
				headCopy = headCopy.getNext();
			}
			headCopy.setNext(node);
		}
		
	}
	
	public void print() {
		Node headCopy;
		if ( this.head == null ) {
			System.out.println(" NO ELEMENT FOUND ");
		}
		headCopy = this.head;
		while( headCopy != null ) {
			System.out.println("VALUE----"+headCopy.getId());
			headCopy = headCopy.getNext();
		}
		
	}
	
	public void intersection(ListIntersection list, ListIntersection list1) {
		Node n1  = list.head;
		while ( n1 != null ) {
			Node n2  = list1.head;
			boolean flag = false;
			while (n2 != null) {
				if (n1.getId() == n2.getId()) {
					flag = true;
					break;
				}
				n2 = n2.getNext();
			}
			if (flag) {
				System.out.println("INTERSECTION NODE -> "+n1.getId()+"INTERSECTION NODE");
				flag = false;
			}
			n2 = null;
			n1 = n1.getNext();
			
		}
	}

	public void union(ListIntersection list, ListIntersection list1) {
		Node n1  = list.head;
		while ( n1 != null ) {
			Node n2  = list1.head;
			boolean flag = true;
			while (n2 != null) {
				if (n1.getId() == n2.getId()) {
					flag = false;
					break;
				}
				n2 = n2.getNext();
			}
			System.out.println("BOOLEAN VALUE"+flag);
			if (flag) {
				Node n3 = list1.head;
				while (n3.getNext() != null ) {
					n3 = n3.getNext();
				}
				n3.setNext(list.create(n1.getId()));
			}
			n2 = null;
			n1 = n1.getNext();
			
		}
	}
	
	public void removeDuplicate(ListIntersection list) {
 
        Node curr = list.head; 
        
        /* Traverse list till the last node */
        while (curr != null) { 
             Node temp = curr; 
            /*Compare current node with the next node and  
            keep on deleting them until it matches the current  
            node data */
            while(temp!=null && temp.getId()==curr.getId()) { 
                temp = temp.getNext(); 
            } 
            /*Set current node next to the next different  
            element denoted by temp*/
            curr.setNext(temp); 
            curr = curr.getNext(); 
        } 
	}
	
	public void swapNode(ListIntersection list) {
		
		int x = 5;
		int y = 6;
		Node curx= list.head;
		Node cury = list.head;
		Node prevx = null;
		Node prevy = null;
		while (curx != null && curx.getId() != x) {
			prevx = curx;
			curx = curx.getNext();
		}
		
		while (cury != null && cury.getId() != y) {
			prevy = cury;
			cury = cury.getNext();
		}

		if (prevx != null && prevy != null) {
			this.reverse(curx, cury, prevx, prevy);
		}
		list.print();
	}
	

	private void reverse(Node curx, Node cury, Node prevx, Node prevy) {	
	
		Node tempx = curx.getNext();
		Node tempy = cury.getNext();
		prevx.setNext(cury);
		prevy.setNext(curx);
		cury.setNext(tempx);
		curx.setNext(tempy);
		
	}

	public static void main(String[] args) {
		// TODO Linked List Operation
		ListIntersection list = new ListIntersection();
		ListIntersection list1 = new ListIntersection();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Total Node -:");
		try {
			int count = sc.nextInt();
			for (int i = 0; i <count;  i++) {
				System.out.print("ENTER ELEMENT NUMBER -:");
				int element = sc.nextInt();
				Node node = list.create(element);
				list.conect(node);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
			System.exit(1);
		}	
//		System.out.print("Enter Total Node -:");
//		try {
//			int count = sc.nextInt();
//			for (int i = 0; i <count;  i++) {
//				System.out.print("ENTER ELEMENT NUMBER -:");
//				int element = sc.nextInt();
//				Node node = list1.create(element);
//				list1.conect(node);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.err.print(e);
//			System.exit(1);
//		}	
//		list.print();
//		list1.print();
		// list.intersection(list, list1);
//		list.union(list, list1);
//		list1.print();
		list.swapNode(list);
		sc.close();	
		
	}
}
