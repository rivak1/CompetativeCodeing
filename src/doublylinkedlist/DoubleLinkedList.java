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
		//list.reverse(list);
		//list.cloneList(list);
		//list.swapKElemetn(list);
		//list.findSum(list);
		//list.findSumLessCom(list);
		list.insetNodeInSorted(list);
		System.out.println("========================================");
		list.print();
		sc.close();
	}

	private void insetNodeInSorted(DoubleLinkedList list) {
		DNode node = list.head;
		int k = 1;
		while (node.getNext() != null ) {
			
			if ( node.getId() > k ) {
				DNode temp = list.create(k, null, null);
				DNode prev = null;
				prev = node.getPrev();
				prev.setNext(temp);
				temp.setNext(node);
				temp.setPrev(prev);
				node.setPrev(temp);
				break;
				
			}
			
			node = node.getNext();
		}
	}

	@SuppressWarnings("unused")
	private void findSumLessCom(DoubleLinkedList list) {
		DNode start = list.head;
		DNode end   = list.head;
		int k = 5;
		
		while (end.getNext() != null) {
			end = end.getNext();
		}
		
		while (start != null && end != null && start != end && end.getNext() != start) {	
			System.out.println("----------------------------");
			if (start.getId() + end.getId() == k) {
				System.out.println(start.getId()+"()"+end.getId());
				start = start.getNext();
				end   = end.getPrev();
			}
			else {
				
				if(start.getId() + end.getId() > k ) {
					end = end.getPrev();
				} else {
					start = start.getNext();
				}
			}
		}
		
	}

	@SuppressWarnings("unused")
	private void findSum(DoubleLinkedList list) {
		int k = 7;
		DNode temp = list.head;
		while (temp != null) {
			DNode temp1 = list.head;
			while (temp1 != null) {
				
				int sum = temp.getId() + temp1.getId();
				if (sum == k) {
					System.out.println("Match Param Are ( "+temp.getId()+" , "+ temp1.getId()+" )");
				}
				temp1 = temp1.getNext();
			}
			temp = temp.getNext();
		}
	}

	@SuppressWarnings("unused")
	private void swapKElemetn(DoubleLinkedList list) {
		int count = 1;
		int k = 5;
		int bnodeCount;
		DNode loopCounter = list.head;
		while (loopCounter != null ) { 
			count++;
			loopCounter = loopCounter.getNext();
		}
		bnodeCount = count - k;
		DNode swapCounter = list.head;
		DNode fNode = null;
		DNode bNode = null;
		int loop = 1;
		while ( swapCounter != null ) {
			if(loop == k) {
				fNode = swapCounter;
			}
			if (loop == bnodeCount) {
				bNode = swapCounter;
			}
			loop++;
			swapCounter = swapCounter.getNext();
		}
		fNode.getPrev().setNext(bNode);
		bNode.getPrev().setNext(fNode);
		DNode tempf = fNode.getNext();
		DNode tempb = bNode.getNext();
		fNode.setNext(tempb);
		bNode.setNext(tempf);	
		System.out.println(fNode.getId()+"IDIDIDI"+bNode.getId());

	}

	@SuppressWarnings("unused")
	private void cloneList(DoubleLinkedList list) {
		DNode node = list.head;
		while ( node != null ) {
			node.setNext(list.create(node.getId(), node.getNext(), node.getPrev()));
			node = node.getNext().getNext();
		}
		
		// Extract The Original From Clone
		DNode clone = list.head;
		while ( clone != null ) {
			clone.setNext(clone.getNext().getNext());
			clone = clone.getNext();
		}	
		
	}

	@SuppressWarnings("unused")
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
