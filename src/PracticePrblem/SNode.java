package PracticePrblem;

public class SNode {
	
	private String name;
	private int id;
	private SNode next;
	
	public SNode(String name, int id, SNode next) {
		super();
		this.name = name;
		this.id = id;
		this.next = next;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SNode getNext() {
		return next;
	}
	public void setNext(SNode next) {
		this.next = next;
	}
	
	

}
