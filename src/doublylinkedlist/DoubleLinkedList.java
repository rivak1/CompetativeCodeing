package doublylinkedlist;

import java.util.Scanner;
public class DoubleLinkedList {
	
	private DNode head;
	private DNode tail;
	
	DNode create(int value, DNode next, DNode prev) {
		
		DNode node = new DNode( value, next, prev );
		node.setId(value);
		node.setNext(next);
		node.setPrev(prev);
		return node;
	}
	
	public void connectNodes( DNode node ) {
		boolean flag = false;
		if (this.head == null && this.tail == null) {
			this.head = node;
			this.tail = node;
		} else {
			DNode temp = this.head;
			while (temp.getNext() != null) {		
				if (temp.getId() > node.getId()) {
					flag = true;
					break;
				}
				temp = temp.getNext();
			}
		if (temp.getId() > node.getId()) {
			flag = true;
		}
		if (flag) {
			if ( temp.getPrev() == null ) {
				this.head = node;
				temp.setPrev(node);
				node.setNext(temp);
			} else {
				temp.getPrev().setNext(node);
				node.setPrev(temp.getPrev());
				node.setNext(temp);
				temp.setPrev(node);
			}
		} else {
		node.setPrev(temp);
		temp.setNext(node);
		this.tail = node;
		}
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
	
	
	@SuppressWarnings("unused")
	private void print() {
		
		DNode temp = this.head;
		
		while ( temp != null ) {
			System.out.println("NEXT-VALUE-------->"+temp.getId());
			temp = temp.getNext();
		}
		
	}
	
	public static void main(String[] args) {
		
		DoubleLinkedList list1 = new DoubleLinkedList();
		DoubleLinkedList list2 = new DoubleLinkedList();
		Scanner sc = new Scanner(System.in);
		System.out.println("ENTER TOTAL NODE FOR 1 -: ");
		int count = sc.nextInt();
		while (count != 0) {
			System.out.println("ENTER TOTAL NODE VALUE -: ");
			int id = sc.nextInt();
			list1.connectNodes(new DNode(id, null, null));
			count--;
		}

//		System.out.println("ENTER TOTAL NODE FOR 2-: ");
//		int count1 = sc.nextInt();
//		while (count1 != 0) {
//			System.out.println("ENTER TOTAL NODE VALUE -: ");
//			int id = sc.nextInt();
//			list2.connectNodes(new DNode(id, null, null));
//			count1--;
//		}
		
		
		//list.print();
		//list.deleteNode(list);
		//list.reverse(list);
		//list.cloneList(list);
		//list.swapKElemetn(list);
		//list.findSum(list);
		//list.findSumLessCom(list);
		//list.insetNodeInSorted(list);
		//list.deleteNodeFromList(list);
		//list.countTriplet(list);
		//list.removeDuplicate(list);
        //list.deleteOccursOfElement(list);
		//list1.sumUsingDoublyLinkedList(list1, list2);
		//list1.multiplyUsingDoublyList(list1,list2);
		//list1.rotateListByNNode(list1);
		//list1.fondSplit();
		list1.head = list1.reverseOnSize(list1, list1.head);
		list1.print();
		sc.close();
	}
	
	
	private DNode reverseOnSize(DoubleLinkedList list1, DNode node) {
		int k = 3;
		int count = 0;
		DNode next = null;
		DNode prev = null;
		while (count != k && node != null) {
			next = node.getNext();
			node.setNext(prev);
			node.setPrev(next);
			prev = node;
			node = next;
			count ++;
		}
		if (node != null && node.getNext() != null) {
			DNode temp = prev;
			System.out.println(prev.getPrev().getId()+"===============");
			temp.setNext(reverseOnSize(list1, node));
		} 
		return prev;
	}

	private void fondSplit() {
		String str = "{sssssssssssssssssssssssssss}";
		String v1 = str.split("\\{",2)[1];
		String v2[] = v1.split("\\}");
		System.out.println(v1+"------------"+v2[0]);
	}

	@SuppressWarnings("unused")
	private void rotateListByNNode(DoubleLinkedList list1) {
		int n = 4;
		System.out.println(tail.getPrev().getNext()+"-------------------");
		for (int i = 0; i < n; i++) {
			DNode node = list1.head;
			DNode tail = list1.tail;
			list1.tail = tail.getPrev();
			tail.getPrev().setNext(null);
			tail.setNext(node);
			node.setPrev(tail);
			tail.setPrev(null);
			list1.head = tail;
			System.out.println("-----------------------------_AFTER ROATE"+i);
			list1.print();
		}
		
	}

	@SuppressWarnings("unused")
	private void sumUsingDoublyLinkedList(DoubleLinkedList list1, DoubleLinkedList list2) {
		DNode A = list1.tail;
		DNode B = list2.tail;
		int   C = 0;
		while (A != null || B != null) {
			
			if ( A != null && B != null ) {
				System.out.print((A.getId() + B.getId() + C)%10);
				C = (A.getId() + B.getId() + C) / 10;
				A = A.getPrev();
				B = B.getPrev();
			}
			else if(A==null && B != null) {
				System.out.print((B.getId() + C)%10);
				C = (B.getId() + C) / 10;
				B = B.getPrev();	
			}
			else if(A != null && B == null) {
				System.out.print((A.getId() + C)%10);
				C = (A.getId() + C) / 10;
				A = A.getPrev();	
			}
		}
		if (C > 0)
		 System.out.print(C);
	}

	@SuppressWarnings("unused")
	private void deleteOccursOfElement(DoubleLinkedList list) {
		DNode node = list.head;
		int k = 1;
		while (node.getNext() != null) {
			if ( k == node.getId() ) {
				DNode prev = node.getPrev();
				DNode next = node.getNext();
				if ( prev == null ) {
					list.head = next;
					next.setPrev(null);
					node = next;
				}else {
					prev.setNext(next);
					next.setPrev(prev);
					node = next;
				}
			} else {
				node = node.getNext();
			}
		}
		if (node.getNext() == null && node.getId() == k) {
			DNode prev = node.getPrev();
			if (prev == null) {
				list.head = null;
			} else {
				prev.setNext(null);
			}
		}
	}

	@SuppressWarnings("unused")
	private void removeDuplicate(DoubleLinkedList list) {
		
		DNode node = list.head;
		while (node.getNext() != null) {
			int k = node.getId();
			DNode next = node.getNext();
			if (k == next.getId()) {
				System.out.println("DUPLICATE-Id------------"+next.getId());
				
				node.setNext(next.getNext());
				if (next.getNext()!= null) {
					next.getNext().setPrev(next.getPrev());
				}
			} else {
			node = node.getNext();
		 }
		}
	}

	@SuppressWarnings("unused")
	private void countTriplet(DoubleLinkedList list) {
		DNode prev  = list.head;
		DNode next  = list.head;
		DNode prev1 = null;
		int k =15;
		
		while (prev.getNext() != null) {
			prev = prev.getNext();
			prev1 = prev.getPrev();
		}
		
		for (DNode current = prev; current != null; current = current.getPrev()) {
			prev = current.getPrev();
			while (next != null && prev != null &&  prev.getNext() != next && prev != next) {
				int sum = prev.getId() + next.getId() + prev1.getId();
				if ( sum == k) {
					System.out.println("("+prev.getId()+", "+prev1.getId()+", "+next.getId()+")");
					next = next.getNext();
					prev1 = prev.getPrev();
				}
				
				if (sum > k) {
					prev1 = prev1.getPrev();
				} else {
					next = next.getNext();
				}
			}
		}
	}

	@SuppressWarnings("unused")
	private void deleteNodeFromList(DoubleLinkedList list) {
		DNode node = list.head;
		int d = 3;
		while (node != null) {
			
			if ( node.getId() == d ) {
				DNode prev = node.getPrev();
				prev.setNext(node.getNext());
				node.setPrev(prev);
				break;
			}
			
			node = node.getNext();
		}
	}

	@SuppressWarnings("unused")
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
	private DNode reverse1(DNode node, DNode temp1) {
		DNode next = null;
		DNode prev = null;
		while (node.getId() != temp1.getId()) {
			next = node.getNext();
			node.setNext(prev);
			node.setPrev(next);
			prev = node;
			node = next;
		}
		return prev;
	}	
}
