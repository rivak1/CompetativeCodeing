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
		default:
			break;
		}	
		countNodeObj.print(countNodeObj.head);
		sc.close();
		
	}

	private void createOperation(int totalNode, CountNode countNodeObj, PracticeResult pc) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < totalNode; i++) {
			System.out.print("Enter Node Id :-");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Node Name :-");
			String name = sc.nextLine();
			System.out.println();
			SNode node = pc.create(id, name);
			pc.connect(node, countNodeObj);
		}	
		sc.close();
	}

}
