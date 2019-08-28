package ex;

import java.util.ArrayList;
import java.util.Scanner;

public class scanner_3_7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner aScanner=new Scanner(System.in);
		ArrayList<Double> aArrayList=new ArrayList<Double>();
		double sum=0;
		System.out.println("enter:");
		while(aScanner.hasNextDouble()) {
			double x=aScanner.nextDouble();
			aArrayList.add(x);
			sum+=x;
		}
		aScanner.close();
		double mean=sum/aArrayList.size();
		System.out.println("input: "+ aArrayList.toString());
		System.out.println("sum: "+ sum);
		System.out.printf("mean: %.5f",mean);
		
		
	}

}
