package linkedlist;

import java.util.LinkedList;
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
		
		int x = 1;
		int y = 2;
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

		if (prevx == null && prevy != null) {
			list.head = cury;
			prevy.setNext(curx);
			Node temp = curx.getNext();
			curx.setNext(cury.getNext());
			cury.setNext(temp);
		}
		if (prevy == null && prevx != null) {
			list.head = curx;
			Node temp = cury.getNext();
			prevx.setNext(cury);
			cury.setNext(curx.getNext());
			curx.setNext(temp);
		}
		list.print();
	}

	
	public void deleteRighNodeHigher(ListIntersection list) {
		Node current = list.head;
		Node prev = null;
		while (current.getNext() != null) {
			if (current.getId() < current.getNext().getId()) {
				if(prev == null) {
					this.head = current.getNext();
				} else {
					prev.setNext(current.getNext());
					prev = current;
				}
			} else {
				prev = current;
			}
			current = current.getNext();
		}
		
		list.print();
	}
	
	public void addTwoList( ListIntersection list, ListIntersection list2) {
		
		Node n1 = list.head;
		Node n2 = list2.head;
		ListIntersection list3 = new ListIntersection();
		int carr = 0;
		while ( n1 != null && n2 != null ) {
			int sum  = n1.getId() + n2.getId() + carr;
			int rem  = sum%10 == 1? 0: sum%10;
			if (list3.head == null) {
				System.out.println(rem+"SUM VALUE");
				Node node = list3.create(rem);
				list3.head = node;
			} else {
				System.out.println(rem+"SUM VALUE");
				Node node = list3.create(rem);
				node.setNext(list3.head);
				list3.head = node;
			}
			carr = sum/10;			
			n1 = n1.getNext();
			n2 = n2.getNext();
		}
		
		while (n1 != null) {
			int  sum  = n1.getId() + carr;
			int  rem = sum%10 == 1? 0: sum%10;
			Node node = list3.create(rem);
			node.setNext(list3.head);
			list3.head = node;
			carr = sum/10;
			n1 = n1.getNext();
		}
		
		while (n2 != null) {
			int  sum  = n2.getId() + carr;
			int  rem = sum%10 == 1? 0: sum%10;
			Node node = list3.create(rem);
			node.setNext(list3.head);
			list3.head = node;
			carr = sum/10;
			n2 = n2.getNext();
		}
		
		list3.print();
	}


	private void reverse(Node curx, Node cury, Node prevx, Node prevy) {	
	
		prevx.setNext(cury);
		prevy.setNext(curx);
		Node tempx = curx.getNext();
		Node tempy = cury.getNext();
		cury.setNext(tempx);
		curx.setNext(tempy);
		
	}
	

	public void mergeTowLinkedList(ListIntersection list1, ListIntersection list) {
		
		Node n1 = list.head;
		Node n2 = list1.head;
		Node node = null;
		ListIntersection list2 = new  ListIntersection();
		
		while (n1 != null && n2 != null) {
			
			if (n1.getId() <= n2.getId() ) {
				
				node = list2.create(n1.getId());
				n1 = n1.getNext();
			}
			else if (n1.getId() >= n2.getId() ) {
				node = list2.create(n2.getId());
				n2 = n2.getNext();
			}
			
			if (list2.head == null) {
				list2.head = node;
			} else {
				node.setNext(list2.head);
				list2.head = node;
			}
		}
		
		while (n1 != null) {
			node = list2.create(n1.getId());
			node.setNext(list2.head);
			list2.head = node;
			n1 = n1.getNext();
			
		}
		while (n2 != null) {
			node = list2.create(n2.getId());
			node.setNext(list2.head);
			list2.head = node;
			n2 = n2.getNext();
			
		}
		
		list2.print();
		
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
		System.out.print("Enter Total Node -:");
		try {
			int count = sc.nextInt();
			for (int i = 0; i <count;  i++) {
				System.out.print("ENTER ELEMENT NUMBER -:");
				int element = sc.nextInt();
				Node node = list1.create(element);
				list1.conect(node);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.print(e);
			System.exit(1);
		}	
//		list.print();
//		list1.print();
		// list.intersection(list, list1);
//		list.union(list, list1);
//		list1.print();
//		list.swapNode(list);
//		list.swapPairWise(list);
//		list.deleteRighNodeHigher(list);
		list.addTwoList(list1, list);
		//list.mergeTowLinkedList(list1, list);
		sc.close();	
		
	}

	private void swapPairWise(ListIntersection list) {
		
		Node nx = list.head;
		Node ny = list.head.getNext();
		
		while (ny.getNext() != null) {
			this.swap(nx, ny);
			nx = nx.getNext();
			ny = ny.getNext();
		}
		
	}


	private void swap(Node nx, Node ny) {
		
	}
}
