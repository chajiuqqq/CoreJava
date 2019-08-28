package ex;

import java.math.BigInteger;
import java.util.Scanner;

public class BigData_3_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inScanner=new Scanner(System.in);
		System.out.println("all?");
		int n=inScanner.nextInt();
		
		System.out.println("got?");
		int k=inScanner.nextInt();
		inScanner.close();
		/**
		 * compute
		 */
		BigInteger lotteryOdds=BigInteger.valueOf(1);
		for (int i = 1; i <=k; i++) {
			lotteryOdds=lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
		}
		System.out.println("Odds are 1 in "+ lotteryOdds+".Good Luck!");
	}

}
