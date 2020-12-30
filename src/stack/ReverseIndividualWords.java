package stack;

import java.util.Scanner;

public class ReverseIndividualWords {

	public static void main(String[] args) {
		ReverseIndividualWords riw = new ReverseIndividualWords();
		System.out.println("Enter The Words :-");
		Scanner sc = new Scanner(System.in);
		String words = sc.nextLine();
		riw.reverseIndividualWords(words);
		sc.close();
	}

	private void reverseIndividualWords(String words) {
		StackOperations stack = new StackOperations();
		for (int i = 0; i < words.length(); i++) {
			if (words.charAt(i) != ' ') {
				stack.push(stack.creataSpace(words.charAt(i)));
			} else {
				stack.push(stack.creataSpace(','));
			}
		}
		String sb = "";
		String sb1 = "";
		while (stack.top != null) {
			
			if (stack.peak().getInfixChar() != ',') {
				if (sb == null) {
					System.out.println("sb null");
				}
				sb = sb + stack.peak().getInfixChar();
			} else {
				System.out.println("value is 1"+sb);
				sb1 = sb +" "+ sb1;
				sb = null;
				System.out.println(sb+"after null");
			}
			stack.pop();
		}
		System.out.println(sb1+"value is");
		System.out.println("https://ca8197c029f8.ngrok.io/pm3API/asp/PMWeb4?DLsession=908bi3qs4s7hsjc5vqs40p659v126158".split("pm3API/")[0]);
		
	}

}
