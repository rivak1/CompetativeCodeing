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
			System.out.println("LAST STEP"+node);
			return false;
		}
		
		if ( node.getId() != element ) {
			System.out.println( node.getId() +"Node id");
			return searchRecursive(node.getNext(), element);
		}
		System.out.println("LAST STEP"+node);
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
}
