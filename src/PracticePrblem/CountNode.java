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
	
}
