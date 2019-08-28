package ex;

import java.util.Arrays;

public class Array_3_10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5};
		System.out.println("old: "+Arrays.toString(a));
		// 重新初始化一个数组变量，而不创造新变量
		a=new int[] {6,7,8,9,10};
		System.out.println("new: "+Arrays.toString(a));
		
		//不使用匿名数组时,still one same array
		int[] b={6,7,8,9,10};
		a=b;
		
		//ArrayCopy to a new array
		int[] c=Arrays.copyOf(a, a.length);
		int[] d=Arrays.copyOf(a, a.length/2);
		int[] e=Arrays.copyOf(a, a.length*2);//超出部分初始化为0
		
		System.out.println("c: "+Arrays.toString(c));
		System.out.println("d: "+Arrays.toString(d));
		System.out.println("e: "+Arrays.toString(e));
		
		//deepToString
		int[][] TwoDArray= {{1,2,3},{4,5},{6}};
		System.out.println("deepToString : "+Arrays.deepToString(TwoDArray));
	}

}
