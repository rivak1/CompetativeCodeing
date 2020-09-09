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
		return new Node();
	}
	
	/**
	 * 
	 * @return
	 */
	public Node deleteFirstNode(Node node) {
		return new Node();
	}

	/**
	 * 
	 * @return
	 */
	public Node deleteLastNode(Node node) {
		return new Node();
	}
	
	
}
