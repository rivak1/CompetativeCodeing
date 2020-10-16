package doublylinkedlist;
import java.util.Scanner;
public class PriorityQuee {

	private DNode head;
	private DNode tail;
	
	DNode create(int value, DNode next, DNode prev) {
		DNode node = new DNode( value, next, prev );
		node.setId(value);
		node.setNext(next);
		node.setPrev(prev);
		return node;
	}
	
	public void connectNodes(DNode node) {
		
		if (this.head == null & this.tail == null) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.setNext(node);
			node.setPrev(this.tail);
			this.tail = node;
		}
	}
	
	private void printHead() {
		DNode temp = this.head;
		while ( temp != null ) {
			System.out.println("NEXT-VALUE-------->"+temp.getId());
			temp = temp.getNext();
		}		
	}
	private void printTail() {
		DNode temp1 = this.tail;
		while ( temp1 != null ) {
			System.out.println("NEXT-VALUE-------->"+temp1.getId());
			temp1 = temp1.getPrev();
		}
	}
	
	public DNode peek() {
		DNode temp = this.head;
		int max = 999;
		DNode prev = null;
		DNode next = null;
		DNode maxNode = null;
		while (temp != null) {
			if (max > temp.getId())
			{
				max = temp.getId();
				maxNode = temp;
			}
			temp = temp.getNext();
		}
		System.out.println(maxNode.getId()+"POP PRIORTY NODE");
		return maxNode;
	}
	
	public DNode pop() {
		DNode temp = this.head;
		int max = 999;
		DNode prev = null;
		DNode next = null;
		DNode maxNode = null;
		while (temp != null) {
			if (max > temp.getId())
			{
				max = temp.getId();
				maxNode = temp;
			}
			temp = temp.getNext();
		}
		System.out.println(maxNode.getId()+"POP PRIORTY NODE");
		prev = maxNode.getPrev();
		next = maxNode.getNext();
		if (prev == null) {
			this.head = next;
			next.setPrev(null);
		} else if ( next == null ) {
			prev.setNext(next);
			
		} else {
			prev.setNext(next);
			next.setPrev(prev);
		}
		return maxNode;
	}
	

	
	public static void main(String[] args) {
		PriorityQuee list1 = new PriorityQuee();
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER TOTAL NODE FOR 1 -: ");
		int count = sc.nextInt();
		while (count != 0) {
			System.out.println("ENTER TOTAL NODE VALUE -: ");
			int id = sc.nextInt();
			list1.connectNodes(new DNode(id, null, null));
			count--;
		}
		list1.printHead();
		list1.pop();
		list1.printHead();
		sc.close();
	}

}
