package stack;

import java.util.Scanner;

public class Countsubarrays {

	public static void main(String[] args) {
		Countsubarrays csa = new Countsubarrays();
		Scanner sc = new Scanner(System.in);
		String value = sc.nextLine();
		csa.findSubArryaElement(value.split(","));
		String[] app = "https://eb6871d970ac.ngrok.io/pm3API/asp/PMWeb4?DLsession=t8ffrpi38r42i3f98hcnaereig126178".split("/");
		System.out.println();
		sc.close();		
	}
	
	private void findSubArryaElement(String[] strings) {
		int [] values = new int[strings.length];
		for (int i = 0; i < strings.length; i++) {
			values[i] = Integer.parseInt(strings[i]);
		}
		
		int [] prevBig = new int[strings.length];
		int [] nextBig = new int[strings.length];
		
		this.prevBig(prevBig, prevBig.length,values);
		this.nextBig(nextBig, prevBig.length,values);
		
		int [] maxi = new int[strings.length];
		
		for (int i = 0; i < maxi.length; i++) {
			if (nextBig[i] != -1) {
				maxi[nextBig[i] - i] = Math.max( maxi[ nextBig[i] - i ], i - prevBig[i] );
			}
		}
		
		for (int i = 0; i < maxi.length; i++) {
			System.out.println("maxi"+maxi[i]);
		}
		
		int ans=0;
		for (int i = 0; i < maxi.length; i++) {
			ans += maxi[i];
		}
		System.out.println("Count No Of Saving"+ans);
	}

	private void nextBig(int[] nextBig, int n, int[] values) {
		StackOperations stack = new StackOperations();
		for (int i = 0; i < values.length; i++) {
			nextBig[i] = -1;
			while(stack.top != null && values[stack.top.getData()] < values[i]) { 
				nextBig[stack.top.getData()] = i;
				stack.pop();
			}
			stack.push(stack.creataSpace(i));
		}
	}

	private void prevBig(int[] prevBig, int n, int[] values) {	
		StackOperations stack = new StackOperations();
		for (int i = 0; i < values.length; i++) {
			prevBig[i] = -1;
			while(stack.top != null && values[stack.top.getData()] > values[i]) { 
				prevBig[i] = stack.top.getData();
				stack.pop();
		}
			stack.push(stack.creataSpace(i));
		}
	}

}
