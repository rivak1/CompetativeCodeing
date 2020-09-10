package linkedlist;

public class SingleLinkedList {
	
	private Node head;
	
	public Node create(int id) {
		Node node = new Node(id, null);
		return node;
	}
	
	public void conect(Node node) {
		Node headCopy;
		if ( this.head == null ) {
			this.head = node;
		} else {
			headCopy = this.head;
			while( headCopy.getNext() != null ) {
				headCopy = headCopy.getNext();
			}
			headCopy.setNext(node);
		}
		
	}
	
	public void print() {
		Node headCopy;
		if ( this.head == null ) {
			System.out.println(" NO ELEMENT FOUND ");
		}
		headCopy = this.head;
		while( headCopy != null ) {
			System.out.println("VALUE----"+headCopy.getId());
			headCopy = headCopy.getNext();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Linked List Operation
		SingleLinkedList list = new SingleLinkedList();
		
		// TODO Delete Operation
		DeleteOperations deleteobj = new DeleteOperations();
		
		Node node = list.create(1);
		list.conect(node);
	
		Node node1 = list.create(2);
		list.conect(node1);
		
		Node node2 = list.create(3);
		list.conect(node2);

		
		Node node3 = list.create(4);
		list.conect(node3);
	
		Node node4 = list.create(5);
		list.conect(node4);
		
		Node node5 = list.create(6);
		list.conect(node5);
	
		Node node6 = list.create(7);
		list.conect(node6);
		
		list.print();
//		Node deleteNode = list.head;
//		Node obj = deleteobj.deleteNodeByID(3, deleteNode);
//		list.head = obj == null? list.head: obj; 
//		list.print();
		
		System.out.println(" AFTER DELETE NODE ");
//		Node centerNode = list.head;
//		deleteobj.deleteCenterNode(centerNode);
//		list.print();
		
//		Node firstNode = list.head;
//		list.head = deleteobj.deleteFirstNode(firstNode);
//		list.print();
		
		Node lasNode = list.head;
		deleteobj.deleteLastNode(lasNode);
		list.print();
		
		
	}

}
