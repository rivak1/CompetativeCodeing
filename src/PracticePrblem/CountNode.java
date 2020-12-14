package PracticePrblem;

public class CountNode {
	SNode head;
	
	public void countTotalNode() {
		int count = 0;
		SNode temp = this.head;
		while ( temp != null ) {
			count++;
			temp = temp.getNext();
		}
		System.out.println("Total Node In List NON RCURN"+count);
	}
	
	public int countNodeRecursion(SNode node) {
		int count = 0;
		if ( node != null ) {
			count++;
			count = count + countNodeRecursion(node.getNext());
		} 
		System.out.println("RECURSION NODE "+count);
		return count;
	}
	
	public void deleteNodeWithNoHead(SNode node) {
		int key = 3;
		
		while ( node != null ) {
			if ( node.getId() == key ) { break;}
			node = node.getNext();
		}
		System.out.println(node.getId()+"We Want to Delete This Node");
		
		SNode prev = null;
		while ( node.getNext() != null ) {
			prev = node;
			node.setId(node.getNext().getId());
			node = node.getNext();
		}
		prev.setNext(null);
	}

	public void deleteNodeWithNoHead1(SNode node) {
		int key = 3;
		
		while ( node != null ) {
			if ( node.getId() == key ) { break;}
			node = node.getNext();
		}
		System.out.println(node.getId()+"We Want to Delete This Node");
		
		node.setId(node.getNext().getId());
		node.setNext(node.getNext().getNext());
		
	}
	
	public void print( SNode node ) {
		if (node == null) {
			System.out.println("Stop yr....");
		}
		while (node != null) {
			System.out.println("Given Id :-"+node.getId());
			node  = node.getNext();
		}
	}
	
	public void compareRef(SNode node) {
		System.out.println(node == this.head);
	}

	public void swapNodeGroupWise(SNode node) {
		int k1 = 2;
		int k2 = 4;
		SNode prevK1 = null;
		SNode prevK2 = null;
		SNode curK1 = node;
		SNode curK2 = node;
		
		while (k1 != curK1.getId()) {	
			prevK1 = curK1;
			curK1 = curK1.getNext();
		}
		
		while (k2 != curK2.getId()) {
			prevK2 = curK2;
			curK2 = curK2.getNext();
		}
		
		if ( prevK1 == null ) {
			this.head = curK2;
		} else {
			prevK1.setNext(curK2);
		}
		
		if ( prevK2 == null ) {
			this.head = curK1;
		} else {
			prevK2.setNext(curK1);
		}

		SNode nextK2 = curK2.getNext();
		SNode nextK1 = curK1.getNext();
		curK2.setNext(nextK1);
		curK1.setNext(nextK2);
		
		System.out.println(curK2.getNext().getId());
	}

	public SNode mergeSort(SNode first) {
		
		if (first != null && first.getNext() != null) {
			SNode second = this.middleNode(first);
			first  = mergeSort(first);
			second = mergeSort(second);
			return this.mergeList(first, second);
			
		}
		return first;
	}

	private SNode mergeList(SNode first, SNode second) {
		
		if (first == null) {
			return second;
		}
		
		if (second == null) {
			return first;
		}
		
		if (first.getId() >= second.getId()) {
			second.setNext(mergeList(first, second.getNext()));
			return second;
			
		} 
		else if (second.getId() >= first.getId()) {
			first.setNext(mergeList(first.getNext(), second));
			return first;		
		} else {
			return null;
		}
		
	}

	private SNode middleNode(SNode head) {
		SNode slow = head;
		while (head.getNext() != null && head.getNext().getNext() != null) {
			head = head.getNext().getNext();
			slow = slow.getNext();
		}
		SNode temp = slow.getNext();
		slow.setNext(null);
		return temp;
	}

	public void deleteAlternate(SNode node) {
		while (node != null && node.getNext() != null) {
			node.setNext(node.getNext().getNext());
			node = node.getNext();
		}
	}

	public void sortAbsoluteList(SNode head) {
		while(head != null) {
			System.out.println("value of list :-"+head.getId());
			head = head.getNext();
		}
	}

	public void deleteAndReverse(SNode head) {
		int k = 2;
		SNode prev = null;
		while (head.getId() != k) {
			if (head.getNext() == this.head) {
				break;
			}
			prev = head;
			head = head.getNext();
		}
		if (prev == null) {
			this.head = head.getNext();
			head = head.getNext();
			while ( head.getId() != k ) {
				prev = head;
				head = head.getNext();
			}
			prev.setNext(this.head);
		}
		else {
			prev.setNext(head.getNext());
		}
		this.reverseCircular(this.head);
	}

	private void reverseCircular(SNode curr) {
		SNode prev = null;
		SNode next = null;
		int k = 2;
		SNode first = this.head;
		while (true) {
			next = curr.getNext();
			curr.setNext(prev);
			prev = curr;
			curr = next;		
			if (curr == this.head) {
				break;
			}
		}	
		first.setNext(prev);
		this.head = prev;
	}

	public void printCircular(SNode head) {
		while (true) {
			System.out.println(head.getId()+"Node Id");
			if (head.getNext() == this.head) {
				break;
			}
			head = head.getNext();
		}
		System.out.println(head.getNext().getId()+"Last Circular Node");
	}

	SNode LastNode(SNode head) {
		SNode prev = null;
        while (head.getNext() != null){
            prev  = head;
            head  = head.getNext();
        }
        System.out.println(prev.getId()+"prev");
        prev.setNext(null);
        return head;
    }
    
    SNode reorderlist(SNode head) {
    	SNode node = head;
    	SNode next = null;
    	SNode last = null;
    	long startTime = System.nanoTime();
  
        while (node != null && node.getNext() != null){ //1-2-3
        System.out.println("-------");
         System.out.println(node.getId());
         next = node.getNext(); //2,3,4
         last = LastNode(head);  // 3,2
         node.setNext(last); //1-next(6) 1-6-2-5-3
         if (last == next) {
        	break; 
         }
         last.setNext(next);
         //1-6-next(2) 1-6-2-5-3-4
         node = next; //2
        }
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime+"total time used");
        return head;
    }

	public void segOddOrEven(SNode head2) {
		SNode node = head;
		SNode even = null;
		SNode odd  = null;
		SNode evenPtr = null;
		SNode oddPtr = null;
		while (node != null){
		boolean flag = node.getId()%2==0? true: false;
		if (flag) {
			if (evenPtr == null){
				even = evenPtr = new SNode("rivak", node.getId(), null);
			} else {
			  evenPtr.setNext(new SNode("rivak", node.getId(), null));
			  evenPtr = evenPtr.getNext();
			}
		} else {
			if (oddPtr == null){
				odd = oddPtr = new SNode("rivak", node.getId(), null);
			} else {
			  oddPtr.setNext(new SNode("rivak", node.getId(), null));
			  oddPtr = oddPtr.getNext();
			}
		}
		node = node.getNext();
		}
		evenPtr.setNext(odd);
		this.head = even;
	}
	
}
