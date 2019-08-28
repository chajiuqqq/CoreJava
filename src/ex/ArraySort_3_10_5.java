package ex;


import java.util.Arrays;
import java.util.Random;

public class ArraySort_3_10_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[200];
		Random aRandom=new Random();
		for (int i = 0; i < a.length; i++) {
			a[i]=aRandom.nextInt(100);
		}
		
		int k=10;
		int r=0;
		int[] out=new int[k];
		int n=a.length-1;
		for (int i = 0; i < out.length; i++) {
			r=aRandom.nextInt(n+1);
			out[i]=a[r];
			a[r]=a[n];
			n--;
		}
		System.out.println(Arrays.toString(out));
		//sort对原数组进行更改
		Arrays.sort(out);
		System.out.println(Arrays.toString(out));
		/**
		 * out:
		 * [88, 8, 63, 80, 1, 62, 89, 13, 23, 59]
		 * [1, 8, 13, 23, 59, 62, 63, 80, 88, 89]
		 */
	}

}
