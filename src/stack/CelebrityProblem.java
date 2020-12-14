package stack;

public class CelebrityProblem {

	public static void main(String args[]) {
		CelebrityProblem cp = new CelebrityProblem();
		int [][]knows = new int[4][4];
		knows[0][0] = 0;
		knows[0][1] = 1;
		knows[0][2] = 0;
		knows[0][3] = 0;
		knows[1][0] = 0;
		knows[1][1] = 0;
		knows[1][2] = 0;
		knows[1][3] = 0;
		knows[2][0] = 0;
		knows[2][1] = 1;
		knows[2][2] = 0;
		knows[2][3] = 0;
		knows[3][0] = 0;
		knows[3][1] = 1;
		knows[3][2] = 0;
		knows[3][3] = 0;
		int id = cp.findCelebrity(knows);
		int j = 3;
		int idegree[] = new int[4];
		int odegree[] = new int[4];
		cp.findCelebrity1(j, knows);
//		if (id == -1) {
//			System.out.println("No Celebrity Found");
//		} else {
//			System.out.println(id+"Celebrity Found");
//		}
	}

	private void findCelebrity1(int j, int[][] knows) {
		int i=0;
		while (i < j) {
			if (knows[i][j] == 1) {
				i++;
			} else {
				j--;
			}
		}
		
		boolean flag = true;
		for (int k = 0; k < knows.length-1; k++) {
			if (knows[j][k] == 1) {
				flag = false;
			}
		}
		if (flag) {
			System.out.println("Celebrity Is"+j);
		}
		
	}

	private int findCelebrity(int[][] knows) {
		int flagValue = 0;
		for (int i = 0; i < knows.length; i++) {
			flagValue = 0;
			for (int j = 0; j < knows.length; j++) {
				if (knows[i][j] == 1) {
					flagValue = -1;
					break;
				}
			}
			if (flagValue != -1) {
				System.out.println(i);
			}
		}
		return flagValue;
	}
}
