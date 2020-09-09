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
		
		list.print();
		Node deleteNode = list.head;
		Node obj = deleteobj.deleteNodeByID(3, deleteNode);
		list.head = obj == null? list.head: obj; 
		list.print();
	}

}
