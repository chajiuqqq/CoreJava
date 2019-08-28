package programme;

import java.util.Comparator;
/**
 * 实践了对泛型参数有约束的泛型方法minmax，对传入的泛型数组求其最大最小元素，并包装成Pair泛型类返回
 * 为minmax方法设置了比较器，利用lambda实现函数接口的转换
 * @author Alice
 * @version 2019年7月21日
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
