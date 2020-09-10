package linkedlist;

public class FindLengthOFLinkedList {

	public int totalNodes(Node node) {
		int counter = 0; 
		while ( node != null ) {
			
			counter = counter + 1;
			node = node.getNext();
		}
		return counter;
	}
}
