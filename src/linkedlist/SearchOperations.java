package linkedlist;

public class SearchOperations {

	/**
	 * 
	 * @param node
	 * @param element
	 * @return
	 */
	public boolean searchIterative(Node node, int element) {
		while ( node.getNext() != null ) {
			if ( node.getId() == element ) {
				return true;
			} 
			node = node.getNext();
		}
		return false;
	}

	/**
	 * 
	 * @param node
	 * @param element
	 * @return
	 */
	public boolean searchRecursive( Node node, int element ) {
		
		if ( node == null ) {
			//System.out.println("LAST STEP"+node);
			return false;
		}
		
		if ( node.getId() != element ) {
			//System.out.println( node.getId() +"Node id");
			return searchRecursive(node.getNext(), element);
		}
		//System.out.println("LAST STEP"+node);
		return true;
	}
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public Node getNthNode( Node node ) {
		
		while ( node.getNext() != null ) {
			
			node = node.getNext();
		}
		return node;
	}
	
	public Node reverseLinkedList( Node node ) {
		System.out.println("WE ARE");
		Node dummy = null;
		Node prev = null;
		Node newnode = null;
		while ( node.getNext() != null) {		
			dummy = node;
			while  (dummy.getNext() != null) {
				prev = dummy;
				dummy = dummy.getNext();
			}
			
			if (prev != null && prev.getNext() != null) {
				prev.setNext(null);
			}
			
			if (newnode == null) {
				newnode = dummy;
			}
			else {
				Node newone = null;
				newone = newnode;
				while (newone.getNext() != null) {
					newone = newone.getNext();
				}
				newone.setNext(dummy);
			}
		}
		Node newmake = newnode;
		while (newmake.getNext()!=null) {
			newmake = newmake.getNext();
		}
		newmake.setNext(prev);
		return newnode;
		
	}
	
	public Node reverseLinkedList1( Node node ) {		
		Node prev = null;
		Node current = node;
		Node next = null;
		
		while (current != null ) {
			//1-2-3-4-5
			// System.out.println("START VALUE OF CURRENT"+current.getId());
			// System.out.println("VALUE OF PREVIOUS"+prev.getId());
			next = current.getNext();
			// System.out.println("VALUE OF NEXT"+next.getId());
			current.setNext(prev);
			prev = current;
			// System.out.println("VALUE OF CURRENT OF NEXT"+current.getNext().getId());
			current = next;
			// System.out.println("END VALUE OF CURRENT"+current.getId());
		}
		
		return prev;
	}
	
	public Node getNthNodeFromEnd(Node node, int pos) {
		
		if (node == null) {
			return null;
		}
		
		if (pos == 0) {
			return node;
		} else {
			pos--;
			System.out.println(pos+"POSITION");
			return getNthNodeFromEnd(node.getNext(), pos);
		}
		
	}
	
	public Node getNthNodeFromEnd1(Node node, int pos) {
		
		Node ref = node;
		Node move = node;
		int count = 0;
		while (count != pos) {
			//System.out.println(count+"TOTAL COUNT");
			count++;
			move = move.getNext();
		}
		
		while (ref.getNext() != move) {
			ref = ref.getNext();
		}
		
		return ref;
	}

	
	public int totalIntegerInNode(Node node, int element) {
		int count = 0;
		while ( node != null ) {
			
			if ( node.getId() == element ) {
				count++;
			}
			node  = node.getNext();
		}
		
		return count;
	}
	
	public int totalIntegerInNodeRecursion( Node node, int element ) {
		int count = 0;
		if (node != null) {
			if (node.getId() == element) {
				count++;
			}
				
			count = count + totalIntegerInNodeRecursion(node.getNext(), element);
		}
		return count;
	}
	
