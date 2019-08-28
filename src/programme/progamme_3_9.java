package programme;

public class progamme_3_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MAX=10;
		int[][] out=new int[MAX+1][];
		for (int i = 0; i < out.length; i++) {
			out[i]=new int[i+1];
		}
		for (int i = 0; i < out.length; i++) {
			for (int j = 0; j < out[i].length; j++) {
				int lottery=1;
				for (int k = 1; k <=j; k++) {
					lottery=lottery*(i-k+1)/k;
				}
				out[i][j]=lottery;
			}
		}
		
		for(int[] line:out) {
			for(int x:line) {
				System.out.printf("%4d",x);
			}
			System.out.println();
		}
		
	}

}
