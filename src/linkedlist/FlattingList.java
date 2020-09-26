package linkedlist;

import java.util.Scanner;

public class FlattingList {
	private FlatNode head;
	
	public FlatNode create(int id) {
		
		FlatNode  node = new FlatNode(id, null, null);
		return node;
	}
	
	public void print() {
		FlatNode node = this.head;
		while ( node != null ) {
			FlatNode nNode = node;
			FlatNode vNode = node.getvNode();
			int minV = nNode.getId();
			while ( nNode != null ) {
				if (minV >= nNode.getId()) {
					minV = nNode.getId();
					nNode.setId(9999999);
				}
				nNode = nNode.getNextNode();
			}
			while ( vNode != null ) {
				if (minV >= vNode.getId()) {
					minV = vNode.getId();
					vNode.setId(9999999);
				}
				vNode = vNode.getNextNode();
			}
			System.out.println(minV+"==================MINVALUE+++++++++++++++++");
			node = node.getNextNode();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Linked List Operation
		FlattingList list = new FlattingList();
		FlatNode node0  = list.create(5);
		FlatNode node1 = list.create(3);
		FlatNode node2 = list.create(7);
		FlatNode node3 = list.create(49);
		FlatNode node4 = list.create(11);
		FlatNode node5 = list.create(90);
		FlatNode node6 = list.create(34);
		FlatNode node7 = list.create(56);
		FlatNode node8 = list.create(90);
		FlatNode node9 = list.create(45);
		FlatNode nod10 = list.create(22);
		FlatNode nod11 = list.create(21);
		FlatNode nod12 = list.create(34);
		FlatNode nod13 = list.create(21);
		FlatNode nod14 = list.create(122);
		node0.setNextNode(node1);
		node1.setNextNode(node2);
		node2.setNextNode(node3);
		node3.setNextNode(node4);
		node4.setNextNode(node5);
		list.head = node0;
		node0.setvNode(node6);
		node1.setvNode(node7);
		node2.setvNode(node8);
		node3.setvNode(node9);
		node4.setvNode(nod10);
		node6.setNextNode(nod11);
		node7.setNextNode(nod12);
		node8.setNextNode(nod13);
		node9.setNextNode(nod14);
		list.print();
		
		
	}
}
