package ex;

import java.util.Arrays;

public class Array_3_10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {1,2,3,4,5};
		System.out.println("old: "+Arrays.toString(a));
		// ���³�ʼ��һ��������������������±���
		a=new int[] {6,7,8,9,10};
		System.out.println("new: "+Arrays.toString(a));
		
		//��ʹ����������ʱ,still one same array
		int[] b={6,7,8,9,10};
		a=b;
		
		//ArrayCopy to a new array
		int[] c=Arrays.copyOf(a, a.length);
		int[] d=Arrays.copyOf(a, a.length/2);
		int[] e=Arrays.copyOf(a, a.length*2);//�������ֳ�ʼ��Ϊ0
		
		System.out.println("c: "+Arrays.toString(c));
		System.out.println("d: "+Arrays.toString(d));
		System.out.println("e: "+Arrays.toString(e));
		
		//deepToString
		int[][] TwoDArray= {{1,2,3},{4,5},{6}};
		System.out.println("deepToString : "+Arrays.deepToString(TwoDArray));
	}

}
