package programme;

import java.util.Comparator;
/**
 * ʵ���˶Է��Ͳ�����Լ���ķ��ͷ���minmax���Դ���ķ����������������СԪ�أ�����װ��Pair�����෵��
 * Ϊminmax���������˱Ƚ���������lambdaʵ�ֺ����ӿڵ�ת��
 * @author Alice
 * @version 2019��7��21��
 */
public class ArrayAlg_parameterizedMethod_8_2 {
	public static <T extends Comparable<T>> Pair<T> minmax(T[] list) {
		if(list==null||list.length==0)
			return null;
		T min=list[0];
		T max=list[0];
		
		for(T x:list){
			if(x.compareTo(max)>0)
				max=x;
			if(x.compareTo(min)<0)
				min=x;
		}
		return new Pair<>(min,max);
	}
	

	public static <T extends Comparable<T>> Pair<T> minmax(T[] list,Comparator<T> com) {
		if(list==null||list.length==0)
			return null;
		T min=list[0];
		T max=list[0];
		
		
		for(T x:list){
			if(com.compare(x, max)>0)
				max=x;
			if(com.compare(x, min)<0)
				min=x;
		}
		return new Pair<>(min,max);
	}
	
	
	static class Pair<T>{

		T first=null;
		T second=null;
		public Pair(T first,T second) {
			// TODO Auto-generated constructor stub
			this.first=first;
			this.second=second;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "first: "+first+" second: "+second;
		}
	}
	
	public static void main(String[] args) {
		String[] list={"ab","f","ddd","bdg"};
		System.out.println(ArrayAlg_parameterizedMethod_8_2.minmax(list));
		System.out.println(ArrayAlg_parameterizedMethod_8_2.minmax(list, (o1,o2)->o1.length()-o2.length()));
	}
}
