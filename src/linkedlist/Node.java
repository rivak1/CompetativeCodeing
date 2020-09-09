package linkedlist;

public class Node {
	// TODO Node class where all info and next address store
	
	private int id;
	private Node next;
	
	public Node() {
		this.next = null;
	}
	
	public Node(int id, Node next) {
		this.id = id;
		this.next = next;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	

}
