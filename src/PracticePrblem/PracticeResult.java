package PracticePrblem;

import java.util.Scanner;

public class PracticeResult {
	
	private SNode create(int id, String name) {
		SNode node = new SNode(name, id, null);
		return node;
	}
	
	private void connect(SNode node, CountNode countNodeObj) {
		
		if ( countNodeObj.head == null ) {
			countNodeObj.head = node;
		} else {
			SNode temp = countNodeObj.head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PracticeResult pc = new PracticeResult();
		
		System.out.println("WE HAVE FOLLOWING OPERATION :-");
		System.out.println("1.COUNT NODE------2.Delete Node Without Head");
		System.out.println("3.Swap Group Node------ 4.Merger Sort In Single List");
		System.out.println("5. Delete Alternate---------6.Absolute List Sorting");
		System.out.println("7. Delete Node And Reverse--------8.List reorder");
		System.out.println("9.Even Or Odd");
		System.out.println("SELECT WHICH TYPE OF OPERATION YOU WANT :-");
		int operation = sc.nextInt();	
		System.out.println("YOUR OPERATION :-"+operation);
		
		System.out.println("Enter Number Of Node :-");
		int totalNode = sc.nextInt();
		CountNode countNodeObj = new CountNode();
		switch (operation) {
		case 1:
			pc.createOperation(totalNode, countNodeObj, pc);
			countNodeObj.countNodeRecursion(countNodeObj.head);
			countNodeObj.countTotalNode();
			break;
		case 2:
			pc.createOperation(totalNode, countNodeObj, pc);
			countNodeObj.deleteNodeWithNoHead1(countNodeObj.head);
			countNodeObj.compareRef(countNodeObj.head);
			break;
		case 3:
			pc.createOperation(totalNode, countNodeObj, pc);
			countNodeObj.swapNodeGroupWise(countNodeObj.head);
			break;
		case 4:
			pc.createOperation(totalNode, countNodeObj, pc);
			countNodeObj.head = countNodeObj.mergeSort(countNodeObj.head);
			break;
		case 5:
			pc.createOperation(totalNode, countNodeObj, pc);
			countNodeObj.deleteAlternate(countNodeObj.head);
			break;
		case 6:
			pc.createOperation(totalNode, countNodeObj, pc);
			countNodeObj.sortAbsoluteList(countNodeObj.head);
			break;
		case 7:
			pc.createCircularNode(totalNode, countNodeObj, pc);
			countNodeObj.deleteAndReverse(countNodeObj.head);	
			countNodeObj.printCircular(countNodeObj.head);
			break;
		case 8:
			pc.createOperation(totalNode, countNodeObj, pc);
			countNodeObj.head = countNodeObj.reorderlist(countNodeObj.head);
			System.out.println(countNodeObj.head.getId());
			break;
		case 9:
			pc.createOperation(totalNode, countNodeObj, pc);
			countNodeObj.segOddOrEven(countNodeObj.head);
			break;
		default:
			break;
		}	
		if (operation != 7) {
			countNodeObj.print(countNodeObj.head);
		}
		sc.close();
		
	}

	private void createCircularNode(int totalNode, CountNode countNodeObj, PracticeResult pc) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < totalNode; i++) {
			System.out.print("Enter Node Id :-");
			int id = sc.nextInt();
			System.out.println();
			SNode node = pc.create(id, "Rivak");
			pc.connectCircular(node, countNodeObj);
		}	
		sc.close();		
	}

	private void connectCircular(SNode node, CountNode countNodeObj) {
		if ( countNodeObj.head == null ) {
			countNodeObj.head = node;
			node.setNext(countNodeObj.head);
		} else {
			SNode temp = countNodeObj.head;
			while ( temp.getNext() != countNodeObj.head) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setNext(countNodeObj.head);
		}		
	}

	private void createOperation(int totalNode, CountNode countNodeObj, PracticeResult pc) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < totalNode; i++) {
			System.out.print("Enter Node Id :-");
			int id = sc.nextInt();
			System.out.println();
			SNode node = pc.create(id, "Rivak");
			pc.connect(node, countNodeObj);
		}	
		sc.close();
	}
	
	

}
