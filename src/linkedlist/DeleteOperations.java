package linkedlist;

public class DeleteOperations {

	/**
	 * 
	 * @param id
	 * @param list 
	 * @return
	 */
	public Node deleteNodeByID(int id, Node node) {
		Node prev = null;
		
		if ( node == null ) {
			System.err.println("Node Is Empty");
			System.exit(0);
		}
		
		while( node != null ) {
			
			if ( node.getId() == id ) {
				
				if ( prev == null ) {
					// System.out.println("DeleteOperations.deleteNodeByID():IN PREVIOUS NULL STEP:- "+node.getId());
					node = node.getNext();
					return node;
					
				} else {
					prev.setNext(node.getNext());
					return null;
				}
				
			}
			prev = node;
			node = node.getNext();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Node deleteCenterNode(Node node) {
		
		int counter = 0;
		Node dummyCounter = node;
		Node doubleCounter = node;
		Node prev = node;
		boolean odd = true;
		while ( dummyCounter != null && doubleCounter != null && doubleCounter.getNext() != null && doubleCounter.getNext().getNext() != null ) { 
			
			counter  = counter  +  2;
			prev = dummyCounter;
			dummyCounter = dummyCounter.getNext();
			doubleCounter = doubleCounter.getNext().getNext();
		}
		
		if ( doubleCounter.getNext() == null ) {
			counter = counter - 1;
			odd = false;
		}
		
		if (odd) {
			prev.setNext(dummyCounter.getNext().getNext());
		} else {
			prev.setNext(dummyCounter.getNext());
		}
		
		return new Node();
	}
	
	/**
	 * 
	 * @return
	 */
	public Node deleteFirstNode(Node node) {
		return node.getNext();
	}

	/**
	 * 
	 * @return
	 */
	public Node deleteLastNode(Node node) {
		Node prev = node;
		while ( node.getNext() != null ) {
			prev = node;
			node = node.getNext();
		}
		prev.setNext(node.getNext());
		return prev;
	}
	
	
}
