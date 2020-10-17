package circularlist;
public class CNode {
	
	private int id;
	private CNode next;
	
	public CNode() {
		this.next = null;
	}
	
	public CNode(int id, CNode next) {
		this.id = id;
		this.next = next;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public CNode getNext() {
		return next;
	}
	
	public void setNext(CNode node) {
		this.next = node;
	}
}
