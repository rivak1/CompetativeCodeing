package linkedlist;

import java.util.Scanner;

public class FlattingList {
	private FlatNode head;
	
	public FlatNode create(int id) {
		
		FlatNode  node = new FlatNode(id, null, null);
		return node;
	}
	
	
	public static void main(String[] args) {
		// TODO Linked List Operation
		FlattingList list = new FlattingList();
		int arr[][] = { {1,2,3},{4,5,6},{7,8,9} };
		list.createMatrixList(arr);
		
		
	}

	private void createMatrixList(int[][] arr) {
		int i=0;
		int j=0;
		FlatNode head =  this.connectList(arr, arr.length, arr[0].length, i, j);
		this.head = head;
		this.print();		
	}


	private FlatNode connectList(int[][] arr, int length, int length2, int i, int j) {
		if ( i > length-1 || j > length2-1) { 
			return null;
		}
		FlatNode temp  = this.create(arr[i][j]);
		temp.setNextNode(connectList(arr, length, length2, i, j+1));
		temp.setvNode(connectList(arr, length, length2, i+1, j));
		return temp;
	}


	private void print() {
		FlatNode temp = this.head;
		while (temp != null) {
			FlatNode v = temp;
			while (v != null) {
				System.out.print(v.getId());
				v = v.getNextNode();
			}
			temp = temp.getvNode();
			System.out.println();
		}
	}

}
