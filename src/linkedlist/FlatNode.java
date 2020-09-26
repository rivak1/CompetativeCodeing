package linkedlist;

public class FlatNode {
	private int id;
	private FlatNode nextNode;
	private FlatNode vNode;
	
	
	public FlatNode() {
		this.nextNode = null;
		this.vNode = null;
	}
	
	
	public FlatNode(int id, FlatNode nextNode, FlatNode vNode) {
		super();
		this.id = id;
		this.nextNode = nextNode;
		this.vNode = vNode;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FlatNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(FlatNode nextNode) {
		this.nextNode = nextNode;
	}
	public FlatNode getvNode() {
		return vNode;
	}
	public void setvNode(FlatNode vNode) {
		this.vNode = vNode;
	}
}