	public Node countMaximumElement( Node node ) {
		Node loop1 = node;
		@SuppressWarnings("unused")
		int max = -1;
		@SuppressWarnings("unused")
		int value = 0;
		int prevCount = 0;
		Node maxNode = null;
		while ( loop1 != null ) {
			int count = 0;
			Node loop2 = node;	
			while ( loop2 != null ) {
				if ( loop1.getId() == loop2.getId() ) {
					count++;
				}
				loop2 = loop2.getNext();
			}
			if ( prevCount < count ) {
				max = loop1.getId();
				maxNode = loop1;
				prevCount = count;
			}
			loop1 = loop1.getNext();
		}
		return maxNode;
		
	}
	
	public Node findLoopInNode( Node node ) {
		Node dnode = node.getNext();
		Node snode = node;
		while ( dnode != null  && dnode.getNext() != null && snode != null ) {
			if ( dnode == snode ) {
				System.out.println("LENGTH OF LOOP"+countLengthOfLoop(snode, node));
				return dnode;
			}
			dnode = dnode.getNext().getNext();
			snode = snode.getNext();
		}
		
		return dnode;
	}
	
	public int countLengthOfLoop( Node snode, Node node ) {
		int count = 0;
		
		while (snode != node) {
			count++;
			node = node.getNext();
		}
		return count;
	}
	
	public Node makemiddleNodeAsHead( Node node ) {
		Node central = node;
		Node prev = node;
		Node doubleNode = node; 
		while (doubleNode != null && doubleNode.getNext() != null && central != null) {
			prev = central;
			central = central.getNext();
			doubleNode = doubleNode.getNext().getNext();
		}
		prev.setNext(central.getNext());
		System.out.println(central.getId());
		
		central.setNext(node);
		return central;
	}
	
	public Node rotateListByK( Node node, int k ) {
		Node rnode = null;
		for (int i=0; i < k; i++) {
			Node pointerF = node;
			rnode = node;
			Node prev = null;
			while ( rnode.getNext() != null ) {
				prev  =  rnode;
				rnode = rnode.getNext();
			}
			prev.setNext(null);
			System.out.println(rnode.getId());
			rnode.setNext(pointerF);
			node = rnode;
		}
		return rnode;
	}
	
	public Node rotateListByKAndBlock( Node node, int block, int rotation ) {
		for (int i = 0; i < rotation; i++) {
			Node startPointer = node;
			Node prevpointer = node;
			Node blocknode = node;
			int cblock = block;
			
			while (cblock > 1 && blocknode.getNext() != null) {
				cblock--;
				prevpointer = blocknode;
				blocknode = blocknode.getNext();
			}
			System.out.println(prevpointer.getId()+" END POINTER");
			prevpointer.setNext(blocknode.getNext());
			blocknode.setNext(startPointer);
			node = blocknode;
		}
		return node;
	}
	
	public Node insertNodeAfterNthNode( Node node , int nthposition, Node inserNode ) {
		
		Node refpointer = node;
		Node movepointer = node;
		
		while (refpointer != null && nthposition != 0) {
			nthposition--;
			refpointer = refpointer.getNext();
		}
		
		while (refpointer != null) {
			refpointer = refpointer.getNext();
			movepointer = movepointer.getNext();
		}
		inserNode.setNext(movepointer.getNext());
		movepointer.setNext(inserNode);
		
		return node;
	}
	public Node insertNodeBeforeNthnode( Node node , int nthposition, Node inserNode ) {
		
		Node refpointer = node;
		Node movepointer = node;
		Node moveprevious = null;
		
		while (refpointer != null && nthposition != 0) {
			nthposition--;
			refpointer = refpointer.getNext();
		}
		
		while (refpointer != null) {
			moveprevious = movepointer;
			refpointer = refpointer.getNext();
			movepointer = movepointer.getNext();
		}
		moveprevious.setNext(inserNode);
		inserNode.setNext(movepointer);
		return node;
	}

	public Node insertNodeMiddleNode(Node node, Node create) {
		
		Node getMiddle = node;
		Node doubleNode = node;
		while ( doubleNode!=null && doubleNode.getNext() != null ) { 	
			getMiddle = getMiddle.getNext();
			doubleNode = doubleNode.getNext().getNext();
		}
		create.setNext(getMiddle.getNext());
		getMiddle.setNext(create);
		return getMiddle;
	}
}
