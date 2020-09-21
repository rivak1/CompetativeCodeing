package linkedlist;
import java.util.*;

public class SingleLinkedList {
	
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
	
	public static void main(String[] args) {
		// TODO Linked List Operation
		SingleLinkedList list = new SingleLinkedList();
		Scanner sc = new Scanner(System.in);
		SearchOperations searchObj = new SearchOperations();
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
//		Node loop = list.head;
//		Node ploop = null;
//		while (loop.getNext() != null) {
//			ploop = loop;
//			loop = loop.getNext();
//		}
//		loop.setNext(ploop);
		//Node searchNode = list.head; 
		//System.out.println(searchObj.searchIterative(searchNode,11)+"Result found");
		//Node searchRecursive = list.head; 
		//System.out.println(searchObj.searchRecursive(searchRecursive, 23)+"Result found");
		//System.out.println("RESULT FOUND:-> "+searchObj.getNthNode(searchNode).getId());
		//Node reverse = list.head;
		//list.head = searchObj.reverseLinkedList1(reverse);
		Node nthnode = list.head;
		//System.out.println(searchObj.getNthNodeFromEnd1(nthnode, 3).getId()+"NTH NODE");
		//System.out.println(searchObj.totalIntegerInNode(nthnode, 1)+"TOTAL COUNT");
		//System.out.println(searchObj.totalIntegerInNodeRecursion(nthnode, 1)+"TOTAL COUNT FROM RECURSION");
		//System.out.println("MAXIMUM ELEMENT ACCOUR IS :- "+searchObj.countMaximumElement(nthnode).getId());
		//System.out.println(" IS LOOP "+searchObj.findLoopInNode(nthnode).getId());
		//list.head = searchObj.makemiddleNodeAsHead(nthnode);
		//list.head = searchObj.rotateListByK(nthnode, 3);
		//list.head = searchObj.rotateListByKAndBlock(nthnode, 4, 3);
		list.head = searchObj.insertNodeBeforeNthnode(nthnode, 4, list.create(5));
		list.head = searchObj.insertNodeAfterNthNode(nthnode, 5, list.create(6));
		searchObj.insertNodeMiddleNode(nthnode,list.create(100));
		list.print();
		sc.close();	
		
	}

}
