package doublylinkedlist;

public class DNode {
	private DNode next;
	private DNode prev;
	private int id;
	public DNode( ) {
		this.next = null;
		this.prev = null;
	}
	
	public DNode(int id, DNode prev, DNode next) {
		super();
		this.next = next;
		this.prev = prev;
		this.id = id;
	}

	public DNode getNext() {
		return next;
	}
	public void setNext(DNode next) {
		this.next = next;
	}
	public DNode getPrev() {
		return prev;
	}
	public void setPrev(DNode prev) {
		this.prev = prev;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
