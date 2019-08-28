package cn.how2j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayList_LinkedList_insertTest {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList=new ArrayList<>();
		insert(arrayList);
		
		LinkedList<Integer> linkedList=new LinkedList<>();
		insert(linkedList);
		/**
		 * out:
		 * java.util.ArrayList: 做100000次插入耗时1566毫秒
			java.util.LinkedList: 做100000次插入耗时14毫秒
		 */
	}
	public static void insert(List<Integer> list) {
		final long total=1000*100;
		final int num=5;
		long time=System.currentTimeMillis();
		for(int i=0;i<total;i++){
			list.add(0, num);
		}
		time=System.currentTimeMillis()-time;
		System.out.printf("%s: 做%d次插入耗时%d毫秒\n",list.getClass().getName(),total,time);
		
	}
}
